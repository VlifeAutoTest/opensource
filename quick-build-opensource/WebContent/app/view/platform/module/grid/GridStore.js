/**
 *  grid的dataStore,用于根据条件来取得相应的记录 proxy的extraParams中要包括 moduleName :
 * 模块名称 schemeOrder : 当前的列表方案序号 columns : 当前grid的显示字段 query :
 * 全局筛选的值，在所有的当前grid的显示字段之中筛选 page,start,limit,sort navigates : 导航树的筛选值 包括
 * 导航的名称，选中的模块，,是一个数组 ----moduleName: 筛选条件的模块名称 ----primarykey:
 * 模块的主键，一般的条件都加在主键之上 ----fieldtitle: 字段的名称 ----equalsValue: 筛选的主键值，或者自基本字段的字段值
 * ----isCodeLevel : 如果是阶梯的module,需要like parentModuleName : 父模块 parentModuleId :
 * 父模块的id operateType : 当前模块的操作属性，是default还是审核，审批，多条选择，单条选择，等等

 * 
 * @author jiangfeng
 * 
 *         www.jhopesoft.com
 * 
 *         jfok1972@qq.com
 * 
 *         2017-06-01
 * 
 */


Ext.define('app.view.platform.module.grid.GridStore', {
	  extend : 'Ext.data.Store',
	  requires : ['Ext.data.proxy.Rest'],

	  modulePanel : null,
	  remoteSort : true,
	  remoteFilter : true,
	  autoLoad : false,
	  autoSync : false,
	  leadingBufferZone : 100,
	  buffered : false, // buffered=true可以无限下拉，但是删除和新增，reload都有问题，暂时不用

	  config : {
		  extraParams : {},
		  navigates : [],
		  userFilters : [],
		  // 导航属性选中的情况
		  sortScheme : null
	  },
	  proxy : {
		  type : 'rest',
		  appendId : false,
		  batchActions : true,
		  extraParams : {
			  moduleName : undefined
		  },
		  api : {
			  read : 'platform/dataobject/fetchdata.do',
			  update : 'platform/dataobject/update.do',
			  create : 'platform/dataobject/create.do',
			  destroy : 'platform/dataobject/remove.do'
		  },
		  actionMethods : {
			  create : 'POST',
			  read : 'POST',
			  update : 'POST',
			  destroy : 'POST'
		  },
		  reader : {
			  type : 'json',
			  rootProperty : 'data',
			  totalProperty : 'total'
		  },
		  writer : {
			  type : 'json',
			  writeRecordId : true,
			  writeAllFields : false
			  // 没有修改过的字段不加入到update的json中去
		  }
	  },
	  constructor : function(param){
		  var me = this;
		  me.pageSize = 20;
		  me.extraParams = {};
		  me.navigates = [];
		  me.userFilters = [];
		  // 有创建时加进来的导航约束
		  if (param.modulePanel.param) {
			  var dnv = param.modulePanel.param.defaultNavigateValues;
			  me.setDefaultNavigates(dnv);
		  }
		  me.callParent(arguments);
	  },

	  listeners : {
		  // 调用proxy进行ajax的时候，将参数加进
		  // store.proxy中，在调用完成后，删除掉所有的extraParams参数
		  // 这样model.proxy就可以多store，互相不干扰了
		  beforeprefetch : function(store){
			  for (var i in store.extraParams)
				  store.proxy.extraParams[i] = store.extraParams[i];
		  },
		  // buffered = true ,执行的是 prefetch
		  prefetch : function(store, records, successful){
			  for (var i in store.extraParams)
				  delete store.proxy.extraParams[i];
		  },

		  // buffered = false ,执行的是 load
		  beforeload : function(store){
			  if (!(store.grid && store.grid.rendered)) { return false; }
			  if (store.getSorters().getCount() > 0) store.sortScheme = null;
			  if (store.sortScheme) {
				  store.proxy.extraParams.sortschemeid = store.sortScheme.sortschemeid;
			  } else delete store.proxy.extraParams.sortschemeid;
			  if (store.parentFilter) {
				  if (store.parentFilter.fieldvalue) { // 如果没记录选中那么是 'null'
																								// ,null表示初始化的时候
					  store.proxy.extraParams.parentFilter = Ext.encode(store.parentFilter);
				  } else {
					  // 把 store 里的数据清空, 好象没有好办法，只能去后台调用一次ajax
					  // store.removeAll(false);
					  // store.setData([]); 都不彻底
					  return false;
				  }
			  } else delete store.proxy.extraParams.parentFilter;
			  for (var i in store.extraParams)
				  store.proxy.extraParams[i] = store.extraParams[i];
			  {
				  var _query_ = false;
				  store.getFilters().each(function(filter){
					    if (filter.getProperty() == '_query_') {
						    _query_ = filter;
						    return false;
					    }
				    })
				  if (_query_) {
					  store.proxy.extraParams.query = Ext.encode(store.grid.getQueryFilters(_query_));
				  } else delete store.proxy.extraParams.query;
			  }
			  if (store.grid.moduleInfo.fDataobject.hassqlparam) {
				  store.proxy.extraParams.sqlparamstr = Ext.encode(store.grid.getSqlParam());
			  }
			  store.lastExtraParams = {};
			  Ext.apply(store.lastExtraParams, store.proxy.extraParams);
		  },

		  load : function(store){
			  for (var i in store.extraParams)
				  delete store.proxy.extraParams[i];
		  }

	  },


	  resetSort : function(){
		  var me = this;
		  me.getSorters().removeAll();
		  me.sortScheme = null;
		  me.load();
	  },

	  setSortScheme : function(scheme){
		  var me = this;
		  me.sortScheme = scheme;
		  me.getSorters().removeAll();
		  me.load();
	  },

	  /**
		 * 设置用户自定义的条件
		 * @param {} filters
		 */
	  setUserFilters : function(filters){
		  var me = this;
		  if (Ext.isArray(filters) && filters.length > 0) {
			  me.userFilters = filters;
			  me.extraParams.userfilter = Ext.encode(filters);
		  } else {
			  me.userFilters = [];
			  delete me.extraParams.userfilter;
		  }
		  if (me.grid && me.grid.rendered) {
			  me.loadPage(1);
			  me.fireEvent('filterchange', this);
		  }
	  },

	  /**
		 * 设置指定的 navigates，是程序里指定的，不是用户单击navigates 产生的
		 * @param {} array
		 */
	  setDefaultNavigates : function(dnv){
		  var me = this;
		  me.navigates = [];
		  delete me.extraParams.navigates;
		  if (dnv && dnv.length > 0) {
			  Ext.each(dnv, function(nv){
				    for (var n in nv) {
					    me.navigates.push(nv[n]);
				    }
			    });
			  if (me.navigates.length > 0) Ext.apply(me.extraParams, {
				    navigates : Ext.encode(me.navigates)
			    });
		  }
	  },

	  /**
		 * 当导航条件修改过了，将数组赋给proxy 刷新数据
		 */
	  setNavigates : function(array){
		  var me = this;
		  me.navigates = array;
		  if (me.navigates.length > 0) Ext.apply(me.extraParams, {
			    navigates : Ext.encode(me.navigates)
		    });
		  else delete me.extraParams.navigates;
		  if (me.buffered) me.data.clear();
		  if (me.grid && me.grid.rendered) {
			  me.loadPage(1);
			  me.fireEvent('filterchange', this);
		  }
	  },

	  getFilterCount : function(){
		  var me = this;
		  var count = me.getFilters().length;
		  count += me.getNavigates().length;
		  count += me.getUserFilters().length;
		  return count;
	  }

  });

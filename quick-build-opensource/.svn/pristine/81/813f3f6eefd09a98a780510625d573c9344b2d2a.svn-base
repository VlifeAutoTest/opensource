package com.jhopesoft.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jhopesoft.framework.critical.Local;
import com.jhopesoft.framework.dao.SqlMapperAdapter;
import com.jhopesoft.framework.dao.entity.system.FSystemcfg;
import com.jhopesoft.framework.utils.CommonUtils;
import com.jhopesoft.framework.utils.DateUtils;
import com.jhopesoft.framework.utils.PrimaryCode;

@Service

/**
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

public class SystemcfgService extends SqlMapperAdapter {

	public List<FSystemcfg> getList(FSystemcfg bean) {
		bean.setUserid(Local.getUserid());
		return dao.findByProperty(FSystemcfg.class, bean);
	}

	public FSystemcfg getInfo(FSystemcfg bean) {
		bean.setUserid(Local.getUserid());
		return null;
	}

	public String saveOrUpdate(FSystemcfg bean) {
		delete(bean);
		bean.setId(PrimaryCode.getUUID());
		bean.setCreater(Local.getUsername());
		bean.setCreatedate(DateUtils.getTimestamp());
		bean.setUserid(Local.getUserid());

		return bean.getId();
	}

	public Integer delete(FSystemcfg bean) {

		return 0;
	}

	public List<Map<String, Object>> getMenucfgList(FSystemcfg bean) {
		String sql = "select b.menuid as id,b.menuname text,b.parentid,c.moduleurl as url,b.icon,b.iconCls,"
				+ " b.iconColor,c.moduletype as type,a.id as themecfgid,1 as leaf " + " from F_systemcfg a "
				+ " inner join f_systemmenu b on a.`value` = b.menuid "
				+ " inner join f_systemmodule c on b.moduleid = c.moduleid " + " where a.type = '" + bean.getType()
				+ "' and a.userid = '" + Local.getUserid() + "'";
		if (!CommonUtils.isEmpty(bean.getValue())) {
			sql += " and a.`value` = '" + bean.getValue() + "'";
		}
		sql += " order by a.orderno";
		return dao.executeSQLQuery(sql);
	}
}

package com.jhopesoft.platform.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.jhopesoft.framework.bean.GridParams;
import com.jhopesoft.framework.bean.GroupParameter;
import com.jhopesoft.framework.bean.SortParameter;
import com.jhopesoft.framework.core.annotation.SystemLogs;
import com.jhopesoft.framework.core.dataobject.filter.UserDefineFilter;
import com.jhopesoft.framework.core.dataobject.filter.UserNavigateFilter;
import com.jhopesoft.framework.core.dataobject.filter.UserParentFilter;
import com.jhopesoft.framework.core.dataobject.grid.ExcelColumn;
import com.jhopesoft.framework.core.dataobject.grid.GridColumn;
import com.jhopesoft.framework.critical.Local;
import com.jhopesoft.framework.dao.entity.dataobject.FDataobject;
import com.jhopesoft.framework.dao.entity.viewsetting.FovGridsortscheme;
import com.jhopesoft.framework.interceptor.transcoding.RequestList;
import com.jhopesoft.framework.utils.CommonFunction;
import com.jhopesoft.framework.utils.CommonUtils;
import com.jhopesoft.framework.utils.DataObjectUtils;
import com.jhopesoft.platform.service.DataExportService;

@Controller
@RequestMapping("/platform/dataobjectexport")

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
public class DataExport {

	@Autowired
	private DataExportService dataExportService;

	@SystemLogs("导出excel数据表")
	@RequestMapping(value = "/exporttoexcel")
	public void exportToExcel(HttpServletRequest request, HttpServletResponse response, String moduleName,
			GridParams pg, @RequestList(clazz = SortParameter.class) List<SortParameter> sort, String group,
			@RequestList(clazz = UserDefineFilter.class) List<UserDefineFilter> filter,
			@RequestList(clazz = UserDefineFilter.class) List<UserDefineFilter> userfilter,
			@RequestList(clazz = UserDefineFilter.class) List<UserDefineFilter> query,
			@RequestList(clazz = GridColumn.class) List<ExcelColumn> columns,
			@RequestList(clazz = UserNavigateFilter.class) List<UserNavigateFilter> navigates,
			@RequestList(clazz = UserDefineFilter.class) List<UserDefineFilter> conditions, String parentFilter,
			String sortschemeid, String sqlparamstr, boolean topdf, boolean colorless, boolean usemonetary,
			boolean sumless) throws IOException {
		if (filter == null)
			filter = new ArrayList<UserDefineFilter>();
		if (!CommonUtils.isEmpty(userfilter))
			filter.addAll(userfilter);

		List<UserParentFilter> userParentFilters = UserParentFilter.changeToParentFilters(parentFilter, moduleName);
		FovGridsortscheme sortscheme = null;
		if (sortschemeid != null && sortschemeid.length() > 0)
			sortscheme = Local.getDao().findById(FovGridsortscheme.class, sortschemeid);
		JSONObject sqlparam = null;
		if (sqlparamstr != null && sqlparamstr.length() > 0)
			sqlparam = JSONObject.parseObject(sqlparamstr);
		OutputStream os = dataExportService.generateExcelorPDF(moduleName, pg, columns, sort,
				GroupParameter.changeToGroupParameter(group), query, filter, navigates, userParentFilters, conditions,
				sortscheme, sqlparam, colorless, usemonetary, sumless);
		FDataobject module = DataObjectUtils.getDataObject(moduleName);
		if (topdf) {
			OutputStream os1 = CommonFunction
					.excelStreamToPDFStream(new ByteArrayInputStream(((ByteArrayOutputStream) os).toByteArray()));
			String fn = module.getTitle() + "列表--" + com.jhopesoft.framework.utils.CommonFunction.fu_GenXH() + ".pdf";
			CommonFunction.download(os1, fn, Local.getResponse());

		} else {
			String fn = module.getTitle() + "列表--" + com.jhopesoft.framework.utils.CommonFunction.fu_GenXH() + ".xls";
			CommonFunction.download(os, fn, Local.getResponse());
		}
	}

	@SystemLogs("根据选中的模块和记录，导出excel或word的模板")
	@RequestMapping(value = "/exportexcelscheme")

	public void exportExcelScheme(String objectid, String schemeid, String recordid) {
		try {
			dataExportService.exportExcelScheme(objectid, schemeid, recordid);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				CommonFunction.downloadFileError(Local.getResponse(), e.getCause().getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

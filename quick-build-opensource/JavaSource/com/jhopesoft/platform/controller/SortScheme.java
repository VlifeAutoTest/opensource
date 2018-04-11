package com.jhopesoft.platform.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhopesoft.framework.bean.ActionResult;
import com.jhopesoft.platform.service.SortSchemeService;

@Controller
@RequestMapping("/platform/scheme/sort")

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
public class SortScheme {

	@Resource
	private SortSchemeService sortSchemeService;

	@RequestMapping("/updatedetails")
	public @ResponseBody ActionResult updateSortSchemeDetails(HttpServletRequest request, String dataObjectId,
			String sortSchemeId, String schemeDefine, String sortSchemeName, Boolean mydefault, Boolean shareowner,
			Boolean shareall) {
		ActionResult result = null;
		try {
			result = sortSchemeService.updateSortSchemeDetails(request, dataObjectId, sortSchemeId, sortSchemeName,
					schemeDefine, mydefault, shareowner, shareall);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/getdetails")
	public @ResponseBody JSONObject getSortSchemeDetails(HttpServletRequest request, String sortSchemeId) {
		return sortSchemeService.getSortSchemeDetails(request, sortSchemeId);
	}

	@RequestMapping("/deletescheme")
	public @ResponseBody ActionResult deleteSortScheme(HttpServletRequest request, String schemeid) {
		return sortSchemeService.deleteSortScheme(request, schemeid);
	}

	@RequestMapping("/checknamevalidate")
	public @ResponseBody ActionResult checkNameValidate(String name, String id) {
		return sortSchemeService.checkNameValidate(name, id);
	}

	@RequestMapping("/getdefaultdetails")
	public @ResponseBody JSONArray getSortDefaultDetails(String dataObjectId) {
		return sortSchemeService.getSortDefaultDetails(dataObjectId);
	}

	@RequestMapping("/updatedefaultdetails")
	public @ResponseBody ActionResult updateDefaultSortDetails(String dataObjectId, String schemeDefine) {
		ActionResult result = null;
		try {
			result = sortSchemeService.updateDefaultSortDetails(dataObjectId, schemeDefine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

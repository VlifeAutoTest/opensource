package com.jhopesoft.platform.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jhopesoft.framework.bean.ActionResult;
import com.jhopesoft.framework.bean.ValueText;
import com.jhopesoft.platform.service.FormSchemeService;

@Controller
@RequestMapping("/platform/scheme/form")

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
public class FormScheme {

	@Resource
	private FormSchemeService formSchemeService;

	@RequestMapping("/updatedetails")
	public @ResponseBody ActionResult updateFormSchemeDetails(HttpServletRequest request, String dataObjectId,
			String formSchemeId, String schemeDefine, String formSchemeName, Boolean mydefault, Boolean shareowner,
			Boolean shareall) {

		return formSchemeService.updateFormSchemeDetails(request, dataObjectId, formSchemeId, formSchemeName,
				schemeDefine, mydefault, shareowner, shareall);
	}

	@RequestMapping("/getdetails")
	public @ResponseBody JSONObject getFormSchemeDetails(HttpServletRequest request, String formSchemeId) {
		return formSchemeService.getFormSchemeDetails(request, formSchemeId);
	}

	@RequestMapping("/deletescheme")
	public @ResponseBody ActionResult deleteFormScheme(HttpServletRequest request, String schemeid) {
		return formSchemeService.deleteFormScheme(request, schemeid);
	}

	@RequestMapping("/getobjectschemename")
	public @ResponseBody List<ValueText> getObjectSchemename(String objectid) {
		return formSchemeService.getObjectSchemename(objectid);
	}

	@RequestMapping("/checknamevalidate")
	public @ResponseBody ActionResult checkNameValidate(String name, String id) {
		return formSchemeService.checkNameValidate(name, id);
	}

}

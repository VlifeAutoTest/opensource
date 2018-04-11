package com.jhopesoft.platform.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhopesoft.framework.bean.ActionResult;
import com.jhopesoft.framework.core.annotation.SystemLogs;
import com.jhopesoft.platform.service.UserFavouriteService;

@Controller
@RequestMapping("/userfavourite")

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
public class UserFavourite {

	@Resource
	private UserFavouriteService userFavouriteService;

	@SystemLogs("用户设置缺省的列表方案")
	@RequestMapping(value = "/setdefaultgridscheme")
	@ResponseBody
	public ActionResult setDefaultGridScheme(String schemeid) {
		return userFavouriteService.setDefaultGridScheme(schemeid);
	}

	@SystemLogs("用户设置缺省的筛选方案")
	@RequestMapping(value = "/setdefaultfilterscheme")
	@ResponseBody
	public ActionResult setDefaultFilterScheme(String schemeid) {
		return userFavouriteService.setDefaultFilterScheme(schemeid);
	}

	@SystemLogs("用户设置缺省的导航方案")
	@RequestMapping(value = "/setdefaultnavigatescheme")
	@ResponseBody
	public ActionResult setDefaultNavigateScheme(String schemeid) {
		return userFavouriteService.setDefaultNavigateScheme(schemeid);
	}

}

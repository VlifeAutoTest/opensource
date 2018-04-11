package com.jhopesoft.platform.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhopesoft.framework.core.annotation.SystemLogs;
import com.jhopesoft.framework.dao.entity.system.FSystemcfg;
import com.jhopesoft.platform.service.SystemcfgService;

@Controller
@RequestMapping("/platform/systemcfg")
public class Systemcfg {

	@Resource
	private SystemcfgService service;
	
	@SystemLogs("查询系统配置列表信息")
	@RequestMapping(value="/getlist")
	@ResponseBody
	public List<FSystemcfg> getList(FSystemcfg bean){
		return service.getList(bean);
	}
	
	@SystemLogs("查询系统配置信息")
	@RequestMapping(value="/getinfo")
	@ResponseBody
	public FSystemcfg getInfo(FSystemcfg bean){
		return service.getInfo(bean);
	}
	
	@SystemLogs("保存/修改系统配置信息")
	@RequestMapping(value="/saveorupdate")
	@ResponseBody
	public String saveOrUpdate(FSystemcfg bean){
		return service.saveOrUpdate(bean);
	}
	
	@SystemLogs("删除系统配置信息")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Integer delete(FSystemcfg bean){
		return service.delete(bean);
	}
	@SystemLogs("查询系统配置列表信息")
	@RequestMapping(value="/getmenulist")
	@ResponseBody
	public List<Map<String,Object>> getMenucfgList(FSystemcfg bean){
		return service.getMenucfgList(bean);
	}
}

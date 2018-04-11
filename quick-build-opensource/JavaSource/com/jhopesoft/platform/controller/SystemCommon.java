package com.jhopesoft.platform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhopesoft.framework.bean.ResultBean;
import com.jhopesoft.framework.bean.TreeNode;
import com.jhopesoft.framework.interceptor.transcoding.RequestList;
import com.jhopesoft.framework.utils.TreeBuilder;
import com.jhopesoft.platform.service.SystemCommonService;

@Controller
@RequestMapping("/platform/systemcommon")
public class SystemCommon {

	@Autowired
	private SystemCommonService service;




	@RequestMapping(value = "/getmoduletree")
	@ResponseBody
	public List<TreeNode> getModuleTree(String companyid) {
		return TreeBuilder.buildListToTree(service.getModuleTree(companyid));
	}




	@RequestMapping(value = "/getcompanymoduletree")
	@ResponseBody
	public List<Map<String, Object>> getCompanyModuleTree(String companyid) {
		return TreeBuilder.buildListToTree(service.getCompanyModuleTree(companyid));
	}




	@RequestMapping(value = "/savecompanymodule")
	@ResponseBody
	public ResultBean saveCompanyModule(@RequestList List<Map<String, Object>> datalist, String companyid) {
		ResultBean result = new ResultBean();
		try {
			result = service.saveCompanyModule(datalist, companyid);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}
}

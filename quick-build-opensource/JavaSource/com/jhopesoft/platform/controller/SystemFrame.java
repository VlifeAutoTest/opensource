package com.jhopesoft.platform.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhopesoft.framework.bean.ActionResult;
import com.jhopesoft.framework.bean.TreeNode;
import com.jhopesoft.framework.core.annotation.SystemLogs;
import com.jhopesoft.framework.utils.TreeBuilder;
import com.jhopesoft.platform.service.SystemFrameService;
import com.jhopesoft.framework.bean.UploadFileBean;

@Controller
@RequestMapping("/platform/systemframe")
public class SystemFrame {

	@Resource
	private SystemFrameService service;

	@SystemLogs("获取系统菜单")
	@RequestMapping(value = "/getmenutree")
	@ResponseBody
	public List<TreeNode> getMenuTree() {
		return TreeBuilder.buildListToTree(service.getMenuTree());
	}

	@RequestMapping(value = "/getuserfavicon")
	public void getUserFavicon(HttpServletRequest request, HttpServletResponse response, String usercode)
			throws IOException {
		service.getUserFavicon(usercode);
	}

	@RequestMapping(value = "/uploadimagefileandreturn")
	public ResponseEntity<Map<String, Object>> uploadImageFileAndReturn(UploadFileBean uploadExcelBean,
			BindingResult bindingResult, HttpServletRequest request) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		ActionResult ar = service.uploadImageFileAndReturn(uploadExcelBean, bindingResult, request);
		map.put("success", ar.getSuccess());
		map.put("msg", ar.getMsg());
		return new ResponseEntity<Map<String, Object>>(map, headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult resetPassword(String userid) {
		return service.resetPassword(userid);
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult changePassword(String oldPassword, String newPassword) {
		return service.changePassword(oldPassword, newPassword);
	}

}

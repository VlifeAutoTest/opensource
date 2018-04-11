package com.jhopesoft.platform.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhopesoft.framework.bean.ValueText;
import com.jhopesoft.framework.dao.entity.dictionary.FDictionary;
import com.jhopesoft.platform.service.DictionaryService;

@Controller
@RequestMapping("/dictionary")

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
public class DictionaryController {

	@Resource
	private DictionaryService dictionaryService;

	@RequestMapping(value = "/getdictionary")
	public @ResponseBody FDictionary getDictionary(String id, Boolean adddetails) {
		return dictionaryService.getDictionary(id, adddetails != null && adddetails);
	}

	@RequestMapping(value = "/getDictionaryComboData")
	public @ResponseBody List<ValueText> getDictionaryComboData(String dictionaryId, Boolean idIncludeText,
			HttpServletRequest request) {

		return dictionaryService.getDictionaryComboData(dictionaryId, idIncludeText == null ? false : idIncludeText,
				request);
	}

}

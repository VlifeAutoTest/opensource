package com.jhopesoft.framework.critical;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.jhopesoft.framework.bean.UserBean;
import com.jhopesoft.framework.context.ContextAware.SContextAware;
import com.jhopesoft.framework.dao.Dao;
import com.jhopesoft.framework.utils.Globals;
import com.jhopesoft.framework.utils.PropertyPreFilters;




public class CriticalObject {
	
	private Dao dao;

	private PropertyPreFilters features;

	private HttpServletRequest request;

	private HttpServletResponse response;

	private HttpSession session;

	private UserBean userBean;

	private String basePath;

	private String root;
	
	public CriticalObject(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.session = request.getSession(false);
		this.root = SContextAware.getServletContext().getRealPath("/");
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		this.dao = wac == null? null : ContextLoader.getCurrentWebApplicationContext().getBean(Dao.class);
		this.userBean = this.session==null?null:(UserBean)session.getAttribute(Globals.SYSTEM_USER);
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public PropertyPreFilters getFeatures() {
		return features;
	}

	public void setFeatures(PropertyPreFilters features) {
		this.features = features;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpSession getSession() {
		return session;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getRoot() {
		return root;
	}
}

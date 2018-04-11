package com.jhopesoft.framework.critical;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;

import com.jhopesoft.framework.bean.UserBean;
import com.jhopesoft.framework.context.ProjectContext;
import com.jhopesoft.framework.context.ProjectSpace;
import com.jhopesoft.framework.context.ContextAware.AppContextAware;
import com.jhopesoft.framework.context.ContextAware.MvcContextAware;
import com.jhopesoft.framework.dao.Dao;
import com.jhopesoft.framework.utils.PropertyPreFilters;

public class Local {

	private static final ThreadLocal<CriticalObject> CriticalObjectStore = new ThreadLocal<CriticalObject>();

	public static Dao getDao() {
		return getCriticalObject().getDao();
	}

	public static boolean islogin() {
		return getUserBean() != null;
	}

	public static UserBean getUserBean() {
		CriticalObject obj = getCriticalObject();
		return obj == null ? null : obj.getUserBean();
	}

	public static String getCompanyid() {
		return getUserBean().getCompanyid();
	}

	public static String getUserid() {
		if (getUserBean() != null)
			return getUserBean().getUserid();
		else
			return null;
	}

	public static String getUsercode() {
		return getUserBean().getUsercode();
	}

	public static String getUsername() {
		return getUserBean().getUsername();
	}

	public static CriticalObject getCriticalObject() {
		return CriticalObjectStore.get();
	}

	public static void setCriticalObject(CriticalObject criticalObject) {
		CriticalObjectStore.set(criticalObject);
	}

	public static String getBasePath() {
		return getCriticalObject().getBasePath();
	}

	public static Object getBean(String name) {
		Object obj = null;
		try {
			obj = AppContextAware.getApplicationContext().getBean(name);
		} catch (BeansException e) {
			try {
				obj = MvcContextAware.getApplicationContext().getBean(name);
			} catch (BeansException e1) {
			}
		}
		return obj;
	}

	public static <T> T getBean(Class<T> requiredtype) {
		T bean = null;
		try {
			bean = AppContextAware.getApplicationContext().getBean(requiredtype);
		} catch (BeansException e) {
			bean = MvcContextAware.getApplicationContext().getBean(requiredtype);
		}
		return bean;
	}

	public static HttpServletRequest getRequest() {
		return getCriticalObject().getRequest();
	}

	public static HttpServletResponse getResponse() {
		return getCriticalObject().getResponse();
	}

	public static void writeJsonToHttpFilters(PropertyPreFilters features) {
		getCriticalObject().setFeatures(features);
	}

	public static PropertyPreFilters getJsonToHttpFilters() {
		if (getCriticalObject() == null)
			return null;
		return getCriticalObject().getFeatures();
	}

	public static void clearJsonToHttpFilters() {
		getCriticalObject().setFeatures(null);
	}

	public static ProjectSpace getProjectSpace() {
		return ProjectContext.getProjectSpace();
	}

}

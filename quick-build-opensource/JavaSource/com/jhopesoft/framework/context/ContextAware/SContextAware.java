package com.jhopesoft.framework.context.ContextAware;
import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;



public class SContextAware implements ServletContextAware{

	private static ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		SContextAware.servletContext = servletContext;
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

}
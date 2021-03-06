package com.jhopesoft.framework.context.ContextAware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContextAware implements ApplicationContextAware{
	
	private static ApplicationContext appCtx;

	public void setApplicationContext(ApplicationContext context) {
		appCtx = context;
	}

	public static ApplicationContext getApplicationContext() {
		return appCtx;
	}
}
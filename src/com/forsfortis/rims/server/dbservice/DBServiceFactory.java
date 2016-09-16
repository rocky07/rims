package com.forsfortis.rims.server.dbservice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBServiceFactory {
	private static DBServiceFactory instance;
	ClassPathXmlApplicationContext ctx;

	private DBServiceFactory() {
		
		ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
	}

	public static DBServiceFactory getInstance() {
		if (instance == null) {
			instance = new DBServiceFactory();
		}
		return instance;
	}
	
	public ObjectManagementDbService getObjectManagementDbService() {
		return ctx.getBean("objectManagementDbService", ObjectManagementDbService.class);
	}
}

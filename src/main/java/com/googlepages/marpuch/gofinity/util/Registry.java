package com.googlepages.marpuch.gofinity.util;

import org.apache.commons.logging.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Registry {

	private static final Log log = LoggerFactory.create();
	private static ApplicationContext context;

	public static void init() {
		log.debug("Starting context initialization...");
		context = new ClassPathXmlApplicationContext("default-beans.xml");
		log.debug("Context initialized successfully");
	}

	public static <T> T getObject(final Class<T> clazz)
	{
		return context.getBean(clazz);
	}
}

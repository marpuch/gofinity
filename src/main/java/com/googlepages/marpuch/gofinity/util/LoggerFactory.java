package com.googlepages.marpuch.gofinity.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggerFactory {

	private LoggerFactory() {
	}

	public static Log create() {
		Throwable t = new Throwable();
		StackTraceElement directCaller = t.getStackTrace()[1];
		return LogFactory.getLog(directCaller.getClassName());
	}
}

package com.googlepages.marpuch.gofinity.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ResourceUtils {

	private ResourceUtils() {
	}

	public static InputStream getClassPathResourceAsStream(final String resource) {
		try {
			URL url = org.springframework.util.ResourceUtils
			.getURL(org.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX
					+ resource);
			InputStream in = url.openStream();
			return in;
		} catch (IOException e) {
			throw new RuntimeException("Could not find " + resource
					+ " on classpath.", e);
		}
	}
}

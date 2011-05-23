package com.googlepages.marpuch.gofinity.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;

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

	public static ImageIcon createImageIcon(final String path,
			final String description) {
		java.net.URL imgURL = ResourceUtils.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}

package com.googlepages.marpuch.gofinity.util;

public class Precondition {

	private Precondition() {}

	public static void notNull(final Object variable, final String variableName) {
		if (variable == null)
			throw new IllegalArgumentException("Variable " + variableName + " can not be null");
	}
}

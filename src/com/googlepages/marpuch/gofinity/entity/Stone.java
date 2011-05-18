package com.googlepages.marpuch.gofinity.entity;

public enum Stone {
	BLACK, WHITE;

	public static FieldContent toFieldContent(final Stone stone)
	{
		if (BLACK.equals(stone))
			return FieldContent.BLACK;
		else
			return FieldContent.WHITE;
	}
}

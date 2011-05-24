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

	public static Stone nextPlayer(final Stone player) {
		if (BLACK.equals(player))
			return WHITE;
		else
			return BLACK;
	}
}

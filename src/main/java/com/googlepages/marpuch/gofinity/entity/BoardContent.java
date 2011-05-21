package com.googlepages.marpuch.gofinity.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString @EqualsAndHashCode public class BoardContent {

	@Getter private final int size;
	private final FieldContent[][] fieldContents;

	public BoardContent(final int size) {
		this.size = size;
		fieldContents = new FieldContent[size][];
		for (int i = 0; i < size; i++)
		{
			fieldContents[i] = new FieldContent[size];
			for (int j = 0; j < size; j++)
			{
				fieldContents[i][j] = FieldContent.EMPTY;
			}
		}
	}

	public FieldContent getFieldContent(final int x, final int y)
	{
		return fieldContents[x][y];
	}

	public void setFieldContent(final int x, final int y, final FieldContent fieldContent)
	{
		fieldContents[x][y] = fieldContent;
	}
}

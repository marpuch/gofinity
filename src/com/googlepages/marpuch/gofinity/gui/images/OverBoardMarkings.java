package com.googlepages.marpuch.gofinity.gui.images;

import java.awt.Color;

import lombok.Getter;

import com.googlepages.marpuch.gofinity.entity.BoardContent;

public class OverBoardMarkings extends AbstractBoardImage {

	private int oldX = -1;
	private int oldY = -1;
	@Getter private boolean changed = false;

	public OverBoardMarkings(final BoardContent boardContent,
			final int singleFieldSize) {
		super(boardContent, singleFieldSize);
	}

	public void handleMouseMove(final int xCoordinate, final int yCoordinate) {
		int x = getBoardCoordinate(xCoordinate);
		int y = getBoardCoordinate(yCoordinate);
		if (x == oldX && y == oldY)
		{
			changed = false;
		}
		else
		{
			oldX = x;
			oldY = y;
			drawMousePosition(x, y);
			changed = true;
		}
	}

	private void drawMousePosition(final int x, final int y) {
		clearImage();
		// TODO localize me
		graphics.setColor(Color.red);
		int xCoordinate = singleFieldSize/2 + x * singleFieldSize;
		graphics.drawLine(xCoordinate, 0, xCoordinate, boardImage.getHeight());
		int yCoordinate = singleFieldSize/2 + y * singleFieldSize;
		graphics.drawLine(0, yCoordinate, boardImage.getWidth(), yCoordinate);
	}

	private int getBoardCoordinate(final int panelCoordinate) {
		int trimmedCoordinate = panelCoordinate % imageSize;
		return trimmedCoordinate / singleFieldSize;
	}

}

package com.googlepages.marpuch.gofinity.gui.images;

import lombok.Getter;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.FieldContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.entity.Stone;

public class OverBoardMarkings extends AbstractBoardImage {

	private int oldX = -1;
	private int oldY = -1;
	@Getter private boolean changed = false;

	public OverBoardMarkings(final BoardContent boardContent, final GameParameters gameParameters,
			final int singleFieldSize) {
		super(boardContent, gameParameters, singleFieldSize);
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
			handlePositionChanged(x, y);
			changed = true;
		}
	}

	private void handlePositionChanged(final int x, final int y) {
		clearImage();
		// TODO localize me
		if (FieldContent.EMPTY.equals(boardContent.getFieldContent(x, y)))
		{
			int xCoordinate = getCoordinate(x);
			int yCoordinate = getCoordinate(y);
			FieldContent fc = Stone.toFieldContent(boardContent.getPlayerToMove());
			drawStoneToImageCoordinates(xCoordinate, yCoordinate, fc, 0.5f);
		}
	}

	private int getBoardCoordinate(final int panelCoordinate) {
		int trimmedCoordinate = panelCoordinate % imageSize;
		return trimmedCoordinate / singleFieldSize;
	}

}

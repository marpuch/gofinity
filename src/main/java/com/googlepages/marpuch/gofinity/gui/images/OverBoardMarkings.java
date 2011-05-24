package com.googlepages.marpuch.gofinity.gui.images;

import lombok.Getter;

import com.googlepages.marpuch.gofinity.entity.FieldContent;
import com.googlepages.marpuch.gofinity.entity.Stone;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;

public class OverBoardMarkings extends AbstractBoardImage {

	private int oldX = -1;
	private int oldY = -1;
	@Getter private boolean changed = false;

	public OverBoardMarkings(final GameLogicBCI gameLogic, final int singleFieldSize) {
		super(gameLogic, singleFieldSize);
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
		if (x < 0 || y < 0)
			return;
		// TODO localize me
		if (FieldContent.EMPTY.equals(boardContent.getFieldContent(x, y)))
		{
			int xCoordinate = getCoordinate(x);
			int yCoordinate = getCoordinate(y);
			FieldContent fc = Stone.toFieldContent(boardContent.getPlayerToMove());
			drawStoneToImageCoordinates(xCoordinate, yCoordinate, fc, 0.5f);
		}
	}



}

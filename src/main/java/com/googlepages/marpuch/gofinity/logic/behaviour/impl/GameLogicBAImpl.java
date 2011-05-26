package com.googlepages.marpuch.gofinity.logic.behaviour.impl;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.FieldContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.entity.Stone;
import com.googlepages.marpuch.gofinity.logic.behaviour.GameLogicBA;

public class GameLogicBAImpl implements GameLogicBA {

	@Override
	public boolean putStone(final int x, final int y,
			final GameParameters gameParameters, final BoardContent boardContent) {

		if (FieldContent.EMPTY.equals(boardContent.getFieldContent(x, y))) {
			boardContent.setFieldContent(x, y,
					Stone.toFieldContent(boardContent.getPlayerToMove()));
			boardContent.setPlayerToMove(Stone.nextPlayer(boardContent
					.getPlayerToMove()));
			return true;
		} else {
			return false;
		}
	}

}

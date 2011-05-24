package com.googlepages.marpuch.gofinity.logic.facade;

import lombok.Getter;

import org.apache.commons.logging.Log;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.FieldContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.entity.Stone;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;
import com.googlepages.marpuch.gofinity.util.LoggerFactory;

public class GameLogicBF implements GameLogicBCI {

	private static final Log log = LoggerFactory.create();
	@Getter private GameParameters gameParameters;
	@Getter private BoardContent boardContent;

	@Override
	public void init(final GameParameters gameParameters) {
		log.debug("init");
		this.gameParameters = gameParameters;
		this.boardContent = new BoardContent(gameParameters.getBoardSize());
	}

	@Override
	public boolean putStone(final int x, final int y) {
		log.debug("putStone");
		if (FieldContent.EMPTY.equals(boardContent.getFieldContent(x, y)))
		{
			boardContent.setFieldContent(x, y, Stone.toFieldContent(boardContent.getPlayerToMove()));
			boardContent.setPlayerToMove(Stone.nextPlayer(boardContent.getPlayerToMove()));
			return true;
		}
		else
		{
			return false;
		}
	}

}

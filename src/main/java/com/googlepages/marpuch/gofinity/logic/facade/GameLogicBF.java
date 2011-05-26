package com.googlepages.marpuch.gofinity.logic.facade;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.logic.behaviour.GameLogicBA;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;
import com.googlepages.marpuch.gofinity.util.LoggerFactory;

public class GameLogicBF implements GameLogicBCI {

	private static final Log log = LoggerFactory.create();
	@Getter private GameParameters gameParameters;
	@Getter private BoardContent boardContent;
	@Setter private GameLogicBA gameLogicBA;

	@Override
	public void init(final GameParameters gameParameters) {
		log.debug("init");
		this.gameParameters = gameParameters;
		this.boardContent = new BoardContent(gameParameters.getBoardSize());
	}

	@Override
	public boolean putStone(final int x, final int y) {
		if (log.isDebugEnabled())
			log.debug("putStone x: " + x + " y: " + y);
		return gameLogicBA.putStone(x, y, gameParameters, boardContent);
	}

}

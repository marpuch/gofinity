package com.googlepages.marpuch.gofinity.logic.spec;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;

public interface GameLogicBCI {

	/**
	 * Initializes the game logic. Must be called before any other method.
	 * 
	 * @param gameParameters Game parameters.
	 */
	void init(GameParameters gameParameters);

	/**
	 * @return Board content. The reference to this object never changes in one game.
	 */
	BoardContent getBoardContent();

	/**
	 * @return Game parameters. The reference to this object never changes in one game.
	 */
	GameParameters getGameParameters();

	/**
	 * Put stone at the position specified.
	 * 
	 * @param x Board coordinate.
	 * @param y Board coordinate.
	 * @return true, if board content changed, false otherwise.
	 */
	boolean putStone(int x, int y);
}

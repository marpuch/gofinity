package com.googlepages.marpuch.gofinity.logic.facade;

import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;

public class GameLogicBF implements GameLogicBCI {

	private GameParameters gameParameters;

	@Override
	public void init(final GameParameters gameParameters) {
		this.gameParameters = gameParameters;
	}

}

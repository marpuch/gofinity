package com.googlepages.marpuch.gofinity.logic.behaviour;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;

public interface GameLogicBA {

	boolean putStone(int x, int y, GameParameters gameParameters,
			BoardContent boardContent);

}

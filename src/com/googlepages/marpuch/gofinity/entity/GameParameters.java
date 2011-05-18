package com.googlepages.marpuch.gofinity.entity;

import lombok.Getter;
import lombok.Setter;

public class GameParameters {

	@Setter @Getter private Stone playerToMove;

	public GameParameters()
	{
		playerToMove = Stone.BLACK;
	}
}

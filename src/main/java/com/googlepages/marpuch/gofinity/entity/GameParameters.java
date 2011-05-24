package com.googlepages.marpuch.gofinity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString public class GameParameters {

	@Setter @Getter private int boardSize;

	@Override
	public GameParameters clone() {
		GameParameters clone = new GameParameters();
		clone.setBoardSize(boardSize);
		return clone;
	}
}

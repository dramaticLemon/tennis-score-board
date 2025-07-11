package com.dch.service.calculate.score.logic;

import com.dch.service.calculate.score.logic.enums.GameEventType;
import com.dch.service.calculate.score.logic.enums.TennisPointState;

public class GameEvent {
    GameEventType type;
    String player;
    TennisPointState pointState;

	public GameEvent(GameEventType type, String player, TennisPointState pointState) {
		this.type = type;
		this.player = player;
		this.pointState = pointState;
	}
	public GameEvent(GameEventType type, String player) {
		this.type = type;
		this.player = player;
	}	

	public GameEventType getType() {
		return type;
	}
}
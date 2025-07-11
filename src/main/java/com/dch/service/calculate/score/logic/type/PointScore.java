package com.dch.service.calculate.score.logic.type;

import com.dch.service.calculate.score.logic.Scorable;
import com.dch.service.calculate.score.logic.enums.TennisPointState;

public class PointScore implements Scorable{
	private int internalScore = 0;

	@Override
	public void add() {
		this.internalScore++;

	}
	
	@Override
	public void reset() {
		this.internalScore = 0;
	}
	
	
	@Override
	public int get() {
		return this.internalScore;
	}
	
	public String getDisplayScore(int opponentInternalScore) {
		if (this.internalScore >= 4 && this.internalScore - opponentInternalScore >= 2) {
			return "GAME";
		}
		if (this.internalScore >= 3 && opponentInternalScore >= 3) {
			if (this.internalScore == opponentInternalScore) {
				return "DE";
			}
			if (this.internalScore == opponentInternalScore + 1) {
				return "AD";
			} 
			if (opponentInternalScore == this.internalScore + 1) {
				return "40";
			}
		}
		return switch (this.internalScore) {
			case 0 -> "0";
			case 1 -> "15";
			case 2 -> "30";
			case 3 -> "40";
			default -> "??";
		};
	}

	public TennisPointState getState(int opponentInternalScore) {	
		if (internalScore >= 4 && (internalScore - opponentInternalScore >= 2)) {
			return TennisPointState.GAME_WON;
		}
		if (internalScore >= 3 && opponentInternalScore >= 3 && internalScore == opponentInternalScore) {
			return TennisPointState.DEUCE;
		}
		if (internalScore >= 4 && internalScore == opponentInternalScore + 1) {
			return TennisPointState.ADVANTAGE;
		}
		if (internalScore == 3) {
			return TennisPointState.FORTY;
		}
		if (internalScore == 2) {
			return TennisPointState.THIRTY;
		}
		if (internalScore == 1) {
			return TennisPointState.FIFTEEN;
		}
		if (internalScore == 0) {
			return TennisPointState.LOVE;
		}
		return TennisPointState.FORTY;
	}
}
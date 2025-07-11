package com.dch.service.calculate.score.logic.type;

import com.dch.service.calculate.score.logic.Scorable;
import com.dch.service.calculate.score.logic.enums.MatchResult;

public class SetScore implements Scorable{
	private int setsWon = 0;
	 private static final int SETS_TO_WIN_MATCH = 2;

	@Override
	public void add() {
		this.setsWon++;
	}

	@Override
	public int get() {
		return setsWon;
	}

	@Override
	public void reset() {
		this.setsWon = 0;
	}

	public String getDisplayScore() {
		return String.valueOf(this.setsWon);
	}

    public MatchResult checkForMatchWin(int opponentSetsWon) {
        if (this.setsWon == SETS_TO_WIN_MATCH) {

            return MatchResult.MATCH_WON;
        }
        return MatchResult.CONTINUE;
    }


}
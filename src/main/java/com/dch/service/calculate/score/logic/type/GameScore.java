package com.dch.service.calculate.score.logic.type;

import com.dch.service.calculate.score.logic.Scorable;
import com.dch.service.calculate.score.logic.enums.SetResult;

public class GameScore implements Scorable{
	private int gamesWon = 0;
	
	@Override
	public void add() {
		this.gamesWon++;
	}

	@Override
	public int get() {
		return gamesWon;
	}

	@Override
	public void reset() {
		this.gamesWon = 0;
	}


	public String getDisplayScore() {
		return String.valueOf(this.gamesWon);
	}

    public SetResult checkForSetWin(int opponentGamesWon) {
        if (this.gamesWon >= 6 && (this.gamesWon - opponentGamesWon >= 2)) {
            return SetResult.SET_WON;
        }

        if (this.gamesWon == 6 && opponentGamesWon == 6) {
            return SetResult.TIE_BREAK;
        }
        return SetResult.CONTINUE;
    }

}

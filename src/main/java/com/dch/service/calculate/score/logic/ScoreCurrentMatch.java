package com.dch.service.calculate.score.logic;

import com.dch.service.calculate.score.logic.enums.GameEventType;
import com.dch.service.calculate.score.logic.enums.MatchResult;
import com.dch.service.calculate.score.logic.enums.SetResult;
import com.dch.service.calculate.score.logic.enums.TennisPointState;

public class ScoreCurrentMatch {
	public PlayerScore playerOneScore;
	public PlayerScore playerTwoScore;

	public ScoreCurrentMatch(String firstPlayerName, String secondPlayerName) {
		this.playerOneScore = new PlayerScore(firstPlayerName);
		this.playerTwoScore =  new PlayerScore(secondPlayerName);
	}

	public GameEvent processPoint(String playerName) {
        PlayerScore scorer;
        PlayerScore opponent;

        if (playerOneScore.getUsername().equals(playerName)) {
            scorer = playerOneScore;
            opponent = playerTwoScore;
        } else {
            scorer = playerTwoScore;
            opponent = playerOneScore;
        }

		scorer.getPointScore().add();
        TennisPointState pointState = scorer.getPointScore().getState(opponent.getPointScore().get());

        if (pointState == TennisPointState.GAME_WON) {
            scorer.getGameScore().add();
            scorer.getPointScore().reset();
            opponent.getPointScore().reset();
            
			SetResult setResult = scorer.getGameScore().checkForSetWin(opponent.getGameScore().get());
			
			if (null == setResult) {
                return new GameEvent(GameEventType.GAME_WON, scorer.getUsername());
                } else switch (setResult) {
                	case SET_WON -> {
                    	scorer.getSetScore().add();
                    	scorer.getGameScore().reset();
                    	// opponent.getGameScore().reset();
                    
                    	MatchResult matchResult = scorer.getSetScore().checkForMatchWin(opponent.getSetScore().get());
                    
                    	if (matchResult == MatchResult.MATCH_WON) {
                        	return new GameEvent(GameEventType.MATCH_WON, scorer.getUsername());
                    	} else {
                        	return new GameEvent(GameEventType.SET_WON, scorer.getUsername());
                    	}
                	}

                	case TIE_BREAK -> {
                    	return new GameEvent(GameEventType.POINT_SCORED, playerName, pointState);
                	}
                	default -> {
                    	return new GameEvent(GameEventType.GAME_WON, scorer.getUsername());
                	}
            	}	
		}
		else {
			return new GameEvent(GameEventType.POINT_SCORED, playerName, pointState);
		}

    }

	public PlayerScore getPlayerOneScore() {
		return playerOneScore;
	}

	public PlayerScore getPlayerTwoScore() {
		return playerTwoScore;
	}
}

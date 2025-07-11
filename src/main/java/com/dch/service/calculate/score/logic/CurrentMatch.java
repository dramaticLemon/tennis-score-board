package com.dch.service.calculate.score.logic;

/**
 * логика подсщета матча
 */
public class CurrentMatch{
	String player1;
	String player2;
	ScoreCurrentMatch scoreCurrentMatch;

	public CurrentMatch(
		String playerIdentificatorFirst,
		String playerIdenrificatorSecond
		) {

		this.player1 = playerIdentificatorFirst;
		this.player2 = playerIdenrificatorSecond;
		this.scoreCurrentMatch = new ScoreCurrentMatch(player1, player2);
	}

	public GameEvent recordPoint(String playerName) {
        GameEvent event = this.scoreCurrentMatch.processPoint(playerName);
        // Здесь можно обработать событие, например, вывести в консоль
        // if (event.getType() == GameEventType.GAME_WON) { ... }
		return event;
    }

	public String getPlayerOnePointScore() {
        return scoreCurrentMatch.getPlayerOneScore().getPointScore().getDisplayScore(
			scoreCurrentMatch.getPlayerTwoScore().getPointScore().get()
		);
    }

	public String getPlayerTwoPointScore() {
        return scoreCurrentMatch.getPlayerTwoScore().getPointScore().getDisplayScore(
			scoreCurrentMatch.getPlayerOneScore().getPointScore().get()
		);
    }

	public String getPlayerOneGameScore() {
        return scoreCurrentMatch.getPlayerOneScore().getGameScore().getDisplayScore();
    }

	public String getPlayerTwoGameScore() {
        return scoreCurrentMatch.getPlayerTwoScore().getGameScore().getDisplayScore();
    }

	public String getPlayerOneSetScore() {
        return scoreCurrentMatch.getPlayerOneScore().getSetScore().getDisplayScore();
    }

	public String getPlayerTwoSetScore() {
        return scoreCurrentMatch.getPlayerTwoScore().getSetScore().getDisplayScore();
    }

	public String getFirstName() {
		return this.player1;
	}

	public String getLastName() {
		return this.player2;
	}

}

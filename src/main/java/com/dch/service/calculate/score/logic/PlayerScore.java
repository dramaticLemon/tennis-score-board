package com.dch.service.calculate.score.logic;

import com.dch.service.calculate.score.logic.type.GameScore;
import com.dch.service.calculate.score.logic.type.PointScore;
import com.dch.service.calculate.score.logic.type.SetScore;

public class PlayerScore {
	private String username;
	private PointScore pointscore;
	private GameScore gamescore;
	private SetScore setScore;

	public PlayerScore(String username) {
		this.username = username;
		this.pointscore = new PointScore();
		this.gamescore = new GameScore();
		this.setScore = new SetScore();
	}

	public String getUsername() {
		return username;
	}

	public PointScore getPointScore() {
		return pointscore;
	}

	public GameScore getGameScore() {
		return gamescore;
	}

	public SetScore getSetScore() {
		return setScore;
	}

	
	
}
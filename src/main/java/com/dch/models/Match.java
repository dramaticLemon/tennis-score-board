package com.dch.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="matches")
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	@ManyToOne
	@JoinColumn(name="player1_id", referencedColumnName="id", nullable=false)
	Player alfa;

	@ManyToOne
	@JoinColumn(name="player2_id", referencedColumnName="id", nullable=false)
	Player omega;

	@ManyToOne
	@JoinColumn(name="winned_id", referencedColumnName="id", nullable=false)
	Player winner;

	public Match() {
	}

	public Match(Player player1, Player player2, Player winner) {
		this.alfa = player1;
		this.omega = player2;
		this.winner = winner;
	}
}

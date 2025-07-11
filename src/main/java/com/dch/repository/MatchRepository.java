package com.dch.repository;

import com.dch.models.Match;
import com.dch.models.Player;
import com.dch.utils.TransactionHelper;

import jakarta.persistence.EntityManagerFactory;

public class MatchRepository {
	TransactionHelper helper;
	EntityManagerFactory emf;

	public MatchRepository(TransactionHelper helper, EntityManagerFactory emf) {
		this.helper = helper;
		this.emf = emf;
	}

	public Match create(Player playerOjbectOne, Player playerObjecTwo, Player winnerObject) {
		Match match = new Match(playerOjbectOne, playerObjecTwo, winnerObject);
		return helper.executeInTransaction(emf -> {
			emf.persist(match);
			return match;
		});
	}

	
	
}

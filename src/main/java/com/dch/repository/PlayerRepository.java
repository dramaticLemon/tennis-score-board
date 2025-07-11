package com.dch.repository;

import java.util.List;

import com.dch.models.Player;
import com.dch.utils.TransactionHelper;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;

public class PlayerRepository {

	TransactionHelper transactionHelper;
	EntityManagerFactory emf;

	public PlayerRepository(TransactionHelper transactionHelper, EntityManagerFactory emf) {
		this.transactionHelper = transactionHelper;
		this.emf = emf;
	}

	public Player ferchPlayer(String name) {
		return transactionHelper.executeInTransaction(emf -> {
			try {
				return emf.createQuery(
					"select p from Player p where p.name = :name", Player.class
				).setParameter("name", name).getSingleResult();
			} catch (NoResultException e) {
				Player player = new Player(name);
				create(player);
				
				return player;
			}
		});
	}

	public Player create(Player player) {
		return transactionHelper.executeInTransaction(emf -> {
			emf.persist(player);

			return player;
		});
	}

	public List<Player> findAll() {
		return transactionHelper.executeInTransaction(emf -> {
			return emf.createQuery(
				"select p from Player p", Player.class
			).getResultList();
		});
	}
	
}

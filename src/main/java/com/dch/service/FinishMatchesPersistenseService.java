package com.dch.service;

import java.util.List;

import com.dch.models.Match;
import com.dch.models.Player;
import com.dch.repository.MatchRepository;
import com.dch.repository.PlayerRepository;
import com.dch.utils.TransactionHelper;

import jakarta.persistence.EntityManagerFactory;


/**
 * чтение и запись законченных матчей
 */
public class FinishMatchesPersistenseService{
	TransactionHelper transactionHelper;
	EntityManagerFactory emf;
	PlayerRepository playerRepository;
	MatchRepository matchRepository;

	public FinishMatchesPersistenseService(
		TransactionHelper transactionHelper,
		EntityManagerFactory emf, 
		PlayerRepository playerRepository,
		MatchRepository matchRepository) {
			
		this.transactionHelper = transactionHelper;
		this.emf = emf;
		this.playerRepository = playerRepository;
		this.matchRepository = matchRepository;
	}

	public void saveMatch (String playerNameOne, String playerNameTwo, String winnerName) {
		Player first = playerRepository.ferchPlayer(playerNameOne);
		Player last = playerRepository.ferchPlayer(playerNameTwo);
		Player winner = playerRepository.ferchPlayer(winnerName);
		matchRepository.create(first, last, winner);
	}

	// получить количество всех страниц
	public long countMatches() {
		return transactionHelper.executeInTransaction(em -> {
			return em.createQuery("SELECT COUNT(m) FROM Match m", Long.class)
			.getSingleResult();
		});
	}

	public List<Match> findMatchesPaginated(int page, int pageSize) {
		return transactionHelper.executeInTransaction(em -> {
			return em.createQuery(
				"select m from Match m", Match.class)
			.setFirstResult((page - 1) * pageSize)
			.setMaxResults(pageSize)
			.getResultList();
		});
	}

	public List<Match> findAll() {
		return transactionHelper.executeInTransaction(em -> {
			return em.createQuery(
					"select m from Match m", Match.class
			).getResultList();
		});
	}

	/**
	 * 
	 * @return список матчей в которых фигурирует имя 
	 */
	public List<Match> findMatchesByPlayerName(String name) {
    return transactionHelper.executeInTransaction(em -> {
        String jpql = "SELECT m FROM Match m WHERE m.alfa.name = :name OR m.omega.name = :name";
        return em.createQuery(jpql, Match.class)
                 .setParameter("name", name)
                 .getResultList();
    });
}

}

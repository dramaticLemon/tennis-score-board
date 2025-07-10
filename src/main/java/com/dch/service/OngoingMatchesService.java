package com.dch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dch.models.Player;
import com.dch.repository.PlayerRepository;

/**
 * хранение текущих матчей (запись и чтение)
 */
public class OngoingMatchesService {
	private static final Logger log = LoggerFactory.getLogger(OngoingMatchesService.class);
	PlayerRepository pRepository;

	public OngoingMatchesService(PlayerRepository pRepository) {
		this.pRepository = pRepository;
	}



	public void createMatch(String userNameOne, String userNameTwo) {

		Player playerOne = pRepository.ferchPlayer(userNameOne);
		Player playerTwo = pRepository.ferchPlayer(userNameTwo);

		log.info("player-one created -- {}", playerOne);
		log.info("player-two created -- {}", playerTwo);
		List<Player> list = pRepository.findAll();
		System.out.println(list);

	}
}

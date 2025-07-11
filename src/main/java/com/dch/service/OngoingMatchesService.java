package com.dch.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dch.models.Player;
import com.dch.repository.PlayerRepository;
import com.dch.service.calculate.score.logic.CurrentMatch;

/**
 * хранение текущих матчей (запись и чтение)
 */
public class OngoingMatchesService {
	private static final Logger log = LoggerFactory.getLogger(OngoingMatchesService.class);
	static final Map<String, CurrentMatch> currentMatches = new HashMap<>();
	PlayerRepository pRepository;
	
	public OngoingMatchesService(PlayerRepository pRepository) {
		this.pRepository = pRepository;
	}

	private String generateUUID() {
		return UUID.randomUUID().toString();
	}

	public String createMatch(String userNameOne, String userNameTwo) {

		Player playerOne = pRepository.ferchPlayer(userNameOne);
		Player playerTwo = pRepository.ferchPlayer(userNameTwo);

		String uuid = generateUUID();
		CurrentMatch currentMatch = new CurrentMatch(playerOne.getName(), playerTwo.getName());
		currentMatches.put(uuid, currentMatch);
		return uuid;
	}

	
	public void deleteMatchByUUID(String uuid) {
		currentMatches.remove(uuid);
		log.info("{} deleted", uuid);
	}

	public CurrentMatch getMatchbyUUID(String uuid) {
		return currentMatches.get(uuid);
	}

	

}

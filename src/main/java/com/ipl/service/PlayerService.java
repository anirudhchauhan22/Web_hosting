package com.ipl.service;

import java.util.List;

import com.ipl.dto.AddPlayerToTeamDto;
import com.ipl.dto.PlayerDto;
import com.ipl.entities.Player;

public interface PlayerService {

	List<PlayerDto> getAllPlayers();

	String addNewPlayer(AddPlayerToTeamDto player, Long teamId);

	String updatePlayer(Player player, Long playerId);

	Player findPlayerById(Long playerId);

	String deletePlayer(Long playerId);
}
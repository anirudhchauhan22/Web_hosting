package com.ipl.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.custom_exceptions.ResourceNotFoundException;
import com.ipl.dao.PlayerDao;
import com.ipl.dao.TeamDao;
import com.ipl.dto.AddPlayerToTeamDto;
import com.ipl.dto.PlayerDto;
import com.ipl.entities.Player;
import com.ipl.entities.Team;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TeamDao teamDao;

	@Override
	public List<PlayerDto> getAllPlayers() {
		// TODO Auto-generated method stub
		System.out.println("In getAllPlayers: " + getClass());
		List<Player> playerList = playerDao.findAll();
		List<PlayerDto> playerDtoList = new ArrayList<>();
		for (Player p : playerList) {
			playerDtoList.add(modelMapper.map(p, PlayerDto.class));
		}
		return playerDtoList;
	}

	@Override
	public String addNewPlayer(AddPlayerToTeamDto player, Long teamId) {
		// TODO Auto-generated method stub
		System.out.println("In addNewPlayer: " + getClass());
		if (teamDao.existsById(teamId)) {
			Team team = teamDao.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Invalid TeamId"));
			playerDao.save(modelMapper.map(player, Player.class));
			modelMapper.map(player, Player.class).setMyTeam(team);
			return "Player added successfully!!";
		}
		throw new ResourceNotFoundException("Invalid TeamId");
	}

	@Override
	public String updatePlayer(Player player, Long playerId) {
		// TODO Auto-generated method stub
		System.out.println("In updatePlayer: " + getClass());
		if (playerDao.existsById(playerId)) {
			playerDao.save(player);
			playerDao.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Invalid playerId"))
					.setMyTeam(player.getMyTeam());
		}
		throw new ResourceNotFoundException("Invalid playerId");
	}

	@Override
	public Player findPlayerById(Long playerId) {
		// TODO Auto-generated method stub
		System.out.println("In findPlayerById: " + getClass());
		if (playerDao.existsById(playerId)) {
//			return modelMapper.map(playerDao.findById(playerId), PlayerDto.class);
			return playerDao.findById(playerId).orElseThrow(()->new ResourceNotFoundException("Invalid playerId"));
		}
		throw new ResourceNotFoundException("Invalid playerId");
	}

	@Override
	public String deletePlayer(Long playerId) {
		// TODO Auto-generated method stub
		System.out.println("In deletePlayer: " + getClass());
		if (playerDao.existsById(playerId)) {
			playerDao.deleteById(playerId);
			return "Player deleted successfully!!";
		}
		throw new ResourceNotFoundException("Invalid playerId");
	}

}

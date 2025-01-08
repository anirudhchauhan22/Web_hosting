package com.ipl.service;

import java.util.List;

import com.ipl.dto.TeamDto;

public interface TeamService {

	List<TeamDto> getAllTeams();
	
	String addNewTeam(TeamDto team);
	
	String updateTeam(TeamDto team, Long teamId);
	
	TeamDto findTeamById(Long teamId);
	
	String deleteTeam(Long teamId);
}

package com.ipl.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.custom_exceptions.ResourceNotFoundException;
import com.ipl.dao.TeamDao;
import com.ipl.dto.TeamDto;
import com.ipl.entities.Team;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TeamDto> getAllTeams() {
		// TODO Auto-generated method stub
		System.out.println("In getAllTeams: " + getClass());
		List<Team> teamList = teamDao.findAll();
		List<TeamDto> teamDtoList = new ArrayList<>();
		for (Team t : teamList) {
			teamDtoList.add(modelMapper.map(t, TeamDto.class));
		}
		return teamDtoList;
	}

	@Override
	public String addNewTeam(TeamDto team) {
		// TODO Auto-generated method stub
		System.out.println("In addNewTeam: " + getClass());
		teamDao.save(modelMapper.map(team, Team.class));
		return "Team saved successfully!!";
	}

	@Override
	public String updateTeam(TeamDto team, Long teamId) {
		// TODO Auto-generated method stub
		System.out.println("In updateTeam: " + getClass());
		if (teamDao.existsById(teamId)) {
			teamDao.save(modelMapper.map(team, Team.class));
			return "Team updated successfully!!";
		}
		throw new ResourceNotFoundException("Invalid Team Id");
	}

	@Override
	public TeamDto findTeamById(Long teamId) {
		// TODO Auto-generated method stub
		System.out.println("In findTeamById: " + getClass());
		if (teamDao.existsById(teamId)) {
			return modelMapper.map(
					teamDao.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Invalid Id")),
					TeamDto.class);
		}
		throw new ResourceNotFoundException("Invalid Team Id");
	}

	@Override
	public String deleteTeam(Long teamId) {
		// TODO Auto-generated method stub
		System.out.println("In deleteTeam: " + getClass());
		if (teamDao.existsById(teamId)) {
			teamDao.deleteById(teamId);
			return "Team deleted successfully!!";
		}
		throw new ResourceNotFoundException("Invalid Team Id");
	}

}

package com.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.dto.TeamDto;
import com.ipl.service.TeamService;

import com.ipl.dto.ApiResponse;

@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllTeamsC() {
		return ResponseEntity.status(HttpStatus.FOUND).body(teamService.getAllTeams());
	}

	@PostMapping("/addNew")
	public ResponseEntity<?> addNewTeamC(@RequestBody TeamDto team) {
		return ResponseEntity.ok(new ApiResponse(teamService.addNewTeam(team)));
	}

	@PutMapping("/update/{teamId}")
	public ResponseEntity<?> updateTeamC(@RequestBody TeamDto team, @PathVariable Long teamId) {
		return ResponseEntity.ok(new ApiResponse(teamService.updateTeam(team, teamId)));
	}

	@GetMapping("/findById/{teamId}")
	public ResponseEntity<?> findTeamByIdC(@PathVariable Long teamId) {
		return ResponseEntity.status(HttpStatus.FOUND).body(teamService.findTeamById(teamId));
	}

	@DeleteMapping("/deleteById/{teamId}")
	public ResponseEntity<?> deleteTeamC(@PathVariable Long teamId) {
		return ResponseEntity.ok(new ApiResponse(teamService.deleteTeam(teamId)));
	}
}

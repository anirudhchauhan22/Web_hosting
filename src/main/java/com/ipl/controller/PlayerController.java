package com.ipl.controller;

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

import com.ipl.dto.AddPlayerToTeamDto;
import com.ipl.dto.ApiResponse;
import com.ipl.entities.Player;
import com.ipl.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllPlayersC() {
		return ResponseEntity.status(HttpStatus.FOUND).body(playerService.getAllPlayers());
	}

	@PostMapping("/addNew/{teamId}")
	public ResponseEntity<?> addNewPlayerC(@RequestBody AddPlayerToTeamDto player, @PathVariable Long teamId) {
		return ResponseEntity.ok(new ApiResponse(playerService.addNewPlayer(player, teamId)));
	}

	@PutMapping("/update/{playerId}")
	public ResponseEntity<?> updatePlayerC(@RequestBody Player player, @PathVariable Long playerId) {
		return ResponseEntity.ok(new ApiResponse(playerService.updatePlayer(player, playerId)));
	}

	@GetMapping("/findById/{playerId}")
	public ResponseEntity<?> findPlayerByIdC(@PathVariable Long playerId) {
		return ResponseEntity.status(HttpStatus.FOUND).body(playerService.findPlayerById(playerId));
	}

	@DeleteMapping("/delete/{playerId}")
	public ResponseEntity<?> deletePlayerC(Long playerId) {
		return ResponseEntity.ok(new ApiResponse(playerService.deletePlayer(playerId)));
	}

}

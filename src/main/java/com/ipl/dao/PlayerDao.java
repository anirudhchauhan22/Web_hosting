package com.ipl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.entities.Player;

public interface PlayerDao extends JpaRepository<Player, Long> {
//	List<Player> findByTeamId(Long teamId);

}

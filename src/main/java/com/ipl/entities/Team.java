package com.ipl.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

	@Column(name = "name", length = 25)
	private String name;

	@Column(length = 5)
	private String abbreviation;

	@Column(length = 5)
	private String owner;

	@Column(name = "max_age")
	private Long maxAge;

	public Team() {
		super();
	}

	public Team(String name, String abbreviation, String owner, Long maxAge) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
	}
	
	/*
	 * This is the inverse side of the relationship as it does not contain the F.K element.
	 * Team 1<---->* Players
	 */
	@OneToMany(mappedBy = "myTeam" , cascade = CascadeType.ALL, orphanRemoval = true)
	List<Player> players = new ArrayList<>();
	
	/*
	 * As this is the inverse side adding the helper functions here as per the recommendations
	 */
	public void addPlayer(Player player, Team team) {
		players.add(player);
		player.setMyTeam(team);
	}
	
	public void deletePlayer(Player player, Team team) {
		player.setMyTeam(null);
		players.remove(player);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Long getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Long maxAge) {
		this.maxAge = maxAge;
	}

}

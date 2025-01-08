package com.ipl.dto;

public class AddPlayerToTeamDto extends BaseDto {

	private String firstName;

	private String lastName;

	private String dateOfBirth;

	private Long teamId;

	public AddPlayerToTeamDto() {
		super();
	}

	public AddPlayerToTeamDto(String firstName, String lastName, String dateOfBirth, Long teamId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.teamId = teamId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
}

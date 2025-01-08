package com.ipl.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class BaseDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate createdOn;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate updatedOn;

	@JsonProperty(access = Access.READ_ONLY)
	private Float wicketAverage;

	@JsonProperty(access = Access.READ_ONLY)
	private Float battingAverage;

	public BaseDto() {
		super();
	}

	public BaseDto(Long id, LocalDate createdOn, LocalDate updatedOn, Float wicketAverage, Float battingAverage) {
		super();
		this.id = id;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.wicketAverage = wicketAverage;
		this.battingAverage = battingAverage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Float getWicketAverage() {
		return wicketAverage;
	}

	public void setWicketAverage(Float wicketAverage) {
		this.wicketAverage = wicketAverage;
	}

	public Float getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(Float battingAverage) {
		this.battingAverage = battingAverage;
	}
}

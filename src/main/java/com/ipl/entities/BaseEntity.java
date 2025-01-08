package com.ipl.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "created_on")
	@CreationTimestamp
	private LocalDate createdOn;

	@Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;

	@Column(name = "wicket_average")
	private Float wicketAverage;

	@Column(name = "batting_average")
	private Float battingAverage;

	public BaseEntity() {
		super();
	}

	public BaseEntity(Long id, LocalDate createdOn, LocalDate updatedOn, Float wicketAverage, Float battingAverage) {
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

package com.kh.coocon.lmsapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="lms_contracts")
public class Contract {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="contract_id")
	private int id;
	
	@Column(name="contract_name")
	private String contractName;
	
	@Column(name="started_date")
	private String startedDate;
	
	@Column(name="end_date")
	private String endDate;
	
	@Column(name="weekly_duration")
	private String weeklyDuration;
	
	@Column(name="daily_duration")
	private String dailyDuration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(String startedDate) {
		this.startedDate = startedDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWeeklyDuration() {
		return weeklyDuration;
	}

	public void setWeeklyDuration(String weeklyDuration) {
		this.weeklyDuration = weeklyDuration;
	}

	public String getDailyDuration() {
		return dailyDuration;
	}

	public void setDailyDuration(String dailyDuration) {
		this.dailyDuration = dailyDuration;
	}
	
	

}

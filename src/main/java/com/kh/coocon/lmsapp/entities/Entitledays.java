package com.kh.coocon.lmsapp.entities;

public class Entitledays {
	private String leavesTypes;
	private Double leavesAvailable;
	private float leavesTaken;
	private float leavesEntitled;
	public String getLeavesTypes() {
		return leavesTypes;
	}
	public void setLeavesTypes(String leavesTypes) {
		this.leavesTypes = leavesTypes;
	}
	public Double getLeavesAvailable() {
		return leavesAvailable;
	}
	public void setLeavesAvailable(Double leavesAvailable) {
		this.leavesAvailable = leavesAvailable;
	}
	public float getLeavesTaken() {
		return leavesTaken;
	}
	public void setLeavesTaken(float leavesTaken) {
		this.leavesTaken = leavesTaken;
	}
	public float getLeavesEntitled() {
		return leavesEntitled;
	}
	public void setLeavesEntitled(float leavesEntitled) {
		this.leavesEntitled = leavesEntitled;
	}
	

}

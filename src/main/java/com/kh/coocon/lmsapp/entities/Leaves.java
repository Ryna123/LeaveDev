package com.kh.coocon.lmsapp.entities;


public class Leaves {
	private int id;
	private int leaveEmployeeId;
	private int leavesStatus;
	private int leavesType;
	private String leavesStartdate;
	private String leavesEnddate;
	private String leavesReason;
	private String leavesStartDateType;
	private String leavesendDateType;
	private double leavesDuration;
	private String leavesEmpName;	
	
	public String getLeavesEmpName() {
		return leavesEmpName;
	}
	public void setLeavesEmpName(String leavesEmpName) {
		this.leavesEmpName = leavesEmpName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLeaveEmployeeId() {
		return leaveEmployeeId;
	}
	public void setLeaveEmployeeId(int leaveEmployeeId) {
		this.leaveEmployeeId = leaveEmployeeId;
	}
	public int getLeavesStatus() {
		return leavesStatus;
	}
	public void setLeavesStatus(int leavesStatus) {
		this.leavesStatus = leavesStatus;
	}
	public int getLeavesType() {
		return leavesType;
	}
	public void setLeavesType(int leavesType) {
		this.leavesType = leavesType;
	}
	public String getLeavesStartdate() {
		return leavesStartdate;
	}
	public void setLeavesStartdate(String leavesStartdate) {
		this.leavesStartdate = leavesStartdate;
	}
	public String getLeavesEnddate() {
		return leavesEnddate;
	}
	public void setLeavesEnddate(String leavesEnddate) {
		this.leavesEnddate = leavesEnddate;
	}
	public String getLeavesReason() {
		return leavesReason;
	}
	public void setLeavesReason(String leavesReason) {
		this.leavesReason = leavesReason;
	}
	public String getLeavesStartDateType() {
		return leavesStartDateType;
	}
	public void setLeavesStartDateType(String leavesStartDateType) {
		this.leavesStartDateType = leavesStartDateType;
	}
	public String getLeavesendDateType() {
		return leavesendDateType;
	}
	public void setLeavesendDateType(String leavesendDateType) {
		this.leavesendDateType = leavesendDateType;
	}
	public double getLeavesDuration() {
		return leavesDuration;
	}
	public void setLeavesDuration(double leavesDuration) {
		this.leavesDuration = leavesDuration;
	}
}
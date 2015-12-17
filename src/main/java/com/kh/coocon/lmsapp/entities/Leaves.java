package com.kh.coocon.lmsapp.entities;

import java.sql.Date;

public class Leaves {
	private int id;
	private int leaveEmployeeId;
	private int leavesStatus;
	private int leavesType;
	private Date leavesStartdate;
	private Date leavesEnddate;
	private String leavesReason;
	private String leavesStartDateType;
	private String leavesendDateType;
	private double leavesDuration;
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
	public Date getLeavesStartdate() {
		return leavesStartdate;
	}
	public void setLeavesStartdate(Date leavesStartdate) {
		this.leavesStartdate = leavesStartdate;
	}
	public Date getLeavesEnddate() {
		return leavesEnddate;
	}
	public void setLeavesEnddate(Date leavesEnddate) {
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
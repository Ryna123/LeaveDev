package com.kh.coocon.lmsapp.entities;

public class OverTime {
	private int id;
	private int oTEmployeeId;
	private int oTStatus_id;
	private String oTType; //day or hour
	private String oTReason;
	private String oTDate;
	private String oTEmpName;
	private String statusNm;
	private double oTDuration;
	
	
	public String getStatusNm() {
		return statusNm;
	}
	public void setStatusNm(String statusNm) {
		this.statusNm = statusNm;
	}
	
	public String getoTEmpName() {
		return oTEmpName;
	}
	public void setoTEmpName(String oTEmpName) {
		this.oTEmpName = oTEmpName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getoTEmployeeId() {
		return oTEmployeeId;
	}
	public void setoTEmployeeId(int oTEmployeeId) {
		this.oTEmployeeId = oTEmployeeId;
	}
	public int getoTStatus_id() {
		return oTStatus_id; 
	}
	public void setoTStatus_id(int oTStatus_id) {
		this.oTStatus_id = oTStatus_id;
	}
	public String getoTType() {
		return oTType;
	}
	public void setoTType(String oTType) {
		this.oTType = oTType;
	}
	public String getoTReason() {
		return oTReason;
	}
	public void setoTReason(String oTReason) {
		this.oTReason = oTReason;
	}
	public String getoTDate() {
		return oTDate;
	}
	public void setoTDate(String oTDate) {
		this.oTDate = oTDate;
	}
	public double getoTDuration() {
		return oTDuration;
	}
	public void setoTDuration(double oTDuration) {
		this.oTDuration = oTDuration;
	}
}

package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.OverTime;

public interface OverTimeService {
	public List<OverTime> getOTList(int userId);
	public boolean insertOT(OverTime OTObj, int Userid); 
	public List<OverTime> getAllOverTimeAdmin(int empId);
	public List<OverTime> getOtOneRecord(int otId,int empId);
	public List<OverTime> getOtOneRecordUser(int otId,int uId);
	public boolean updateStatusOvertime(int otId, String otAct );
	public boolean updateOvertime(OverTime OTObj, int otId, int uId);
	
}

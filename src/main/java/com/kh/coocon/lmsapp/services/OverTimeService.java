package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.OverTime;

public interface OverTimeService {
	public List<OverTime> getOTList(int userId);
	public boolean insertOT(OverTime OTObj, int Userid); 
	public List<OverTime> getAllOverTimeAdmin(int empId, String frstNm, String lstNm);
	
	
}

package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.LeaveType;

public interface LeaveTypeService {
	public List<LeaveType> getLeavesTypeList();
	public List<LeaveType> getLeavesStatus();
	
}

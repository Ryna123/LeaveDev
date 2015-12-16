package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.LeaveStaus;
import com.kh.coocon.lmsapp.entities.LeaveType;
import com.kh.coocon.lmsapp.entities.Leaves;

public interface LeaveTypeService {
	public List<LeaveType> getLeavesTypeList();
	public List<LeaveStaus> getLeavesStatus();
	public boolean addLeave(Leaves leaveObj);
}

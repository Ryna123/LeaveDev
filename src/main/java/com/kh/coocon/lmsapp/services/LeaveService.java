package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.Leaves;

public interface LeaveService {
	public List<Leaves> getLeavesList(int userId);
	public List<Leaves> getLeavesListAdmin(int userId);
	public boolean addLeaves(Leaves leavesObj, int Userid);
	public boolean deleteLeaves(int id);
	public boolean updateLeavesAdmin(int lid, String lact );
}

package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.ListUser;




public interface OrgUserService {
	public List<ListUser> getOrgUserList(int orgId, int managerId);


	
}

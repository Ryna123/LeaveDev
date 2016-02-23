package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.ListUser;

public interface ListUserService {
	public List<ListUser> getListUsers(int limit, int offset);
	
}

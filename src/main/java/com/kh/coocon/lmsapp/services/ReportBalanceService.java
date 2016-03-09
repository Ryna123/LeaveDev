package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.ListUser;

public interface ReportBalanceService {
	public List<ListUser> getListUsersReBalance(int offset, int limi);
	long CountRecord(String name);
}

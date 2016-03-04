package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.EntitledDayContract;

public interface EntitledDCService {
	List<EntitledDayContract> listEntitleDaysContract(int id);
	int addEntitleDaysContract();
	int deleteEntitleDaysContract();
	int updateEntitleDaysContract();
}

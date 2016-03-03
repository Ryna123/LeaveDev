package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.Contract;

public interface ContractService {
	List<Contract> listContract();
	int addContract(Contract contrast);
	void deleteContract(int id);
	int editContract(Contract contrast);
}

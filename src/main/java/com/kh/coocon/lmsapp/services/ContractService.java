package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.Contract;

public interface ContractService {
	List<Contract> listContract();
	void addContract(Contract contrast);
	void deleteContract(int id);
	void editContract(Contract contrast);
}

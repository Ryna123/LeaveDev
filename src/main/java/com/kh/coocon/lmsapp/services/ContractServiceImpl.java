package com.kh.coocon.lmsapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.coocon.lmsapp.dao.ContractDao;
import com.kh.coocon.lmsapp.entities.Contract;

@Transactional
@Service("contractService")
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	private ContractDao contractDao;

	@Override
	public List<Contract> listContract() {
		return this.contractDao.listContract();
	}

}

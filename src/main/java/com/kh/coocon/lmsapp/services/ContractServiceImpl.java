package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.coocon.lmsapp.dao.ContractDao;
import com.kh.coocon.lmsapp.entities.Contract;
import com.kh.coocon.lmsapp.entities.HrManagement;

@Transactional
@Service("contractService")
public class ContractServiceImpl implements ContractService {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ContractDao contractDao;

	@SuppressWarnings("null")
	@Override
	public List<Contract> listContract() {
		String sql="select contract_id, contract_name,weekly_duration,daily_duration, started_date,end_date from lms_contracts";
		System.out.println("start SQL");
		try {
			System.out.println("try block");
			Connection cnn= dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<Contract> contractList = new ArrayList<Contract>();
			Contract contract= new Contract();
			while (rs.next()) {
				contract.setId(rs.getInt("contract_id"));
				contract.setContractName(rs.getString("contract_name"));
				contract.setWeeklyDuration(rs.getString("weekly_duration"));
				contract.setDailyDuration(rs.getString("daily_duration"));
				contract.setStartedDate(rs.getString("started_date"));
				contract.setEndDate(rs.getString("end_date"));
				contractList.add(contract);
			}
			return (List<Contract>) contractList;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void addContract(Contract contrast) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContract(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editContract(Contract contrast) {
		// TODO Auto-generated method stub
		
	}


}

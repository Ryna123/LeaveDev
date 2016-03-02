package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;
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
		try {
			Connection cnn= dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<Contract> contractList = new ArrayList<Contract>();
			Contract contract= null;
			while (rs.next()) {
				contract= new Contract();
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
	public int addContract(Contract contrast) {
		String sql="insert into lms_contracts(contract_id ,contract_name,started_date,end_date) values(nextval('ctSerialID1'),?,?,?)";
		
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setString(1, contrast.getContractName());
			preparedStatement.setString(2, contrast.getStartedDate());
			preparedStatement.setString(3, contrast.getEndDate());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public void deleteContract(int id) {
		String sql="delete from lms_contracts where contract_id=?";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()==1){
				sql="delete from lms_entitleddays where contract_id=?";
				preparedStatement.setInt(1, id);
				preparedStatement.execute();
			}
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void editContract(Contract contrast) {
		// TODO Auto-generated method stub
		
	}


}

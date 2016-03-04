package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.coocon.lmsapp.entities.EntitledDayContract;

@Service("entitledDaysContrastService")
public class EntitledDCServiceImpl implements EntitledDCService {
	
	@Autowired DataSource dataSource;
	
	
	@Override
	public List<EntitledDayContract> listEntitleDaysContract(int id) {
		// TODO Auto-generated method stub
		String sql="select ent.id, ent.contract_id, to_char(ent.startdate, 'DD-MM-YYYY') as start,"
				+ "to_char(ent.enddate,'DD-MM-YYYY') as end,"
				+ "ent.days, ltp.name,ent.description "
				+ "from lms_entitleddays ent,lms_types ltp "
				+ "where ent.type_id=ltp.type_id and ent.contract_id = ?";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			EntitledDayContract enDC = null;
			List<EntitledDayContract> listDayContract = new ArrayList<EntitledDayContract>();
			while(rs.next()){
				enDC = new EntitledDayContract();
				enDC.setId(rs.getInt("id"));
				enDC.setContractId(rs.getInt("contract_id"));
				enDC.setStart(rs.getString("start"));
				enDC.setEnd(rs.getString("end"));
				enDC.setDays(rs.getInt("days"));
				enDC.setLeaveType(rs.getString("name"));
				enDC.setDescript(rs.getString("description"));
				listDayContract.add(enDC);
			}
			return listDayContract;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int addEntitleDaysContract(EntitledDayContract obj) {
		// TODO Auto-generated method stub
		String sql="";
		return 0;
	}

	@Override
	public int deleteEntitleDaysContract(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEntitleDaysContract(EntitledDayContract obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

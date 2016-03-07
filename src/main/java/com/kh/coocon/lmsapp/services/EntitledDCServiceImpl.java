package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		String sql="insert into lms_entitleddays(id,contract_id,type_id,startdate,enddate,days,description) "
				+ "values(nextval('entitleddc'),?,?,?,?,?,?)";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setInt(1, obj.getContractId());
			preparedStatement.setInt(2, obj.getLeaveTypeId());
			preparedStatement.setDate(3, convertStrToDate(obj.getStart()));
			preparedStatement.setDate(4, convertStrToDate(obj.getEnd()));
			preparedStatement.setInt(5, obj.getDays());
			preparedStatement.setString(6, obj.getDescript());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("error message");
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int deleteEntitleDaysContract(int id) {
		String sql="delete from lms_entitleddays where id = ?";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int updateEntitleDaysContract(EntitledDayContract obj) {
		// TODO Auto-generated method stub
		String sql="update lms_entitleddays set type_id=?, startdate=?, "
				+ "enddate=?, days=?, description=? where id=?";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setInt(1, obj.getLeaveTypeId());
			preparedStatement.setDate(2, convertStrToDate(obj.getStart()));
			preparedStatement.setDate(3, convertStrToDate(obj.getEnd()));
			preparedStatement.setInt(4, obj.getDays());
			preparedStatement.setString(5, obj.getDescript());
			preparedStatement.setInt(6, obj.getId());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	protected java.sql.Date convertStrToDate(String date){
		Date dateUtil;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateUtil = dateFormat.parse(date);
			java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
			return dateSql;
		} catch (Exception e) {
			System.out.println("error");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}

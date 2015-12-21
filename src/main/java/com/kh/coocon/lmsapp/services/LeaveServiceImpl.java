package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.coocon.lmsapp.entities.Leaves;


@Service
public class LeaveServiceImpl implements LeaveService  {
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Leaves> getLeavesList(int userId) {
		String sql	= " SELECT								      "   
					  + " 	A . ID,								      "   
					  + " 	A .employee_id,							      "   
					  + " 	A .status_id,							      "   
					  + " 	A .type_id,							      "   
					  + " 	A .startdate,							      "   
					  + " 	A .enddate,							      "   
					  + " 	A .cause,							      "   
					  + " 	A .startdatetype,						      "   
					  + " 	A .enddatetype,							      "   
					  + " 	A .duration,							      "   
					  + " 	b. NAME	as leavesStatus	,						      "   
					  + " 	d. NAME AS leavesType							      "   
					  + " FROM								      "   
					  + " 	lms_leaves A							      "   
					  + " LEFT JOIN lms_status b ON A .status_id = b.status_id		      "   
					  + " LEFT JOIN lms_types d ON A .type_id = d.type_id		      "   
					  + " LEFT JOIN lms_users C ON A .employee_id = C .id where employee_id =  ?    " ;  
	

	try (
		
		Connection cnn = dataSource.getConnection();
		PreparedStatement ps = cnn.prepareStatement(sql);
		
	)
	{
		
		ps.setInt(1, userId);
		System.out.println("sql  query " +ps);
		ResultSet rs = ps.executeQuery();
		ArrayList<Leaves> ll = new ArrayList<Leaves>();
		Leaves leave = null;
		while (rs.next()) {
			leave = new Leaves();				
			leave.setLeavesStartdate(rs.getDate("startdate"));
			leave.setLeavesEnddate(rs.getDate("enddate"));
			leave.setLeavesReason(rs.getString("cause"));
			leave.setLeavesStartDateType(rs.getString("startdatetype"));
			leave.setLeavesendDateType(rs.getString("enddatetype"));
			leave.setLeavesDuration(rs.getDouble("duration"));
			leave.setLeavesStatus(rs.getString("leavesStatus"));
			leave.setLeavesType(rs.getString("leavesType"));
			ll.add(leave);
		}
		return ll;
	} catch (SQLException e) {
		System.out.println(e);
	} 
	return null;
	}

	@Override
	public boolean addLeaves(Leaves lo, int Userid) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO lms_leaves ( "
				 + "ID,		   " 
				 + "employee_id,   " 
				 + "status_id,	   " 
				 + "type_id,	   " 
				 + "startdate,	   " 
				 + "enddate,	   " 
				 + "cause,	       " 
				 + "startdatetype, " 
				 + "enddatetype,   " 
				 + "duration	   " 
				 + ") "
			+" VALUES "
				 + "(   "
				 + "nextval('lmsLeave_sequence') ,?,?,?,?,?,?,?,?,? "
				 + ")";

		try(
				Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
			) 
		{
			ps.setInt(1, Userid);
			ps.setString(2, lo.getLeavesStatus());
			ps.setString(3, lo.getLeavesType());
			ps.setDate(4, lo.getLeavesStartdate());
			ps.setDate(5, lo.getLeavesEnddate());
			ps.setString(6, lo.getLeavesReason());
			ps.setString(7, lo.getLeavesStartDateType());
			ps.setString(8, lo.getLeavesendDateType());
			ps.setDouble(9, lo.getLeavesDuration());
			
			
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}

	@Override
	public boolean deleteLeaves(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLeaves(Leaves leavesObj) {
		// TODO Auto-generated method stub
		return false;
	}
	
}	

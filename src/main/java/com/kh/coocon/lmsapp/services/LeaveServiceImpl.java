package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
					  + " 	CONCAT_WS(' ',c.first_name,c.last_name) as employee_name,"   
					  + " 	d. NAME AS leavesType							      "   
					  + " FROM								      "   
					  + " 	lms_leaves A							      "   
					  + " LEFT JOIN lms_status b ON A .status_id = b.status_id		      "   
					  + " LEFT JOIN lms_types d ON A .type_id = d.type_id		      "   
					  + " LEFT JOIN lms_users C ON A .employee_id = C .id where employee_id =  ?  ORDER BY id DESC " ;  
	

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
			leave.setId(rs.getInt("id"));
			leave.setLeavesStartdate(rs.getString("startdate"));
			leave.setLeavesEnddate(rs.getString("enddate"));
			leave.setLeavesReason(rs.getString("cause"));
			leave.setLeavesStartDateType(rs.getString("startdatetype"));
			leave.setLeavesendDateType(rs.getString("enddatetype"));
			leave.setLeavesDuration(rs.getDouble("duration"));
			leave.setLeavesStatus(rs.getString("status_id"));
			leave.setLeavesType(rs.getString("type_id"));
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
				/* + "ID,		   " */
				 + "employee_id,   " 
				 + "status_id,	   " 
				 + "type_id,	   " 
				 + "startdate,	   " 
				 + "enddate,	   " 
				 + "cause,	       " 
				 + "startdatetype, " 
				 + "enddatetype,   " 
				 + "duration,	   " 
				 + "requested_date	   " 
				 + ") "
			+" VALUES "
				 + "(   "
				 + /*"nextval('lmsLeave_sequence') ,*/"?,?,?,?,?,?,?,?,?,?"
				 + ")";

		try(
				Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
			) 
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			ps.setString(10, dateFormat.format(date));
			ps.setInt(1, Userid);
			ps.setInt(2, Integer.parseInt(lo.getLeavesStatus()));
			ps.setInt(3, Integer.parseInt(lo.getLeavesType()));
			ps.setString(4, lo.getLeavesStartdate().replace("/", "-"));
			ps.setString(5, lo.getLeavesEnddate().replace("/", "-"));
			ps.setString(6, lo.getLeavesReason());
			ps.setString(7, lo.getLeavesStartDateType());
			ps.setString(8, lo.getLeavesendDateType());
			ps.setDouble(9, lo.getLeavesDuration());
			ps.setString(10, dateFormat.format(date));
			System.out.println(ps);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		
		return false;
	}

	@Override
	public boolean deleteLeaves(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Leaves> getLeavesListAdmin(int userId) {
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
				  + " 	CONCAT_WS(' ',c.first_name,c.last_name) as employee_name,"   
				  + " 	d. NAME AS leavesType							      "   
				  + " FROM								      "   
				  + " 	lms_leaves A							      "   
				  + " LEFT JOIN lms_status b ON A .status_id = b.status_id		      "   
				  + " LEFT JOIN lms_types d ON A .type_id = d.type_id		      "   
				  + " LEFT JOIN lms_users C ON A .employee_id = C .id where manager_id =  ? and employee_id != ?  ORDER BY id DESC   " ;  


		try (
			
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			
		)
		{
			
			ps.setInt(1, userId);
			ps.setInt(2, userId);
			System.out.println("sql  query " +ps);
			ResultSet rs = ps.executeQuery();
			ArrayList<Leaves> ll = new ArrayList<Leaves>();
			Leaves leave = null;
			while (rs.next()) {
				leave = new Leaves();				
				leave.setLeavesStartdate(rs.getString("startdate"));
				leave.setLeavesEnddate(rs.getString("enddate"));
				leave.setLeavesReason(rs.getString("cause"));
				leave.setLeavesStartDateType(rs.getString("startdatetype"));
				leave.setLeavesendDateType(rs.getString("enddatetype"));
				leave.setLeavesDuration(rs.getDouble("duration"));
				leave.setLeavesStatus(rs.getString("status_id"));
				leave.setLeavesType(rs.getString("type_id"));
				leave.setLeavesEmpName(rs.getString("employee_name"));;
				leave.setId(rs.getInt("id"));
				ll.add(leave);
			}
			return ll;
		} catch (SQLException e) {
			System.out.println(e);
		} 
		return null;
	}

	@Override
	public boolean updateLeavesAdmin(int lid, String lact) {
		String sql =   "UPDATE lms_leaves	    " 
					 + "SET status_id = ?	,    " 
					 + "edited_date = ?	    " 
					 + "WHERE		    		" 
					 + "	ID = ?		    	" ;

		try(
				Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
			) 
		{
			if(lact.endsWith("AP")) {
				ps.setInt(1, 2);
			} else {
				ps.setInt(1, 3);
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			//System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
			ps.setString(2, dateFormat.format(date));
			ps.setInt(3, lid);
			
			
			
			System.out.println(ps);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		
		return false;
	}

	@Override
	public List<Leaves> selectOneRecord(int lid , int userId) {
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
				  + " 	CONCAT_WS(' ',c.first_name,c.last_name) as employee_name,"   
				  + " 	d. NAME AS leavesType							      "   
				  + " FROM								      "   
				  + " 	lms_leaves A							      "   
				  + " LEFT JOIN lms_status b ON A .status_id = b.status_id		      "   
				  + " LEFT JOIN lms_types d ON A .type_id = d.type_id		      "   
				  + " LEFT JOIN lms_users C ON A .employee_id = C .id where manager_id =  ? and employee_id != ? AND A.id = ? ORDER BY id DESC   " ;  


		try (
			
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			
		)
		{
			
			ps.setInt(1, userId);
			ps.setInt(2, userId);
			ps.setInt(3, lid);
			System.out.println("sql  query " +ps);
			ResultSet rs = ps.executeQuery();
			ArrayList<Leaves> ll = new ArrayList<Leaves>();
			Leaves leave = null;
			while (rs.next()) {
				leave = new Leaves();				
				leave.setLeavesStartdate(rs.getString("startdate"));
				leave.setLeavesEnddate(rs.getString("enddate"));
				leave.setLeavesReason(rs.getString("cause"));
				leave.setLeavesStartDateType(rs.getString("startdatetype"));
				leave.setLeavesendDateType(rs.getString("enddatetype"));
				leave.setLeavesDuration(rs.getDouble("duration"));
				leave.setLeavesStatus(rs.getString("status_id"));
				leave.setLeavesType(rs.getString("type_id"));
				leave.setLeavesEmpName(rs.getString("employee_name"));;
				leave.setId(rs.getInt("id"));
				ll.add(leave);
			}
			return ll;
		} catch (SQLException e) {
			System.out.println(e);
		} 
		return null;
	}

	@Override
	public List<Leaves> selectOneRecordUser(int lid, int Uid) {
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
				  + " 	CONCAT_WS(' ',c.first_name,c.last_name) as employee_name,"   
				  + " 	d. NAME AS leavesType							      "   
				  + " FROM								      "   
				  + " 	lms_leaves A							      "   
				  + " LEFT JOIN lms_status b ON A .status_id = b.status_id		      "   
				  + " LEFT JOIN lms_types d ON A .type_id = d.type_id		      "   
				  + " LEFT JOIN lms_users C ON A .employee_id = C .id where employee_id = ? AND A.id = ? ORDER BY id DESC   " ;  


		try (
			
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			
		)
		{
			
			ps.setInt(1, Uid);
			ps.setInt(2, lid);
			System.out.println("sql  query " +ps);
			ResultSet rs = ps.executeQuery();
			ArrayList<Leaves> ll = new ArrayList<Leaves>();
			Leaves leave = null;
			while (rs.next()) {
				leave = new Leaves();				
				leave.setLeavesStartdate(rs.getString("startdate"));
				leave.setLeavesEnddate(rs.getString("enddate"));
				leave.setLeavesReason(rs.getString("cause"));
				leave.setLeavesStartDateType(rs.getString("startdatetype"));
				leave.setLeavesendDateType(rs.getString("enddatetype"));
				leave.setLeavesDuration(rs.getDouble("duration"));
				leave.setLeavesStatus(rs.getString("status_id"));
				leave.setLeavesType(rs.getString("type_id"));
				leave.setLeavesEmpName(rs.getString("employee_name"));;
				leave.setId(rs.getInt("id"));
				ll.add(leave);
			}
			return ll;
		} catch (SQLException e) {
			System.out.println(e);
		} 
		return null;
	}

	
}	

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

import com.kh.coocon.lmsapp.entities.LeaveType;
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService  {
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<LeaveType> getLeavesTypeList() {
		String sql	= "SELECT	type_id,	NAME FROM	lms_types"   ;	
				try (
					
					Connection cnn = dataSource.getConnection();
					PreparedStatement ps = cnn.prepareStatement(sql);
					
				)
				{
					ResultSet rs = ps.executeQuery();
					ArrayList<LeaveType> ll = new ArrayList<LeaveType>();
					LeaveType lt = null;
					while (rs.next()) {
						lt = new LeaveType();				
						lt.setTypeId(rs.getInt("type_id"));
						lt.setTypeName(rs.getString("name"));
						ll.add(lt);
					}
					return ll;
				} catch (SQLException e) {
					System.out.println(e);
				} 
				return null;
	
		}

	@Override
	public List<LeaveType> getLeavesStatus() {
		String sql	= "select status_id, name  from lms_status where status_id in(1,4) ORDER BY status_id"   ;	
		try (
			
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			
		)
		{
			ResultSet rs = ps.executeQuery();
			ArrayList<LeaveType> ll = new ArrayList<LeaveType>();
			LeaveType ls = null;
			while (rs.next()) {
				ls = new LeaveType();				
				ls.setStatusId(rs.getInt("status_id"));
				ls.setStatusName(rs.getString("name"));
				ll.add(ls);
			}
			return ll;
		} catch (SQLException e) {
			System.out.println(e);
		} 
		return null;

	}
}
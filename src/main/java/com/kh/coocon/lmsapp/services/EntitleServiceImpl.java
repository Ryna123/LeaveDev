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

import com.kh.coocon.lmsapp.entities.Entitledays;

@Service
public class EntitleServiceImpl implements EntitleService{
	@Autowired
	private DataSource dataSource;
	
	@Override
	public boolean addUser(Entitledays b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Entitledays b) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Entitledays> getEntitiledList(int userId, int statusId) {
		String sql	= " SELECT								"   
				+ " 	leaveType,							"   
				+ " 	(entitled - taken) AS available,				"   
				+ " 	taken,								"   
				+ " 	entitled							"   
				+ " FROM								"   
				+ " 	(								"   
				+ " 		SELECT							"   
				+ " 			SUM (A .duration) AS taken,			"   
				+ " 			b. NAME AS leaveType,				"   
				+ " 			MIN (C .days) AS entitled			"   
				+ " 		FROM							"   
				+ " 			lms_leaves A					"   
				+ " 		LEFT JOIN lms_types b ON b.type_id = A .type_id		"   
				+ " 		LEFT JOIN lms_entitleddays C ON b.type_ID = C .TYPE_id	"   
				+ " 		WHERE							"   
				+ " 			A .employee_id = ?				"   
				+ " 		AND A .status_id = ?					"   
				+ " 		GROUP BY						"   
				+ " 		NAME							"   
				+ " 	ORDER BY							"   
				+ " 		taken							"   
				+ " ) AS mytable							";  	

	try (
		
		Connection cnn = dataSource.getConnection();
		PreparedStatement ps = cnn.prepareStatement(sql);
		
	)
	{
		ps.setInt(1, userId);
		ps.setInt(2, statusId);
		System.out.println(ps);
		ResultSet rs = ps.executeQuery();
		ArrayList<Entitledays> a = new ArrayList<Entitledays>();
		Entitledays b = null;
		while (rs.next()) {
			b = new Entitledays();				
			b.setLeavesAvailable(rs.getDouble("available"));
			b.setLeavesTypes(rs.getString("leaveType"));
			b.setLeavesTaken(rs.getFloat("taken"));
			b.setLeavesEntitled(rs.getFloat("entitled"));
			a.add(b);
		}
		return a;
	} catch (SQLException e) {
		System.out.println(e);
	} 
	return null;
	}

	@Override
	public List<Entitledays> list() {
		// TODO Auto-generated method stub
		return null;
	}

}

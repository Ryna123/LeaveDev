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

import com.kh.coocon.lmsapp.entities.ListUser;
@Service
public  class ListUserServiceImpl implements ListUserService{
	@Autowired
	private DataSource dataSource;
	
	public List<ListUser> getListUsers() {
		String sql	= "SELECT "
				+ " 	a.id as id,  " 
				+ "		a.first_name as firstname," 
				+ "		a.last_name as lastname," 
				+ "		a.login as login," 
				+ "		a.email as email," 
				+ "		a.phone as phone," 
				+ "		b.name as role," 
				+ "		CONCAT_WS(' ',c.first_name,c.last_name) as manager_name" 
				+ "		from lms_users a" 
				+ "		LEFT JOIN lms_roles b on a.role =b.id" 
				+ "		LEFT JOIN lms_users c on c.id = a.manager_id" 
				+ "		ORDER BY id asc"  ;	
				try (
					
					Connection cnn = dataSource.getConnection();
					PreparedStatement ps = cnn.prepareStatement(sql);
					
				)
				{
					System.out.println("sql  query " +ps);
					ResultSet rs = ps.executeQuery();
					ArrayList<ListUser> ll = new ArrayList<ListUser>();
					ListUser lt = null;
					while (rs.next()) {
						lt = new ListUser();				
						lt.setFirstname(rs.getString("first_name"));
						lt.setLastname(rs.getString("last_name"));
						lt.setEamil(rs.getString("email"));
						lt.setPhone(rs.getInt("phone"));
						ll.add(lt);
					}
					return ll;
				} catch (SQLException e) {
					System.out.println(e);
				} 
				return null;


	}

	public List<ListUser> getListUList() {
		// TODO Auto-generated method stub
		return null;
	}

}
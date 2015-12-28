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
				+ "		a.sso_id as login," 
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
					
					ResultSet rs = ps.executeQuery();
					ArrayList<ListUser> ll = new ArrayList<ListUser>();
					ListUser lu = null;
					while (rs.next()) {
						lu = new ListUser();
						lu.setId(rs.getInt("id"));
						lu.setFirstname(rs.getString("firstname"));
						lu.setLastname(rs.getString("lastname"));
						lu.setEmail(rs.getString("email"));
						lu.setLogin(rs.getString("login"));
						lu.setRole(rs.getString("role"));
						lu.setPhone(rs.getInt("phone"));
						lu.setManagername(rs.getString("manager_name"));
						
						ll.add(lu);
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
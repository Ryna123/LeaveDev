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
	
	public List<ListUser> getListUsers(int offset, int limit) {
		String sql	= "SELECT "
				+ " 	this_.id as id,  " 
				+ "		this_.first_name as firstName," 
				+ "		this_.last_name as lastName," 
				+ "		this_.sso_id as username," 
				+ "		this_.email as email," 
				+ "		this_.phone as phone," 				
				+ "		CONCAT_WS(' ',c.first_name,c.last_name) as manager_name,"
				+ "		profile1_.NAME as role"				
				+ "		from lms_users this_" 					
				+ "		LEFT JOIN lms_users c on c.id = this_.manager_id"
				+ "		LEFT OUTER JOIN"
				+ "		LMS_USER_ROLES userprofil3_"
				+ "			on this_.id=userprofil3_.USER_ID"
				+ "		left outer join"
				+ "		LMS_ROLES profile1_"
				+ "			on userprofil3_.USER_PROFILE_ID=profile1_.id"
				+ "		ORDER BY id DESC"
				+ "		LIMIT ?"
				+ "		OFFSET ?"				
				+ "		" ;	
				
				System.out.println(sql);
				try (
					
					Connection cnn = dataSource.getConnection();
					PreparedStatement ps = cnn.prepareStatement(sql);
					
				)
				{
					ps.setInt(1, offset);
					ps.setInt(2, limit);
					ResultSet rs = ps.executeQuery();
					ArrayList<ListUser> ll = new ArrayList<ListUser>();
					ListUser lu = null;
					while (rs.next()) {
						lu = new ListUser();
						lu.setId(rs.getInt("id"));
						lu.setFirstName(rs.getString("firstName"));
						lu.setLastName(rs.getString("lastName"));
						lu.setEmail(rs.getString("email"));
						lu.setUsername(rs.getString("username"));
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
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
public  class OrgUserServiceImpl implements OrgUserService {
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<ListUser> getOrgUserList(int orgId, int managerId) {
		String sql	="SELECT id,identifier,first_name,last_name,email, phone,manager_id FROM lms_users"
				+" WHERE organization_id = ?  AND manager_id = ? ";
			
	
			
			try (
				
				Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
				
			)
			{
				ps.setInt(1,orgId);
				ps.setInt(2,managerId);
				System.out.println("HELOO"+ sql);
				ResultSet rs = ps.executeQuery();
				ArrayList<ListUser> userlist = new ArrayList<ListUser>();
				ListUser lu = null;
				while (rs.next()) {
					lu = new ListUser();
					lu.setId(rs.getInt("id"));
					lu.setManagerId(rs.getInt("manager_id"));
					lu.setIdentifier(rs.getString("identifier"));
					lu.setFirstName(rs.getString("first_name"));
					lu.setLastName(rs.getString("last_name"));
					lu.setEmail(rs.getString("email"));
					lu.setPhone(rs.getInt("phone"));
					
					
					userlist.add(lu);
				}
				return userlist;
			} catch (SQLException e) {
				System.out.println(e);
			} 
			return null;
	}



}
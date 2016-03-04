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

import com.kh.coocon.lmsapp.entities.Organization;


@Service
public  class OrgServiceImpl implements OrgService {
	@Autowired
	private DataSource dataSource;
	
	public List<Organization> getOrgList() {
//		String sql	=" SELECT a.organization_id,a.parent_id, a.name,b.name,a.organization_id " 
//				+ "	FROM lms_organization a " 
//				+ "	LEFT JOIN lms_organization b " 
//				+ "	ON b.parent_id = a.organization_id" ;
		
		String sql	="select * from lms_organization";
				
		
				System.out.println(sql);
				try (
					
					Connection cnn = dataSource.getConnection();
					PreparedStatement ps = cnn.prepareStatement(sql);
					
				)
				{
					
					ResultSet rs = ps.executeQuery();
					ArrayList<Organization> ll = new ArrayList<Organization>();
					Organization org = null;
					while (rs.next()) {
						org = new Organization();
						org.setSupervisor(rs.getInt("supervisor"));
						org.setId(rs.getInt("organization_id"));
						org.setParent_id(rs.getInt("parent_id"));
						org.setName(rs.getString("name"));
				//		org.setParent_id(rs.getInt("parent_id"));
						
						
						ll.add(org);
					}
					return ll;
				} catch (SQLException e) {
					System.out.println(e);
				} 
				return null;


	}

	public List<Organization> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
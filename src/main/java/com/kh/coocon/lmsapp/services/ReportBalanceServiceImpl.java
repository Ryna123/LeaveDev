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
public   class ReportBalanceServiceImpl implements ReportBalanceService{
	@Autowired
	private DataSource dataSource;
	@Override
	public List<ListUser> getListUsersReBalance(int offset, int limit) {
		String sql	= "SELECT "
				+ " 	a.identifier,  " 
				+ "		a.first_name," 
				+ "		a.last_name," 
				+ "		b.name as orgNm," 
				+ "		c.name as positionNm," 
				+ "		a.datehired," 				
				+ "		a.phone,"
				+ "		f.name as typeNm"				
				+ "		FROM lms_users a" 					
				+ "		LEFT JOIN lms_organization b on b.organization_id = a.organization_id"
				+ "		LEFT JOIN lms_positions c on a.position_id = c.position_id"
				+ "		LEFT JOIN lms_contracts d on d.contract_id = a.contract_id "
				+ "		LEFT JOIN lms_entitleddays e on e.contract_id = d.contract_id  "
				+ "		LEFT JOIN lms_types f on f.type_id = e.type_id"
				+ "		ORDER BY first_name DESC"
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
						lu.setIdentifier(rs.getString("identifier"));
						lu.setFirstName(rs.getString("first_name"));
						lu.setLastName(rs.getString("last_name"));
						lu.setDeptNm(rs.getString("orgNm"));
						lu.setPosition(rs.getString("positionNm"));
						lu.setHiredDate(rs.getString("datehired"));
						lu.setPhone(rs.getInt("phone"));
						
						ll.add(lu);
					}
					return ll;
				} catch (SQLException e) {
					System.out.println(e);
				} 
				return null;


	}
	@Override
	public long CountRecord(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<ListUser> getListUsersReBalanceFindByManager(int managerId,int offset, int limit) {
		String sql	= "SELECT "
				+ " 	a.identifier,  " 
				+ "		a.first_name," 
				+ "		a.last_name," 
				+ "		b.name as orgNm," 
				+ "		c.name as positionNm," 
				+ "		a.datehired," 				
				+ "		a.phone,"
				+ "		f.name as typeNm"				
				+ "		FROM lms_users a" 					
				+ "		LEFT JOIN lms_organization b on b.organization_id = a.organization_id"
				+ "		LEFT JOIN lms_positions c on a.position_id = c.position_id"
				+ "		LEFT JOIN lms_contracts d on d.contract_id = a.contract_id "
				+ "		LEFT JOIN lms_entitleddays e on e.contract_id = d.contract_id  "
				+ "		LEFT JOIN lms_types f on f.type_id = e.type_id"
				+"      WHERE b.organization_id =  ?"
				+ "		ORDER BY first_name DESC"
				+ "		LIMIT ?"
				+ "		OFFSET ?"				
				+ "		" ;	
				
				
				try (
					
					Connection cnn = dataSource.getConnection();
					PreparedStatement ps = cnn.prepareStatement(sql);
					
				)
				{
					ps.setInt(1, managerId);
					ps.setInt(2, offset);
					ps.setInt(3, limit);
					
					ResultSet rs = ps.executeQuery();
					System.out.println(sql);
					ArrayList<ListUser> ll = new ArrayList<ListUser>();
					ListUser lu = null;
					while (rs.next()) {
						lu = new ListUser();
						lu.setIdentifier(rs.getString("identifier"));
						lu.setFirstName(rs.getString("first_name"));
						lu.setLastName(rs.getString("last_name"));
						lu.setDeptNm(rs.getString("orgNm"));
						lu.setPosition(rs.getString("positionNm"));
						lu.setHiredDate(rs.getString("datehired"));
						lu.setPhone(rs.getInt("phone"));
						
						ll.add(lu);
					}
					return ll;
				} catch (SQLException e) {
					System.out.println(e);
				} 
				return null;
	}
	

}
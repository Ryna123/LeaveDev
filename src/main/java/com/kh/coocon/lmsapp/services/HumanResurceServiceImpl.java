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

import com.kh.coocon.lmsapp.entities.HrManagement;

@Service("humanResourceService")
public class HumanResurceServiceImpl implements HumanResurceService {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<HrManagement> getAllEmp() {
		// TODO Auto-generated method stub
		String sql = "select u.id, u.first_name, u.last_name, u.phone, u.email, "
				+ "org.name as department, ct.contract_name as contrast, u.manager_id from lms_users u "
				+ "JOIN lms_organization org on (u.organization_id = org.organization_id) "
				+ "JOIN lms_contracts ct on (u.contract_id = ct.contract_id) ORDER BY u.id ASC";
		
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List <HrManagement> list= new ArrayList<HrManagement>();
			HrManagement hrmng = null;
			while (rs.next()) {
				hrmng= new HrManagement();
				hrmng.setId(rs.getInt("id"));
				hrmng.setFirstName(rs.getString("first_name"));
				hrmng.setLastName(rs.getString("last_name"));
				hrmng.setPhone(rs.getString("phone"));
				hrmng.setEmail(rs.getString("email"));
				hrmng.setDepartment(rs.getString("department"));
				hrmng.setContract(rs.getString("contrast"));
				hrmng.setManager(rs.getInt("manager_id"));
				list.add(hrmng);
			}
			return (List<HrManagement>)list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

}

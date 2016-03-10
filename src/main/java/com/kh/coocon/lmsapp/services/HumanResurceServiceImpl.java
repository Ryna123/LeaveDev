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
		String sql = "select u.id, u.first_name, u.last_name, u.phone, u.email,u.state, "
				+ "org.name as department, ct.contract_name as contrast, concat_ws(' ',m.first_name,m.last_name) as manager_name from lms_users u "
				+ "JOIN lms_organization org on (u.organization_id = org.organization_id) "
				+ "JOIN lms_contracts ct on (u.contract_id = ct.contract_id)"
				+ "LEFT OUTER JOIN lms_users m on (m.id=u.manager_id) where u.state <> 'Inactive' and u.state <> 'Deleted' ORDER BY u.id ASC";
		
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List <HrManagement> list= new ArrayList<HrManagement>();
			HrManagement hrmng = new HrManagement();
			while (rs.next()) {
				hrmng= new HrManagement();
				hrmng.setId(rs.getInt("id"));
				hrmng.setStatus(rs.getString("state"));
				hrmng.setFirstName(rs.getString("first_name"));
				hrmng.setLastName(rs.getString("last_name"));
				hrmng.setPhone(rs.getString("phone"));
				hrmng.setEmail(rs.getString("email"));
				hrmng.setDepartment(rs.getString("department"));
				hrmng.setContract(rs.getString("contrast"));
				hrmng.setManager(rs.getString("manager_name"));
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


	@Override
	public List<HrManagement> getEmpByOrg(int orgId) {
		String sql = "select u.id, u.first_name, u.last_name, u.phone, u.email,u.state, "
				+ "org.name as department, ct.contract_name as contrast, concat_ws(' ',m.first_name,m.last_name) as manager_name from lms_users u "
				+ "JOIN lms_organization org on (u.organization_id = org.organization_id) "
				+ "JOIN lms_contracts ct on (u.contract_id = ct.contract_id)"
				+ "LEFT OUTER JOIN lms_users m on (m.id=u.manager_id) where u.state <> 'Inactive' and u.state <> 'Deleted' and u.organization_id=? or org.parent_id=? ORDER BY u.id ASC";
		
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setInt(1, orgId);
			preparedStatement.setInt(2, orgId);
			ResultSet rs = preparedStatement.executeQuery();
			List <HrManagement> list= new ArrayList<HrManagement>();
			HrManagement hrmng = null;
			while (rs.next()) {
				hrmng= new HrManagement();
				hrmng.setId(rs.getInt("id"));
				hrmng.setStatus(rs.getString("state"));
				hrmng.setFirstName(rs.getString("first_name"));
				hrmng.setLastName(rs.getString("last_name"));
				hrmng.setPhone(rs.getString("phone"));
				hrmng.setEmail(rs.getString("email"));
				hrmng.setDepartment(rs.getString("department"));
				hrmng.setContract(rs.getString("contrast"));
				hrmng.setManager(rs.getString("manager_name"));
				list.add(hrmng);
			}
			return (List<HrManagement>)list;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		return null;
	}

}

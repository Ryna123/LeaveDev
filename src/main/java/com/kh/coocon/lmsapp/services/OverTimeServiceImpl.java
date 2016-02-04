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

import com.kh.coocon.lmsapp.entities.OverTime;

@Service
public  class OverTimeServiceImpl implements OverTimeService {
	@Autowired
	private DataSource dataSource;
 
	@Override
	public boolean insertOT(OverTime OTObj, int Userid) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO lms_overtime ( " + "ID,"
				+ "employee_id,   " + "status_id,	   " + "ot_type,	   "
				+ "date,	 	   " + "duration,	   " + "cause"+")"
				+ " VALUES " + "(" + "nextval('lmsot_sequence'),?,?,?,?,?,?"
				+ ")";

		try (Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);) {
			ps.setInt(1, Userid);
			ps.setInt(2, OTObj.getoTStatus_id());
			ps.setInt(3, OTObj.getoTType());
			ps.setString(4, OTObj.getoTDate());
			ps.setDouble(5, OTObj.getoTDuration());
			ps.setString(6, OTObj.getoTReason());
			System.out.println(ps);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	@Override
	public List<OverTime> getOTList(int userId) {
		String sql = " SELECT								      "
				+ " 	A . ID,								      "
				+ " 	A .employee_id,							      "
				+ " 	A .status_id,							      "
				+ " 	A .ot_type,							      "
				+ " 	A .date,							      "
				+ " 	A .cause,							      "
				+ " 	A .duration,							      "
				+ " 	b. name	as otStatus	,						      "
				+ " 	CONCAT_WS(' ',c.first_name,c.last_name) as employee_name"
				+ " FROM								      "
				+ " 	lms_overtime A							      "
				+ " LEFT JOIN lms_status b ON A .status_id = b.status_id		      "
				+ " LEFT JOIN lms_users C ON A .employee_id = C .id where employee_id =  ?  ORDER BY id DESC ";

		try (

		Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
		) {

			ps.setInt(1, userId);
			System.out.println("sql  query " + ps);
			ResultSet rs = ps.executeQuery();
			ArrayList<OverTime> lot = new ArrayList<OverTime>();
			OverTime ot = null;
			while (rs.next()) {
				ot = new OverTime();
				ot.setoTDate(rs.getString("date"));
				ot.setoTReason(rs.getString("cause"));
				ot.setoTStatus_id(rs.getInt("status_id"));
				ot.setoTDuration(rs.getDouble("duration"));
				ot.setoTType(rs.getInt("ot_type"));
				lot.add(ot);
			}
			return lot;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<OverTime> getAllOverTimeAdmin(int empId, String frstNm, String lstNm) {
		String sql = " SELECT								      "
				+ "  a.id,"
				+ "	CONCAT_WS(' ',b.first_name,b.last_name) as full_name,"
				+ "	a.date as startdate,"
				+ "	a.duration,"
				+ " a.ot_type,"
				+ "	a.cause,"
				+ "	c.name as status"
				+ "	from  lms_overtime a"
				+ "	left join lms_users b on a.employee_id = b.id"
				+ "	left join lms_status c on a.status_id =  c.status_id"
				+ "	where manager_id = ? AND first_name like ? OR last_name like ? " 
				+ "	order by startdate desc";
		
	
		try (

		Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
		) {
            
			ps.setInt(1,empId);
			ps.setString(2, frstNm);
			ps.setString(3, lstNm);
			System.out.println("sql  query " + ps);
			ResultSet rs = ps.executeQuery();
			ArrayList<OverTime> lot = new ArrayList<OverTime>();
			OverTime ot = null;
			while (rs.next()) {
				ot = new OverTime();
				
				ot.setoTDate(rs.getString("startdate"));
				ot.setoTEmployeeId(rs.getInt("id"));
				ot.setoTDuration(rs.getInt("duration"));
				ot.setoTReason(rs.getString("cause"));
				ot.setoTEmpName(rs.getString("full_name"));
				ot.setStatusNm(rs.getString("status"));
				ot.setoTType(rs.getInt("ot_type"));
				lot.add(ot);
			}
			return lot;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}

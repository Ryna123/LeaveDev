package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.coocon.lmsapp.dao.UserDao;
import com.kh.coocon.lmsapp.entities.Leaves;
import com.kh.coocon.lmsapp.entities.User;
 

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private DataSource dataSource;
	
    @Autowired
    private UserDao dao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    public User findById(int id) {
        return dao.findById(id);
    }
 
    public User findBySso(String sso) {
        return dao.findBySSO(sso);
    }

	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
		
		
	}

	@Override
	public boolean addUsers(User userObj, int Userid) {
		String sql=	"INSERT INTO lms_users (    "
				+ "contract_id,		    " 
				+ "oraganization_id,	    " 
				+ "position_id,       	    " 
				+ "first_name,		    " 
				+ "last_name,		    " 
				+ "LOGIN,		    " 
				+ "email,		    " 
				+ "PASSWORD,		    " 
				+ "ROLE,		    " 
				+ "manager_id,		    " 
				+ "country,		    " 
				+ "	datehired,	    " 
				+ "identifier,		    " 
				+ "active,		    " 
				+ "calendar,		    " 
				+ "phone,		    "
				+ "emergency,		    "
				+ "STATE,		    "
				+ "sso_id		    "
				+ ")			    "
				+ "VALUES		    "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
				

		try(
				Connection cnn = dataSource.getConnection();
				PreparedStatement ps = cnn.prepareStatement(sql);
			) 
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			ps.setString(2, dateFormat.format(date));
			ps.setInt(1, Userid);
			
			
			
			
			
			
			ps.setInt(2, Integer.parseInt(lo.getLeavesStatus()));
			ps.setInt(3, Integer.parseInt(lo.getLeavesType()));
			ps.setString(4, lo.getLeavesStartdate().replace("/", "-"));
			ps.setString(5, lo.getLeavesEnddate().replace("/", "-"));
			ps.setString(6, lo.getLeavesReason());
			ps.setString(7, lo.getLeavesStartDateType());
			ps.setString(8, lo.getLeavesendDateType());
			ps.setDouble(9, lo.getLeavesDuration());
			ps.setString(10, dateFormat.format(date));
			System.out.println(ps);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		
		return false;
	}
 
}

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
	public boolean addUsers(User UserObj, int Userid) {
		String sql=	"INSERT INTO lms_users (    "
				+ "contract_id,		    " 
				+ "organization_id,	    " 
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
			//ps.setString(2, dateFormat.format(date));
			ps.setInt(1, UserObj.getContractId());
			ps.setInt(2, UserObj.getOrganizationId());
			ps.setInt(3, UserObj.getPositionId());
			ps.setString(4, UserObj.getFirstName());
			ps.setString(5,UserObj.getLastName());
			ps.setString(6,UserObj.getLogin());
			ps.setString(7,UserObj.getEmail());
			ps.setString(8,UserObj.getPassword());
			ps.setInt(9,UserObj.getRole());
			ps.setInt(10, UserObj.getManagerId());
			ps.setString(11, UserObj.getCountry());
			ps.setString(12, UserObj.getDateHired());
			ps.setString(13, UserObj.getIdentifirer());
			ps.setString(14, UserObj.getState());
			ps.setString(15, UserObj.getCalendar());
			ps.setString(16, UserObj.getPhone());
			ps.setString(17, UserObj.getEmergency());
			ps.setString(18, UserObj.getState());
			ps.setString(19, UserObj.getSsoId());
			
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

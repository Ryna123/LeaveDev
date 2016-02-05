package com.kh.coocon.lmsapp.services;

import java.util.List;

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
	public List<User> listUserByPosition() {
		return this.dao.findByPosition();
	}
 
}

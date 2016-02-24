package com.kh.coocon.lmsapp.dao;

import java.util.List;

import com.kh.coocon.lmsapp.entities.User;

public interface UserDao {
	 
    User findById(int id);
     
    User findBySSO(String sso);
    
    List<User> findByPosition();
    List<User> findAllUser();
    
    void save(User user);
     
}

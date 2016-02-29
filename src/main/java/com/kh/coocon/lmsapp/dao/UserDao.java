package com.kh.coocon.lmsapp.dao;

import java.util.List;

import com.kh.coocon.lmsapp.entities.User;

public interface UserDao {
	 
    User findById(int id);
     
    User findBySSO(String sso);
    
    List<User> findByPosition(int limit, int offset);
    List<User> findAllUser();
    long countRecord(String position);
    
    void save(User user);
     
}

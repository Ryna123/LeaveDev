package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.User;

public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);
    
    List<User> listUserByPosition(int limit, int offset);
    List<User> findAllUser();
    long countRecord(String position);
    List<User> findLastId();
    
    void save(User user);    
   
}

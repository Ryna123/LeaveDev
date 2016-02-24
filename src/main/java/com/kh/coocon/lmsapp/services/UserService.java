package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.User;

public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);
    
    List<User> listUserByPosition();
    List<User> findAllUser();
    long countRecord(String position);
    
    void save(User user);    
   
}

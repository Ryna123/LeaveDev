package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.User;

public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);
    
    List<User> listUserByPosition();
    
    void save(User user);    
   
}

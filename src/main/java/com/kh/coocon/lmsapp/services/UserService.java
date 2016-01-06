package com.kh.coocon.lmsapp.services;

import com.kh.coocon.lmsapp.entities.User;

public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);
    
    void save(User user);
    
    public boolean addUsers(User UserObj, int Userid);
}

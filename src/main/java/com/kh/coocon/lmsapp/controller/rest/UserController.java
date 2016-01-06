package com.kh.coocon.lmsapp.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.coocon.lmsapp.entities.User;
import com.kh.coocon.lmsapp.services.UserService;

@RequestMapping("/action/service")
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/checkUsername", method = RequestMethod.GET)
	public Map<String, Object> getUserName(@RequestParam("userName") String userName){
		Map<String, Object> map = new HashMap<>();
		try{
			User user = service.findBySso(userName);
			System.out.println(user);
			if(user == null){
				map.put("Message", true);
			}else{

				map.put("Message", false);
			}
			
		}catch(Exception e){
			map.put("Message", false);
			map.put("error", e.getMessage());
			
		}		
		return map;
	}
	

	
}

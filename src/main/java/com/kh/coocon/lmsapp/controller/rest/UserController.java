package com.kh.coocon.lmsapp.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.coocon.lmsapp.entities.State;
import com.kh.coocon.lmsapp.entities.User;
import com.kh.coocon.lmsapp.entities.UserProfile;
import com.kh.coocon.lmsapp.services.UserService;

@RequestMapping("/action/service")
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	

	@RequestMapping(value="listUserByPosition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> listUserByPosition(){
		Map<String, Object> map = new HashMap<>();
		try{
			List<User> users = service.listUserByPosition();
			map.put("MESSAGE", "SUCCESS");
			map.put("LIST", users);
		}catch(Exception e){
			map.put("MESSAGE", "ERROR");
			map.put("ERROR", e.getMessage());
			e.printStackTrace();
		}
		
		return map;	
		
	}
	@RequestMapping(value="checkUsername", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getUserName(@RequestParam("ssoId") String userName
			){
		
		Map<String, Object> map = new HashMap<String, Object>();
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
	//For simple user
	@RequestMapping(value="/newUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> newUser(@RequestBody() User user){
		Map<String,Object> map = new HashMap<String, Object>();
		user.setState(State.INACTIVE.getState());
		try{
			service.save(user);
			map.put("Message", "User "+user.getSsoId()+ " added successfully!");
		}catch(Exception e){
			map.put("Message", e.getMessage());
			e.printStackTrace();
			
		}	
		
		return map;
	}
	//For manager creating user
	@RequestMapping(value="/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> addNew(@RequestBody() User user){
		Map<String,Object> map = new HashMap<String, Object>();
		user.setState(State.ACTIVE.getState());
		try{
			service.save(user);
			if(user.getUserProfiles()!=null){
	    		for(UserProfile profile : user.getUserProfiles()){
	    			System.out.println("Profile"+ profile.getType());;
	    		}
	    	}
			map.put("Message", "User "+user.getSsoId()+ " added successfully!");
		}catch(Exception e){
			map.put("Message", e.getMessage());
			e.printStackTrace();
			
		}	
		
		return map;
	}
	

	
}

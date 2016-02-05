package com.kh.coocon.lmsapp.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.coocon.lmsapp.services.PositionService;

@RestController
@RequestMapping(value="action/service")
public class PositionRestController {
	
	@Autowired
	private PositionService positionService;
	
	@RequestMapping(value="listPosition", method=RequestMethod.GET)
	public Map<String, Object> listPosition(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("Message", "Success");
			map.put("LIST", positionService.listPosition());
		}catch(Exception e){
			map.put("Message", "Error");
			map.put("Error", e.getMessage());
			e.printStackTrace();
		}
		return map;
		
	}

}

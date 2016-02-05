package com.kh.coocon.lmsapp.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.coocon.lmsapp.services.ContractService;

@RestController
@RequestMapping("action/service")
public class ContractRestController {
	
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(value="listContract", method=RequestMethod.GET)
	public Map<String, Object> listContract (){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("LIST", contractService.listContract());
			map.put("Msg", "Success");
		}catch(Exception e){
			map.put("Msg", e.getMessage());
			e.printStackTrace();
		}
		
		return map;
		
	}

}

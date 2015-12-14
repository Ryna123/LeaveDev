package com.kh.coocon.lmsapp.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.coocon.lmsapp.entities.Entitledays;
import com.kh.coocon.lmsapp.enums.LmsMsg;
import com.kh.coocon.lmsapp.services.EntitleService;
import com.kh.coocon.lmsapp.services.LeaveService;
import com.kh.coocon.lmsapp.services.UserService;

@RestController
@RequestMapping("/admin/action/service")

public class ActionController {
	
	
	@Autowired
	EntitleService entitleService;
	@Autowired
	LeaveService leaveService;
	@Autowired
	UserService userService;
	
	
	
/*	@RequestMapping(value = { "/lms_adm_001/{field1}/{field2}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> GetEntitledlist(@PathVariable int field1 , @PathVariable int field2,@RequestBody String test) {
		System.out.println("test"+field1+"test1"+field2 + " | " + test  );
		return null;
		*/
		/*@RequestMapping(value = { "/lms_adm_001"}, method = RequestMethod.POST)
		public void doSomeTest(@RequestParam("ab") String ab,@RequestParam("ac") String bc){
			System.out.println(ab+bc);
			
		}*/
	
		@RequestMapping(value = { "/lms_adm_001"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> GetEntitledlist(@RequestParam("empId") int empId,@RequestParam("statId") int statId) {
			//List<Entitledays> Mylist = userService.list();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("ENTITLE_REC", entitleService.getEntitiledList(empId, statId));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		
		@RequestMapping(value = { "/lms_adm_002"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getLeavesList(@RequestParam("empId") int empId) {
			//List<Entitledays> Mylist = userService.list();
					
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVES_REC", leaveService.getLeavesList(empId));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
	}
	










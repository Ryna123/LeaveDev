package com.kh.coocon.lmsapp.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.coocon.lmsapp.entities.Leaves;
import com.kh.coocon.lmsapp.entities.User;
import com.kh.coocon.lmsapp.enums.LmsMsg;
import com.kh.coocon.lmsapp.services.EntitleService;
import com.kh.coocon.lmsapp.services.LeaveService;
import com.kh.coocon.lmsapp.services.LeaveTypeService;
import com.kh.coocon.lmsapp.services.ListUserService;
import com.kh.coocon.lmsapp.services.UserService;
import com.kh.coocon.lmsapp.utils.SSOIdUtil;

@RestController
@RequestMapping("/action/service")
public class ActionController {
	
	
	@Autowired
	EntitleService entitleService;
	@Autowired
	LeaveService leaveService;
	@Autowired
	UserService userService;
	@Autowired
	LeaveTypeService leaveTypeService;
	
	@Autowired
	ListUserService listuserservice;
	SSOIdUtil ssoidUtils = new SSOIdUtil();
	
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
		public ResponseEntity<Map<String, Object>> GetEntitledlist(@RequestParam("statId") int statId) {
			//List<Entitledays> Mylist = userService.list();
			
			User user = userService.findBySso(getPrincipal());
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("ENTITLE_REC", entitleService.getEntitiledList(user.getId(), statId));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			//System.out.println("console is "+ userService.findBySso(getPrincipal()).getId());
			//return null;
		}

		@RequestMapping(value = { "/lms_adm_002"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getLeavesList(@RequestParam("empId") int empId) {
			//List<Entitledays> Mylist = userService.list();
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVES_REC", leaveService.getLeavesList(user.getId()));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		// list all user
		@RequestMapping(value = { "/lms_adm_006"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getEntity() {
			
			//List<Entitledays> Mylist = userService.list();
			//User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("USER_REC", listuserservice.getListUsers());
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		
		
		@RequestMapping(value = { "/lms_adm_027lt"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getLeavesType() {
			//List<Entitledays> Mylist = userService.list();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVETYPE_REC", leaveTypeService.getLeavesTypeList());
			listData.put("LEAVESTATUS_REC", leaveTypeService.getLeavesStatus());
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		@RequestMapping(value = { "/lms_adm_027It"}, method = RequestMethod.POST ,produces=MediaType.APPLICATION_JSON_VALUE )
		public ResponseEntity<Map<String, Object>> addLeave(@RequestBody Leaves lobj) throws Exception {
			User user = userService.findBySso(getPrincipal());
			Map<String, Object> map = new HashMap<String, Object>();
			if (leaveService.addLeaves(lobj, user.getId() )==false) {
				map.put("MESSAGE", "Insert leave failse");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}
		
		
		//admin : get all list user request;
		@RequestMapping(value = { "/lms_adm_004"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getLeavesListAdmin(@RequestParam("empId") int empId) {
			//List<Entitledays> Mylist = userService.list();
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVES_REC", leaveService.getLeavesListAdmin(user.getId()));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");	
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		
		//admin : get all list user request;
		@RequestMapping(value = { "/lms_adm_004UA"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> UpdateAdminApprove(@RequestParam("lId") int lId ,@RequestParam("lAct") String lAct) {
			//List<Entitledays> Mylist = userService.list();
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVES_REC", leaveService.updateLeavesAdmin(lId, lAct));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");	
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
				
		
		private String getPrincipal(){
	    	 String userName = null;
	         Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  
	         if (principal instanceof UserDetails) {
	             userName = ((UserDetails)principal).getUsername();
	         } else {
	             userName = principal.toString();
	         }
	         return userName;
	   	}
		
		
		
	}

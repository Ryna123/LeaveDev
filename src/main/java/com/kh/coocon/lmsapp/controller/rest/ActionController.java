package com.kh.coocon.lmsapp.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.ModelAndView;

import com.kh.coocon.lmsapp.entities.Contract;
import com.kh.coocon.lmsapp.entities.HrManagement;
import com.kh.coocon.lmsapp.entities.Leaves;
import com.kh.coocon.lmsapp.entities.OverTime;
import com.kh.coocon.lmsapp.entities.State;
import com.kh.coocon.lmsapp.entities.User;
import com.kh.coocon.lmsapp.entities.UserProfile;
import com.kh.coocon.lmsapp.enums.LmsMsg;
import com.kh.coocon.lmsapp.services.ContractService;
import com.kh.coocon.lmsapp.services.EntitleService;
import com.kh.coocon.lmsapp.services.HumanResurceService;
import com.kh.coocon.lmsapp.services.LeaveService;
import com.kh.coocon.lmsapp.services.LeaveTypeService;
import com.kh.coocon.lmsapp.services.ListUserService;
import com.kh.coocon.lmsapp.services.OverTimeService;
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
	OverTimeService overTimeService;
	
	@Autowired
	private HumanResurceService humanResourceService;
	@Autowired
	private ContractService contractService;
	
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
	
		@RequestMapping(value={"/hrListExport"},method=RequestMethod.GET)
		public ModelAndView getHrListExport(HttpServletResponse response){
			Map<String, Object> hrMap = new HashMap<>();
				List<HrManagement> hrManagements = humanResourceService.getAllEmp();
				if(hrManagements.isEmpty() || hrManagements == null){
					hrMap.put("Message","Empty");
				}else{
					hrMap.put("Message","Exist");
					//hrMap.put("hrListExport", hrManagements);
					System.out.println("jlkdfjlkdsjfaflkfsdafjsdkfsdfjkdsjlfjsdkjflkjfasdkj"+hrManagements);
				}
			return new ModelAndView("hrExcelView","hrListExports",hrManagements);	
		}
	
		@RequestMapping(value = { "/export"}, method = RequestMethod.GET)
		public ModelAndView getOverTimeViewForResourceBundle(HttpServletResponse response) {
			User user = userService.findBySso(getPrincipal());
			response.setHeader("Content-Disposition",
					"attachment; filename=\"Export_my_overtime.xls\"");
			List<OverTime> listOT = overTimeService.getOTList(user.getId());
			return new ModelAndView("overtimeExport", "listOT", listOT);
		}
	
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
		
		@RequestMapping(value = { "/lms_adm_011"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getListLeavesType() {
			//List<Entitledays> Mylist = userService.list();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVETYPE_REC", leaveTypeService.getLeavesTypeList());
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
		
		//List over time list
		@RequestMapping(value = { "/lms_adm_028"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getOverTimeList(@RequestParam("empId") int empId) {
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("OVERTIME_REC", overTimeService.getOTList(user.getId()));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		//Get one record of list overtime
		@RequestMapping(value = { "/lms_adm_030p"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getOvertimeOneRecord(@RequestParam("otId") int otId) {
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("OVERTIME_REC", overTimeService.getOtOneRecordUser(otId, user.getId()));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		//List overTime for manager
		@RequestMapping(value = { "/lms_adm_r005"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getAllOverTimeAdmin(@RequestParam("empId") int empId,@RequestParam("frstNm") String frstNm,@RequestParam("lstNm") String lstNm ) {
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			System.out.println("@@@@@@@@@"+user.getId());
			listData.put("OVERTIME_LIST", overTimeService.getAllOverTimeAdmin(user.getId(),frstNm,lstNm));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		
		
		//admin : Update status of overtime
		@RequestMapping(value = { "/lms_adm_u005"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> updateStatusOvertime(@RequestParam("otId") int otId ,@RequestParam("otAct") String otAct) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("UPDATE_STS", overTimeService.updateStatusOvertime(otId, otAct));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");	
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", "Update Success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		

		//admin : View overtime 
		@RequestMapping(value = { "/lms_adm_005p"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getOtOneRecord(@RequestParam("otId") int otId,@RequestParam("empId") int empId ) {
			//List<Entitledays> Mylist = userService.list();
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("OVERTIME_REC", overTimeService.getOtOneRecord(otId, empId));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");	
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		
		//get Leave status
		@RequestMapping(value = { "/lms_adm_029"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getLeaveStatus() {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
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
		
		//Insert Over Time
		@RequestMapping(value = { "/lms_adm_029I"}, method = RequestMethod.POST ,produces=MediaType.APPLICATION_JSON_VALUE )
		public ResponseEntity<Map<String, Object>> addOT(@RequestBody OverTime otobj) throws Exception {
			User user = userService.findBySso(getPrincipal());
			Map<String, Object> map = new HashMap<String, Object>();
			if (overTimeService.insertOT(otobj, user.getId())==false) {
				map.put("MESSAGE", "Insert over time failse");
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
			//User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVES_REC", leaveService.updateLeavesAdmin(lId, lAct));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");	
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", "Update Success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		
		//admin : get list user request by Request ID;
		@RequestMapping(value = { "/lms_adm_004LR"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> UpdateAdminApprove(@RequestParam("lId") int lId ) {
			//List<Entitledays> Mylist = userService.list();
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVES_REC", leaveService.selectOneRecord(lId, user.getId()));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");	
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
			
		//admin : Insert users to lms_user
		
		@RequestMapping(value = { "/lms_adm_c008"}, method = RequestMethod.POST ,produces=MediaType.APPLICATION_JSON_VALUE )
		public Map<String, Object> addNew(@RequestBody() User user){
			Map<String,Object> map = new HashMap<String, Object>();
			user.setState(State.ACTIVE.getState());
			try{
				userService.save(user);
				if(user.getUserProfiles()!=null){
		    		for(UserProfile profile : user.getUserProfiles()){
		    			System.out.println("Profile"+ profile.getName());;
		    		}
		    	}
				map.put("Message", "User "+user.getSsoId()+ " added successfully!");
			}catch(Exception e){
				map.put("Message", e.getMessage());
				e.printStackTrace();
				
			}	
			
			return map;
		}
		
		//List all employee in human resource menu
		@RequestMapping(value={"/lms_adm_r014"}, method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String, Object> hrListAllEmp(){
			
			Map<String, Object> map = new HashMap<>();
			try{
				List<HrManagement> hrManagements = humanResourceService.getAllEmp();
				if(hrManagements.isEmpty() || hrManagements == null){
					map.put("Message", "Empty");
				}else{
					map.put("Message", "Exist");
					map.put("List", hrManagements);
				}
			}catch(Exception e){
				map.put("Message", e.getMessage());
			}
			return map;
		}
		
		@RequestMapping(value={"/lms_adm_r017"}, method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> listContract(){
			Map<String,Object> map = new HashMap<>();
			try {
				List<Contract> contractList = contractService.listContract();
				if(contractList.isEmpty() || contractList == null){
					map.put("Message","Ëmpty");
				}else{
					map.put("Message", "Exist");
					map.put("contractList", contractList);
				}
			} catch (Exception e) {
				map.put("Message", e.getMessage());
				e.printStackTrace();
			}
			return map;	
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

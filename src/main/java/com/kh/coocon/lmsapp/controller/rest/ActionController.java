package com.kh.coocon.lmsapp.controller.rest;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kh.coocon.lmsapp.entities.Contract;
import com.kh.coocon.lmsapp.entities.EntitledDayContract;
import com.kh.coocon.lmsapp.entities.HrManagement;
import com.kh.coocon.lmsapp.entities.Leaves;
import com.kh.coocon.lmsapp.entities.ListUser;
import com.kh.coocon.lmsapp.entities.OverTime;
import com.kh.coocon.lmsapp.entities.Position;
import com.kh.coocon.lmsapp.entities.State;
import com.kh.coocon.lmsapp.entities.User;
import com.kh.coocon.lmsapp.entities.UserProfile;
import com.kh.coocon.lmsapp.enums.LmsMsg;
import com.kh.coocon.lmsapp.services.ContractService;
import com.kh.coocon.lmsapp.services.EntitleService;
import com.kh.coocon.lmsapp.services.EntitledDCService;
import com.kh.coocon.lmsapp.services.HumanResurceService;
import com.kh.coocon.lmsapp.services.LeaveService;
import com.kh.coocon.lmsapp.services.LeaveTypeService;
import com.kh.coocon.lmsapp.services.ListUserService;
import com.kh.coocon.lmsapp.services.OrgService;
import com.kh.coocon.lmsapp.services.OrgUserService;
import com.kh.coocon.lmsapp.services.OverTimeService;
import com.kh.coocon.lmsapp.services.PositionService;
import com.kh.coocon.lmsapp.services.ReportBalanceService;
import com.kh.coocon.lmsapp.services.UserService;
import com.kh.coocon.lmsapp.utils.SSOIdUtil;

@RestController
@RequestMapping("/action/service")
public class ActionController {
	
	@Autowired
	EntitledDCService entitledDaysContrastService;
	@Autowired
	EntitleService entitleService;
	@Autowired
	LeaveService leaveService;
	@Autowired
	UserService userService;
	@Autowired
	LeaveTypeService leaveTypeService;
	@Autowired
	OrgService orgService;
	@Autowired
	ReportBalanceService  reportBalanceService;
	@Autowired
	OrgUserService orgUseService;
	@Autowired
	OverTimeService overTimeService;
	
	@Autowired
	private HumanResurceService humanResourceService;
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private PositionService positionService;
	
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
		public ModelAndView getHrListExport(@RequestParam(value="orgid") int orgId){
			Map<String, Object> hrMap = new HashMap<>();
			List<HrManagement> hrManagements = new ArrayList<HrManagement>();
			if(orgId != 0){
				hrManagements = humanResourceService.getEmpByOrg(orgId);
			}else{
				hrManagements = humanResourceService.getAllEmp();
			}	
				if(hrManagements.isEmpty() || hrManagements == null){
					hrMap.put("Message","Empty");
				}else{
					hrMap.put("Message","Exist");
				}
			System.out.println(hrManagements);
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
		
		@RequestMapping(value = { "/lAdminExport"}, method = RequestMethod.GET)
		public ModelAndView getLeaveRequestAdminExport(HttpServletResponse response) {
			User user = userService.findBySso(getPrincipal());
			response.setHeader("Content-Disposition",
					"attachment; filename=\"Export_Admin_LeavesRquest.xls\"");
			List<Leaves> leavesRequestAdmin = leaveService.getLeavesListAdmin(user.getId());
			return new ModelAndView("LeavesRequestAdminExport", "leavesRequestAdmin", leavesRequestAdmin);
		}
		
		@RequestMapping(value = { "/otAdminExport"}, method = RequestMethod.GET)
		public ModelAndView getOtAdminExport(HttpServletResponse response) {
			User user = userService.findBySso(getPrincipal());
			response.setHeader("Content-Disposition",
					"attachment; filename=\"Export_Admin_Overtime.xls\"");
			List<OverTime> otAdmin = overTimeService.getAllOverTimeAdmin(user.getId());
			return new ModelAndView("otAdminExport", "otAdmin", otAdmin);
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
		
		@RequestMapping(value = { "/lms_adm_r002"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getLeaveRecord(@RequestParam("lId") int lId) {
			//List<Entitledays> Mylist = userService.list();
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("LEAVE_REC", leaveService.selectOneRecordUser(lId, user.getId()));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		//Read User
		/**
		 * @param id
		 * @return
		 */
		@RequestMapping(value ="/lms_adm_r006/{id}", method = RequestMethod.GET)
		public Map<String, Object> getSingleUser(
				@PathVariable("id") int id
				){
			Map<String, Object> m = new HashMap<>();
			
			try{
				User user = userService.findById(id);
				user.setPassword("");
				m.put("Success", true);
				m.put("Record", user);
			}catch(Exception e){
				m.put("Success", false);
				m.put("Message", e.getMessage());
			}
			
			return m;
		}
		
		// list all user
		@RequestMapping(value = { "/lms_adm_l006"}, method = RequestMethod.GET)
		public ResponseEntity<Map<String, Object>> getEntity(
				@RequestParam("pageCount") int pageCount,
				@RequestParam("numberOfRecord") int numberOfRecord
				) {
			int offset = (pageCount-1)*numberOfRecord;			
			//List<Entitledays> Mylist = userService.list();
			//User user = userService.findBySso(getPrincipal());			
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			
			try{
				List<ListUser> user = listuserservice.getListUsers(numberOfRecord,offset);
				//List<User> user = userService.findAllUser();
				//long totalRecord = user.size();
				
				listData.put("USER_REC", user);
				listData.put("TOTAL_REC", userService.countRecord("All user"));
			}catch(Exception e){
				listData.put("USER_REC", e.getMessage());
				e.printStackTrace();
			}
			
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
		
		//update overtime
		@RequestMapping(value = { "/lms_adm_u030p"},method = RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Map<String, Object>> updateOvertime(@RequestBody OverTime otobj
				/*,@RequestParam("otId") int otId*/) throws Exception {
			User user = userService.findBySso(getPrincipal());
			Map<String, Object> map = new HashMap<String, Object>();
			if (overTimeService.updateOvertime(otobj,otobj.getId(),user.getId())==false) {
				map.put("MESSAGE", "update over time failse");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);	
		}
		
		//List overTime for manager
		@RequestMapping(value = { "/lms_adm_r005"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getAllOverTimeAdmin(@RequestParam("empId") int empId ) {
			User user = userService.findBySso(getPrincipal());		
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			System.out.println("@@@@@@@@@"+user.getId());
			listData.put("OVERTIME_LIST", overTimeService.getAllOverTimeAdmin(user.getId()));
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
			
			
			
			System.out.println(user.getUserProfiles()+"*************"+user.getId()+"****"+user.getManager_Id());
			try{
				userService.save(user);
				if(user.getUserProfiles()!=null){
		    		for(UserProfile profile : user.getUserProfiles()){
		    			System.out.println("Profile"+ profile.getType());;
		    		}
		    	}
				map.put("Message", "User "+user.getSsoId()+ " added successfully!");
				map.put("SUCCESS", true);
			}catch(Exception e){
				map.put("SUCCESS", false);
				map.put("Message", e.getMessage());
				e.printStackTrace();
				
			}
			
			return map;
		}
		
		@RequestMapping(value="/lms_adm_r009p",method=RequestMethod.GET)
		public Map<String, Object> listEmpByOrg(@RequestParam(value="orgId")int orgId){
			Map<String, Object> map = new HashMap<>();
			try{
				List<HrManagement> hrManagements = humanResourceService.getEmpByOrg(orgId);
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
		
		// list all departments
		@RequestMapping(value = { "/lms_adm_r015"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getOrgList() {
			//List<Entitledays> Mylist = userService.list();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			listData.put("ORG_REC", orgService.getOrgList());
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		// list specific user in each departments
		@RequestMapping(value = { "/lms_adm_016"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getOrgUserList(
				@RequestParam("orgId") int orgId,
				@RequestParam("managerId") int managerId) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			System.out.println("Dept"+orgId+"managerId"+managerId);
			listData.put("USR_REC", orgUseService.getOrgUserList(orgId, managerId));
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
		
		@RequestMapping(value={"/lms_adm_r017"}, method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> listContract(){
			Map<String,Object> map = new HashMap<>();
			try {
				List<Contract> contractList = contractService.listContract();
				if(contractList.isEmpty() || contractList == null){
					map.put("Message","Empty");
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
		
		@RequestMapping(value="/lms_adm_d017", method=RequestMethod.POST)
		public Map<String,Object> deleteContract(@RequestParam(value="dID") int id){
			try {
				contractService.deleteContract(id);
				return listContract();
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
			return null;
		}
		@RequestMapping(value="/lms_adm_c017", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> createContract(@RequestBody() Contract ctObj){
			try {
				if(contractService.addContract(ctObj) == 1 ){
					return listContract();
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "add false");
			return map;
		}
		@RequestMapping(value="/lms_adm_u017", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String, Object> editContract(@RequestBody() Contract ctObj){
			if(contractService.editContract(ctObj)==1){
				return listContract();
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "Edit False");
			return map;
		}
		@RequestMapping(value="/lms_adm_r019",method=RequestMethod.GET)
		public Map<String, Object> listEntitledDays(@RequestParam(value="id")int id){
			Map<String, Object> map = new HashMap<>();
			try {
				List<EntitledDayContract> listEDC = entitledDaysContrastService.listEntitleDaysContract(id);
				if(listEDC.isEmpty() || listEDC == null){
					map.put("Message","Empty");
				}else{
					map.put("Message", "Exist");
					map.put("listEDC", listEDC);
				}
			} catch (Exception e) {
				map.put("Message", e.getMessage());
				e.printStackTrace();
			}
			return map;
		}
		@RequestMapping(value="/lms_adm_c019", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> createEntitledDC(@RequestBody() EntitledDayContract entitledDCObj){
			System.out.println(entitledDCObj.getContractId());
			try {
				if(entitledDaysContrastService.addEntitleDaysContract(entitledDCObj) == 1 ){
					return listEntitledDays(entitledDCObj.getContractId());
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "add false");
			return map;
		}
		
		@RequestMapping(value="/lms_adm_u19", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> editEntitledDC(@RequestBody() EntitledDayContract entitledDCObj){
			try {
				if(entitledDaysContrastService.updateEntitleDaysContract(entitledDCObj) == 1 ){
					return listEntitledDays(entitledDCObj.getContractId());
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "update false");
			return map;
		}
		@RequestMapping(value="/lms_adm_d019", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> deleteEntitledDC(@RequestParam(value="dID") int id,@RequestParam(value="contractID")int cid){
			try {
				if(entitledDaysContrastService.deleteEntitleDaysContract(id)==1)
					return listEntitledDays(cid);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getStackTrace());
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "delete false");
			return map;
		}
		
		@RequestMapping(value="/lms_adm_r021",method=RequestMethod.GET)
		public Map<String, Object> listPosition(){
			Map<String, Object> map = new HashMap<>();
			try {
				List<Position> listPos = positionService.listPosition();
				if(listPos.isEmpty() || listPos == null){
					map.put("Message","Empty");
				}else{
					map.put("Message", "Exist");
					map.put("listPos", listPos);
				}
			} catch (Exception e) {
				map.put("Message", e.getMessage());
				System.out.println(e.getStackTrace());
			}
			return map;
		}
		
		@RequestMapping(value="/lms_adm_c021", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> createPosition(@RequestBody() Position posObj){
			System.out.println(posObj.getDescription());
			try {
				if(positionService.addPosition(posObj) == 1 ){
					return listPosition();
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "add false");
			return map;
		}
		
		@RequestMapping(value="/lms_adm_u021", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> updatePos(@RequestBody() Position posObj){
			try {
				if(positionService.EditPosition(posObj) == 1 ){
					return listPosition();
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "update false");
			return map;
		}
		
		@RequestMapping(value="/lms_adm_d021", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,Object> deletePos(@RequestParam(value="dID") int id){
			System.out.println(id+"*****");
			
			try {
				if(positionService.deletePosition(id)==1)
					return listPosition();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getStackTrace());
			}
			Map<String,Object> map = new HashMap<>();
			map.put("Message", "delete false");
			return map;
		}
		
		
		// report balance of all employees
		@RequestMapping(value = { "/lms_adm_r023"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getListUsersReBalance(
				@RequestParam("pageCount") int pageCount,
				@RequestParam("numberOfRecord") int numberOfRecord) {
			
			int offset = (pageCount-1)*numberOfRecord;	
			//List<Entitledays> Mylist = userService.list();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			
			try{
				System.out.println(numberOfRecord+offset);
				List<ListUser> user = reportBalanceService.getListUsersReBalance(numberOfRecord,offset);
				//List<User> user = userService.findAllUser();
				//long totalRecord = user.size();
				
				listData.put("REP_BAL", user);
				listData.put("TOTAL_REC", userService.countRecord("name"));
			//	listData.put("TOTAL_REC", reportBalanceService.CountRecord("name"));
			}catch(Exception e){
				listData.put("REP_BAL", e.getMessage());
				e.printStackTrace();
			}
			
			
	//		listData.put("REP_BAL", reportBalanceService.getListUsersReBalance(numberOfRecord,offset));
			if (listData.isEmpty()) {
				map.put("MESSAGE", "No data");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("CODE",LmsMsg.RSLT_CD.getmsg() );
			map.put("MESSAGE",LmsMsg.RSLT_MSG.getmsg() );
			map.put("RESP_DATA", listData);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		// report balance of all employees findBy manager
		@RequestMapping(value = { "/lms_adm_l023"}, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> getEntity(
				@RequestParam("pageCount") int pageCount,
				@RequestParam("numberOfRecord") int numberOfRecord,
				@RequestParam("managerId") int managerId) {
			
			int offset = (pageCount-1)*numberOfRecord;	
			//List<Entitledays> Mylist = userService.list();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> listData = new HashMap<String, Object>();
			
			try{
				System.out.println(managerId);
				List<ListUser> user = reportBalanceService.getListUsersReBalanceFindByManager(managerId,numberOfRecord,offset);
				//List<User> user = userService.findAllUser();
				//long totalRecord = user.size();
				listData.put("REP_BAL", user);
				listData.put("TOTAL_REC", userService.countRecord("name"));
			//	listData.put("TOTAL_REC", reportBalanceService.CountRecord("name"));
			}catch(Exception e){
				listData.put("REP_BAL", e.getMessage());
				e.printStackTrace();
			}
			
			
	//		listData.put("REP_BAL", reportBalanceService.getListUsersReBalance(numberOfRecord,offset));
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

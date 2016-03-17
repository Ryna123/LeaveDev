
$(window).load(function(){
});
var userInfo = {
		"identifier"	:"",
		"firstName"		:"",
		"lastName"		:"",
		"ssoId"			:"",
		"email"			:"",
		"phone"			:"",
		"password"		:"",
		"dateHired"		:"yyyy/mm/dd",
		"userProfiles"	:[{
			"id"	:0,
			"type"	:""
		}],
		"manager_Id"	:0,
		"position"		:{"id":0},
		"contract"		:{"id":0}
};

$(document).ready(function(){
	$("#startdate,#enddate").daterangepicker({
		singleDatePicker: true,
        showDropdowns: true,
        format:'YYYY/MM/DD'
	});
	
	$("#phoneNumber").mask("(999) 99-999-999",{placeholder:"(000) 00-000-000"});
	
	userProfile.listUserProfiles();
	contract.listContrac();
	position.listPosition();
	
	/**
	 * Display the last id;
	 */
	user.list_last_id();
	
	
	/**
	 * When user click the create button
	 */
	//$("#frmValidate").validationEngine(gbox.ui.validationEngineOptions);	
	$("#frmValidate").validationEngine();
	$("#btnCreate").click(function(){
		if(!$("#frmValidate").validationEngine('validate')) {
			return false;
		}
		//loading(true);
		
		/*if(validation.isEmpty($("#firstName").val())){
			$("#firstName").focus();
			alert("Please insert First Name!");
			return false;
		}else if(validation.isEmpty($("#lastName").val())){
			$("#lastName").focus();
			alert("Please insert Last Name!");
			return false;
		}else if(validation.isEmpty($("#userName").val())){
			$("#userName").focus();
			alert("Please insert User Name!");
			return false;
		}else if(validation.isEmpty($("#txtManager").val())){
			alert("Please select manager!");
			return false;
		}*/
		
		userInfo.firstName 				= $("#firstName").val();
		userInfo.lastName 				= $("#lastName").val();
		userInfo.ssoId 					= $("#userName").val();
		userInfo.email 					= $("#email").val();
		userInfo.phone					= $("#phoneNumber").val();
		userInfo.dateHired				= $.trim($("#startdate").val())
		userInfo.password				= $("#password").val()
		userInfo.userProfiles[0].id		= $("#userProfile").val();	
		userInfo.userProfiles[0].type	= $("#userProfile option:selected").text();
		userInfo.position.id			= $("#position").val();
		userInfo.manager_Id 			= manager_Id;
		userInfo.contract				= $("#contract").val();
		user.createUser();
		
	});
	/**
	 * When the user click on the select Self 
	 */
	$("#btnSelf").click(function(){
		var firstName = $("#firstName").val();
		var lastName = $("#lastName").val();
		if(validation.isEmpty(firstName) || validation.isEmpty(lastName)){
			alert("Please enter First Name and Last Name!")
			return false;
		}		
		$("#txtManager").val(firstName+" "+lastName);
		manager_Id=userInfo.manager_Id;
		
	});
	
	
});
var user = {
		list_last_id: function(){
			loading(true);
			$.ajax({
				type	: 'GET',
				url		: '../action/service/listLastId',
				success	: function(resp){
					identifier.convertId(resp);
				}
			});
			loading(false);
			
		},
		createUser: function(){
			loading(true);
			$.ajax({
				headers:{
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				type		: "POST",
				data		: JSON.stringify(userInfo), 
				url			: "../action/service/lms_adm_c008",
				success		: function(resp){
					console.log(resp);
					if(resp["SUCCESS"]==true){						
						location.href = "../admin/lms_adm_006";
					}else if(resp["SUCCESS"]==false){
						user.list_last_id();
						alert(resp["Message"]);
						loading(false);
					}
					loading(false);
				},
			});
		}
}
/**
 * Position
 */
var position = {
		/**
		 * listing position from server
		 */
		listPosition: function(){
			loading(true);
			$.ajax({
				type	: 'GET',
				url		: '../action/service/listPosition',
				success	: function(resp){
					optionSelection.createPosition(resp);
				}
			});
			loading(false);
		}
		
}
/**
 * Contract
 */
var contract = {
		/**
		 * Listing Contract from server	
		 */
		listContrac: function(){
			loading(true);
			$.ajax({
				type	: "GET", 
				url		: "../action/service/listContract",
				success	: function(resp){
					optionSelection.createContract(resp);
					
				}
				
			});
			loading(false);
		}
};
/**
 * User Profiles
 */
var userProfile = {
		/**
		 * Get data from userProfiles(Retriving roles of user)
		 */
		listUserProfiles: function(){
			loading(true);
			$.ajax({
				type	: "GET",
				url		: "../action/service/userProfiles",
				success	: function(resp){
					optionSelection.createRoles(resp);
				}
			});
			loading(false);
		}
}
/**
 * Creating the selection option
 */
var optionSelection = {
		/**
		 * Create select option position
		 * @param data
		 */
		createPosition: function(data){
			var selectionOption = "<select data-parsley-id='4308' id='position' class='form-control'>";
			for(i=0; i< data['LIST'].length; i++){
				selectionOption += "<option value='"+
										data.LIST[i].id+"'>"+
										data.LIST[i].name+
									"</option>";
			}
			selectionOption +="</select>";
			$("#selectPosition").html(selectionOption);
		},
		/**
		 * Create select option Contract
		 * @param data
		 */
		createContract: function(data){
			var selectionOption = "<select data-parsley-id='4308' id='contract' class='form-control'>";
			for(i=0; i< data['LIST'].length; i++){
				selectionOption += "<option value='"+
										data.LIST[i].id+"'>"+
										data.LIST[i].contractName+
									"</option>";
			}
			selectionOption +="</select>";
			$("#selectContract").html(selectionOption);
			
		},
		/**
		 * Create Select option Roles
		 * @param data
		 */
		createRoles: function(data){
			var selectionOption = "<select data-parsley-id='4308' id='userProfile' class='form-control'>";
			for(i=0; i< data['LIST'].length; i++){
				selectionOption += "<option value='"+
										data.LIST[i].id+"'>"+
										data.LIST[i].type+
									"</option>";
			}
			selectionOption +="</select>";
			$("#userRole").html(selectionOption);
		}	
}
var identifier = {
		convertId: function(resp){
			var myNumber = 0;
			userInfo.manager_Id = resp['LIST'][0].id + 1;
			var identifier = resp["LIST"][0].identifier;
			
			var str = identifier.substr(2);
			var strArray = str.split("");
			if(strArray[0]=="0" && strArray[1]=="0" && strArray[2]=="0"){
				myNumber = Number(strArray[3]) + 1;
				userInfo.identifier 	= "KS000"+myNumber;						
			}else if(strArray[0]=="0" && strArray[1]=="0"){
				myNumber = Number(strArray[2]+strArray[3]) + 1;
				userInfo.identifier 	= "KS00"+myNumber;
			}else if (strArray[0]=="0") {
				myNumber = Number(strArray[1]+strArray[2]+strArray[3]) + 1;
				userInfo.identifier 	= "KS0"+myNumber;
			}else{
				myNumber = Number(strArray[0]+strArray[1]+strArray[2]+strArray[3]) + 1;
				userInfo.identifier 	= "KS"+myNumber;
			}
			$("#txtIdentifier").val(userInfo.identifier);
		}
}
var validation = {
		// For checking if a string is empty, null or undefined
	isEmpty: function(str){
		return (!str || 0 === str.length);
		
	},
	//For checking if a string is blank, null or undefined
	isBlank: function(str){
		return (!str || /^\s*$/.test(str));
	}
		
};

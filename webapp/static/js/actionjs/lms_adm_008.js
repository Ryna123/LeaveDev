
$(window).load(function(){
});
var prefix = "selectBox_"
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
	
	loading(true);
	userProfile.listUserProfiles();
	contract.listContrac();
	position.listPosition();
	user.list_last_id();
	loading(false);
	
	
	
	
	
	//$("#frmValidate").validationEngine(gbox.ui.validationEngineOptions);	
	$("#frmValidate").validationEngine('attach', 
			{
				promptPosition : "topRight", 
				scroll: false,
				prettySelect : true,
				usePrefix: prefix
			});
/*	$("select").selectBox();
	
		// By default, selectBox does not create an id to the newly created element - We need to add this manually
		$('select').each(function(){ 
			// The jquery validation engine needs an id on the "a" element created by selectBox plugin
	    $(this).next('a.selectBox')
	    // Since id needs to be unique, we use a prefix here (can use suffix - up to you)
	    .attr("id", prefix + this.id )
	    // By default, all classes are passed on to the new element - Important: We need to remove it
	    .removeClass("validate[required]");		
	  });*/
		
		/**
		 * When user click the create button
		 */
	$("#btnCreate").click(function(){
		loading(true);
		if(!$("#frmValidate").validationEngine('validate')) {
			loading(false);
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
			$.ajax({
				type	: 'GET',
				url		: '../action/service/listLastId',
				success	: function(resp){
					identifier.convertId(resp);
				}
			});
			
		},
		createUser: function(){
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
					}
				},
			});
			loading(false);
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
			$.ajax({
				type	: 'GET',
				url		: '../action/service/listPosition',
				success	: function(resp){
					optionSelection.createPosition(resp);
				}
			});
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
			$.ajax({
				type	: "GET", 
				url		: "../action/service/listContract",
				success	: function(resp){
					optionSelection.createContract(resp);
					
				}
				
			});
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
			$.ajax({
				type	: "GET",
				url		: "../action/service/userProfiles",
				success	: function(resp){
					optionSelection.createRoles(resp);
				}
			});
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
			var selectionOption = "<select data-parsley-id='4308' id='position' " +
					"class='form-control validate[required]'>" +
					"<option value='"+" "+"'>-Please Choose-</option>";
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
			var selectionOption = "<select data-parsley-id='4308' id='contract' " +
					"class='form-control validate[required]'>" +
					"<option value='default'>-Please Choose-</option>";
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
			var selectionOption = "<select data-parsley-id='4308' id='userProfile' " +
					"class='form-control validate[required]'>" +
					"<option value='default'>-Please Choose-</option>";
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

			//loading(false);
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

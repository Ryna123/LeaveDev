
$(window).load(function(){
});
var userInfo = {
		"identifier":"KS00000",
		"firstName":"jatret",
		"lastName":"Chitra",
		"ssoId":"11111bd0fsadfsdafsdf",
		"email":"mail@mail.com",
		"password":"123456",
		"userProfiles":[{
			"id":1,
			"type":""
		}],
		"manager_Id":0,
		"position":{"id":2}
};

$(document).ready(function(){
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
	$("#btnCreate").click(function(){
		alert($("#userProfile").val());
		
		userInfo.firstName 				= $("#firstName").val();
		userInfo.lastName 				= $("#lastName").val();
		userInfo.ssoId 					= $("#userName").val();
		userInfo.email 					= $("#email").val();
		userInfo.password				= $("#password").val()
		userInfo.userProfiles[0].id		= $("#userProfile").val();	
		userInfo.userProfiles[0].type	= $("#userProfile option:selected").text();
		userInfo.position.id			= $("#position").val();
		userInfo.manager_Id 			= manager_Id;
		console.log(userInfo);
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
			});
			
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
					if(resp["MESSAGE"]=="Success"){						
						location.href = "../admin/lms_adm_006";
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

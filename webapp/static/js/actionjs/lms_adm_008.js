
$(window).load(function(){
});

var userInfo = {
		"firstName":"jatret",
		"lastName":"Chitra",
		"ssoId":"11111bd0fsadfsdafsdf",
		"email":"mail@mail.com",
		"password":"123456",
		"userProfiles":[{
			"id":1,
			"type":""
		}],
		"manager_id":0
};

$(document).ready(function(){
	userProfile.listUserProfiles();
	contract.listContrac();
	position.listPosition();
	
	/**
	 * When user click the create button
	 */
	$("#btnCreate").click(function(){
		alert($("#userProfile").val());
		
		userInfo.firstName 			= $("#firstName").val();
		userInfo.lastName 			= $("#lastName").val();
		userInfo.ssoId 				= $("#userName").val();
		userInfo.email 				= $("#email").val();
		userInfo.password			= $("#password").val()
		userInfo.userProfiles[0].id	= $("#userProfile").val();	
		userInfo.userProfiles[0].type = $("#userProfile option:selected").text();
		console.log(userInfo);
		alert();
		alert(userInfo.manager_id);
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
		userInfo.manager_id=0;
		
	});
	
});
var user = {
		createUser: function(){
			$.ajax({
				headers:{
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				type	: "POST",
				data	: JSON.stringify(userInfo), 
				url		: "../action/service/lms_adm_c008",
				success	: function(resp){
					console.log(resp);
				}
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

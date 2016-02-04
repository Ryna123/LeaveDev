$(window).load(function(){
});

$(document).ready(function(){

	userProfile.listUserProfiles();
	

	$("#btnCreate").click(function(){
		userInfo.firstName 			= $("#firstName").val();
		userInfo.lastName 			= $("#lastName").val();
		userInfo.ssoId 				= $("#userName").val();
		userInfo.email 				= $("#email").val();
		userInfo.password			= $("#password").val()
		userInfo.userProfiles[0].id	= $("#userProfile").val();
		
		user.createUser();
	});
	
});
var userInfo = {
		"firstName":"",
		"lastName":"",
		"ssoId":"11111bd0fsa",
		"email":"mail@mail.com",
		"password":"123456",
		"userProfiles":[{
			"id":1
		}]
};
var user = {
		createUser: function(){
			$.ajax({
				headers:{
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				type: "POST",
				data: JSON.stringify(userInfo), 
				url: "../action/service/lms_adm_c008",
				success: function(resp){
					console.log(resp);
					alert("Success!")
				}
			});
		}
}
var contract = {
		listContrac: function(){
			$.ajax({
				type: "GET", 
				url: "../action/service/listContract",
				success: function(resp){
					optionSelection.createContract(resp);
					
				}
				
			});
		}
};
var userProfile = {
		listUserProfiles: function(){
			$.ajax({
				type: "GET",
				url: "../action/service/userProfiles",
				success: function(resp){
					optionSelection.createRoles(resp);
				}
			});
		}
}

var optionSelection = {

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
		createRoles: function(data){
			var selectionOption = "<select data-parsley-id='4308' id='userProfile' class='form-control'>";
			for(i=0; i< data['LIST'].length; i++){
				selectionOption += "<option value='"+
										data.LIST[i].id+"'>"+
										data.LIST[i].name+
									"</option>";
			}
			selectionOption +="</select>";
			$("#userRole").html(selectionOption);
		}
		
}
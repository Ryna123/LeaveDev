$(document).ready(function(){
	userProfile.listUserProfiles();
	$("#btnCreate").click(function(){
		user.createUser();
	});
});
var userInfo = {
	"ssoId":"1111",
	"email":"mail@mail.com",
	"password":"123456"
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
				url: "../action/service/addUser",
				success: function(resp){
					console.log(resp);
					alert("Success!")
				}
			});
		}
}
var userProfile = {
		listUserProfiles: function(){
			$.ajax({
				type: "GET",
				url: "../action/service/userProfiles",
				success: function(resp){
					console.log(resp);
					optionSelection.creating(resp);
				}
			});
		}
}

var optionSelection = {

		
		creating: function(data){
			var selectionOption = "<select data-parsley-id='4308'> id='heard' class='form-control'";
			for(i=0; i< data['LIST'].length; i++){
				selectionOption += "<option value='"+data.LIST[i].id+"'>"+data.LIST[i].name+"</option>";
			}
			selectionOption +="</select>";
			$("#userRole").html(selectionOption);
		}
		
}
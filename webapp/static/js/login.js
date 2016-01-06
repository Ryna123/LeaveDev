$(document).ready(function(){
	$("#btnRegister").click(function(){
		password = "123";
		repassword = "123";
		if(isTheSamePassword(password, repassword)){
		}else{
		}
	});
	$("#inputUserName").keyup(function(){
		var userName = $(this).val();
		userInfo["userName"] = userName;
		if(userName.length<3){
			$("#lblUserName").text("Username must be greater than or equal three characters")
		}else{
			$("#lblUserName").text("");
		}
		register.availableUserName();
		
	});
	
});
var userInfo = {
		"userName":"",
		"email":"",
		"password":"",
}


var register = {
	availableUserName: function(){
		$.ajax({
			type: "GET",
			data: userInfo,
			url: "http://localhost:8080/LMSAPP/action/service/checkUsername",
			success: function(resp){
				console.log(resp)
				
			}
		});
	},
	addNewUser: function(){
		$.ajax({
			type: "POST",
			url: "",
			success : function(resp){
				console.log(resp)
			}
		});
	}	
		
};

var isTheSamePassword = function(password, repassword){
	if(password != repassword){
		return false;
	}else{
		return true;
	}
	
};
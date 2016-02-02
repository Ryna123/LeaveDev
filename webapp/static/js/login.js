var typingTimer;
var doneTypingInterval = 10;
var finaldoneTypingInterval = 500;
$(document).ready(function(){
	$("#btnRegister").click(function(){
		userInfo['password'] = $("#inputPassword1").val();
		userInfo['ssoId'] = $("#inputUserName").val();
		userInfo['email'] = $("#inputEmail").val();
		
		if(register.availableUserName()){
			if(isTheSamePassword($("#inputPassword1").val(), $("#inputPassword2").val())){
				register.addNewUser();
			}else{
				return false;
			}
		}else{
			sendMessage.messageAlert("#userMessage", "User isn't available");
		}
	});
	$("#inputUserName").keydown(function(){
		clearTimeout(typingTimer);
		typingTimer = setTimeout(function(){
			sendMessage.messageAlert("#userMessage", "typing...");
			
		}, doneTypingInterval)
	});
	$("#inputUserName").keyup(function(){
		userInfo['ssoId'] = $(this).val();
		clearTimeout(typingTimer);
		typingTimer = setTimeout(function(){
			register.availableUserName();
		}, finaldoneTypingInterval);
	});
	
});
var userInfo = {
		"ssoId":"",
		"email":"",
		"password":"",
}


var register = {
	isValid: true,	
	availableUserName: function(){
		if(userInfo['ssoId'].length < 3){
			sendMessage.messageAlert("#userMessage","Username must be greater than or equal to 3");
			register.isValide = false;
		}else{
			$.ajax({
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'applicaiont/json'
				},
				type: 'GET',
				data: userInfo,
				url: "action/service/checkUsername",
				success: function(resp){
					if(resp.Message == true){
						sendMessage.messageAlert("#userMessage", userInfo['ssoId'] + " is available!");
						register.isValid = true;
					}else{
						sendMessage.messageAlert("#userMessage", userInfo['ssoId'] + " isn't available!");
						register.isValid = false;
					}
				}
			});
		}
		return register.isValid;
	},
	addNewUser: function(){
		console.log(userInfo);
		
		$.ajax({
			headers:{
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			type: "POST",
			data: JSON.stringify(userInfo),
			url: "action/service/newUser",
			beforeSend: function(){
				alert("Before");
			},
			success : function(resp){
				console.log(resp);
				
				//window.location.href = "../home/success_add";
			}
		});
	}	
		
};

var isTheSamePassword = function(password, repassword){
	var isValid = true;
	if(password != repassword){
		isValid = false;
	}else{
		isValid = true;
	}
	return isValid;
}

var sendMessage = {
		messageAlert: function(target,  message){
			$(target).text(message);
		},
		clearMessage: function(target){
			$(target).text("");
		}
};
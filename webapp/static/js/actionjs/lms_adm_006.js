$(document).ready(function() {
	loading(true);
	
	myData = {
		'numberOfRecord': 5,
		'pageCount':1
	};
	
//	var a = {/*empId :2,*/statId : 2};
	$.ajax({
		url : "../action/service/lms_adm_006",		
		dataType : "JSON",
		data: myData,
		type : "GET",
	//	data :a,
		
		success : function(data) {
			var res = data.RESP_DATA['USER_REC'];
			console.log(data.RESP_DATA['USER_REC']);
				if(res.length <=0) {
					$("tfoot#entitleFooter").show();
				} else {
					$.each(res,function(i){
						var data = {};
						data['ID'] = i+1; // show auto number on screen
						data['FIRSTNAME']  = res[i].firstName;
						data['LASTNAME']  = res[i].lastName;
						data['EMAIL']  = res[i].email;
						data['USERNAME']  = res[i].username;
						data['ROLE']  = res[i].role;
						data['MANAGERNAME']  = res[i].managername;
						data['PHONE'] = res[i].phone;
						$("#lmsAdm006").tmpl(data).appendTo("tbody#listUser");
					})
				}
				loading(false);
			},
//			error : function(data) {
//			//	console.log(data);
//			}

		});
	
	$("#btn_search").click(function(){
		var SearchVal= $("#text_search").val();
		alert(SearchVal);
	});
	
	
	
});
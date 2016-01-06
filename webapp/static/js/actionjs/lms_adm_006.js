$(document).ready(function() {
	loading(true);
	
//	var a = {/*empId :2,*/statId : 2};
	$.ajax({
		//url : "../admin/action/service/lms_adm_001/1/2",
		url : "../action/service/lms_adm_006",
		
		dataType : "JSON",
		type : "POST",
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
						data['FIRSTNAME']  = res[i].firstname;
						data['LASTNAME']  = res[i].lastname;
						data['EMAIL']  = res[i].email;
						data['LOGIN']  = res[i].login;
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
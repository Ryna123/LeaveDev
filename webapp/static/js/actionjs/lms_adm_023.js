/**
 * 
 */
var lms_adm_023 ={};
$(document).ready(function() {
	
	lms_adm_023.listReportBalance();

});

lms_adm_023.listReportBalance = function(input){
//	loading(true);
	$.ajax({
		url : "../action/service/lms_adm_r023",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(dat) {
			var data =[]
			 console.log(dat);      
			var res =dat.RESP_DATA['REP_BAL']
			$.each(res, function(i, v) {
				var data = {};
				data['IDENTITIER']  = res[i].identifier;
				data['FIRSTNAME']  = res[i].firstName;
				data['LASTNAME']  = res[i].lastName;
				data['DEPARTMENT']  = res[i].deptNm;
				data['POSTION']  = res[i].position;
				data['HIREDDATE']  = res[i].hiredDate;
				data['PHONE'] = res[i].phone;
				$("#ReportBalTemplate").tmpl(data).appendTo("tbody#reportBal");
				
			});
		}
	});
	
}
			


			
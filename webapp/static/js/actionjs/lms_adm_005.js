/**
 * 
 */
var lms_adm_005 ={};
$(document).ready(function() {
	lms_adm_005.listOverTime();
	
	$("#srchBtn").click(function(){
		lms_adm_005.listOverTime();
		
		
	});
});

lms_adm_005.listOverTime = function(input){
//	loading(true);
	var a = {empId :1,frstNm:'%'+$("#srchTxt").val()+'%',lstNm:'%'+$("#srchTxt").val()+'%'};
	$.ajax({
		url : "../action/service/lms_adm_r005",
		dataType : "JSON",
		type : "POST",
		data :a,
		success : function(data) {
			$("#overTime").empty();
			console.log(data.RESP_DATA['OVERTIME_LIST']);
			var res = data.RESP_DATA['OVERTIME_LIST'];
			if(res.length<=0) {
				$("tfoot#leaveFooter").show();
			} else {
				$.each(res,function(i,v){
					
					var data = {};
					data['FULLNAME']  = res[i].oTEmpName;
					data['DATE']  = res[i].oTDate;
					data['DURATION']  = res[i].oTDuration;
					data['CAUSE'] = res[i].oTReason;
					data['STATUSNAME'] = res[i].statusNm;
					data['TYPE'] = res[i].oTType;
					data['OTID'] = res[i].oTEmployeeId;
					data['ID'] = i+1;
					if((data['STATUSNAME'])=='Approved') {
						(data['STATUSNAME'])='<span class="label label-success">Approve</span>';
					} else if((data['STATUSNAME'])=='Rejected') {
						(data['STATUSNAME'])='<span class="label label-danger">Rejected</span>';
					} else if((data['STATUSNAME'])=='Requested') {
						(data['STATUSNAME'])='<span class="label label-warning">Requested</span>';
					}else {
						(data['STATUSNAME'])='<span class="label label-info">Plan</span>';
					}
					if((data['TYPE'])=='1') {
						(data['TYPE'])='Day(s)';
					} else if((data['TYPE'])=='2') {
						(data['TYPE'])='Hour(s)';
					}
					
					$("#lmsAdm005").tmpl(data).appendTo("tbody#overTime").html();
				
				})
			}
			
			lms_adm_005.clickToUpdateStatusOvertime();
		}
	});
	
}


lms_adm_005.clickToUpdateStatusOvertime =function() {
	$("tr a#approveBtn").click(function() {
		var id = ($(this).find('input').val());
		var input={otId:id,otAct:'AP'} // Approve
		lms_adm_005.updateOvertime(input);
	});
	
	$("tr a#rejectBtn").click(function() {
		var id = ($(this).find('input').val());
		var input={otId:id,otAct:'RJ'} // Reject
		lms_adm_005.updateOvertime(input);
		
	});
}

lms_adm_005.updateOvertime = function(input) {
	loading(true);
	console.log(input);
	$.ajax({
		url : "../action/service/lms_adm_u005",
		dataType : "JSON",
		type : "POST",
		data :input,
		success : function(data) {
			console.log(data.RESP_DATA);
			lms_adm_005.listOverTime();
		}
	})
	loading(false);
}
	
			


			
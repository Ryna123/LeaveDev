var lms_adm_004={};
$(document).ready(function() {
	lms_adm_004.listAdmin();
	
	$("tbody#leaveBalancedAdmin tr a#testaa").click(function() {
		alert($(this).find('input#input').val());
	});
	
	
	$("#leaveView").click(function () {
		alert('test');
	});
	
});



lms_adm_004.listAdmin = function () {
	$("tbody#leaveBalancedAdmin").find("tr").remove();
	loading(true);
	var a = {empId :2};
	$.ajax({
		url : "../action/service/lms_adm_004",
		dataType : "JSON",
		type : "POST",
		data :a,
		success : function(data) {
			var res = data.RESP_DATA['LEAVES_REC'];
				if(res.length<=0) {
					$("tfoot#leaveFooter").show();
				} else {
					$.each(res,function(i,v){
						
						var data = {};
						data['LD']  = res[i].leavesDuration;
						data['LED']  = res[i].leavesEnddate;
						data['LR']  = res[i].leavesReason;
						data['LSD'] = res[i].leavesStartdate;
						data['LS'] = res[i].leavesStatus;
						data['LT'] = res[i].leavesType;
						data['LEN'] = res[i].leavesEmpName;
						data['LID'] = res[i].id;
						data['ID'] = i+1;
						if((data['LS'])=='Approved') {
							(data['LS'])='<span class="label label-success">Approve</span>';
						} else if((data['LS'])=='Reject') {
							(data['LS'])='<span class="label label-danger">Reject</span>';
						} else if((data['LS'])=='Requested') {
							(data['LS'])='<span class="label label-warning">Requested</span>';
						}else {
							(data['LS'])='<span class="label label-info">Plan</span>';
						}
						data['LEDT'] = res[i].leavesendDateType;
						
						$("#lmsAdm004").tmpl(data).appendTo("tbody#leaveBalancedAdmin").html();
					
					})
				}
				
				lms_adm_004.ClickUpdateLeave();
				lms_adm_004.CallListId ();
				
				loading(false);
			},
			error : function(data) {
				console.log(data);
			}
	
		});
		
	}



lms_adm_004.CallListId = function () {
	$("tbody#leaveBalancedAdmin tr a#leaveView").click(function() {
		var lId = ($(this).find('input#input').val());
		lms_adm_004.readLeaveRecord (lId);
		$('#myModal').modal('toggle');
	});
}



lms_adm_004.ClickUpdateLeave =function() {
	$("tbody#leaveBalancedAdmin tr a#leaveReject").click(function() {
		var lId = ($(this).find('input#input').val());
		var act = 'RJ';
		lms_adm_004.updateLeave(lId, act);
	});
	
	$("tbody#leaveBalancedAdmin tr a#leaveApprove").click(function() {
		var lId = ($(this).find('input#input').val());
		var act = 'AP';
		lms_adm_004.updateLeave(lId, act);
		
	});
}

lms_adm_004.readLeaveRecord = function (LeaveId) {
	loading(true);
	var aa = {lId : LeaveId };
	console.log(aa);
	$.ajax({
		url : "../action/service/lms_adm_004LR",
		dataType : "JSON",
		type : "POST",
		data :aa,
		success : function(data) {
			console.log(data.RESP_DATA);
			//lms_adm_004.listAdmin();
		}
	})
	loading(false);
}

lms_adm_004.updateLeave = function(LeaveId, LeaveAct) {
	loading(true);
	var aa = {lId : LeaveId , lAct : LeaveAct};
	console.log(aa);
	$.ajax({
		url : "../action/service/lms_adm_004UA",
		dataType : "JSON",
		type : "POST",
		data :aa,
		success : function(data) {
			console.log(data.RESP_DATA);
			lms_adm_004.listAdmin();
		}
	})
	loading(false);
}
$(document).ready(function() {
	var a = {empId :2};
	$.ajax({
		url : "../admin/action/service/lms_adm_002",
		dataType : "JSON",
		type : "POST",
		data :a,
		success : function(data) {
			console.log(data.RESP_DATA);
				var res = data.RESP_DATA['LEAVES_REC'];
				console.log(res);
				$.each(res,function(i,v){
					var data = {};
					data['LD']  = res[i].leavesDuration;
					data['LED']  = res[i].leavesEnddate;
					data['LR']  = res[i].leavesReason;
					data['LSD'] = res[i].leavesStartdate;
					data['LS'] = res[i].leavesStatus;
					data['LT'] = res[i].leavesType;
					data['ID'] = i+1;
					if((data['LS'])=='Approved') {
						(data['LS'])='<span class="label label-success">Approve</span>';
					} else if((data['LS'])=='Reject') {
						(data['LS'])='<span class="label label-danger">Reject</span>';
					} else {
						(data['LS'])='<span class="label label-info">Plan</span>';
					}
					data['LEDT'] = res[i].leavesendDateType;
					$("#lmsAdm002").tmpl(data).appendTo("tbody#leaveBalanced").html();
					
					console.log(data);
					
				})
			},
			error : function(data) {
				console.log(data);
			}

		});
});
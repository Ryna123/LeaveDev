$(document).ready(function() {
	loading(true);
	var a = {empId :2};
	$.ajax({
		url : "../action/service/lms_adm_002",
		dataType : "JSON",
		type : "POST",
		data :a,
		success : function(data) {
			console.log(data.RESP_DATA);
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
						$("#lmsAdm002").tmpl(data).appendTo("tbody#leaveBalanced").html();
					
					})
				}
				loading(false);
			},
			error : function(data) {
				console.log(data);
			}

		});
});
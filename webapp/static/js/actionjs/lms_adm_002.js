
lms_adm_002={};
$(document).ready(function() {
	lms_adm_002.getLeaveType();
	lms_adm_002.listLeaveRequest();
	
});

lms_adm_002.listLeaveRequest=function(){
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
						if((data['LT'])=='0') {
							(data['LT'])='Annual Leave';
						} else if((data['LT'])=='1') {
							(data['LT'])='Sick Leave';
						} else if((data['LT'])=='2') {
							(data['LT'])='Special Leave';
						}
						data['ID'] = i+1;
						data['LID']=res[i].id;
						if((data['LS'])=='2') {
							(data['LS'])='<span class="label label-success">Approve</span>';
						} else if((data['LS'])=='3') {
							(data['LS'])='<span class="label label-danger">Reject</span>';
						} else if((data['LS'])=='4') {
							(data['LS'])='<span class="label label-warning">Requested</span>';
						}else {
							(data['LS'])='<span class="label label-info">Plan</span>';
						}
						data['LEDT'] = res[i].leavesendDateType;
						$("#lmsAdm002").tmpl(data).appendTo("tbody#leaveBalanced").html();
					
					})
				}
				lms_adm_002.clickEvent();
				loading(false);
			},
			error : function(data) {
				console.log(data);
			}

		});
}

lms_adm_002.clickEvent=function(){
	$("a#leaveId").click(function(){
		var leaveId=$(this).find("input").val();
		console.log("**********leaveid: "+leaveId);
		lms_adm_002.readLeaveOneRecord(leaveId);
		$('#leaveRequestModal').modal('toggle');
	});
}

lms_adm_002.readLeaveOneRecord = function (LeaveId) {
	loading(true);
	var aa = {lId : LeaveId };
	console.log(aa);
	$.ajax({
		url : "../action/service/lms_adm_r002",
		dataType : "JSON",
		type : "POST",
		data :aa,
		success : function(data) {
			console.log("**********data.RESP_DATA: "+data.RESP_DATA);
			var res = data.RESP_DATA['LEAVE_REC'];
			$.each(res,function(i,v){ 
				$("#startDateType").val(res[i].leavesStartDateType);
				$("#endDateType").val(res[i].leavesendDateType);
				$("#duration").val(res[i].leavesDuration);
				$("#reason").val(res[i].leavesReason);
				$("#startDate").val((res[i].leavesStartdate).replace(/\-/g,"/"));
				$("#endDate").val((res[i].leavesEnddate).replace(/\-/g,"/"));
				$("#selectLeaveType").val(res[i].leavesType);
				$("#selectSt").val(res[i].leavesStatus);
			});
			console.log("*******res: "+res);
		}
	})
	loading(false);
}

lms_adm_002.getLeaveType=function(){
	$.ajax({
		url : "../action/service/lms_adm_011",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(data) {
			var res  = data.RESP_DATA['LEAVETYPE_REC'];
			$.each(res,function(i,v){
				var data = {};
				data['leaveTypeId']  = res[i].typeId;
				data['leaveTypeName']  = res[i].typeName;
				$("#selectLeaveTypeTmpl").tmpl(data).appendTo("#selectLeaveType");
			})
			console.log(res);
		},
		error : function(data) {
			console.log(data);
		}
	});
}

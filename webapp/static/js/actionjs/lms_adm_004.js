var lms_adm_004={};
var count=1;

$(document).ready(function() {
	
	lms_adm_004.listAdmin();
	
	/*$("tbody#leaveBalancedAdmin tr a#testaa").click(function() {
		alert($(this).find('input#input').val());
	});*/
	
/*	
	$("#leaveView").click(function () {
		alert('test');
	});
	*/
	lms_adm_004.getLeaveType();
	
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
			table = $('#leaveAdminDataTable').DataTable({
				"order": [[ 0, "desc" ]],
				"pagingType": "full_numbers",
				data:res,
				 "dom": 'rt<"bottom"lp>',//"dom": '<"top"i>rt<"bottom"lp>',
				columns:[
				        {"data":"id","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		 $(nTd).html("<span>"+(count++)+
					        				"</span>");
					             }
				        },
				        {"data":"id","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		$(nTd).html("<a href='javascrip:' id='leaveView'>" +
				        				"<input type='hidden' value="+sData+" data-empid= "+oData.oTEmployeeId+">"+
				        				"<span class='fa fa-eye' title='View' data-original-title='View'>" +
				        				"</span>" +
				        				"</a> | " +
				        				"<a href='javascrip:' id='leaveApprove'><input type='hidden'value="+sData+">"+"<span class='glyphicon glyphicon-ok' title='Approve' data-original-title='Active'></span></a> | " +
				        				"<a href='javascrip:' id='leaveReject'><input type='hidden' value="+sData+">"+"<span class='fa fa-close fa-lg' title='Reject' data-original-title='Delete'></span></a>");
				             }
				        },
				        {"data":"leavesEmpName"},
				        {"data":"leavesStartdate","bSearchable": false},
				        {"data":"leavesEnddate","bSearchable": false},
				        {"data":"leavesDuration","bSearchable": false
				        	/*"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		if((oData.oTType)==1){
				        			$(nTd).html("<span>" +oData.oTDuration+"</span>" +
					        				"&nbsp;&nbsp;"+
					        				"<span>Day(s)</span>");
				        		}else{$(nTd).html("<span>" +oData.oTDuration+"</span>" +
				        				"&nbsp;&nbsp;"+
				        				"<span>Hour(s)</span>");}
				             }*/
				        },
				        {"data":"leavesReason",className:"clnReason",
				        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		$(nTd).html("<div style='white-space: nowrap;overflow: hidden; text-overflow: ellipsis; width:100px;'>" + sData +
				        				"</div>");
				             }
				        },
				        {"data":"leavesType",
				        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		if ((oData.leavesType) == '0') {
				        			oData.leavesType="Annual Leave";
				        			$(nTd).html('Annual Leave');
								} else if ((oData.leavesType) == '1') {
									oData.leavesType="Sick Leave";
									$(nTd).html('Sick Leave');
								} else if ((oData.leavesType) == '2') {
									oData.leavesType="Special Leave";
									$(nTd).html('Special Leave');
								}
				             }
				        },
				        {"data":"leavesStatus",
				        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		if ((oData.leavesStatus) == '1') {
				        			oData.leavesStatus="Planned";
				        			$(nTd).html('<span class="label label-info">Planned</span>');
								} else if ((oData.leavesStatus) == '4') {
									oData.leavesStatus="Requested";
									$(nTd).html('<span class="label label-warning">Requested</span>');
								} else if ((oData.leavesStatus) == '2') {
									oData.leavesStatus="Approved";
									$(nTd).html('<span class="label label-success">Approved</span>');
								} else if ((oData.leavesStatus) == '3') {
									oData.leavesStatus="Rejected";
									$(nTd).html('<span class="label label-danger">Rejected</span>');
								}
				             }
				        },
				        
				],
			});
				
				lms_adm_004.ClickUpdateLeave();
				lms_adm_004.CallListId ();
				
				loading(false);
			},
			error : function(data) {
				console.log(data);
			}
	
		});
		
	}

$('#SearchBox').keyup(function(){
	table.search($(this).val()).draw() ;
})

lms_adm_004.CallListId = function () {
	$("a#leaveView").click(function() {
		var lId = ($(this).find('input').val());
		console.log("*****lId: "+lId);
		lms_adm_004.readLeaveRecord (lId);
		$('#lms_adm_004p').modal('toggle');
	});
}



lms_adm_004.ClickUpdateLeave =function() {
	$("a#leaveReject").click(function() {
		var lId = ($(this).find('input').val());
		var act = 'RJ';
		lms_adm_004.updateLeave(lId, act);
	});
	
	$("a#leaveApprove").click(function() {
		var lId = ($(this).find('input').val());
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
			var res = data.RESP_DATA['LEAVES_REC'];
			$.each(res,function(i,v){ 
				$("#duration").val(res[i].leavesDuration);
				$("#reason").val(res[i].leavesReason);
				$("#startdate").val((res[i].leavesStartdate).replace(/\-/g,"/"));
				$("#enddate").val((res[i].leavesEnddate).replace(/\-/g,"/"));
				$("#startDateType").val((res[i].leavesStartDateType));
				$("#endDateType").val((res[i].leavesendDateType));
				$("#selectSt").val((res[i].leavesStatus));
				$("#selectLeaveType").val((res[i].leavesType));
//				$("#enddate").val(res[i].leavesReason);
				
			});
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
			location.href= "lms_adm_004";
		}
	})
	loading(false);
}

lms_adm_004.getLeaveType=function(){
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

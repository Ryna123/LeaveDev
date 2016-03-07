
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
			var listData=data.RESP_DATA['LEAVES_REC'];
			var values={"data":listData};
			var count = 1;
			
			table = $('#leaveRequestDataTable').DataTable({
				"order": [[ 1, "desc" ]],
				"pagingType": "full_numbers",
				data:values["data"],
				"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 0, 0 ] } ] ,
				 "dom": 'rt<"bottom"lp>',//"dom": '<"top"i>rt<"bottom"lp>',
				columns:[
				        {"data":"id","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		$(nTd).html("<a href='javascrip:' id='viewBtn'>" +
				        				"<input type='hidden' value="+sData+">"+
				        				"<span class='fa fa-eye' title='View' data-original-title='View'>" +
				        				"</span>" +
				        				"</a>");
				             }
				        },
				        {"data":"id","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		 $(nTd).html("<span>"+(count++)+
					        				"</span>"); 
					             }
				        },
				        {"data":"leavesStartdate","bSearchable": false},
				        {"data":"leavesEnddate","bSearchable": false},
				        {"data":"leavesDuration","bSearchable": false},
				        {"data":"leavesReason"},
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
				lms_adm_002.clickEvent();
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

lms_adm_002.clickEvent=function(){
	$("a#viewBtn").click(function(){
		var leaveId=$(this).find("input").val();
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

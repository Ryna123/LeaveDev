$(document).ready(function() {
	alert(1);
	
//	var a = {/*empId :2,*/statId : 2};
	
	$("#addUser").click(function(){
		
		alert();
		loading(true);
		var lobj = {};
		var lType = $("#selectLt").val();
		var lDuration = $("#duration").val();
		var lStartDate = $("#startdate").val();
		var lEnddate = $("#enddate").val();
		var lStartDateType = $("#startdatetype").val();
		var lEndDateType = $("#enddatetype").val();
		var lReason = $("#reason").val();
		var lStatus = $("#selectSt").val();
		
		lobj.leavesType = lType;
		lobj.leavesDuration = lDuration;
		lobj.leavesStartdate = lStartDate;
		lobj.leavesEnddate = lEnddate;
		lobj.leavesStartDateType =lStartDateType
		lobj.leavesendDateType =lEndDateType
		lobj.leavesReason = lReason;
		lobj.leavesStatus = lStatus;
		console.log(lobj);
		
		$.ajax({
			//url : "../admin/action/service/lms_adm_001/1/2",
			url : "../action/service/lms_adm_008",
			
			dataType : "JSON",
			type : "POST",
		//	data :a,
			
			success : function(data) {
				
				},
//				}

			});
		
	});
	
	
	
});
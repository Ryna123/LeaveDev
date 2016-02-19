$(document).ready(function() {
	
	$("#startdate,#enddate").daterangepicker({
		singleDatePicker: true,
        showDropdowns: true,
        format:'DD/MM/YYYY'
	});
	
	
	$.ajax({
		url : "../action/service/lms_adm_027lt",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(data) {
			//console.log(data.RESP_DATA);
			var res = data.RESP_DATA['LEAVETYPE_REC'];
			var res2  = data.RESP_DATA['LEAVESTATUS_REC'];
			$.each(res,function(i,v){
				var data = {};
				data['TI']  = res[i].typeId;
				data['TN']  = res[i].typeName;
				$("#mytemplate").tmpl(data).appendTo("#selectLt");
			})
			
			$.each(res2,function(i,v){
				var data = {};
				data['SI']  = res2[i].statusId;
				data['SN']  = res2[i].statusName;
				$("#mytemplate1").tmpl(data).appendTo("#selectSt");
			})
			
		},
		error : function(data) {
			console.log(data);
		}

	});
	
	$("#addleave").validationEngine(gbox.ui.validationEngineOptions);
	$("#addLeave").click(function() {
		
		if(!$("#addleave").validationEngine('validate')) {
			return false;
		}	
		
		
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
			url : "../action/service/lms_adm_027It",
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			dataType : "JSON",
			type : "POST",
			data :JSON.stringify(lobj),
			success : function(data) {
			//	console.log(data.CODE);
				if(data.CODE =='000') {
					loading(false);
					maketoast();
					location.href= "lms_adm_002"; // link to list all requested
				}
				
			},
			error : function(data) {
				console.log(data);
			}

		});
		
		
	})
});
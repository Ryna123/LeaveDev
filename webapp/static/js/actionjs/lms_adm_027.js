$(document).ready(function() {
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
	
	$("#addLeave").click(function() {
		var lobj = {};
		var lType = $("#selectLt").val();
		var lDuration = $("#duration").val();
		var lStartDate = $("#startdate").val();
		var lEnddate = $("#enddate").val();
		var lStartDateType = $("#startdatetype").val();
		var lEndDateType = $("#startdatetype").val();
		var lReason = $("#reason").val();
		var lStatus = $("#selectSt").val();
		
		lobj.type = lType;
		lobj.duration = lDuration;
		lobj.startdate = lStartDate;
		lobj.enddate = lEnddate;
		lobj.startdatetype =lStartDateType
		lobj.enddatetype =lEndDateType
		lobj.reason = lReason;
		lobj.status = lStatus;
		console.log(lobj);
		
		var data = {};
		data["fname"] = "Yon";
		data["lname"] = "Ryna";
		//data["as"] = "lasjdf";
		$.ajax({
			url : "../action/service/lms_adm_027It",
			//"Content-Type":" application/json",
			dataType : "JSON",
			type : "POST",
			data :data,
			/*success : function(data) {
				//console.log(data.RESP_DATA);
				
			},*/
			error : function(data) {
				console.log(data);
			}

		});
		
		
	})
});
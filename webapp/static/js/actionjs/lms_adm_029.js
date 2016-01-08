/**
 * 
 */
$(document).ready(function() {
	$.ajax({
		url : "../action/service/lms_adm_029",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(data) {
			//console.log(data.RESP_DATA);
			var res  = data.RESP_DATA['LEAVESTATUS_REC'];
			$.each(res,function(i,v){
				var data = {};
				data['statusID']  = res[i].statusId;
				data['statusName']  = res[i].statusName;
				$("#selectStTmpl").tmpl(data).appendTo("#selectSt");
			})
			console.log(res);
		},
		error : function(data) {
			console.log(data);
		}
	});
	
	$("#addOTForm").validationEngine(gbox.ui.validationEngineOptions);
	$("#addOT").click(function() {
		
		if(!$("#addOTForm").validationEngine('validate')) {
			return false;
		}	
		
		loading(true);
		var ot = {};
		var otType = $("#otType").val();
		var otDuration = $("#otDuration").val();
		//var otDate = $("#otDate").val().replace(/[&\/\\#,+()$~%.'":*?<>{}]/g, '');
		var otDate = $("#otDate").val();
		var otReason = $("#otReason").val();
		var otStatusId = $("#selectSt").val();
		
		ot.oTType = otType;
		ot.oTDuration = otDuration;
		ot.oTDate = otDate;
		ot.oTReason = otReason;
		ot.oTStatus_id =otStatusId;
		console.log(ot);
		
		$.ajax({
			url : "../action/service/lms_adm_029I",
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			dataType : "JSON",
			type : "POST",
			data :JSON.stringify(ot),
			success : function(data) {
				console.log(data);
				if(data.CODE =='000') {
					loading(false);
					maketoast();
					location.href= "lms_adm_028"; // link to list all requested
				}
			},
			error : function(data) {
				console.log(data);
			}
		});
	})
});
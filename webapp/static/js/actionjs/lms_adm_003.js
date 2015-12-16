$(document).ready(function() {
	$.ajax({
		url : "../admin/action/service/lms_adm_003lt",
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
	
	
});
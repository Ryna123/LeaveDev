$(document).ready(function() {
	$.ajax({
		url : "../admin/action/service/lms_adm_003lt",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(data) {
			console.log(data.RESP_DATA);
			var res = data.RESP_DATA['LEAVETYPE_REC'];
			console.log(res);
			$.each(res,function(i,v){
				var data = {};
				data['TI']  = res[i].typeId;
				data['TN']  = res[i].typeName;
				$("#mytemplate").tmpl(data).appendTo("#selectLt");
			})
			},
			error : function(data) {
				console.log(data);
			}

		});
});
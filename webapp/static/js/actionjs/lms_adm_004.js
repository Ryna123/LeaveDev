$(document).ready(function() {
	var empId = 2;
	
	
	var a = {empId :2,statId : 2};
	/*
	a["ab"] = "hi";
	a["bc"] = "oh";
	*/
	/* {type:"Fiat", model:"500", color:"white"},*/

	console.log(a);
	
	$.ajax({
		//url : "../admin/action/service/lms_adm_001/1/2",
		url : "../admin/action/service/lms_adm_001",
		dataType : "JSON",
		type : "POST",
		data :a,
		success : function(data) {
			console.log(data.RESP_DATA);
			//console.log(data.RESP_DATA['ENTITLE_REC']);
				var res = data.RESP_DATA['ENTITLE_REC'];
				console.log(res);
				//$("#mytemplate").tmpl(res).appendTo("tbody#entitle");
				$.each(res,function(i,v){
					var data = {};
					data['LA']  = res[i].leavesAvailable;
					data['LE']  = res[i].leavesEntitled;
					data['LT']  = res[i].leavesTaken;
					data['LTY'] = res[i].leavesTypes;
					$("#mytemplate").tmpl(data).appendTo("tbody#entitle");
				})
			},
			error : function(data) {
				console.log(data);
			}

		});
});
$(document).ready(function() {
	//loading(true);
	alert(1);
//	var a = {/*empId :2,*/statId : 2};
	$.ajax({
		//url : "../admin/action/service/lms_adm_001/1/2",
		url : "../action/service/lms_adm_006",
		dataType : "JSON",
		type : "POST",
	//	data :a,
		success : function(data) {
			console.log(data);
			//console.log(data.RESP_DATA['ENTITLE_REC']);
//				var res = data.RESP_DATA['ENTITLE_REC'];
//				console.log(res);
//				//$("#mytemplate").tmpl(res).appendTo("tbody#entitle");
//				if(res.length <=0) {
//					$("tfoot#entitleFooter").show();
//				} else {
//					$.each(res,function(i,v){
//						var data = {};
//						data['LA']  = res[i].leavesAvailable;
//						data['LE']  = res[i].leavesEntitled;
//						data['LT']  = res[i].leavesTaken;
//						data['LTY'] = res[i].leavesTypes;
//						$("#mytemplate").tmpl(data).appendTo("tbody#entitle");
//					})
//				}
//				loading(false);
			},
			error : function(data) {
			//	console.log(data);
			}

		});
});
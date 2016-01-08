/**
 * 
 */
$(document).ready(function() {
	loading(true);
	var a = {empId :2};
	$.ajax({
		url : "../action/service/lms_adm_028",
		dataType : "JSON",
		type : "POST",
		data :a,
		success : function(data) {
			console.log(data.RESP_DATA);
				var res = data.RESP_DATA['OVERTIME_REC'];
				if(res.length<=0) {
					$("tfoot#otFooter").show();
				} else {
					$.each(res,function(i,v){
						
						var data = {};
						data['otID'] = i+1;
						data['otDuration']  = res[i].oTDuration;
						data['otDate']  = res[i].oTDate;
						data['otReason']  = res[i].oTReason;
						data['otStatus'] = res[i].oTStatus_id;
						data['otType'] = res[i].oTType;
						/*if((data['otType'])=='1') {
							(data['otType'])='<span class="label label-success">Days</span>';
						} else if((data['otType'])=='2') {
							(data['otType'])='<span class="label label-danger">Hours</span>'; 
						}*/
						
						if((data['otType'])=='1') {
							(data['otType'])='Day(s)';
						} else if((data['otType'])=='2') {
							(data['otType'])='Hour(s)';
						}
						
						if((data['otStatus'])=='1') {
							(data['otStatus'])='Planned';
						} else if((data['otStatus'])=='4') {
							(data['otStatus'])='Requested';
						}
						$("#lmsAdm028").tmpl(data).appendTo("tbody#listOT").html();
					
					})
				}
				loading(false);
			},
			error : function(data) {
				console.log(data);
			}

		});
});
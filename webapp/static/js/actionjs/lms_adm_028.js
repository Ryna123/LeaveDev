/**
 * 
 */

var lms_adm_028 = {};
$(document).ready(function() {
	lms_adm_028.listOverTime();
});

// list all overtime request
lms_adm_028.listOverTime = function() {
	loading(true);
	var a = {
		empId : 2
	};
	$.ajax({
		url : "../action/service/lms_adm_028",
		dataType : "JSON",
		type : "POST",
		data : a,
		success : function(data) {
			console.log(data.RESP_DATA);
			var res = data.RESP_DATA['OVERTIME_REC'];
			if (res.length <= 0) {
				$("tfoot#otFooter").show();
			} else {
				$.each(res, function(i, v) {

					var data = {};
					data['otID'] = i + 1;
					data['otDuration'] = res[i].oTDuration;
					data['otDate'] = res[i].oTDate;
					data['otReason'] = res[i].oTReason;
					data['otStatus'] = res[i].oTStatus_id;
					data['otType'] = res[i].oTType;
					data['id'] = res[i].id;
					/*
					 * if((data['otType'])=='1') { (data['otType'])='<span
					 * class="label label-success">Days</span>'; } else
					 * if((data['otType'])=='2') { (data['otType'])='<span
					 * class="label label-danger">Hours</span>'; }
					 */

					if ((data['otType']) == '1') {
						(data['otType']) = 'Day(s)';
					} else if ((data['otType']) == '2') {
						(data['otType']) = 'Hour(s)';
					}

					if ((data['otStatus']) == '1') {
						(data['otStatus']) = 'Planned';
					} else if ((data['otStatus']) == '4') {
						(data['otStatus']) = 'Requested';
					} else if ((data['otStatus']) == '2') {
						(data['otStatus']) = 'Approved';
					} else if ((data['otStatus']) == '3') {
						(data['otStatus']) = 'Rejected';
					}
					$("#lmsAdm028").tmpl(data).appendTo("tbody#listOT").html();

				})
			}
			lms_adm_028.CallOtOneRecord();
			loading(false);
		},
		error : function(data) {
			console.log(data);
		}

	});
}

lms_adm_028.CallOtOneRecord = function() {
	$("#listOT tr a#viewBtn").click(function() {
		var otId = ($(this).find('input').val());
		lms_adm_028.getOtOneRecord(otId);
		$('#otModal').modal('toggle');
	});
}

lms_adm_028.getOtOneRecord = function(input) {
	loading(true);
	var a = {
		otId : input
	};
	$.ajax({
		url : "../action/service/lms_adm_030p",
		dataType : "JSON",
		type : "POST",
		data : a,
		success : function(data) {
			console.log(data.RESP_DATA);
			var res = data.RESP_DATA['OVERTIME_REC'];
			$.each(res, function(i, v) {
				var data = {};
				$("#otType").val(res[i].oTType);
				$("#otDuration").val(res[i].oTDuration);
				$("#otDate").val((res[i].oTDate).replace(/\-/g, "/"));
				$("#otReason").val(res[i].oTReason);
				$("#otStatus").val(res[i].oTStatus_id);
			});
		}
	})
	loading(false);
}
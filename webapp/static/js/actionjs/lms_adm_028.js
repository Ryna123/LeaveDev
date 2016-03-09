/**
 * 
 */

var lms_adm_028 = {};
var count=1;
$(document).ready(function() {
	lms_adm_028.listOverTime();
	
	$("#otDate").daterangepicker({ 
		singleDatePicker: true,
        showDropdowns: true,
        format:'DD/MM/YYYY'
	});
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
			var listData = data.RESP_DATA['OVERTIME_REC'];
			//var count = Object.keys(listData).length;
			
			var values={"data":listData};
			console.log(values);
			//var count = Object.keys(listData).length;
			console.log(count);
				table = $('#otDataTable').DataTable({
					"order": [[ 1, "desc" ]],
					"aoColumnDefs": [{ "bSortable": false, "aTargets": [0]}],
					"pagingType": "full_numbers",
					data:values["data"],
					 "dom": 'rt<"bottom"lp>',//"dom": '<"top"i>rt<"bottom"lp>',
					columns:[
					        {"data":"id","bSearchable": false,
					        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
					        		$(nTd).html("<a href='javascrip:' id='viewBtn'>" +
					        				"<input type='hidden' value="+sData+">"+
					        				"<span class='fa fa-eye' title='View' data-original-title='View'>" +
					        				"</span>" +
					        				"</a>");
					             }
					        },
					        {"data":"id","bSearchable": false,
					        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
					        		 $(nTd).html("<span>"+(count++)+
						        				"</span>");
						             }
					        },
					        {"data":"oTDate","bSearchable": false},
					        {"data":"oTDuration","bSearchable": false,
					        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
					        		if((oData.oTType)==1){
					        			$(nTd).html("<span>" +oData.oTDuration+"</span>" +
						        				"&nbsp;&nbsp;"+
						        				"<span>Day(s)</span>");
					        		}else{$(nTd).html("<span>" +oData.oTDuration+"</span>" +
					        				"&nbsp;&nbsp;"+
					        				"<span>Hour(s)</span>");}
					             }
					        },
					        {"data":"oTReason",className:"clnReason",
					        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
					        		$(nTd).html("<div style='white-space: nowrap;overflow: hidden; text-overflow: ellipsis; width:100px;'>" + sData +
					        				"</div>");
					             }
					        },
					        {"data":"oTStatus_id",
					        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
					        		if ((oData.oTStatus_id) == '1') {
					        			oData.oTStatus_id="Planned";
					        			$(nTd).html('<span class="label label-info">Planned</span>');
									} else if ((oData.oTStatus_id) == '4') {
										oData.oTStatus_id="Requested";
										$(nTd).html('<span class="label label-warning">Requested</span>');
									} else if ((oData.oTStatus_id) == '2') {
										oData.oTStatus_id="Approved";
										$(nTd).html('<span class="label label-success">Approved</span>');
									} else if ((oData.oTStatus_id) == '3') {
										oData.oTStatus_id="Rejected";
										$(nTd).html('<span class="label label-danger">Rejected</span>');
									}
					             }
					        },
					        
					],
				});
			lms_adm_028.CallOtOneRecord();
			lms_adm_028.callUpdateOt();
			loading(false);
			count=1;
		},
		error : function(data) {
			console.log(data);
		}
	});
}

$('#SearchBox').keyup(function(){
	table.search($(this).val()).draw() ;
})

lms_adm_028.CallOtOneRecord = function() {
	$("#otDataTable tr a#viewBtn").click(function() {
		var otId = ($(this).find('input').val());
		lms_adm_028.getOtOneRecord(otId);
		$('#otModal').modal('toggle');
	});
}

lms_adm_028.callUpdateOt = function() {
	$("#oTEditBtn").click(function() {
		lms_adm_028.updateOt();
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
				//var data = {};
				$("#otType").val(res[i].oTType);
				$("#otDuration").val(res[i].oTDuration);
				$("#otDate").val((res[i].oTDate).replace(/\-/g, "/"));
				$("#otReason").val(res[i].oTReason);
				$("#otStatus").val(res[i].oTStatus_id);
				$("#otId").val(res[i].id);

				//visible for user input when status="planned" || ="Requested"
				if (($("#otStatus").val())== '1' || ($("#otStatus").val())=='4') {
					$("#oTEditBtn").show();
					$("#otType").removeAttr("disabled");
					$("#otDuration").removeAttr("disabled");
					$("#otDate").removeAttr("disabled");
					$("#otReason").removeAttr("disabled");
					$("#otStatus").removeAttr("disabled");
				} else {
					$("#oTEditBtn").hide();
					$("#otType").attr("disabled", "disabled");
					$("#otDuration").attr("disabled", "disabled");
					$("#otDate").attr("disabled", "disabled");
					$("#otReason").attr("disabled", "disabled");
					$("#otStatus").attr("disabled", "disabled");
				}
			});
		}
	})
	loading(false);
}


lms_adm_028.updateOt=function(){
	if(!$("#otModalForm").validationEngine('validate')) { 
		return false;
	}	

	loading(true);
	var otid=($("#otModal").find('#otId').val());
	
	var ot = {};
	var otType = $("#otType").val();
	var otDuration = $("#otDuration").val();
	var otDate = $("#otDate").val();
	var otReason = $("#otReason").val();
	var otStatusId = $("#otStatus").val();
	
	ot.oTType = otType;
	ot.oTDuration = otDuration;
	ot.oTDate = otDate;
	ot.oTReason = otReason;
	ot.oTStatus_id =otStatusId;
	ot.id=otid;
	
	$.ajax({
		url : "../action/service/lms_adm_u030p",
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		dataType : "JSON",
		type : "PUT",
		data :JSON.stringify(ot),
		success : function(data) {
			location.href= "lms_adm_028";
		}
	})
	loading(false);
}
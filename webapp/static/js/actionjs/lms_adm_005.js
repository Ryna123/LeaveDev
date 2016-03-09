/**
 * 
 */
var lms_adm_005 ={};
var count = 1;

$(document).ready(function() {
	lms_adm_005.listOverTime();
	
	/*$("#srchBtn").click(function(){
		//lms_adm_005.listOverTime();
	});*/
});

lms_adm_005.listOverTime = function(){
//	loading(true);
	var a = {
			empId : 1
		};
	$.ajax({
		url : "../action/service/lms_adm_r005",
		dataType : "JSON",
		type : "POST",
		data:a,
		success : function(data) {
			console.log(data.RESP_DATA['OVERTIME_LIST']);
			var res = data.RESP_DATA['OVERTIME_LIST'];
			var values={"data":res};
			table = $('#otDataTable').DataTable({
				"order": [[ 0, "desc" ]],
				"pagingType": "full_numbers",
				data:values["data"],
				 "dom": 'rt<"bottom"lp>',//"dom": '<"top"i>rt<"bottom"lp>',
				columns:[
				        {"data":"id","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		 $(nTd).html("<span>"+(count++)+
					        				"</span>");
					             }
				        },
				        {"data":"id","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		$(nTd).html("<a href='javascrip:' id='viewBtn'>" +
				        				"<input type='hidden' value="+sData+" data-empid= "+oData.oTEmployeeId+">"+
				        				"<span class='fa fa-eye' title='View' data-original-title='View'>" +
				        				"</span>" +
				        				"</a> | " +
				        				"<a href='javascrip:' id='approveBtn'><input type='hidden' value="+sData+">"+"<span class='glyphicon glyphicon-ok' title='Approve' data-original-title='Active'></span></a> | " +
				        				"<a href='javascrip:' id='rejectBtn'><input type='hidden' value="+sData+">"+"<span class='fa fa-close fa-lg' title='Reject' data-original-title='Delete'></span></a>");
				             }
				        },
				        {"data":"oTEmpName"},
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
				        {"data":"statusNm",
				        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		if ((oData.statusNm) == 'Planned') {
				        			oData.statusNm="Planned";
				        			$(nTd).html('<span class="label label-info">Planned</span>');
								} else if ((oData.statusNm) == 'Requested') {
									oData.statusNm="Requested";
									$(nTd).html('<span class="label label-warning">Requested</span>');
								} else if ((oData.statusNm) == 'Approved') {
									oData.statusNm="Approved";
									$(nTd).html('<span class="label label-success">Approved</span>');
								} else if ((oData.statusNm) == 'Rejected') {
									oData.statusNm="Rejected";
									$(nTd).html('<span class="label label-danger">Rejected</span>');
								}
				             }
				        },
				        
				],
			});
			lms_adm_005.clickToUpdateStatusOvertime();
			lms_adm_005.CallListId();
			count=1;
		}
	});
	
}

$('#srchBtn').click(function(){
	alert($(this).val);
	table.search($('#srchTxt').val()).draw() ;
})

lms_adm_005.clickToUpdateStatusOvertime =function() {
	// update status use current page
	$("a#approveBtn").click(function() {
		var id = ($(this).find('input').val());
		var input={otId:id,otAct:'AP'} // Approve
		lms_adm_005.updateOvertime(input);
	});
	$("a#rejectBtn").click(function() {
		var id = ($(this).find('input').val());
		var input={otId:id,otAct:'RJ'} // Reject
		lms_adm_005.updateOvertime(input);
	});
	
	// update statuse use pop up
	$(".form-group div #appBtn").click(function() {
		var id = ($(this).parent('div').find('input').val());
		var input={otId:id,otAct:'AP'} // Approve
		lms_adm_005.updateOvertime(input);
	});
	
	$(".form-group div #rejBtn").click(function() {
		var id = ($(this).parent('div').find('input').val());
		var input={otId:id,otAct:'RJ'} // Reject
		lms_adm_005.updateOvertime(input);
		
	});
	
}

lms_adm_005.CallListId = function () {
	$("a#viewBtn").click(function() {
		var oId = ($(this).find('input').val());
		var uId = ($(this).find('input').data("empid"));
		var input={otId:oId,empId:uId} // 
		console.log(input);
		lms_adm_005.readOtOfUser(input)
		$('#lms_adm_005p').modal('toggle');
	});
}

/*$("#backBtn").click(function(){
	$("#lms_adm_005p").modal('toggle')
});*/
lms_adm_005.updateOvertime = function(input) {
	loading(true);
	console.log(input);
	$.ajax({
		url : "../action/service/lms_adm_u005",
		dataType : "JSON",
		type : "POST",
		data :input,
		success : function(data) {
			console.log(data.RESP_DATA);
			location.href= "lms_adm_005";
		}
	})
	loading(false);
}



lms_adm_005.readOtOfUser  = function (input) {
	loading(true);
	console.log(input);
	$.ajax({
		url : "../action/service/lms_adm_005p",
		dataType : "JSON",
		type : "POST",
		data :input,
		success : function(data) {
			$("div#divDuration").empty();
			console.log(data.RESP_DATA);
			var res = data.RESP_DATA['OVERTIME_REC'];
			    $.each(res,function(i,v){ 
			    	var data = {};
					data['TYPE']  = res[i].oTType;
					data['DURATION']  = res[i].oTDuration;
					$("#startDate").val((res[i].oTDate).replace(/\-/g,"/"));;
					$("#reason").val(res[i].oTReason);
					$("#status").val(res[i].oTStatus_id);
					$("#overtimeId").val(res[i].id);
					$("#userNm").text("( # "+res[i].oTEmpName+")");
					
					if((data['TYPE'])=='1') {
						(data['TYPE'])='Day(s)';
					} else if((data['TYPE'])=='2') {
						(data['TYPE'])='Hour(s)';
					}
					$("#templateDuration").tmpl(data).appendTo("div#divDuration");
			    });
		}
	})
	loading(false);
}
			


			
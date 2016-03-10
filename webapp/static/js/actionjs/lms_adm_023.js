var lms_adm_023 ={};
myData = {
		'numberOfRecord': $("#numberOfRecord").val(),
		'pageCount':1
	};
$(document).ready(function() {
	
	lms_adm_023.listReportBalance();
	
	/**
	 * change numberOfRecord
	 */
	$("#numberOfRecord").change(function(){
		myData.numberOfRecord = $(this).val();
		myData.pageCount = 1;
		lms_adm_023.listReportBalance();
	});
	
	$("#btn_selDept").click(function(){
		$("#select_dept").modal("toggle");
	});
	
	// button Launch to show employees in specific department
	$("#btn_ShowEmp").click(function(){
		var managerId = $("#valDepartment").val();
		if(managerId == ''){
			alert("Please select department");
		}else{
			input = {
					'numberOfRecord': $("#numberOfRecord").val(),
					'pageCount':1,
					'managerId':managerId
				};
			lms_adm_023.listReportBalanceFindByManager(input);
		}
		
	});
	//button in lms_adm_009p   
	$("#btnCacelDept").click(function(){
		  $("#txtDepartment").val("");
		  lms_adm_023.listReportBalance();
	  });

});

lms_adm_023.listReportBalance = function(input){
//	loading(true);
	$.ajax({
		url : "../action/service/lms_adm_r023",
		dataType : "JSON",
		type : "POST",
		data :myData,
		success : function(dat) {
			$("tbody#reportBal").empty();
			var data =[]
			var res =dat.RESP_DATA['REP_BAL']
			$.each(res, function(i, v) {
				var data = {};
				data['IDENTITIER']  = res[i].identifier;
				data['FIRSTNAME']  = res[i].firstName;
				data['LASTNAME']  = res[i].lastName;
				data['DEPARTMENT']  = res[i].deptNm;
				data['POSTION']  = res[i].position;
				data['HIREDDATE']  = res[i].hiredDate;
				data['PHONE'] = res[i].phone;
				$("#ReportBalTemplate").tmpl(data).appendTo("tbody#reportBal");
				
			});
			paging.createPagination(dat.RESP_DATA['TOTAL_REC']);
		}
	});
	
}

lms_adm_023.listReportBalanceFindByManager = function(input){
//	loading(true);
	
	
	$.ajax({
		url : "../action/service/lms_adm_l023",
		dataType : "JSON",
		type : "POST",
		data :input,
		success : function(dat) {
			$("tbody#reportBal").empty();
			var data =[]
			 console.log(dat);      
			var res =dat.RESP_DATA['REP_BAL']
			$.each(res, function(i, v) {
				var data = {};
				data['IDENTITIER']  = res[i].identifier;
				data['FIRSTNAME']  = res[i].firstName;
				data['LASTNAME']  = res[i].lastName;
				data['DEPARTMENT']  = res[i].deptNm;
				data['POSTION']  = res[i].position;
				data['HIREDDATE']  = res[i].hiredDate;
				data['PHONE'] = res[i].phone;
				$("#ReportBalTemplate").tmpl(data).appendTo("tbody#reportBal");
			});
			paging.createPagination(dat.RESP_DATA['TOTAL_REC']);
		}
	});
	
}




var paging = {
		createPagination : function(totalRecord)
		{
			if(totalRecord==0){
				$("#pagination").html("");
			}else{
				var a = totalRecord % myData.numberOfRecord; // 5				
				var numberOfPaging = Math.floor(totalRecord / myData.numberOfRecord);
			
				if(a>0){			
					numberOfPaging += 1;			
				}
				var paging = "<span class='dataTables_paginate paging_full_numbers'>" +
								"<a tabindex='0' class='first paginate_button paginate_button_disabled' href='javascript:' id='paging_first'>First</a>" +
								"<a tabindex='0' class='previous paginate_button paginate_button_disabled' id='page_previous' href='javascript:'>Previous</a>" +
								"<span>";				
				for(var i=1; i<(numberOfPaging+1);i++){
					if(i == myData.pageCount) {
						paging += "<a class='numberOfPage paginate_active' href='javascript:'>"+i+"</a>";
						continue;
					}
					paging += "<a class='numberOfPage paginate_button' href='javascript:'>"+i+"</a>";			
				}
				paging 		+='</span>'+
							'<a tabindex="0" class="next paginate_button" href="javascript:" id="paging_next">Next</a>'+
							'<a tabindex="0" class="last paginate_button" href="javascript:" id="paging_last">Last</a>'+
						'</span>';			
				$("#paging").html(paging);
				
				/*if(myData['pageCount'] == 1){
					$("#page_previous").addClass("disabled");
				}else{
					$("#page_previous").removeClass("disabled");
				}
				if(myData['pageCount'] == numberOfPaging){
					$("#paging_next").addClass("disabled");
				}else{
					$("#paging_next").removeClass("disabled");
				}*/		
				

				$("#paging span a.numberOfPage").on("click", function(){ 
						myData['pageCount'] = Number($(this).text());
						lms_adm_023.listReportBalance();
				});
				$("#page_previous").on("click", function(){
					if(myData['pageCount'] == 1){
						alert("This is the first page");
						return false;
					}else{
						myData['pageCount'] -= 1;
						lms_adm_023.listReportBalance();
					}
				});
				$("#paging_first").on("click", function(){
					if(myData.pageCount==1){
						alert("already in the first page")
						return false;
					}else{
						myData.pageCount = 1;
						lms_adm_023.listReportBalancea();
					}
				});
				$("#paging_next").on("click", function(){
					if(numberOfPaging == myData['pageCount']){
						alert("This is the last page");
						return false;
					}else{
						myData['pageCount'] += 1;
						lms_adm_023.listReportBalance();
					}
				});
				$("#paging_last").on("click", function(){
					if(numberOfPaging == myData.pageCount){
						alert("already in the last page");
						return false;
					}else{
						myData.pageCount = numberOfPaging;
						lms_adm_023.listReportBalance();
					}
				});
			}
			
		},
}

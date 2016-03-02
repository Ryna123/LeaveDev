var contractManagment={};
var table;
$(document).ready(function(){
	$("#txtStart,#txtEnd,#txtCStart,#txtCEnd").daterangepicker({ 
		  singleDatePicker: true,
		        showDropdowns: true,
		        format:'DD/MM/YYYY'
	});
	
	contractManagment.listContractInfo();
	/*$('#btnCreate').click(function(){
		contractManagment.createContract();
	});*/
});

contractManagment.listContractInfo = function(){
	loading(true);
	var pathname = window.location.pathname;
	$.ajax({
		url:"../action/service/lms_adm_r017",
		dataType:"JSON",
		type:"GET",
		success:function(data){
			var values={"data":data.contractList};
			console.log(values);
			table = $("#ctTable").DataTable({
				"pagingType": "full_numbers",
				data:values["data"],
				columns:[
				         {"data":"id", className:"dataRow", "bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        			 $(nTd).html("<div class='fa-hover col-md-3 col-sm-4 col-xs-12'>" +
				        			 		"<a href='#/trash-o' class='btnDelete' data-index="+sData+"><i class='fa fa-trash-o'></i></a>" +
				        			 		" </div>" + "<div class='fa-hover col-md-3 col-sm-4 col-xs-12'><a class='btnEdit' href='#' data-index="+sData+"><i class='fa fa-pencil' data-toggle='modal' ></i><input type='hidden' class='inputEdit'></a></div>"+
				        			 		"<div class='fa-hover col-md-3 col-sm-4 col-xs-12'><a class='btnView' data-index="+sData+"><i class='fa fa-signal'></i></a></div>");
				             }
				        },
				         {"data":"id"},
				         {"data":"contractName"},
				         {"data":"startedDate"},
				         {"data":"endDate"}
				]
			});
			contractManagment.clickEvent();
		}
	});
	
	loading(false);
}

contractManagment.clickEvent=function(){
	$('#ctTable tbody tr td a.btnDelete').click(function(){
		/*alert($(this).data('index'));*/
		var dID=$(this).data('index');	
		if(confirm('Do you want to delete record: ')+dID){
			$.ajax({
				url:"../action/service/lms_adm_d017",
				type:"POST",
				dataType:"JSON",
				data:{"dID":dID},
				success:function(data){
					alert("Record is deleted!");
					console.log(data);
					table.clear().draw();
					table.rows.add(data.contractList);
					table.columns.adjust().draw();
					contractManagment.clickEvent();
				}
			});
		}
	});
	$('#ctTable tbody tr td a.btnEdit').click(function () {
		var row = table.row($(this).closest('tr')).data();
		$('#txtName').val(row.contractName);
		$('#txtStart').val(row.startedDate);
		$('#txtEnd').val(row.endDate);
		$('#lms_adm_018p_Modal').modal('toggle');
	} );
	$('#ctTable tbody tr td a.btnView').click(function() {

	});
}

contractManagment.createContract=function(){
	var name = $('#txtCName').val();
	var start = $('#txtCStart').val();
	var end = $('#txtCEnd').val();
	
	var values={"name":name,"start":start,"end":end};
	$.ajax({
		url:"../action/service/lms_adm_c017",
		type:"POST",
		dataType:"JSON",
		data:values,
		success:function(data){
			console.log(data);
			//contractManagment.clickEvent();
		}
	});
}
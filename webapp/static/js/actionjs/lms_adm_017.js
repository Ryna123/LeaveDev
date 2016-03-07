var _contractManagment={};
var _table;
$(document).ready(function(){
	$("#txtStart,#txtEnd,#txtCStart,#txtCEnd").daterangepicker({ 
		  singleDatePicker: true,
		        showDropdowns: true,
		        format:'DD/MM/YYYY'
	});
	
	_contractManagment.listContractInfo();
	$('#btnCreate').click(function(){
		_contractManagment.createContract();
	});
	$('#btnOK').click(function(){
		_contractManagment.editContract();
	});
	$('#txtSearch').keyup(function(){
	      _table.search($(this).val()).draw() ;
	});
});

_contractManagment.listContractInfo = function(){
	loading(true);
	var pathname = window.location.pathname;
	$.ajax({
		url:"../action/service/lms_adm_r017",
		dataType:"JSON",
		type:"GET",
		success:function(data){
			var values={"data":data.contractList};
			console.log(values);
			_table = $("#ctTable").DataTable({
				"pagingType": "full_numbers",
				data:values["data"],
				"dom": '<"top"i>rt<"bottom"lp>',
				columns:[
				         {"data":"id", 
				        	 //disable sort 
				        	 "orderable": false, 
				        	 //set ClassName to this td
				        	 className:"dataRow", 
				        	 //Disable search on this column
				        	 "bSearchable": false,
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
			_contractManagment.clickEvent();
		}
	});
	
	loading(false);
}

_contractManagment.clickEvent=function(){
	$('#ctTable tbody tr td a.btnDelete').click(function(){
		/*alert($(this).data('index'));*/
		var dID=$(this).data('index');	
		var alertText='Do you want to delete record: '+dID;
		if(confirm(alertText)){
			$.ajax({
				url:"../action/service/lms_adm_d017",
				type:"POST",
				dataType:"JSON",
				data:{"dID":dID},
				success:function(data){
					alert("Record is deleted!");
					console.log(data);
					//Redraw Table
					_table.clear().draw();
					_table.rows.add(data.contractList);
					_table.columns.adjust().draw();
					_contractManagment.clickEvent();
				}
			});
		}
	});
	
	$('#ctTable tbody tr td a.btnEdit').click(function () {
		var row = _table.row($(this).closest('tr')).data();
		$('#txtName').val(row.contractName);
		$('#txtStart').val(row.startedDate);
		$('#txtEnd').val(row.endDate);
		$('#txtName').data('index',row.id);
		$('#lms_adm_018p_Modal').modal('toggle');
	} );
	
	$('#ctTable tbody tr td a.btnView').click(function() {
		var id = $(this).data('index');
		var url= '../admin/lms_adm_019?'+id;
		$(location).attr('href',url);
	});
}

_contractManagment.createContract=function(){
	var name = $('#txtCName').val();
	var start = $('#txtCStart').val();
	var end = $('#txtCEnd').val();
	var weekly="";
	var daily="";
	
	var contrastObj={"contractName":name,
			"weeklyDuration":weekly,
			"dailyDuration":daily,
			"startedDate":start,
			"endDate":end
			};
	$.ajax({
		headers:{
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		url:"../action/service/lms_adm_c017",
		type:"POST",
		data: JSON.stringify(contrastObj),
		success:function(data){
			$('#lms_adm_017p_Modal').modal('toggle');
			_table.clear().draw();
			_table.rows.add(data.contractList);
			_table.columns.adjust().draw();
			_contractManagment.clickEvent();
		}
	});
}

_contractManagment.editContract=function(){
	var contrastObj={
			"id":$('#txtName').data('index'),
			"contractName":$('#txtName').val(),
			"weeklyDuration":"",
			"dailyDuration":"",
			"startedDate":$('#txtStart').val(),
			"endDate":$('#txtEnd').val()
			};
	$.ajax({
		url:"../action/service/lms_adm_u017",
		dataType:"JSON",
		headers:{"Accept":"application/json","Content-Type":"application/json"},
		type:"POST",
		data:JSON.stringify(contrastObj),
		success:function(data){
			console.log(data);
			_table.clear().draw();
			_table.rows.add(data.contractList);
			_table.columns.adjust().draw();
			_contractManagment.clickEvent();
		}
	});
}
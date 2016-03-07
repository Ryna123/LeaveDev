var _entitledDays={};
var _table;
$(document).ready(function(){
	loading(true);
	$("#txtStart,#txtEnd,#txtCStart,#txtCEnd").daterangepicker({ 
		  singleDatePicker: true,
		        showDropdowns: true,
		        format:'DD-MM-YYYY'
	});
	var url=document.location.href.split("?");
	var id = url[1];
	_entitledDays.listEntities(id);
	$('#txtCStart').data('index',id);
	
	$("#btnAdd").click(function(){
		_entitledDays.addEDC();
	});
	
	$('#btnEdit').click(function(){
		_entitledDays.editEDC();
	});
		
	loading(false);
});

_entitledDays.listEntities=function(id){
	$.ajax({
		type:"GET",
		dataType:"JSON",
		data:{"id":id},
		contentType:"application/json",
		url:"../action/service/lms_adm_r019",
		success:function(data){
			console.log(data['listEDC']);
			/*$("tblEDC").DataTable(data["listEDC"]);*/
			_table = $("#tblEDC").DataTable({
				"pagingType": "full_numbers",
				data:data.listEDC,
				"dom": '<"top"i>rt<"bottom"lp>',
				columns:[
				         {
				        	 "data":"id", 
				        	 //disable sort 
				        	 "orderable": false, 
				        	 //Disable search on this column
				        	 "bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        			 $(nTd).html("<div class='fa-hover col-md-3 col-sm-4 col-xs-12'>" +
				        			 		"<a class='btnDelete' data-index="+sData+"><i class='fa fa-trash-o'></i></a>" +
				        			 		" </div>" + "<div class='fa-hover col-md-3 col-sm-4 col-xs-12'>" +
				        			 		"<a class='btnEdit' data-index="+sData+"><i class='fa fa-pencil' data-toggle='modal' ></i></a></div>");
				             }
				        },
				         {"data":"start"},
				         {"data":"end"},
				         {"data":"days"},
				         {"data":"leaveType"},
				         {"data":"descript"}]
			});
			_entitledDays.clickEvent();
		}
	});
}
_entitledDays.clickEvent=function(){
	$('#tblEDC tbody tr td a.btnDelete').click(function(){		
		var dID=$(this).data('index');
		var alertText='Do you want to delete record: '+dID;
		if(confirm(alertText)){
			var data={
					"dID":dID,
					"contractID":$('#txtCStart').data('index')
			}
			$.ajax({
				url:"../action/service/lms_adm_d019",
				type:"POST",
				dataType:"JSON",
				data:data,
				success:function(data){
					alert("Record is deleted!");
					console.log(data);
					_table.clear().draw();
					_table.rows.add(data.listEDC);
					_table.columns.adjust().draw();
					_entitledDays.clickEvent();
				}
			});
		}
	});
	$('#tblEDC tbody tr td a.btnEdit').click(function(){
		var row = _table.row($(this).closest('tr')).data();
		console.log(row);
		$('#txtStart').data('index',row.id);
		$('#txtStart').val(row.start);
		$('#txtEnd').val(row.end);
		$('#txtDays').val(row.days);
		$('#txtDescript').val(row.descript);
		$('#lms_adm_020p').modal('toggle');
	});
}
_entitledDays.editEDC=function(){
	var entitledDCObj={
			"id":$('#txtStart').data('index'),
			"contractId":$('#txtCStart').data('index'),
			"start":$('#txtStart').val(),
			"end":$('#txtEnd').val(),
			"leaveTypeId":$('#lbsLT').val(),
			"days":$('#txtDays').val(),
			"descript":$('#txtDescript').val()
			};
	console.log(entitledDCObj);
	$.ajax({
		url:"../action/service/lms_adm_u19",
		dataType:"JSON",
		headers:{"Accept":"application/json","Content-Type":"application/json"},
		type:"POST",
		data:JSON.stringify(entitledDCObj),
		success:function(data){
			console.log(data);
			$('#lms_adm_020p').modal('toggle');
			_table.clear().draw();
			_table.rows.add(data.listEDC);
			_table.columns.adjust().draw();
			_entitledDays.clickEvent();
		}
	});
}
_entitledDays.addEDC=function(){
	var entitledDCObj={
			"contractId":$('#txtCStart').data('index'),
			"start":$('#txtCStart').val(),
			"end":$('#txtCEnd').val(),
			"leaveTypeId":$('#lbsCLT').val(),
			"days":$('#txtCDays').val(),
			"descript":$('#txtCDescript').val()
			};
	console.log(entitledDCObj);
	$('#lms_adm_019p').modal('toggle');
	$.ajax({
		headers:{
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		url:"../action/service/lms_adm_c019",
		data:JSON.stringify(entitledDCObj),
		type:"POST",
		dataType:"JSON",
		success:function(data){
			console.log(data);
			$('#lms_adm_019p_Modal').modal('toggle');
			_table.clear().draw();
			_table.rows.add(data.listEDC);
			_table.columns.adjust().draw();
			_entitledDays.clickEvent();
		}
	});
}

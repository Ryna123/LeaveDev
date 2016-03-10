var _positionManagement={};
var _table;
$(document).ready(function(){
	loading(true);
	_positionManagement.loadData();
	loading(false);
	$('#btnCreate').click(function(){
		loading(true);
		_positionManagement.createPos();
		$('#lms_adm_021p').modal('hide');
		$('#txtCName').val('');
		$('#txtCDescript').val('');
		loading(false);
	});
	$('#btnUpdate').click(function(){
		loading(true);
		_positionManagement.updatePos();
		$('#lms_adm_022p').modal('hide');
		loading(false);
	});
});

_positionManagement.loadData=function(){
	$.ajax({
		url:"../action/service/lms_adm_r021",
		type:"GET",
		dataType:"JSON",
		success:function(data){
			console.log(data.listPos);
			_table = $("#tblPosition").DataTable({
				"pagingType": "full_numbers",
				data:data.listPos,
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
				        			 $(nTd).html("<div>" +
				        			 		"<a href='#' class='fa-hover col-md-1 btnDelete' data-index="+sData+"><i class='fa fa-trash-o'></i></a>" +
				        			 		" </div>" + "<div><a class='fa-hover col-md-1 btnEdit' href='#' data-index="+sData+"><i class='fa fa-pencil' data-toggle='modal' ></i></a></div>");
				             }
				        },
				         {"data":"id"},
				         {"data":"name"},
				         {"data":"description"}
				],
				"fnDrawCallback":function(){
					_positionManagement.clickEvent();
				}
			});
			
		}
		
	});
}

_positionManagement.clickEvent=function(){
	
	$('#tblPosition tbody tr td a.btnDelete').click(function(){
		var dID=$(this).data('index');	
		var alertText='Do you want to delete record: '+dID;
		if(confirm(alertText)){
			$.ajax({
				url:"../action/service/lms_adm_d021",
				type:"POST",
				dataType:"JSON",
				data:{"dID":dID},
				success:function(data){
					alert("Record is deleted!");
					console.log(data);
					_table.clear().draw();
					_table.rows.add(data.listPos);
					_table.columns.adjust().draw();
					//_positionManagement.clickEvent();
				}
			});
		}
	});
	$('#tblPosition tbody tr td a.btnEdit').click(function(){
		var row = _table.row($(this).closest('tr')).data();
		$('#txtName').data('index',row.id);
		$('#txtName').val(row.name);
		$('#txtDescript').val(row.description);
		$('#lms_adm_022p').modal('show');
	});
}
_positionManagement.createPos=function(){
	var data={
			'name':$('#txtCName').val(),
			'description':$('#txtCDescript').val()
		};
	console.log(data);
	
	$.ajax({
		headers:{
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		url:"../action/service/lms_adm_c021",
		type:"POST",
		data: JSON.stringify(data),
		success:function(data){
			_table.clear().draw();
			_table.rows.add(data.listPos);
			_table.columns.adjust().draw();
			//_positionManagement.clickEvent();
		}
	});
}
_positionManagement.updatePos=function(){
	var data={
			'id':$('#txtName').data('index'),
			'name':$('#txtName').val(),
			'description':$('#txtDescript').val()
	};
	$.ajax({
		url:"../action/service/lms_adm_u021",
		dataType:"JSON",
		headers:{"Accept":"application/json","Content-Type":"application/json"},
		type:"POST",
		data:JSON.stringify(data),
		success:function(data){
			_table.clear().draw();
			_table.rows.add(data.listPos);
			_table.columns.adjust().draw();
			//_positionManagement.clickEvent();
		}
	});
}

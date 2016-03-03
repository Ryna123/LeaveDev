var entitledDays={};
var table;
$(document).ready(function(){
	loading(true);
	var url=document.location.href.split("?");
	var id = url[1];
	entitledDays.listEntities(id);
	loading(false);
});

entitledDays.listEntities=function(id){
	$.ajax({
		type:"GET",
		dataType:"JSON",
		data:{"id":id},
		contentType:"application/json",
		url:"../action/service/lms_adm_r019",
		success:function(data){
			console.log(data['listEDC']);
			/*$("tblEDC").DataTable(data["listEDC"]);*/
			table = $("#tblEDC").DataTable({
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
			entitledDays.clickEvent();
		}
	});
}
entitledDays.clickEvent=function(){
	$('#tblEDC tbody tr td a.btnDelete').click(function(){
		
	});
	$('#tblEDC tbody tr td a.btnEdit').click(function(){
		var row = table.row($(this).closest('tr')).data();
		console.log(row);
		$('#txtStart').data('index',row.id);
		$('#txtStart').val(row.start);
		$('#txtEnd').val(row.end);
		$('#txtDays').val(row.days);
		$('#txtDescript').val(row.descript);
		$('#lms_adm_020p').modal('toggle');
	});
}
entitledDays.editEDC=function(){
	var entitledDCObj={
			"id":$('#txtStart').data('index'),
			"start":$('#txtStart').val(),
			"end":$('#txtEnd').val(),
			"leaveType":$('#lsbLT').val(),
			"days":$('#txtDays').val(),
			"descript":$('#txtDescript').val()
			};
	console.log(entitledDCObj);
	/*$.ajax({
		url:"../action/service/lms_adm_e017",
		dataType:"JSON",
		headers:{"Accept":"application/json","Content-Type":"application/json"},
		type:"POST",
		data:JSON.stringify(contrastObj),
		success:function(data){
			console.log(data);
			table.clear().draw();
			table.rows.add(data.contractList);
			table.columns.adjust().draw();
			contractManagment.clickEvent();
		}
	});*/
}

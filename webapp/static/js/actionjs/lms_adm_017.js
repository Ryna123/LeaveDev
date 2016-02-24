var contractManagment={};
var table;
$(document).ready(function(){
	contractManagment.listContractInfo();
	
	
	/*$('.btnEdit').on('click',function(){alert("message")});*/
});
/*contractManagment.getRow = function(){
	alert("messgae");
}*/

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
				         {"data":"id", "bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        			 $(nTd).html("<div class='fa-hover col-md-3 col-sm-4 col-xs-12'>" +
				        			 		"<a href='#/trash-o'><i class='fa fa-trash-o'><input type='hidden' value="+sData+"></i></a>" +
				        			 		" </div>" + "<div class='fa-hover col-md-3 col-sm-4 col-xs-12'><a class='btnEdit' href='#'><i class='fa fa-pencil' data-toggle='modal' ></i><input type='hidden' class='inputEdit'></a></div>"+
				        			 		"<div class='fa-hover col-md-3 col-sm-4 col-xs-12'><a><i class='fa fa-signal'></i></a></div>");
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
	$('#ctTable tbody tr td a.btnEdit').click(function () {
		console.log( table.row( this ).data() );
	} );
}

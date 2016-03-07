var _employeeManagement = {};
var _table;

$(document).ready(function(){
	loading(true);
	
	_employeeManagement.loadEmpData();
	
	loading(false);
	$('#txtSearch').keyup(function(){
	      _table.search($(this).val()).draw() ;
	});
});

_employeeManagement.loadEmpData=function(){
	$.ajax({
		url:"../action/service/lms_adm_r014",
		dataType: "JSON",
		type:"GET",
		success:function(data){
			//alert(JSON.stringify(data.List));
			var listData=data.List;
			//var count = Object.keys(listData).length;
			console.log(data.List);
			var values={"data":listData};
			//Covert json to String 
			//var dataSet=JSON.stringify(values);
			//covert String to json
			//var dd=JSON.parse(dataSet);
			//console.log(values);
			//$('#hrTable tbody tr').remove();
			_table = $('#hrTable').DataTable({
				"pagingType": "full_numbers",
				data:values["data"],
				 "dom": '<"top"i>rt<"bottom"lp>',
				 "scrollY":"400px",
				"scrollCollapse":true,
				columns:[
				        {"data":"id","bSearchable": false},
				        {"data":"status",className:"btnStatus","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		 if(oData.status.toLowerCase()=='active'){
				        			 $(nTd).html("<span class='glyphicon glyphicon-ok' data-toggle='tooltip' " +
				                 		"data-placement='top' title='' data-original-title='Active' value='1'></span>");
				        		 }else{
				        			 $(nTd).html("<span class='glyphicon glyphicon-remove' data-toggle='tooltip' " +
				                 		"data-placement='top' title='' data-original-title='Active' value='0'></span>");
				        		 }
				             }
				        },
				        {"data":"firstName"},
				        {"data":"lastName"},
				        {"data":"phone","bSearchable": false},
				        {"data":"email","bSearchable": false},
				        {"data":"department"},
				        {"data":"contract","bSearchable": false},
				        {"data":"manager","bSearchable": false}
				],
				//"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
			});
		}
	});
}
	
	
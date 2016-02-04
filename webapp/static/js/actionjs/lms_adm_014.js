$(document).ready(function(){
	loading(true);
	var table;
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
			//console.log(dd);
			//console.log(dataSet["data"]);
			//$('#hrTable tbody tr').remove();
			table = $('#hrTable').DataTable({
				"pagingType": "full_numbers",
				data:values["data"],
				 "dom": '<"top"i>rt<"bottom"lp>',
				 "scrollY":"400px",
				"scrollCollapse":true,
				columns:[
				        {"data":"id","bSearchable": false},
				        {"data":"active",className:"btnStatus","bSearchable": false,
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		 if(oData.active==1){
				        			 $(nTd).html("<a href='#'><span class='glyphicon glyphicon-ok' data-toggle='tooltip' " +
				                 		"data-placement='top' title='' data-original-title='Active' value='1'></span></a>");
				        		 }else{
				        			 $(nTd).html("<a href='#'><span class='glyphicon glyphicon-remove' data-toggle='tooltip' " +
				                 		"data-placement='top' title='' data-original-title='Active' value='0'></span></a>");
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
	loading(false);
	
	$('#txtSearch').keyup(function(){
	      table.search($(this).val()).draw() ;
	})
	$('#hrTable tbody').on( 'click', 'tr', function () {
	    var data = table.row( this ).data();
	    var myData = {
	    		'id': data['id'],
	    		'status': data['active']
	    		
	    }
	    console.log(data.active);
	    console.log(myData);
	    //var values={"data":data};
	    console.log(data);
	  /*  $.ajax({
	    	type: "PUT",
	    	url:"../action/service/lms_adm_014active",
	    	data: myData
	    });*/
	} );
	
});
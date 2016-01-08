$(document).ready(function(){
	loading(true);
	$.ajax({
		url:"../action/service/lms_adm_014",
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
			$('#hrTable').DataTable({
				"pagingType": "full_numbers",
				data:values["data"],
				 "dom": '<"top"if>rt<"bottom"lp>',
				columns:[
				        {"data":"id"},
				        {"data":"active",
				        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				        		 if(oData.active==1){
				        			 $(nTd).html("<a href='/lms_adm_014active'><span class='glyphicon glyphicon-ok' data-toggle='tooltip' " +
				                 		"data-placement='top' title='' data-original-title='Active'></span></a>");
				        		 }else{
				        			 $(nTd).html("<a href='/lms_adm_014active'><span class='glyphicon glyphicon-remove' data-toggle='tooltip' " +
				                 		"data-placement='top' title='' data-original-title='Active'></span></a>");
				        		 }
				             }
				        },
				        {"data":"firstName"},
				        {"data":"lastName"},
				        {"data":"phone"},
				        {"data":"email"},
				        {"data":"department"},
				        {"data":"contract"},
				        {"data":"manager"}
				],
				//"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
			});
		}
	});
	loading(false);
});
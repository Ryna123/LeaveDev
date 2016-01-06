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
			//console.log(count);
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
				columns:[
				        {"data":"id"},
				        {"data":"firstName"},
				        {"data":"lastName"},
				        {"data":"phone"},
				        {"data":"email"},
				        {"data":"department"},
				        {"data":"contract"},
				        {"data":"manager"}
				]
				//"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
			});
		}
	});
	loading(false);
});
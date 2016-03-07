var _positionManagement={};
var _table;
$(document).ready(function(){
	loading(true);
	_positionManagement.loadData();
	loading(false);
});

_positionManagement.loadData=function(){
	$.ajax({
		url:"../action/service/listPosition",
		type:"GET",
		dataType:"JSON",
		success:function(data){
			console.log(data.LIST);
		}
		
	});
}
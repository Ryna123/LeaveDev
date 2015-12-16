$(document).ready(function(){
	var _start =0;
	var _end= 0;
	$('input[name="daterang1"]').daterangepicker({
        singleDatePicker: true,
        calender_style: "picker_4"
    }, function (start, end, label) {
        console.log((start.month()+1) -(end.month()) );
    	//_start = start.month()+1;
    	//_end = end.month()+1;
    });
	$('input[name="daterang2"]').daterangepicker({
        singleDatePicker: true,
        calender_style: "picker_3"
    }, function (start, end, label) {
       // console.log(start.toISOString(), end.toISOString(), label);
    });
	
	console.log("Start Date: "+_start +" End date : "+_end);
	
	
	
});
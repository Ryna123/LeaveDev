
	//loading with ajax
	function loading(opt){
		if(opt == true){
			$("body").prepend("<div id='jloading-bag' style='z-index:9999999;position:fixed;top:0px'></div><div id='jloading-img'><img src='../static/js/loading/ajax-loading.gif' ></div>");
		}else{
			$("#jloading-img").fadeOut('fast');
			$("#jloading-bag").fadeOut('500');
		}
	}
	

	function jSloading(opt){
		if(opt == true){
			$("#jSloading-img").html("<img src='../static/js/loading/ajax-s-loading.gif' /> Loading...");
		}else{
			$("#jSloading-img").html("");
		}
	}
	
	function jsLoadingResend(opt){
		if(opt == true){
			$("#jSloading-img").html("<img src='../static/js/loading/ajax-s-loading.gif' />");
		}else{
			$("#jSloading-img").html("<img src='../static/js/ico/small_tick.png' />");
		}
	}
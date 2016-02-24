myData = {
		'numberOfRecord': $("#numberOfRecord").val(),
		'pageCount':1
	};
$(document).ready(function() {
	user.loadData();
	
	/**
	 * change numberOfRecord
	 */
	$("#numberOfRecord").change(function(){
		myData.numberOfRecord = $(this).val();
		user.loadData();
	});
	
	$("#btn_search").click(function(){
		var SearchVal= $("#text_search").val();
		alert(SearchVal);
	});		
	
});
var user = {
		loadData: function(){
			$("tbody#listUser").empty();
			loading(true);
			$.ajax({
				url : "../action/service/lms_adm_006",		
				dataType : "JSON",
				data: myData,
				type : "GET",
			//	data :a,
				
				success : function(data) {
					var res = data.RESP_DATA['USER_REC'];
					console.log(data.RESP_DATA['USER_REC']);
						if(res.length <=0) {
							$("tfoot#entitleFooter").show();
						} else {
							$.each(res,function(i){
								var data = {};
								data['ID'] = i+1; // show auto number on screen
								data['FIRSTNAME']  = res[i].firstName;
								data['LASTNAME']  = res[i].lastName;
								data['EMAIL']  = res[i].email;
								data['USERNAME']  = res[i].username;
								data['ROLE']  = res[i].role;
								data['MANAGERNAME']  = res[i].managername;
								data['PHONE'] = res[i].phone;
								$("#lmsAdm006").tmpl(data).appendTo("tbody#listUser");
								paging.createPagination(23);
							})
						}
						loading(false);
					}
				});
			
		}
}
var paging = {
		createPagination : function(totalRecord)
		{
			if(totalRecord==0){
				$("#pagination").html("");
			}else{
				var a = totalRecord % myData.numberOfRecord; // 5				
				var numberOfPaging = Math.floor(totalRecord / myData.numberOfRecord);
			
				if(a>0){			
					numberOfPaging += 1;			
				}
				var paging = "<span class='dataTables_paginate paging_full_numbers'>" +
								"<a tabindex='0' class='first paginate_button paginate_button_disabled' id='example_first'>First</a>" +
								"<a tabindex='0' class='previous paginate_button paginate_button_disabled' id='page_previous' href='javascript:'>Previous</a>" +
								"<span>";				
				for(var i=1; i<(numberOfPaging+1);i++){
					if(i == myData.pageCount) {
						paging += "<a class='numberOfPage paginate_active' href='javascript:'>"+i+"</a>";
						continue;
					}
					paging += "<a class='numberOfPage paginate_button' href='javascript:'>"+i+"</a>";			
				}
				paging 		+='</span>'+
							'<a tabindex="0" class="next paginate_button" href="javascript:" id="paging_next">Next</a>'+
							'<a tabindex="0" class="last paginate_button" href="javascript:" id="paging_last">Last</a>'+
						'</span>';			
				$("#paging").html(paging);
				
				if(myData['pageCount'] == 1){
					$("#page_previous").addClass("disabled");
				}else{
					$("#page_previous").removeClass("disabled");
				}
				if(myData['pageCount'] == numberOfPaging){
					$("#paging_next").addClass("disabled");
				}else{
					$("#paging_next").removeClass("disabled");
				}		
				

				$("#paging span a.numberOfPage").on("click", function(){ 
						myData['pageCount'] = Number($(this).text());
						user.loadData();
				});
				$("#page_previous").on("click", function(){
					if(myData['pageCount'] == 1){
						return false;
					}else{
						myData['pageCount'] -= 1;
						user.loadData();
					}
				});
				$("#paging_next").on("click", function(){
					if(numberOfPaging == myData['pageCount']){
						return false;
					}else{
						myData['pageCount'] += 1;
						//student.list_all_students();
						user.loadData();
					}
				});
				$("#paging_last").on("click", function(){
					if(numberOfPagin == myData.pageCount){
						alert("already in the last page");
						return false;
					}else{
						myData.pageCount = numberOfPaging;
						user.loadData();
					}
				});
			}
			
		},
}
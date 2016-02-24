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
				var paging = "<ul class='pagination'>"+
								"<li class='pagePrevious disabled'><a href='javascript:' aria-label='Previous'>" +
									"<span aria-hidden='true'>&laquo;</span></a></li>";
				
				for(var i=1; i<(numberOfPaging+1);i++){
					if(i == myData.pageCount) {
						paging += "<li class='active'><a class='numberOfPage' href='javascript:'>"+i+"</a></li>";
						continue;
					}
					paging += "<li><a class='numberOfPage' href='javascript:'>"+i+"</a></li>";			
				}
				paging +='<li class="pageNext disabled"><a href="javascript:" aria-label="Next"><span aria-hidden="true">&laquo;</span></a></li>';
				paging += "</u>";			
				$("#paging").html(paging);
				
				if(myData['pageCount'] == 1){
					$("ul.pagination li.pagePrevious").addClass("disabled");
				}else{
					$("ul.pagination li.pagePrevious").removeClass("disabled");
				}
				if(myData['pageCount'] == numberOfPaging){
					$("ul.pagination li.pageNext").addClass("disabled");
				}else{
					$("ul.pagination li.pageNext").removeClass("disabled");
				}		
				

				$("#pagination li a.numberOfPage").on("click", function(){ 
						myData['pageCount'] = Number($(this).text());
						user.loadData();
				});
				$("ul.pagination li.pagePrevious").on("click", function(){
					if(myData['pageCount'] == 1){
						return false;
					}else{
						myData['pageCount'] -= 1;
						user.loadData();
					}
				});
				$("ul.pagination li.pageNext").on("click", function(){
					if(numberOfPaging == myData['pageCount']){
						return false;
					}else{
						myData['pageCount'] += 1;
						//student.list_all_students();
						user.loadData();
					}
				});
			}
			
		},
}
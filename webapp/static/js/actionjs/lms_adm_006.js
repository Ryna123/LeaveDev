myData = {
		'numberOfRecord':10, //$("#numberOfRecord").val(),
		'pageCount':1
	};
$(document).ready(function() {
	user.loadData();
	
	/**
	 * change numberOfRecord
	 */
	$("#numberOfRecord").change(function(){
		myData.numberOfRecord = $(this).val();
		myData.pageCount = 1;
		user.loadData();
	});
	
	$("#btn_search").click(function(){
		var SearchVal= $("#text_search").val();
		alert(SearchVal);
	});	
	
});
var user = {
		/**
		 * put the value into the edit form
		 */
		edit_form: function(record){
			if(record.length!=null || record.length!=1){
				$("#txtIdentifier").val(record.identifier);
				$("#firstName").val(record.firstName);
				$("#lastName").val(record.lastName);
				$("#userName").val(record.ssoId);
				$("#email").val(record.email);
				$("#phoneNumber").val(record.phone);
				$("#startdate").val(record.startdate);
				$("#userProfile").val(record.userProfiles[0].id);	
				$("#userProfile option:selected").text(record.userProfiles[0].type);
				$("#position").val(record.position.name);
				$("#managerId").val();
				$("#contract").val();	
				loading(false);
			}
			
			
		},
		find_user_by_id: function(id){
			loading(true);
			$.ajax({
				url: "../action/service/lms_adm_r006/"+id,
				type: "GET",
				success: function(resp){
					console.log(resp);
					var record = resp["Record"];
					if(resp['Success']==true){
						user.edit_form(record);						
					}else{
						loading(false);
						alert(resp["Message"]);
						
					}
					
				}
			});
			
		},
		loadData: function(){
			$("tbody#listUser").empty();
			loading(true);
			$.ajax({
				url : "../action/service/lms_adm_l006",		
				dataType : "JSON",
				data: myData,
				type : "GET",				
				success : function(data) {
					var res = data.RESP_DATA['USER_REC'];
					console.log(data);
						if(res.length <=0) {
							$("tfoot#entitleFooter").show();
						} else {
							$.each(res,function(i){
								var data = {};
								//data['ID'] = i+1; // show auto number on screen
								data['ID']				= res[i].id;
								data['IDENTIFIER'] 		= res[i].identifier;
								data['FIRSTNAME'] 		= res[i].firstName;
								data['LASTNAME']  		= res[i].lastName;
								data['EMAIL']  			= res[i].email;
								data['USERNAME']  		= res[i].username;
								data['ROLE']  			= res[i].role;
								data['MANAGERNAME'] 	= res[i].managername;
								data['PHONE'] 			= res[i].phone;
								
								$("#lmsAdm006").tmpl(data).appendTo("tbody#listUser");
							})
							paging.createPagination(data.RESP_DATA['TOTAL_REC']);
							//Edit user
							$("a.editUser").click(function(){
								var userID = $(this).parent().find(".userID").val();
								user.find_user_by_id(userID);
								
							});
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
								"<a tabindex='0' class='first paginate_button paginate_button_disabled' href='javascript:' id='paging_first'>First</a>" +
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
				
				/*if(myData['pageCount'] == 1){
					$("#page_previous").addClass("disabled");
				}else{
					$("#page_previous").removeClass("disabled");
				}
				if(myData['pageCount'] == numberOfPaging){
					$("#paging_next").addClass("disabled");
				}else{
					$("#paging_next").removeClass("disabled");
				}*/		
				

				$("#paging span a.numberOfPage").on("click", function(){ 
						myData['pageCount'] = Number($(this).text());
						user.loadData();
				});
				$("#page_previous").on("click", function(){
					if(myData['pageCount'] == 1){
						alert("This is the first page");
						return false;
					}else{
						myData['pageCount'] -= 1;
						user.loadData();
					}
				});
				$("#paging_first").on("click", function(){
					if(myData.pageCount==1){
						alert("already in the first page")
						return false;
					}else{
						myData.pageCount = 1;
						user.loadData();
					}
				});
				$("#paging_next").on("click", function(){
					if(numberOfPaging == myData['pageCount']){
						alert("This is the last page");
						return false;
					}else{
						myData['pageCount'] += 1;
						user.loadData();
					}
				});
				$("#paging_last").on("click", function(){
					if(numberOfPaging == myData.pageCount){
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
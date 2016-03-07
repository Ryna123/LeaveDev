

	<!-- Modal Select Manager-->
	<div class="modal fade" id="select_manager" role="dialog">
		<div class="modal-dialog">
		<!-- pop up form--edit user-->
			<div class="modal-content">
				<div class="main_container" style="height: 500px">

    <!-- page content -->
            <div class="right_col" role="main">

                <div class="">
  					
                    <div class="row">
                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Select Manager</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
				                      <div class="input-group">
				                           <input class="form-control" placeholder="Search for..." type="text">
				                            <span class="input-group-btn">
				                            	<button class="btn btn-default" type="button">Go!</button>
				                        	</span>
				                      </div>
                 				</div>
                                
                                <div class="x_content">
                                    <!-- start project list -->
                                    <table class="table table-hover table-bordered projects responsive-utilities bulk_action"><!-- responsive-utilities jambo_table bulk_action -->
                                        <thead>
                                             <tr class="headings">
                                             	<th>Select<!-- <input type="checkbox" id="check-all" class="flat"/> --></th>
                                                <th>ID</th>
                                                <th>Full Name</th>
                                                <th>Email</th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody id="userPosition">
                                           <!--  <tr class="even pointer">
                                            	<td class="a-center "><input type="checkbox" class="flat" name="table_records"/></td>
                                                <td scope="row">1</td>
                                                <td>Kim</td>
                                                <td>Wansu</td>
                                                <td>kimwansu@gmail.com</td>
                                            </tr>
                                            <tr class="odd pointer">
                                            	<td class="a-center "><input type="checkbox" class="flat" name="table_records"/></td>
                                                <td scope="row">2</td>
                                                <td>Choi</td>
                                                <td>Siwan</td>
                                                <td>choisiwan@gmail.com</td>
                                            </tr> -->
                                        </tbody>
                                    </table>
                                    <!-- end project list -->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Pagination block -->
                <div id="paging">
	
	                <span class="dataTables_paginate paging_full_numbers">
	                	<a tabindex="0" class="first paginate_button paginate_button_disabled" id="example_first">First</a>
	                	<a tabindex="0" class="previous paginate_button paginate_button_disabled" id="example_previous">Previous</a>
	                	<span>
	                		<a tabindex="0" class="paginate_active">1</a><a tabindex="0" class="paginate_button">2</a>
	                		<a tabindex="0" class="paginate_button">3</a><a tabindex="0" class="paginate_button">4</a>
	                	</span>
	                	<a tabindex="0" class="next paginate_button" id="example_next">Next</a>
	                	<a tabindex="0" class="last paginate_button" id="example_last">Last</a>
	                </span> 
                </div>
                <!-- End Pagination block -->
                
                
				<div id="ok_btn">
					<a id="btnSelectManager" href="javascript:" class="btn btn btn-primary"><i class="fa fa-check"></i>OK</a>
					<a href="javascript:" class="btn btn btn-danger" data-dismiss="modal"><i class="fa fa-close"></i>Cancel</a>
				</div>
				
            </div>
    <!-- /page content -->
        </div>
	      	</div>
	    </div>
	</div>
	<!-- End Modal select Manager-->
	 <script type="text/x-jquery-tmpl" id="lmsAdm006p">
		<tr>			
			<td class="a-center "><input type="radio" value="{{= ID}}" class="flat" name="table_records"/></td>			
             <td scope="row" class="manager_id">{{= ID}}</th>												
             <td class="manager_name">{{= FIRSTNAME}} {{= LASTNAME}}</td>
			 <td>{{= EMAIL}}</td>
       	</tr>
	</script>
	<script>
	
	myData = {
			'numberOfRecord':5,
			'pageCount':1
		};
	
	
	$(document).ready(function(){
		/**
		*On click or update button
		*/
		$("#btnSelectManager").click(function(){
			if($("input:radio:checked").val()== undefined){
				alert("Please select the manager!");
				return false;
			}else{
				manager_Id = $("input:radio:checked").val();
				
				
				//var test = $("input:radio:checked").parent().next().next().css( "background-color", "red" );
				var manager_name = $("input:radio:checked").parent().next().next().text();
				$("#txtManager").val(manager_name)
				
				$("#select_manager").modal("toggle");
			}
			
		});
		/************************************************************************************************
		 * Select Manger
		 */
		$("#btnManager").on("click",function(){
			manager.loadManager();
			
		});//******************************************end***********************************************
	});
	
	var manager = {
			loadManager: function(){
				$("tbody#userPosition").empty();
				$.ajax({
					data: myData,
					url: "../action/service/listUserByPosition",
					type: "GET",
					success: function(data){
						var res = data['LIST'];
							if(res.length <=0) {
								$("tfoot#entitleFooter").show();
							} else {
								$.each(res,function(i){
									var data = {};
									data['ID'] = res[i].id; // show auto number on screen
									data['FIRSTNAME']  = res[i].firstName;
									data['LASTNAME']  = res[i].lastName;
									data['EMAIL']  = res[i].email;
									$("#lmsAdm006p").tmpl(data).appendTo("tbody#userPosition");
									
								})
								paging.createPagination(data['TOTAL_REC']);
							}
							loading(false);
					}					
					
				});
			}
	};
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

					$("#paging span a.numberOfPage").on("click", function(){ 
							myData['pageCount'] = Number($(this).text());
							manager.loadManager();
					});
					$("#page_previous").on("click", function(){
						if(myData['pageCount'] == 1){
							alert("This is the first page");
							return false;
						}else{
							myData['pageCount'] -= 1;
							manager.loadManager();
						}
					});
					$("#paging_first").on("click", function(){
						if(myData.pageCount==1){
							alert("already in the first page")
							return false;
						}else{
							myData.pageCount = 1;
							manager.loadManager();
						}
					});
					$("#paging_next").on("click", function(){
						if(numberOfPaging == myData['pageCount']){
							alert("This is the last page");
							return false;
						}else{
							myData['pageCount'] += 1;
							manager.loadManager();
						}
					});
					$("#paging_last").on("click", function(){
						if(numberOfPaging == myData.pageCount){
							alert("already in the last page");
							return false;
						}else{
							myData.pageCount = numberOfPaging;
							manager.loadManager();
						}
					});
				}
				
			},
	}
	</script>
	


	
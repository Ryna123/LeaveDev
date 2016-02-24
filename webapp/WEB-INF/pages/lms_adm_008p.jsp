

	<!-- Modal Select Manager-->
	<div class="modal fade" id="select_manager" role="dialog">
		<div class="modal-dialog">
		<!-- pop up form--edit user-->
			<div class="modal-content">
				<div class="main_container" style="height:420px;">

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
                                             	<th><input type="checkbox" id="check-all" class="flat"/></th>
                                                <th>ID</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
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
                <div id="pagination">
	
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
					<a class="btn btn btn-primary"><i class="fa fa-check"></i>OK</a>
					<a class="btn btn btn-danger" data-dismiss="modal"><i class="fa fa-close"></i>Cancel</a>
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
			
			<td class="a-center "><input type="checkbox" class="flat" name="table_records"/></td>
			
             <th scope="row">{{= ID}}</th>												
                    <td>{{= FIRSTNAME}}</td>
                    <td>{{= LASTNAME}}</td> 
					<td>{{= EMAIL}}</td>
        </tr>
	</script>
	<script>
	$(document).ready(function(){
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
					url: "../action/service/listUserByPosition",
					type: "GET",
					success: function(data){
						var res = data['LIST'];
						console.log(data);
							if(res.length <=0) {
								$("tfoot#entitleFooter").show();
							} else {
								$.each(res,function(i){
									var data = {};
									data['ID'] = i+1; // show auto number on screen
									data['FIRSTNAME']  = res[i].firstName;
									data['LASTNAME']  = res[i].lastName;
									data['EMAIL']  = res[i].email;
									$("#lmsAdm006p").tmpl(data).appendTo("tbody#userPosition");
									console.log(data)
								})
								//paging.createPagination(data.RESP_DATA['TOTAL_REC']);
							}
							loading(false);
					}					
					
				});
			}
	};
	</script>
	


	
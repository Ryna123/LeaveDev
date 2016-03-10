<!-- Modal select Department-->
	<div class="modal fade" id="select_dept" role="dialog">
		<div class="modal-dialog">
		<!-- pop up form--edit user-->
			<div class="modal-content">
				<div class="modal-header">
	          		<button type="button" class="close" data-dismiss="modal">&times;</button>
	          		<h2>Select the Department</h2>
	        	</div>
	        	<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                      <div class="input-group">
                           <input class="form-control"  id="txtInput" placeholder="Search for..." type="text">
                           <input type="hidden" id="txtOrgId">
                            <span class="input-group-btn">
                            	<button  id="btn_search" class="btn btn-default" type="button">Go!</button>
                        	</span>
                      </div>
                 </div> 
	          	 <div>
                 	<form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
					<!-- Tree -->                                
                    	<div style="padding:40px 50px;">   
                                <ul id="treeData">
								   
								    
								</ul>
                               
                               	</div>  
                              	<!-- /Tree -->

        			</form>
                </div>
	        	<div class="modal-footer">
	        		<button type="button" id="btnOk" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-check"></i>&nbsp;&nbsp;OK</button>
	          		<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-close"></i>&nbsp;&nbsp;Cancel</button>
	        	</div>
	      	</div>
	    </div>
	</div>
	<!-- End Modal select department-->
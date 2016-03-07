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
                           <input class="form-control" placeholder="Search for..." type="text">
                            <span class="input-group-btn">
                            	<button class="btn btn-default" type="button">Go!</button>
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
	        		<button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-check"></i>&nbsp;&nbsp;OK</button>
	          		<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-close"></i>&nbsp;&nbsp;Cancel</button>
	        	</div>
	      	</div>
	    </div>
	</div>
	<!-- End Modal select department-->
	<script>
	
	 var lms_adm_009p ={};
	$(document).ready(function(){
		lms_adm_009p.loadData();
		
	});
	lms_adm_009p.loadData = function(){
		
		$.ajax({
			url : "../action/service/lms_adm_r015",
			dataType : "JSON",
			type : "POST",
			//data :a,
			success : function(dat) {
				var data =[]
				 console.log(dat.RESP_DATA['ORG_REC']);      
				$.each(dat.RESP_DATA['ORG_REC'], function(i, v) {
					if(dat.RESP_DATA['ORG_REC'][i].parent_id == "-1"){
						v['parent'] = "#";
					}else{
						v['parent'] = dat.RESP_DATA['ORG_REC'][i].parent_id;
					};
					v['id'] = dat.RESP_DATA['ORG_REC'][i].id;
					v['supervisor'] = dat.RESP_DATA['ORG_REC'][i].supervisor;
					v['text'] = dat.RESP_DATA['ORG_REC'][i].name;
//					v[i] = data;
					console.log(v);
					data.push(v);
					
				});
				$('#treeData').jstree({
					'checkbox': {
					 'keep_selected_style': true,
				     'tie_selection': false,
				     'whole_node': false // click on checkBox
					},
					"plugins": ["type","checkbox", "json_data"],
					'core' : {
				    'data' : data,
				    "themes":{
			         "icons":true,
				    }			           
				}})		
			}
		});
	}     
				

	</script>
	
	
	
	
	
<%-- <body class="nav-md" style="background-color:white; " >
	<div class="x_panel" style="width: 450px;" >
        	<div class="x_title">
                	<h2>Select the Department</h2>
                    <ul class="nav navbar-right panel_toolbox" style="min-width: 0;">
                       <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
            </div>
            <div class="x_content">
            
            <!-- Select for -->
                 <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search" style="position: absolute">
                      <div class="input-group">
                           <input class="form-control" placeholder="Search for..." type="text">
                            <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                      </div>
                 </div>                                        
                                    
            <!-- /Select for -->  
                <br>
            <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
				<!-- Tree -->                                
                           <div style="padding-top: 20px;">   
                                <ul id="tree1">
								    <li><a href="#">KOSIGN</a>
								
								        <ul>								            
								            <li>Account Center
								                <ul>
								                    <li>GM
								                        <!-- <ul>
								                            <li>Report1</li>
								                            <li>Report2</li>
								                            <li>Report3</li>
								                        </ul> -->
								                    </li>
								                    
								                </ul>
								            </li>
								            <li>Business Center
								                <ul>
								                    <li>Network
								                        <!-- <ul>
								                            <li>Report1</li>
								                            <li>Report2</li>
								                            <li>Report3</li>
								                        </ul> -->
								                    </li>
								                   <!--  <li>Employee Maint.</li> -->
								                </ul>
								            </li>
								            <li>Coocon Center
								                <ul>
								                    <li>Scraping Team
								                        <!-- <ul>
								                            <li>Report1</li>
								                            <li>Report2</li>
								                            <li>Report3</li>
								                        </ul> -->
								                    </li>
								                    <li>Web Team
								                       <!--  <ul>
								                            <li>Report1</li>
								                            <li>Report2</li>
								                            <li>Report3</li>
								                        </ul> -->
								                    </li>
								                    
								                </ul>
								            </li>								            
								            <li>R & D Center
								                <ul>
								                    <li>Fintech Team
								                        <!-- <ul>
								                            <li>Report1</li>
								                            <li>Report2</li>
								                            <li>Report3</li>
								                        </ul> -->
								                    </li>
								                    <li>Bizplay Team
								                        <!-- <ul>
								                            <li>Report1</li>
								                            <li>Report2</li>
								                            <li>Report3</li>
								                        </ul> -->
								                    </li>
								                    <li>Smart Team
								                        <!-- <ul>
								                            <li>Report1</li>
								                            <li>Report2</li>
								                            <li>Report3</li>
								                        </ul> -->
								                    </li>
								                    
								                </ul>
								            </li>
								            
								            <!-- <li>Human Resources</li> -->
								        </ul>
								    </li>
								    
								</ul>
                               
                               </div>  
                                <!-- /Tree -->
                                        
               
              
               <div class="ln_solid"></div>
                   <div class="form-group">
                   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3" style="text-align:center;">
                   		<button type="submit" class="btn btn-primary" style="width:70px;">  OK  </button>
                       	<button type="submit" class="btn btn-success" style="width: 70px;">Cancel</button>
                      
                   </div>
               </div>
        	</form>
    	</div>
	</div>
    </body>

   <%@include file="/static/include/assetfooter.jsp" %> --%>
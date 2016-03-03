<%@include file="/static/include/assetheader.jsp" %>

<body class="nav-md">

    <div class="container body">

        <div class="main_container">

            <%@include file="/static/include/leftbar.jsp" %> 
            <%@include file="/static/include/topNav.jsp" %>

            <!-- page content -->
            <div class="right_col" role="main">                
                    <div class="page-title">
                        <div class="title_left">                            
                            <h3><small>
									<ol class="breadcrumb">
									  <li><a href="#">Leave and Times Management System</a></li>									  
									  <!--<li class="active">Data</li>-->
									</ol>
								</small>
						</h3>
                        </div>   
                                            
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                    	<div class="col-md-12 col-sm-12 col-xs-12" > 
                            <div class="x_panel">
                            <div class="x_title">
                                    <h2>Hover rows <small>Try hovering over the rows</small></h2>
                                   
                                    <div class="clearfix"></div>
                                </div>
                            
                            
                            <div class="col-md-4 col-sm-4 col-xs-4"> 
                                <div class="x_panel"><!-- panel left  -->   
                                <h2>Organization</h2>                             
	                                <div class="x_title">                                
	                                 <!-- Search for -->
	                                  
	                               			 <div class="input-group">
	                                    		<input type="text" class="form-control" placeholder="Search for...">
	                                   			 <span class="input-group-btn">
	                            					<button class="btn btn-default" type="button">Go!</button>
	                      						</span>
	                               			</div> 
	                                 <!-- /Search for -->                                    
	                                    
	                                <div class="clearfix"></div>
	                                </div>
                                <div class="x_content">

                                <!-- Tree -->                                
                                
                                <ul id="treeData">
								   
								    
								</ul>
                                <!-- /Tree -->

                                </div>
                            </div><!-- /panel left  -->
                            
                            
                         </div> <!-- /class x3 -->

                        
                            <div class="col-md-8 col-sm-8 col-xs-8">
                            <div class="x_panel" ><!-- panel right  -->
                                <h2>Supervisor</h2>
                                <div class="x_content">
									If you select a supervisor, he will receive a copy of accepted and rejected leave requests submitted by employees of this department.
                                   <br/><br/>  
                                </div>
                               
                                 <!-- Select for -->
                                <div class="col-md-6 col-sm-8 col-xs-12">  
	                               	<div class="input-group">
	                                    <input type="text" class="form-control" placeholder="Please Select an User ..." >
	                                   	<span class="input-group-btn">
		                            		<button class="btn btn-default" type="button" ><i class="fa fa-close"></i></button>
		                            		<button class="btn btn-default" type="button" data-toggle="modal" data-target="#lms_adm_015p_Modal" >Select</button>
	                      				</span>
	                               	</div>
	                              	                                           
                                </div><br/><br/>
                                  <!-- /Select for -->  
                                  
                                <div class="col-md-8" style="width:56.66%"><h2 style="font-weight:600;">Employees attached to Department</h2></div>
                                <!-- Search  -->
                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">  
                                                               
                                	<div class="input-group">
	                                    <input type="text" class="form-control" placeholder="Search for...">
	                                    <span class="input-group-btn">
	                            			<button class="btn btn-default" type="button">Go!</button>
	                       				 </span>
                                	</div>
                            	</div>                                
                                <!-- /Search  -->                                
                                 <!-- table  -->                                
                                 <table class="table table-striped responsive-utilities jambo_table bulk_action">
                                    <thead>
                                            <tr class="headings">
                                                <th>
                                                    <div>
                                                   	 <input type="checkbox" id="">                                                    
                                                    </div>
                                                </th>
                                                <th class="column-title">ID </th>
                                                <th class="column-title">First Name </th>
                                                <th class="column-title">Last Name </th>
                                                <th class="column-title">E-mail </th>
                                                
                            			    </tr>
                           			</thead>
                             		<tbody>
                               			<tr class="even pointer">
				                        	<td class="a-center "><input type="checkbox" id=""></td>
				                            <td class=" ">001</td>
				                            <td class=" ">Sunleng </td>
				                            <td class=" ">Lao </td>
				                            <td class=" ">sunlenglao@yahoo.com</td>
                                
                                		   </tr>
                                            <tr class="odd pointer">
                                               <td class="a-center "><input type="checkbox" id=""></td>
                                               <td class=" ">002</td>
				                               <td class=" ">Gechleng </td>
				                               <td class=" ">Ngor </td>
				                               <td class=" ">jexl@yahoo.com</td>
                                                
                                            </tr>
                                            <tr class="even pointer">
                                                <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                                <td class=" ">003</td>
				                               <td class=" ">Bunna </td>
				                               <td class=" ">Long </td>
				                               <td class=" ">longbunna@yahoo.com</td>
                                                
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                               <td class=" ">004</td>
				                               <td class=" ">Sunleng </td>
				                               <td class=" ">Lao </td>
				                               <td class=" ">sunlenglao@yahoo.com</td>
                                                
                                            </tr>
                                            <tr class="even pointer">
                                                <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                                <td class=" ">005</td>
				                               <td class=" ">Sunleng </td>
				                               <td class=" ">Lao </td>
				                               <td class=" ">sunlenglao@yahoo.com</td>
                                                
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                                <td class=" ">006</td>
				                               <td class=" ">Sunleng </td>
				                               <td class=" ">Lao </td>
				                               <td class=" ">sunlenglao@yahoo.com</td>
                                               
                                            </tr>
                                            <tr class="even pointer">
                                               <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                                <td class=" ">005</td>
				                               <td class=" ">Sunleng </td>
				                               <td class=" ">Lao </td>
				                               <td class=" ">sunlenglao@yahoo.com</td>
                                                
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                                <td class=" ">006</td>
				                               <td class=" ">Sunleng </td>
				                               <td class=" ">Lao </td>
				                               <td class=" ">sunlenglao@yahoo.com</td>
                                               
                                            </tr>
                                            <tr class="even pointer">
                                                <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                                <td class=" ">005</td>
				                               <td class=" ">Sunleng </td>
				                               <td class=" ">Lao </td>
				                               <td class=" ">sunlenglao@yahoo.com</td>
                                                
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
				                               <input type="checkbox" id=""> 
				                               </td>
                                                <td class=" ">006</td>
				                               <td class=" ">Sunleng </td>
				                               <td class=" ">Lao </td>
				                               <td class=" ">sunlenglao@yahoo.com</td>
                                               
                                            </tr>
                                            
                                       </tbody>

                                  </table>
                                    
                                     <!-- Combo  -->
                                  <div id="example_length" class="dataTables_length">
                                  	<label>Show <select size="1" style="width: 56px;padding: 6px;" name="example_length" aria-controls="example">
	                                  <option value="10">10</option>
	                                  <option value="25">25</option>
	                                  <option value="50">50</option>	                                  
	                                  </select> entries</label>
                                  </div>
                                  <!-- /Combo  -->
                                  
                                  <!--   Pagination  -->
                                  <div class="dataTables_paginate paging_full_numbers" id="example_paginate" style="float: right;">
	                                  <a tabindex="0" class="first paginate_button paginate_button_disabled" id="example_first">First</a>
	                                  <a tabindex="0" class="previous paginate_button paginate_button_disabled" id="example_previous">Previous</a>
	                                  <span><a tabindex="0" class="paginate_active">1</a><a tabindex="0" class="paginate_button">2</a>
	                                  <a tabindex="0" class="paginate_button">3</a></span><a tabindex="0" class="next paginate_button" id="example_next">Next</a>
	                                  <a tabindex="0" class="last paginate_button" id="example_last">Last</a>
                                  </div>
                                  
                                  <!--  / Pagination  -->
                                 <br/><br/><br/>
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3" style="float: right;">
                                           <button type="submit" class="btn btn-success" style="float: right">Delete an Employee</button>
                                           <button type="submit" class="btn btn-primary" style="float: right" data-toggle="modal" data-target="#lms_adm_016p_Modal" >Add an Employee</button>
                                           
                                 </div>   
                            <!-- </div> -->
                        </div><!-- panel right  -->
                        </div><!-- panel x 6  -->
                      </div> <!-- /class 12 all  -->
                    </div>

                </div>
				<!-- footer content -->
                <footer >
                    <div class="" >
                        <p style="text-align: center !important; margin-top:8px;" >copyright @ 2015 kosign.All reserve</p>
                    </div>                    
                </footer>
                <!-- /footer content -->
               
                
                <!-- ****************** Popup lms_adm_015p******************************************************************************* -->
                
                <div class="modal fade"  id="lms_adm_015p_Modal"  role="dialog">
                  
                	<div class="modal-dialog modal-md">
                		<div class="modal-content" style="padding-top:4px;">
                           <div class="x_panel" style="border:none;">
                                <div class="x_title" >
                                   <h2> Select a Supervisor</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        
                                        
                                        <li style="float:right;"><a href="#"><i class="fa fa-close" data-dismiss="modal"></i></a>                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                
                                <div class="title_right">
                            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                                </div>
                            </div>
                        </div>
                                
                                
                                <div class="x_content">
                                    <table id="example" class="table table-striped responsive-utilities jambo_table">
                                        <thead>
                                            <tr class="headings">
                                                <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th>
                                                <th>ID </th>
                                                <th>First Name </th>
                                                <th>Last Name </th>
                                                <th>E-mail </th>      
                                                </th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            
                                            
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>003</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>004</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                           <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>005</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>006</td>
                                                <td class=" ">Sunleng</td>
                                                <td class=" ">Lao</td>
                                                <td class=" ">sunlenglao@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                               <td>007</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>008</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>009</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>010</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>011</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>012</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                              <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>013</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                            </tr>   
                                        </tbody>

                                    </table>
                                     <!-- Combo  -->
                                  <div id="example_length" class="dataTables_length" style="width:26%;"><label>Show <select size="1" style="width: 56px;padding: 6px;" name="example_length" aria-controls="example">
	                                  <option value="10">10</option>
	                                  <option value="25">15</option>	                                  
	                                  </select> entries</label>
                                  </div>
                                  <!-- /Combo  -->
                                  
                                  <!--   Pagination  -->
                                  <div class="dataTables_paginate paging_full_numbers" id="example_paginate" style="float: right; padding-top:4px;">
	                                  <a tabindex="0" class="first paginate_button paginate_button_disabled" id="example_first">First</a>
	                                  <a tabindex="0" class="previous paginate_button paginate_button_disabled" id="example_previous">Previous</a>
	                                  <span><a tabindex="0" class="paginate_active">1</a><a tabindex="0" class="paginate_button">2</a>
	                                  <a tabindex="0" class="paginate_button">3</a></span><a tabindex="0" class="next paginate_button" id="example_next">Next</a>
	                                  <a tabindex="0" class="last paginate_button" id="example_last">Last</a>
                                  </div>
                                  
                                  <!--  / Pagination  -->
                                    
                                    <br/><br/><br/>
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3" style="float: right">
                                            <button type="submit" class="btn btn-success" style="float: right">Cancel</button>
                                           <button type="submit" class="btn btn-primary" style="float: right">OK</button>
                                    </div>
                                </div>
                             </div> 
                        </div> <!--  /class x 8 -->
                
                
                </div> <!-- /Modal content -->
                
        	</div> <!-- /Modal -->
                
                
                
                <!-- ****************** /Popup lms_adm_015p******************************************* -->  
                
                <!-- ****************** Popup lms_adm_016p************************************************************************************************************** -->
                
                <div class="modal fade"  id="lms_adm_016p_Modal"  role="dialog">
                	<div class="modal-dialog modal-md">
                		<div class="modal-content" style="padding-top:4px;">
                            <div class="x_panel" style="border:none;">
                                <div class="x_title">
                                   <h2> Add an Employee</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        
                                        
                                        <li style="float:right;"><a href="#"><i class="fa fa-close" data-dismiss="modal"></i></a>                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                
                                <div class="title_right">
                            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                                </div>
                            </div>
                        </div>
                                
                                
                                <div class="x_content">
                                    <table id="example" class="table table-striped responsive-utilities jambo_table">
                                        <thead>
                                            <tr class="headings">
                                                <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th>
                                                <th>ID </th>
                                                <th>First Name </th>
                                                <th>Last Name </th>
                                                <th>E-mail </th>      
                                                </th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            
                                            
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>003</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>004</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                           <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>005</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>006</td>
                                                <td class=" ">Sunleng</td>
                                                <td class=" ">Lao</td>
                                                <td class=" ">sunlenglao@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                               <td>007</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>008</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>009</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>010</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td>011</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>012</td>
                                                <td class=" ">Bunna</td>
                                                <td class=" ">Long</td>
                                                <td class=" ">longbunna@gmail.com 
                                                </td>
                                                
                                               
                                            </tr>
                                              <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>013</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                               
                                                
                                            </tr>
                                            
                                           
                                            <tr class="even pointer selected">
                                                <td class="a-center ">
                                                   
                                                    <input type="checkbox" checked class="tableflat">
                                                </td>
                                                <td>014</td>
                                                <td class=" ">Rathana</td>
                                                <td class=" ">Song</td>
                                                <td class=" ">rathana@gmail.com 
                                                </td>
                                            </tr>
                                            
                                        </tbody>

                                    </table>
                                     <!-- Combo  -->
                                  <div id="example_length" class="dataTables_length" style="width:26%;"><label>Show <select size="1" style="width: 55px;padding: 5px;" name="example_length" aria-controls="example">
	                                  <option value="10">10</option>
	                                  <option value="25">15</option>	                                  
	                                  </select> entries</label>
                                  </div>
                                  <!-- /Combo  -->
                                  
                                  <!--   Pagination  -->
                                  <div class="dataTables_paginate paging_full_numbers" id="example_paginate" style="float: right; padding-top:4px;">
	                                  <a tabindex="0" class="first paginate_button paginate_button_disabled" id="example_first">First</a>
	                                  <a tabindex="0" class="previous paginate_button paginate_button_disabled" id="example_previous">Previous</a>
	                                  <span><a tabindex="0" class="paginate_active">1</a><a tabindex="0" class="paginate_button">2</a>
	                                  <a tabindex="0" class="paginate_button">3</a></span><a tabindex="0" class="next paginate_button" id="example_next">Next</a>
	                                  <a tabindex="0" class="last paginate_button" id="example_last">Last</a>
                                  </div>
                                  
                                  <!--  / Pagination  -->
                                    
                                    <br/><br/><br/>
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3" style="float: right">
                                            <button type="submit" class="btn btn-success" style="float: right">Cancel</button>
                                           <button type="submit" class="btn btn-primary" style="float: right">OK</button>
                                    </div>
                                </div>
                            </div>
                        </div> 
                
                
                
                
                
                
                <!-- ****************** /Popup lms_adm_016p******************************************* -->  
            
            <!-- /page content -->
            	</div> <!-- /Modal content -->
        	</div> <!-- /Modal -->
       	
        	
        </div>
        
    </div>  
    <%@include file="/static/include/assetfooter.jsp" %>
    <script src="<c:url value="/static/js/actionjs/lms_adm_015.js" />"></script>
</div>
</body>

 </html>

<%@include file="/static/include/assetheader.jsp" %>

<script
	src="<c:url value="/static/js/datatables/js/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="../static/js/actionjs/lms_adm_019.js" />"></script>

<%@include file="lms_adm_019p.jsp" %>
<%@include file="lms_adm_020p.jsp" %>



<body class="nav-md">

    <div class="container body">


        <div class="main_container">
			
			<!-- Left menu bar -->
			
            <%@include file="/static/include/leftbar.jsp" %>
            
			<!-- /Left menu bar -->
			
            <!-- top navigation -->
            
            <%@include file="/static/include/topNav.jsp" %>
            
            <!-- /top navigation -->

            <!-- page content -->
            <div class="right_col" role="main">
				<div class="">
			       <div class="page-title">
                        <div class="title_left">
                            <h3><small>
									<ol class="breadcrumb">
									  <li><a href="#">Users</a></li>
									  <li><a href="#">balance</a></li>
									  <!--<li class="active">Data</li>-->
									</ol>
								</small>
							</h3>
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
                    </div>
                    <div class="clearfix"></div>


                    <div class="row">
                        <div class="col-md-12 col-sm-6 col-xs-12">
                              <div class="x_panel">
                                <div class="x_title">
                                    <h2>Entitled days for contrat <spam>(Employee term)</spam></h2>
                                    <div class="clearfix"></div>
                                </div>

                                <div class="x_content">
									<div class="title_right">                        </div>
                                    	<table class="table table-striped responsive-utilities jambo_table bulk_action">
                                        	<thead>
                                           		<tr class="headings">
                                                	<th class="column-title">Actions </th>
                                                	<th class="column-title">Start </th>
                                                	<th class="column-title">End </th>
                                                	<th class="column-title">Days </th>
                                                	<th class="column-title">Leave type </th>
                                                	<th class="column-title">Description </th>
                                                </tr>
                            				</thead>

                            				<tbody>
                                				<tr class="even pointer">
                                    				<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                   					</td>
                                    				<td class=" ">10/12/2015</td>
                                    				<td class=" ">20/12/2015</td>
                                    				<td class=" ">10</td>
                                    				<td class=" ">Annual Leave</td>
                                   				 	<td class=" ">Annual leave for employee only 18 days</td>
                                				</tr>
                                				<tr class="odd pointer">
                                                	<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                     				<td class=" ">10/12/2015</td>
                                    				<td class=" ">12/12/2015</td>
                                   	 				<td class=" ">2</td>
                                    				<td class=" ">Special leave</td>
                                    				<td class=" ">Special leave for employee only 7 days</td>
                                				</tr>
                                				<tr class="even pointer">
                                    				<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                    				<td class=" ">10/12/2015</td>
                                    				<td class=" ">12/12/2015</td>
                                   					<td class=" ">2</td>
                                    				<td class=" ">Sick leave</td>
                                    				<td class=" ">Sick leave for employee only 7 days</td>
                                				</tr>
                                				<tr class="even pointer">
                                    				<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                    				<td class=" ">10/12/2015</td>
                                    				<td class=" ">20/12/2015</td>
                                    				<td class=" ">10</td>
                                    				<td class=" ">Annual Leave</td>
                                    				<td class=" ">Annual leave for employee only 18 days</td>
                                				</tr>
                                				<tr class="odd pointer">
                                               	 	<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                     				<td class=" ">10/12/2015</td>
                                    				<td class=" ">12/12/2015</td>
                                    				<td class=" ">2</td>
                                    				<td class=" ">Special leave</td>
                                    				<td class=" ">Special leave for employee only 7 days</td>
                                				</tr>
                                				<tr class="even pointer">
                                    				<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                    				<td class=" ">10/12/2015</td>
                                    				<td class=" ">12/12/2015</td>
                                    				<td class=" ">2</td>
                                    				<td class=" ">Sick leave</td>
                                    				<td class=" ">Sick leave for employee only 7 days</td>
                                				</tr>
                               				 	<tr class="even pointer">
                                    				<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                    				<td class=" ">10/12/2015</td>
                                    				<td class=" ">20/12/2015</td>
                                    				<td class=" ">10</td>
                                    				<td class=" ">Annual Leave</td>
                                    				<td class=" ">Annual leave for employee only 18 days</td>
                                				</tr>
                                				<tr class="odd pointer">
                                                	<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                     				<td class=" ">10/12/2015</td>
                                   				 	<td class=" ">12/12/2015</td>
                                    				<td class=" ">2</td>
                                    				<td class=" ">Special leave</td>
                                    				<td class=" ">Special leave for employee only 7 days</td>
                                				</tr>
                                				<tr class="even pointer">
                                    				<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                    				<td class=" ">10/12/2015</td>
                                    				<td class=" ">12/12/2015</td>
                                    				<td class=" ">2</td>
                                   	 				<td class=" ">Sick leave</td>
                                    				<td class=" ">Sick leave for employee only 7 days</td>
                               				 	</tr>
                                  				<tr class="even pointer">
                                    				<td class="a-center ">
                                    					<a href="#/trash"><i class="fa fa-trash"></i></a>
                                    					<a href="#/pencil" data-toggle="modal" data-target="#lms_adm_020p"><i class="fa fa-pencil"></i></a>
                                    				</td>
                                    				<td class=" ">10/12/2015</td>
                                    				<td class=" ">12/12/2015</td>
                                    				<td class=" ">2</td>
                                    				<td class=" ">Sick leave</td>
                                    				<td class=" ">Sick leave for employee only 7 days</td>
                              			  		</tr>         
                         					</tbody>
										</table>
					
						<select size="1" style="width: 56px;padding: 6px;" name="example_length" aria-controls="example">
							<option value="10">5</option>
							<option value="25">10</option>
							<option value="50">15</option>
						</select> 
						
						<div class="dataTables_paginate paging_full_numbers" id="example_paginate"><a tabindex="0" class="first paginate_button paginate_button_disabled" id="example_first">First</a><a tabindex="0" class="previous paginate_button paginate_button_disabled" id="example_previous">Previous</a><span><a tabindex="0" class="paginate_active">1</a><a tabindex="0" class="paginate_button">2</a><a tabindex="0" class="paginate_button">3</a><a tabindex="0" class="paginate_button">4</a></span><a tabindex="0" class="next paginate_button" id="example_next">Next</a><a tabindex="0" class="last paginate_button" id="example_last">Last</a></div>
						<div>
							<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                           		<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 pull-right">
                                	<button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#lms_adm_019p">Add</button>
                                	<button type="submit" class="btn btn-success">Back to list</button>
                           	 	</div>
                         	</div>
						
                        </div>
                        </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!-- /page content -->
        </div>

    </div>

    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>

   <%@include file="/static/include/assetfooter.jsp" %>

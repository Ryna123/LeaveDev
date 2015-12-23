<%@include file="/static/include/assetheader.jsp" %>
	<style type="text/css">
		#create_new_type_btn{
			text-align: right;
			margin-bottom:10px;
		}
		#ok_btn{
			text-align: right;
			margin-bottom:10px;
			margin-right: 16px;
		}
		#create_new_type_btn i{
			padding-right:5px;
		}
		.modal-dialog{
			margin-top: 100px;
		}
		#pagination{
			clear: both;
			width:100%;
			text-align: center;
			margin:0px auto;
			margin-bottom: 30px;
		}
		#pagination label select{
			padding: 6px;
		}
		#pagination label{
			float:left;
		}
		 p{
		 	margin-left:40px !important;
		 }

	</style>
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
									  <li><a href="#">Admin</a></li>
									  <li><a href="#">List of Users</a></li>
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
                                    <h2>Leave and Overtime Management System<small>List of all users</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <!--<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>-->
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Actions</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Login</th>
                                                <th>Email</th>
                                                <th>Phone</th>
                                                <th>Role</th>
                                                <th>Manager</th>
                                            </tr>
                                        </thead>
                                        <tbody id="listUser">
<!--                                         	<tr> -->
<!--                                         		<th scope="row">1</th> -->
<!--                                             	<td> -->
<!-- 													<a href=""><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="" data-original-title="Active"></span></a> |  -->
<!-- 													<a href="javascrip:void(0)" data-toggle="modal" data-target="#update_user"><span class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit"></span></a> |  -->
<!-- 													<a href=""><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a>  -->
<!-- 												</td>												 -->
<!--                                                 <td>Mark</td> -->
<!--                                                 <td>Otto</td> -->
<!--                                                 <td>rara</td> -->
<!--                                                 <td>rara@gmail.com</td> -->
<!--                                                 <td>User</td> -->
<!--                                                 <td>Kim Wansu</td> -->
<!--                                             </tr> -->
<!--                                             <tr> -->
<!--                                                 <th scope="row">2</th> -->
<!--                                                 <td> -->
<!-- 													<a href=""><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="" data-original-title="Active"></span></a> |  -->
<!-- 													<a href="javascrip:void(0)" data-toggle="modal" data-target="#update_user"><span class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit"></span></a> |  -->
<!-- 													<a href=""><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a> -->
<!-- 												</td>												 -->
<!--                                                 <td>Mark</td> -->
<!--                                                 <td>Otto</td> -->
<!--                                                 <td>otto</td> -->
<!--                                                 <td>mark@gmail.com</td> -->
<!--                                                 <td>HR Admin</td> -->
<!--                                                 <td>Kim Wansu</td> -->
<!--                                             </tr>                                    -->
                                        </tbody>
										<!--<tfoot>
											<div><span>There aren't any users</span></div>
										</tfoot>-->
                                    </table>

                                </div>
                                
                                <!-- Pagination block -->
				                <div id="pagination">
					                <label>Show <select size="1" name="" aria-controls="">
							              <option value="10">10</option>
							              <option value="25">25</option>
							              <option value="50">50</option>
							              <option value="100">100</option>
					                </select> entries</label>
					
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
				                
				                
								<div id="create_new_type_btn">
									<a class="btn btn btn-success"><i class="fa fa-download"></i>Export List</a>
									<a class="btn btn btn-primary" href="lms_adm_008.jsp"><i class="fa fa-plus-circle"></i>Create a new user</a>
								</div>
                            </div>
                        </div>
                    </div>
                    
                </div>
				
				
            </div>
            <!-- /page content -->
        </div>
    </div>
    
	<%@include file="lms_adm_007.jsp"%>
	
    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>
    
<%@include file="/static/include/assetfooter.jsp" %>
   <script src="<c:url value="../static/js/actionjs/lms_adm_006.js" />"></script>
    <script type="text/x-jquery-tmpl" id="lmsAdm006">
		<tr>
             <th scope="row">{{= ID}}</th>
                   <td>
						<a href=""><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="" data-original-title="Active"></span></a> | 
						<a href="javascrip:void(0)" data-toggle="modal" data-target="#update_user"><span class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit"></span></a> | 
						<a href=""><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a> 
					</td>												
                    <td>{{= FIRSTNAME}}</td>
                    <td>{{= LASTNAME}}</td> 
					<td>{{= LOGIN}}</td>
					<td>{{= EMAIL}}</td>
                    <td>{{= PHONE}}</td>
					<td>{{= ROLE}}</td>
					<td>{{= MANAGERNAME}}</td>
					
                   
        </tr>
	</script>
   




<%-- <%@include file="/static/include/assetheader.jsp" %>


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
									  <li><a href="#">list</a></li>
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
                                    <h2>Hover rows <small>Try hovering over the rows</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <!--<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>-->
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
												<th>ID</th>
                                                <th>First Name</th>
												<th>Last Name</th>
												<th>Email</th>
												<th>Department</th>
												<th>Contrast</th>
												<th>Manager</th>
                                            </tr>
                                        </thead>
                                        <tbody>
											                                            <tr>
                                                <th scope="row">1</th>
                                                <td>
													<a href=""><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="" data-original-title="Active"></span></a> | 
													<a href=""><span class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit"></span></a> | 
													<a href=""><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a> | 
													<a href=""><span class="glyphicon glyphicon-lock" data-toggle="tooltip" data-placement="top" title="" data-original-title="Lock"></span></a>
												</td>												
                                                <td>yonryna</td>
                                                <td>yonryna123@gmail.com</td>
                                                <td>Manager</td>
                                                <td>User</td>
                                                <td>1</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>
													<a href=""><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="" data-original-title="Active"></span></a> | 
													<a href=""><span class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit"></span></a> | 
													<a href=""><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a> | 
													<a href=""><span class="glyphicon glyphicon-lock" data-toggle="tooltip" data-placement="top" title="" data-original-title="Lock"></span></a>
												</td>												
                                                <td>bensteav</td>
                                                <td>ben@gmail.com</td>
                                                <td>Employee</td>
                                                <td>Hr Manager</td>
                                                <td>1</td>
                                            </tr>                                   
                                        </tbody>
										<!--<tfoot>
											<div><span>There aren't any users</span></div>
										</tfoot>-->
                                    </table>

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

<%@include file="/static/include/assetfooter.jsp" %> --%>
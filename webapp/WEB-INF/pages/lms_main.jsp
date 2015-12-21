
<%@include file="/static/include/assetheader.jsp" %>


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
                            <h3>Dashboard<small>
									<!-- <ol class="breadcrumb">
									  <li><a href="#">Users</a></li>
									  <li><a href="#">list</a></li>
									  <li class="active">Data</li>
									</ol> -->
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
                                    <h2>If you are an employee, you here</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                   <div class="row">
                                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                          <a href="<c:url value="/users/lms_adm_001" />">
                                            <div class="tile-stats" style="height: 138px;text-align: center;">
                                                <div class="icon" style="right: 130px;"><i class="fa fa-bar-chart"></i>
                                                </div>
                                                <h3 class="tile_align">Leave Balance</h3>
                                            </div>
                                            </a>
                                        </div>
                                        
                                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                           <a href="<c:url value="/users/lms_adm_002" />">
                                            <div class="tile-stats" style="height: 138px;text-align: center;">
                                                <div class="icon" style="right: 130px;"><i class="fa fa-list"></i>
                                                </div>
                                                <h3 class="tile_align">List Leave requested</h3>
                                            </div>
                                            </a>
                                        </div>
                                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                         <a href="<c:url value="/users/lms_adm_027" />">
                                            <div class="tile-stats" style="height: 138px;text-align: center;">
                                                <div class="icon" style="right: 130px;"><i class="fa fa-pencil-square-o"></i>
                                                </div>
                                                <h3 class="tile_align">New Leave</h3>
                                            </div>
                                            </a>
                                        </div>
                                    </div>
                                   
                                </div>
                            </div>
                            
                             <sec:authorize access="hasRole('ADMIN')">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>If you are an manager, you here</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                   <div class="row">
                                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                            <a href="<c:url value="/admin/lms_adm_004" />">
                                            <div class="tile-stats" style="height: 138px;text-align: center;">
                                                <div class="icon" style="right: 130px;"><i class="fa fa-envelope-o"></i>
                                                </div>
                                                <h3 class="tile_align">Leave Submitted </h3>
                                            </div>
                                            </a>
                                        </div>
                                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                          <a href="<c:url value="/admin/lms_adm_005" />">
                                            <div class="tile-stats" style="height: 138px;text-align: center;">
                                                <div class="icon" style="right: 130px;"><i class="fa fa-clock-o"></i>
                                                </div>
                                                <h3 class="tile_align">OT Submitted</h3>
                                            </div>
                                            </a>
                                        </div>
                                    </div>
                                        
                                </div>
                                   
                                </div>
                                </sec:authorize>
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
   
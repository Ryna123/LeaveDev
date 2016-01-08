<%@include file="/static/include/assetheader.jsp" %>
<style>
 .sm2{
 		padding: 1px 67px !important; 
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
									  <li>Calendar / My Calendar</li>
									  <!--<li class="active">Data</li>-->
									</ol>
								</small>
							</h3>
                        </div>
                        
                        <!-- <div class="title_right">
                            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                                </div>
                            </div>
                        </div> -->
                        
                        
                    </div>
                    <div class="clearfix"></div>
                    <!-- Create Calendar -->
                    <div class="row">
                            <div class="col-md-12">
                                <div class="x_panel">
                                    <div class="x_title">                                    
                                    	<div class="group">
                                    		<div class="col-sm-2">
                                    	 		<h3 class="btn-sm btn-primary status_space sm2">Planed</h3>
                                    		</div>
                                    		<div class="col-sm-2">
	                                     		<h3 class="btn-sm btn-warning sm2">Requested</h3>
                                    		</div>
                                    		<div class="col-sm-2">
	                                        	<h3 class="btn-sm btn-success sm2">Approved</h3>
                                    		</div>
                                    		<div class="col-sm-2">
	                                        <h3 class="btn-sm btn-danger sm2">Rejected</h3>
                                    		</div>
                                    	</div>
                                        <!-- <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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
                                            </li> 
                                        </ul> -->
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">

                                        <div id='calendar'></div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--End row-->


                    
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
   <script type="text/javascript" src="<c:url value="/static/js/lms_adm_031.js "/>"></script>
    
    </body>
    </html>
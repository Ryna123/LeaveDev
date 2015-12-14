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
                            <h3><small>
									<ol class="breadcrumb">
									  <li><a href="#">Home</a></li>
									  <li class="active"><a href="#">Leave balances</a></li>
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
                                
                                <div class="x_content">
                                   <form class="form-inline">
										 <div class="form-group">
										    <label for="exampleInputName2">Date of Report &nbsp &nbsp : &nbsp &nbsp</label>
										    <input type="text" class="form-control" id="exampleInputName2" placeholder="10 /-Oct-/2015">
										 </div>
									</form>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>My balance summary</h2>
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
												<th>Leave type</th>
                                                <th>Available</th>
												<th>Taken</th>
												<th>Entitled</th>
												
                                            </tr>
                                        </thead>
                                        <tbody id="entitle">
											
                                        </tbody>
 										<tfoot id="entitleFooter" style="display:none;">
										    <tr align="center">
										      <td colspan="4">There aren't any records</td>
										    </tr>
									  </tfoot>
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

   <%@include file="/static/include/assetfooter.jsp" %>
   <script src="<c:url value="/static/js/actionjs/lms_adm_001.js" />"></script>
   <script id="mytemplate" type="text/html">
   	<tr>                                             											
   		<td>{{= LTY}}</td>
   		<td>{{= LA}}</td>
   		<td>{{= LT}}</td>
   		<td>{{= LE}}</td>    
	</tr>
   </script>
   
   
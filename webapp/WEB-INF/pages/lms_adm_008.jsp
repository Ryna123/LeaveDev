<%@include file="/static/include/assetheader.jsp" %>
<style type="text/css">
		#ok_btn{
			text-align: right;
			margin-bottom:10px;
			margin-right: 16px;
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
									  <li><a href="#">Create Users</a></li>
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
                                    <h2>Leave and Overtime Management System<small>Create Users</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                
                                    <form class="form-horizontal form-label-left">

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">First Name :</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                        	<input id="firstName" type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" ></ul>
                                        </div>
										<label class="control-label col-md-1 col-sm-1 col-xs-1">Contract :</label>
										<div class="col-md-3 col-sm-3 col-xs-3" id="selectContract">
											<select data-parsley-id="4308" id="heard" class="form-control">
											<option value="">Employee Term</option>
										</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label control-label col-md-3 col-sm-3 col-xs-3">Last Name :</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                        	<input id="lastName" type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" ></ul>
                                        </div>
                                        <label class="control-label col-md-1 col-sm-1 col-xs-1">Department :</label>
										<div class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback" style="padding-left:10px;">
                                        	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                        	<span class="input-group-btn">
                                            	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#select_dept">Select</button> 
                                        	</span>
                                        </div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Role :</label>
										<div id="userRole" class="col-md-3 col-sm-3 col-xs-3">
											<select data-parsley-id="4308" class="form-control">
												<option value="">User</option>
												<option value="">HR Admin</option>
											</select>
										</div>
										<label class="control-label col-md-1 col-sm-1 col-xs-1">Position :</label>
										<div id="selectPosition" class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback" style="padding-left:10px;">
                                        	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                        	<span class="input-group-btn">
                                            	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#select_position">Select</button> 
                                        	</span>
                                        </div>
									</div>
									
									<div class="form-group">
										<label class="control-label control-label col-md-3 col-sm-3 col-xs-3">Username :</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                        	<input id="userName" type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                        </div>
                                        <label class="control-label col-md-1 col-sm-1 col-xs-1">Start Date :</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
											<input type="text" class="form-control has-feedback-left"  aria-describedby="inputSuccess2Status">
											<span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span> <span class="sr-only">(success)
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Email :</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                        	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="email"></ul>
                                        </div>
										<label class="control-label col-md-1 col-sm-1 col-xs-1">Identifier :</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                        	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                        </div>
									</div>

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Manager :</label>
										<div class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback" style="padding-left:10px;">
                                        	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                        	<span class="input-group-btn">
                                            	<button type="button" class="btn btn-primary">Self</button> 
                                        	</span>
                                        	<span class="input-group-btn">
                                            	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#select_manager">Select</button> 
                                        	</span>
                                        </div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Password :</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                        	<input type="password" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="password"></ul>
                                        </div>
									</div>
									
									<div class="form-group">
										<p>If a user has no manager(itself), it can validate its leave request.</p>
									</div>
									
									<div class="ln_solid"></div>
									<!-- Buttons -->
									<div class="form-group">
										<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3" style="margin-left:63%;">
											<button id="btnCreate" class="btn btn-info"><span class="fa fa-check-circle" aria-hidden="true"></span>Create User</button>
											<button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancel</button>
										</div>
									</div>

								</form>
                                </div>
                                <!-- /End x-content -->
                            </div>
                            <!-- /End x-panel -->
                        </div>
                    </div>
                    
                </div>
            </div>
            <!-- /page content -->
        </div>
    </div>
    
	<%@include file="lms_adm_010p.jsp"%> <!-- select position -->
	<%@include file="lms_adm_009p.jsp"%> <!-- select dept -->
	<%@include file="lms_adm_008p.jsp"%> <!-- select manager -->

	
	
    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>
    
<%@include file="/static/include/assetfooter.jsp" %> 
<script src="<c:url value="../static/js/actionjs/lms_adm_008.js" />"></script>
 
 
 
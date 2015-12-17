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
				<div class="page-title">
					<div class="title_left">
                            <h3><small>
									<ol class="breadcrumb">
									  <li><a href="#">Request</a></li>
									  <li><a href="#">Leaves</a></li>
									  <li><a href="#">Request Leaves</a></li>
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
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>Submit a Leave Request</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br>
								<form class="form-horizontal form-label-left" method="GET">

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Leave Type:</label>
										<div class="col-md-3 col-sm-3 col-xs-3">
										 <select  data-parsley-id="4308" id=selectLt class="form-control" required="required">
                        
                       					 </select>
										</div>
										<label class="control-label col-md-1 col-sm-1 col-xs-1">Duration:</label>
										<div class="col-md-2 col-sm-2 col-xs-2">
											<input class="form-control" id="duration" required="required" type="text">
										</div>
										<label class="control-label col-md-1 col-sm-1 col-xs-1" style="text-align: left;">Day(s)</label>
										
									</div>
									<div class="form-group">
										<label class="control-label control-label col-md-3 col-sm-3 col-xs-3">Start Date:</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
											<input type="text" class="form-control has-feedback-left" required="required" id="startdate" name="daterang1" aria-describedby="inputSuccess2Status">
												<span class="fa fa-calendar-o form-control-feedback left"aria-hidden="true"></span>
											<span id="" class="sr-only">(success)</span>
										</div>
										<span class="control-label col-md-1 col-sm-1 col-xs-1  "></span>
										<div class="col-md-3 col-sm-3 col-xs-3">
											<select data-parsley-id="4308" id="startdatetype" class="form-control" required="required">
												<option value="morning">Morning</option>
												<option value="afternoon">Afternoon</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label control-label col-md-3 col-sm-3 col-xs-3">End Date:</label>
										<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
											<input type="text" class="form-control has-feedback-left" required="required" id="enddate" name="daterang1" aria-describedby="inputSuccess2Status">
											<span class="fa fa-calendar-o form-control-feedback left"
													aria-hidden="true"></span> <span id="" class="sr-only">(success)
											</span>
										</div>
										<span class="control-label col-md-1 col-sm-1 col-xs-1  "></span>
										<div class="col-md-3 col-sm-3 col-xs-3">
											<select data-parsley-id="4308" id="endadatetype" class="form-control"	required="required">
											<option value="morning">Morning</option>
											<option value="afternoon">Afternoon</option>
										</select>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Reason
											<span class="required">*</span>
										</label>
										<div class="col-md-7 col-sm-7 col-xs-7">
											<textarea class="form-control" rows="2" required="required" id="reason"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Status:</label>
										<div class="col-md-3 col-sm-3 col-xs-3">
											<select class="form-control" id="selectSt" required="required">
                          
                       						</select>
										</div>
									</div>
									<div class="ln_solid"></div>
									<!-- Buttons -->
									<div class="form-group">
										<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3">
											<a href="javascript:" id="addLeave" class="btn btn-success"><span class="fa fa-check-circle" aria-hidden="true"></span> Request Leave</a>
											<button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancel</button>
										</div>
									</div>

								</form>
							</div>
						</div>
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
<script src="<c:url value="/static/js/actionjs/lms_adm_027.js" />"></script>
  <script id="mytemplate" type="text/html">
    <option value="{{= TI}}">{{= TN}}</option>
   </script>
    <script id="mytemplate1" type="text/html">
    <option value="{{= SI}}">{{= SN}}</option>
   </script>
   
<%@include file="/static/include/assetheader.jsp"%>

<body class="nav-md">

	<div class="container body">


		<div class="main_container">

			<!-- Left menu bar -->

			<%@include file="/static/include/leftbar.jsp"%>

			<!-- /Left menu bar -->

			<!-- top navigation -->

			<%@include file="/static/include/topNav.jsp"%>

			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="page-title">
					<div class="title_left">
						<h3>
							<small>
								<ol class="breadcrumb">
									<li><a href="#">Request</a></li>
									<li><a href="#">Overtime</a></li>
									<li><a href="#">Request an Extra</a></li>
									<!--<li class="active">Data</li>-->
								</ol>
							</small>
						</h3>
					</div>
					<div class="title_right">
						<div
							class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search">
								<span class="input-group-btn">
									<button class="glyphicon glyphicon-search btn btn-default"
										type="button"></button>
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
								<h2>Submit an overtime request</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br>
								<form class="form-horizontal form-label-left" method="GET" id="addOTForm">
									<div class="form-group">
										<label
											class="control-label control-label col-md-3 col-sm-3 col-xs-3">Start
											Date:</label>
										<div
											class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
											<span
												class="fa fa-calendar-o form-control-feedback left"
												aria-hidden="true"></span> <span id="" class="sr-only">(success)
											</span>
											<input type="text" class="form-control has-feedback-left"
												id="otDate" name="daterang1"
												aria-describedby="inputSuccess2Status" required="required">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Duration:</label>
										<div class="col-md-3 col-sm-3 col-xs-3">
											<input class="form-control"
												data-inputmask="'mask': '99/99/9999'" type="text" id="otDuration" required="required" data-validation-engine="validate[required,maxSize[10]">
										</div>
										<div class="col-md-3 col-sm-3 col-xs-3"> 
											<select data-parsley-id="4308" class="form-control" required="" id="otType">
												<option value="1">Days</option>
												<option value="2">Hours</option>
											</select>
										</div>
									</div>
									<br>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Reason
											<span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<textarea class="form-control" rows="2" id="otReason" required="required" data-validation-engine="validate[required]"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-3">Status:</label>
										<div class="col-md-3 col-sm-3 col-xs-3">
											<select data-parsley-id="4308" class="form-control"
												required="" id="selectSt">

											</select>
										</div>
									</div>
									<div class="ln_solid"></div>
									<!-- Buttons -->
									<div class="form-group">
										<div class="col-md-9 col-md-offset-3">
											<a href="javascript:" id="addOT" class="btn btn-success"><span class="fa fa-check-circle" aria-hidden="true"></span> Request Overtime</a>
											<!-- <button type="submit" class="btn btn-primary">Cancel</button> -->
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
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div> 
	</div>

	<%@include file="/static/include/assetfooter.jsp"%>

	<script src="<c:url value="/static/js/actionjs/lms_adm_029.js" />"></script>
	<script id="selectStTmpl" type="text/html">
    	<option value="{{= statusID}}">{{= statusName}}</option> 
   	</script>
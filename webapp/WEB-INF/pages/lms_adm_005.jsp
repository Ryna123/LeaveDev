<%@include file="/static/include/assetheader.jsp"%>
<script src="<c:url value="/static/js/datatables/js/jquery.dataTables.js" />"></script>
<%@include file="lms_adm_005p.jsp"%>

<style type="text/css">
		#otDataTable_length select{
			min-height: 30px;
		}
		.paginate_button.current{
		    background-color: rgba(38, 185, 154, 0.59) !important;
    		border-color: rgba(38, 185, 154, 0.59) !important;
		}
</style>

<body class="nav-md">

	<div class="container body">


		<div class="main_container">

			<!-- Left menu bar -->

			<%@include file="/static/include/leftbar.jsp"%>

			<!-- /Left menu bar -->

			<!-- top navigation -->

			<%@include file="/static/include/topNav.jsp"%>

			<!-- /top navigation -->
			<script type="text/javascript"
				src="<c:url value="../static/js/actionjs/lms_adm_005.js" />"></script>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="page-title">
					<!-- Content title left -->
					<div class="title_left">
						<h3>
							<small>
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li><a href="#">Overtime requests</a></li>
									<!--<li class="active">Data</li>-->
								</ol>
							</small>
						</h3>
					</div>
					<!-- Content title right -->
					<div class="title_right">
						<div
							class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
							<div class="input-group">
								<input type="text" class="form-control" id="srchTxt"
									placeholder="Search for..."> <span
									class="input-group-btn">
									<button class="btn btn-default" id="srchBtn" type="button">Go!</button>
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<!-- Content -->
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<!-- Content title -->
							<div class="x_title">
								<h2>Overtime requests summited to me</h2>
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
								<!-- Table and button -->
								<form class="form-horizontal form-label-left">
									<div>
										<table id="otDataTable"
											class=" table table-bordered table-striped responsive-utilities jambo_table dataTable"
											aria-describedby="example_info">
											<thead>
												<tr class="headings" role="row">
													<th class="" role="columnheader" tabindex="0"
														aria-controls="example" rowspan="1" colspan="1"
														style="width: 40px; text-align: center;">ID</th>
													<th class="" role="columnheader" tabindex="0"
														aria-controls="example" rowspan="1" colspan="1"
														style="width: 133px;">Action</th>
													<th class="" role="columnheader" tabindex="0"
														aria-controls="example" rowspan="1" colspan="1"
														style="width: 112px;">Full Name</th>
													<th class="" role="columnheader" tabindex="0"
														aria-controls="example" rowspan="1" colspan="1"
														style="width: 134px;">Start Date</th>
													<th class="" role="columnheader" tabindex="0"
														aria-controls="example" rowspan="1" colspan="1"
														style="width: 133px;">Duration</th>
													<th class="" role="columnheader" tabindex="0"
														aria-controls="example" rowspan="1" colspan="1"
														style="width: 133px;">Reason</th>
													<th class="" role="columnheader" tabindex="0"
														aria-controls="example" rowspan="1" colspan="1"
														style="width: 133px;">Status</th>
												</tr>
											</thead>

											<tbody role="alert" aria-live="polite" aria-relevant="all">
												<!-- <tr class="pointer odd">
                          <td id="">1</td>
                          <td id="">
                            <a href="javascrip:"><span class="fa fa-eye" data-toggle="modal" data-target="#lms_adm_005p" data-placement="top" title="" data-original-title="View"></span></a> |
                            <a href="javascrip:"><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="" data-original-title="Active"></span></a> |
                            <a href="javascrip:"><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a>
                          </td>
                          <td id="">Yon Ryna</td>
                          <td id="">10/16/2015</td>
                          <td id="">2</td>
                          <td id="">Standby</td>
                          <td id="">Planed</td>
                        </tr>
                        <tr class="pointer odd">
                          <td id="">1</td>
                          <td id="">
                            <a href="javascrip:"><span class="fa fa-eye" data-toggle="modal" data-target="#lms_adm_005p" data-placement="top" title="" data-original-title="View"></span></a> |
                            <a href="javascrip:"><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="" data-original-title="Active"></span></a> |
                            <a href="javascrip:"><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a>
                          </td>
                          <td id="">Yon Ryna</td>
                          <td id="">10/16/2015</td>
                          <td id="">2</td>
                          <td id="">Urgent working</td>
                          <td id="">Requested</td>
                        </tr> -->
											</tbody>
										</table>
									</div>
									<!-- <div class="form-group">
										<div class="col-md-1 col-sm-1 col-xs-1">
											<select data-parsley-id="4308" id="heard"
												class="form-control" required="">
												<option value="10">10</option>
												<option value="20">20</option>
												<option value="30">30</option>
											</select>
										</div>
										Pagination
										<div class="dataTables_paginate paging_full_numbers"
											style="margin-left: 23%; float: left;" id="example_paginate">
											<a tabindex="0"
												class="first paginate_button paginate_button_disabled"
												id="example_first">First</a> <a tabindex="0"
												class="previous paginate_button paginate_button_disabled"
												id="example_previous">Previous</a> <span> <a
												tabindex="0" class="paginate_active">1</a> <a tabindex="0"
												class="paginate_button">2</a> <a tabindex="0"
												class="paginate_button">3</a> <a tabindex="0"
												class="paginate_button">4</a>
											</span> <a tabindex="0" class="next paginate_button" id="">Next</a>
											<a tabindex="0" class="last paginate_button" id="">Last</a>
										</div>
										End Pagination
									</div> -->
									<div class="ln_solid"></div>
									<!-- Buttons -->
									<div class="form-group pull-right">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<a class="btn btn-success" href="${pageContext.request.contextPath}/action/service/otAdminExport"
												style="border-radius: 15px; !important">Export</a> <a
												class="btn btn-primary"
												style="border-radius: 15px; !important">All requests</a> <a
												class="btn btn-default"
												style="border-radius: 15px; !important">Pending requests</a>
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
			<%@include file="lms_adm_002p.jsp"%><!--  -->
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



	<!--  <script type="text/x-jquery-tmpl" id="lmsAdm005">
   <tr class="pointer odd">
                          <td id="">{{= ID}}</td>
                          <td id="">
                            <a href="javascrip:" id="viewBtn"><input type="hidden" data-empid= "{{= EMPID}}" value= "{{= OTID}}"><span class="fa fa-eye" data-toggle="modal" data-target="#lms_adm_005p" data-placement="top" title="View" data-original-title="View"></span></a> |
                            <a href="javascrip:" id="approveBtn"><input type="hidden" value= "{{= OTID}}"><span class="glyphicon glyphicon-ok" data-toggle="tooltip" data-placement="top" title="Approve" data-original-title="Active"></span></a> |
                            <a href="javascrip:" id="rejectBtn"><input type="hidden" value= "{{= OTID}}"><span class="fa fa-close fa-lg" data-toggle="tooltip" data-placement="top" title="Reject" data-original-title="Delete"></span></a>
                          </td>
                          <td style='width:300px' id="">{{= FULLNAME}}</td>
                          <td id="">{{= DATE}}</td>
                          <td id="">{{= DURATION}}&nbsp;&nbsp;{{= TYPE}}</td>
                          <td id=""><div style="text-overflow:ellipsis;overflow:hidden;width:360px;">{{= CAUSE}}</div></td>
                          <td>
				              {{html STATUSNAME}}
			              </td>
                        </tr>
   </script>-->
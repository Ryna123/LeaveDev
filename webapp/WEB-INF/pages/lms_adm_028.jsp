<%@include file="/static/include/assetheader.jsp"%>
<script src="<c:url value="/static/js/datatables/js/jquery.dataTables.js" />"></script>
<style type="text/css">

		#SearchBox{
			border-radius: 25px 25px 25px 25px;
		} 
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

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">

					<div class="page-title">
						<div class="title_left">
							<h3>
								<small>
									<ol class="breadcrumb">
										<li><a href="#">Request</a></li>
										<li><a href="#">Overtime</a></li>
										<li><a href="#">List of Extra</a></li>
										<!--<li class="active">Data</li>-->
									</ol>
								</small>
							</h3>
						</div>
						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="col-md-12 col-sm-12 col-xs-12 input-group">
									<input type="text" class="form-control"
										placeholder="Search for..." id="SearchBox"> <span
										class="input-group-btn">
										<!-- <button class="btn btn-default" type="button">Go!</button> -->
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
									<h2>Personal Overtime Request</h2>
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
								<div class="x_content" >
									<table class="table table-bordered" id="otDataTable">
										<thead>
											<tr>
												<th>View</th>
												<th>ID</th>
												<th>Date</th>
												<th>Duration</th>
												<th>Reason</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody id="listOT">
											
										</tbody>
										<!-- <tfoot id="otFooter" style="display: none;">
											<tr align="center">
												<td colspan="8">There aren't any leaves requested</td>
											</tr>
										</tfoot> -->
									</table>
									<!-- <div id="example_length" class="dataTables_length">
										<label>Show <select size="1"
											style="width: 56px; padding: 6px;" name="example_length"
											aria-controls="example"><option value="10">10</option>
												<option value="25">25</option>
												<option value="50">50</option>
												<option value="100">100</option></select>
										</label>
									</div>
									<div class="dataTables_paginate paging_full_numbers"
										id="example_paginate">
										<a tabindex="0"
											class="first paginate_button paginate_button_disabled"
											id="example_first">First</a><a tabindex="0"
											class="previous paginate_button paginate_button_disabled"
											id="example_previous">Previous</a><span><a
											tabindex="0" class="paginate_active">1</a><a tabindex="0"
											class="paginate_button">2</a><a tabindex="0"
											class="paginate_button">3</a><a tabindex="0"
											class="paginate_button">4</a></span><a tabindex="0"
											class="next paginate_button" id="example_next">Next</a><a
											tabindex="0" class="last paginate_button" id="example_last">Last</a>
									</div> -->
									<!-- End Pagination -->
									<!-- <div class="clearfix"></div> -->
									<div class="ln_solid"></div>
									<!-- Buttons -->
									<div class="form-group">
										<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-9">
											<a class="btn btn-success"  href="${pageContext.request.contextPath}/action/service/export"> <i class="fa fa-send" ></i> Export</a> 
											<a class="btn btn-primary"  href="${pageContext.request.contextPath}/users/lms_adm_029"><i class="fa fa-plus"></i> New Request	</a>
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
			<%@include file="lms_adm_030p.jsp"%><!--  -->
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
	<script src="<c:url value="/static/js/actionjs/lms_adm_028.js" />"></script>
	<!-- <script type="text/x-jquery-tmpl" id="lmsAdm028">
		<tr class="pointer odd">   
			<td>
				<a href="javascrip:" id="viewBtn">
					<input type="hidden" value= "{{= id}}">
					<span class="fa fa-eye" title="View" data-original-title="View">
					</span>
				</a>
			</td>  
			<td>{{= otID}}</td>                            											
			<td>{{= otDate}}</td>
   			<td>{{= otDuration}}&nbsp;&nbsp;{{= otType}}</td>
   			<td><div style="white-space: nowrap;overflow: hidden; text-overflow: ellipsis; width:100px;">{{= otReason}}</div></td>
   			<td>{{html otStatus}}</td> 			   
		</tr>


	</script> -->
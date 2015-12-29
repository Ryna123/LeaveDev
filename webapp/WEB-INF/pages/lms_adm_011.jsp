
<%@include file="/static/include/assetheader.jsp"%>
<style type="text/css">
#create_new_type_btn {
	text-align: right;
	margin-bottom: 10px;
}

#create_new_type_btn i {
	padding-right: 5px;
}

.modal-dialog {
	margin-top: 200px;
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
										<li><a href="#">Leaves</a></li>
										<li><a href="#">List of Types</a></li>
										<!--<li class="active">Data</li>-->
									</ol>
								</small>
							</h3>
						</div>
						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
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
									<h2>
										Leave and Overtime Management System<small>List of
											Leave Types</small>
									</h2>
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
												<th>Action</th>
												<th>Type</th>
											</tr>
										</thead>
										<tbody id="listLeaveType">

										</tbody>
										<!--<tfoot>
											<div><span>There aren't any users</span></div>
										</tfoot>-->
									</table>

								</div>
								<div id="create_new_type_btn">
									<a class="btn btn btn-primary" data-toggle="modal"
										data-target="#new_leave_type"><i class="fa fa-plus-circle"></i>Create
										a new type</a>
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

	<!-- Modal of form create new leave type-->
	<%@include file="lms_adm_012p.jsp"%>
	<!--End Modal -->

	<!-- Modal updating leaving form-->
	<%@include file="lms_adm_013p.jsp"%>
	<!--End Modal -->

	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>

	<%@include file="/static/include/assetfooter.jsp"%>

	<script src="<c:url value="../static/js/actionjs/lms_adm_011.js" />"></script>
	<script type="text/x-jquery-tmpl" id="lmsAdm011">
    <tr>
    	<th scope="row">{{= ID}}</th>
    	<td>
			<a href="#" data-toggle="modal" data-target="#update_leave_type"><span class="glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" ></span></a> | 
			<a href=""><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete"></span></a>  
		</td>												
    	<td>{{= LEAVETYPE}}</td>
    </tr>


	</script>
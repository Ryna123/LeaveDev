<%@include file="/static/include/assetheader.jsp"%>

<script
	src="<c:url value="/static/js/datatables/js/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="../static/js/actionjs/lms_adm_021.js" />"></script>

<%@include file="lms_adm_021p.jsp"%>
<%@include file="lms_adm_022p.jsp"%>
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
										<li><a href="#">Users</a></li>
										<li><a href="#">balance</a></li>
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
										List of positions
										</spam>
									</h2>
									<div class="clearfix"></div>
								</div>

								<div class="x_content">
									<div class="title_right"></div>
									<table
										class="table table-striped responsive-utilities jambo_table bulk_action">
										<thead>
											<tr class="headings">
												<th class="column-title">Act</th>
												<th class="column-title">ID</th>
												<th class="column-title">Name</th>
												<th class="column-title">Description</th>
											</tr>
										</thead>

										<tbody>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">1</td>
												<td class=" ">CEO</td>
												<td class=" ">The head quater</td>
											</tr>
											<tr class="odd pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">2</td>
												<td class=" ">General Manager</td>
												<td class=" "></td>
											</tr>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">3</td>
												<td class=" ">Manager</td>
												<td class=" "></td>
											</tr>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">4</td>
												<td class=" ">Researcher</td>
												<td class=" "></td>
											</tr>
											<tr class="odd pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">5</td>
												<td class=" ">Assistand Researcher</td>
												<td class=" "></td>
											</tr>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">6</td>
												<td class=" ">General worker</td>
												<td class=" "></td>
											</tr>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">7</td>
												<td class=" ">Internship</td>
												<td class=" "></td>
											</tr>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">7</td>
												<td class=" ">Internship0</td>
												<td class=" "></td>
											</tr>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">7</td>
												<td class=" ">Internship1</td>
												<td class=" "></td>
											</tr>
											<tr class="even pointer">
												<td class="a-center "><a href="#/trash"><i
														class="fa fa-trash"></i></a> <a href="#/pencil"
													data-toggle="modal" data-target="#lms_adm_022p"><i
														class="fa fa-pencil"></i></a></td>
												<td class=" ">7</td>
												<td class=" ">Internship11</td>
												<td class=" "></td>
											</tr>
										</tbody>
									</table>

									<select size="1" style="width: 56px; padding: 6px;"
										name="example_length" aria-controls="example">
										<option value="10">10</option>
										<option value="25">15</option>
										<option value="50">20</option>
									</select>

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
									</div>
									<div>
										<div
											class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
											<div
												class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 pull-right">
												<button type="submit" class="btn btn-success"
													data-toggle="modal" data-target="#lms_adm_021p">Create
													position</button>
											</div>
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
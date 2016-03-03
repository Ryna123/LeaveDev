
<%@include file="/static/include/assetheader.jsp"%>
<script
	src="<c:url value="/static/js/datatables/js/jquery.dataTables.js" />"></script>

<script type="text/javascript"
	src="<c:url value="../static/js/actionjs/lms_adm_017.js" />"></script>
<body class="nav-md">

	<div class="container body">


		<div class="main_container">

			<%@include file="/static/include/leftbar.jsp"%>
			<%@include file="/static/include/topNav.jsp"%>

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="" style="height: 100%">
					<div class="page-title">
						<!-- Contain  -->
						<div id="coonten" style="height: 100%">
							<div class="title_left">
								<h3>
									<small>
										<ol class="breadcrumb">
											<li><a href="#">List of Contracts</a></li>
											<!--<li class="active">Data</li>-->
										</ol>
									</small>
								</h3>



							</div>

						</div>

						<!-- Search  -->
						<div
							class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
							<div class="input-group">
								<input type="text" id="txtSearch" class="form-control"
									placeholder="Search for..."> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">Go!</button>
								</span>
							</div>
						</div>
						<!-- /Search  -->


					</div>
					<div class="clearfix"></div>
					<div class="row">

						<div class="col-md-6 col-sm-6 col-xs-12"
							style="width: 100%; position: relative;">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Hover rows <small>Try hovering over the rows</small>
									</h2>
									<div class="clearfix"></div>
								</div>

								<!-- table  -->
								<table id="ctTable"
									class="table table-striped responsive-utilities jambo_table dataTable"
									aria-describedby="example_info">
									<thead>
										<tr class="headings" role="row">
											<th class="sorting" role="columnheader" tabindex="0"
												aria-controls="example" rowspan="1" colspan="1"
												aria-label="Invoice : activate to sort column ascending"
												style="width: 150px;">Action</th>
											<th class="sorting" role="columnheader" tabindex="0"
												aria-controls="example" rowspan="1" colspan="1"
												aria-label="Invoice Date : activate to sort column ascending"
												style="width: 120px;">ID</th>
											<th class="sorting" role="columnheader" tabindex="0"
												aria-controls="example" rowspan="1" colspan="1"
												aria-label="Order : activate to sort column ascending"
												style="width: 350px;">Name</th>
											<th class="sorting" role="columnheader" tabindex="0"
												aria-controls="example" rowspan="1" colspan="1"
												aria-label="Bill to Name : activate to sort column ascending"
												style="width: 156px;">Start Period</th>
											<th class="sorting" role="columnheader" tabindex="0"
												aria-controls="example" rowspan="1" colspan="1"
												aria-label="Status : activate to sort column ascending"
												style="width: 156px;">End Period</th>

										</tr>
									</thead>



									<tbody role="alert" aria-live="polite" aria-relevant="all">

									</tbody>

								</table>

								<!-- Combo  -->
								<!--  <div id="example_length" class="dataTables_length"><label>Show <select size="1" style="width: 60px;padding: 5px;" name="example_length" aria-controls="example">
	                                  <option value="10">10</option>
	                                  <option value="25">25</option>
	                                  <option value="50">50</option>
	                                  <option value="100">100</option>
	                                  </select> entries</label>
                                  </div> -->
								<!-- /Combo  -->

								<!--   Pagination  -->
								<!-- <div class="dataTables_paginate paging_full_numbers" id="example_paginate" style="float: right;">
	                                  <a tabindex="0" class="first paginate_button paginate_button_disabled" id="example_first">First</a>
	                                  <a tabindex="0" class="previous paginate_button paginate_button_disabled" id="example_previous">Previous</a>
	                                  <span><a tabindex="0" class="paginate_active">1</a><a tabindex="0" class="paginate_button">2</a>
	                                  <a tabindex="0" class="paginate_button">3</a></span><a tabindex="0" class="next paginate_button" id="example_next">Next</a>
	                                  <a tabindex="0" class="last paginate_button" id="example_last">Last</a>
                                  </div> -->

								<!--  / Pagination  -->
								<br />
								<br />
								<br />
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3"
									style="float: right">
									<button type="submit" class="btn btn-primary"
										style="float: right" data-toggle="modal"
										data-target="#lms_adm_017p_Modal">Create Contract</button>

								</div>
							</div>
						</div>
					</div>
					<!-- footer content -->
					<footer>
						<div class="">
							<p style="text-align: center !important; margin-top: 8px;">copyright
								@ 2015 kosign.All reserve</p>
						</div>
					</footer>
					<!-- /footer content -->

				</div>
				<!-- /coonten -->




			</div>


		</div>
		<!-- /right_col  -->



		<!-- /page content -->
	</div>

	<!-- ****************** /Popup lms_adm_017p*************************************************************************************************************** -->
	<%@include file="lms_adm_017p.jsp"%>
	<!-- ****************** Popup lms_adm_018p*************************************************************************************** -->
	<%@include file="lms_adm_018p.jsp"%>

	<%@include file="/static/include/assetfooter.jsp"%>t>



</body>

</html>
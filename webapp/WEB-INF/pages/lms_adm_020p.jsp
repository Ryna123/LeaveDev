
<div id="lms_adm_020p" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Edit entitled days</h4>
			</div>
			<div class="modal-body">
				<form id="demo-form2" data-parsley-validate=""
					class="form-horizontal form-label-left" novalidate="">
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">Start date: </label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="txtStart" required="required"
								class="form-control col-md-7 col-xs-12" data-parsley-id="1224">
							<ul class="parsley-errors-list" id="parsley-id-1224"></ul>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="last-name">End date: </label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="txtEnd" name="last-name"
								required="required" class="form-control col-md-7 col-xs-12"
								data-parsley-id="3556">
							<ul class="parsley-errors-list" id="parsley-id-3556"></ul>
						</div>
					</div>
					<div class="form-group">
						<label for="middle-name"
							class="control-label col-md-3 col-sm-3 col-xs-12">Leave
							type: </label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<select id="lbsLT" class="form-control" required=""
								data-parsley-id="0188">
								<option value="0">Annual leave</option>
								<option value="2">Special leave</option>
								<option value="1">Sick leave</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Days:
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input id="txtDays"
								class="date-picker form-control col-md-7 col-xs-12"
								required="required" type="text" data-parsley-id="4786">
							<ul class="parsley-errors-list" id="parsley-id-4786"></ul>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Description:
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input id="txtDescript"
								class="date-picker form-control col-md-7 col-xs-12"
								required="required" type="text" data-parsley-id="4786">
							<ul class="parsley-errors-list" id="parsley-id-4786"></ul>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="submit" class="btn btn-success" id="btnEdit" style="width: 70px;">Modify</button>
						<button type="submit" class="btn btn-primary" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




<!-- Modal User Edition-->
<div class="modal fade" id="update_user" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- pop up form--edit user-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" style="display: inline">Edit User</h4>
				<h4 class="modal-title" style="display: inline">&nbsp;&nbsp;#1</h4>
			</div>
			<div class="clearfix"></div>
			<div style="margin-top: 10px;">

				<form class="form-horizontal form-label-left" id="frmValidate">

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-3">Identifier:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
							<input type="text" id="txtIdentifier" readonly="readonly"
								class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="parsley-id-7168"></ul>
						</div>

						<label class="control-label col-md-2 col-sm-2 col-xs-2">Status:</label>
						<div class="col-md-3 col-sm-3 col-xs-3">
							<input id="" type="text"
								class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list"></ul>
						</div>

					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-3">First
							Name:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
							<input required="required"
								data-validation-engine="validate[required,minSize[3],maxSize[15]"
								id="firstName" type="text"
								class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list"></ul>
						</div>

						<label class="control-label col-md-2 col-sm-2 col-xs-2">Last
							Name:</label>
						<div class="col-md-3 col-sm-3 col-xs-3">
							<input required="required"
								data-validation-engine="validate[required,minSize[3],maxSize[15]"
								id="lastName" type="text" class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list"></ul>
						</div>


					</div>

					<div class="form-group">

						<label
							class="control-label control-label col-md-3 col-sm-3 col-xs-3">Contract:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback"
							id="selectContract">
							<select required="required"
								data-validation-engine="validate[required,maxSize[15]"
								data-parsley-id="4308" id="heard" class="form-control">
								<option value="">Employee Term</option>
							</select>
						</div>
						<label class="control-label col-md-2 col-sm-2 col-xs-2">Department:</label>
						<div
							class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback"
							style="padding-left: 10px;">
							<input required="required"
								data-validation-engine="validate[required,maxSize[15]"
								type="text" class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="parsley-id-7168"></ul>
							<span class="input-group-btn">
								<button type="button" id="btn_selectDept"
									class="btn btn-primary" data-toggle="modal"
									data-target="#select_dept">Select</button>
							</span>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-3">Role:</label>
						<div id="userRole" class="col-md-3 col-sm-3 col-xs-3">
							<select data-parsley-id="4308" class="form-control">
								<option value="">User</option>
								<option value="">HR Admin</option>
							</select>
						</div>
						<label class="control-label col-md-2 col-sm-2 col-xs-2">Position:</label>
						<div id="selectPosition"
							class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback"
							style="padding-left: 10px;">
							<input type="text" id="position" class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="parsley-id-7168"></ul>
							<span class="input-group-btn">
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#select_position">Select</button>
							</span>
						</div>
					</div>

					<div class="form-group">
						<label
							class="control-label control-label col-md-3 col-sm-3 col-xs-3">Username:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
							<input required="required"
								readonly="readonly"
								data-validation-engine="validate[required,maxSize[15]"
								id="userName" type="text" class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="parsley-id-7168"></ul>
						</div>

						<label class="control-label col-md-2 col-sm-2 col-xs-2">Password:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
							<input required="required"
								data-validation-engine="validate[required,maxSize[15]"
								type="password" class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="password"></ul>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-3">Email:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
							<input data-validation-engine="validate[required,custom[email]]"
								data-errormessage-value-missing="Email is required!"
								data-errormessage-custom-error="Let me give you a hint: someone@nowhere.com"
								data-errormessage="This is the fall-back error message."
								id="email" type="text" class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="email"></ul>
						</div>
						<label class="control-label col-md-2 col-sm-2 col-xs-2">Phone:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
							<input required="required"
								data-validation-engine="validate[required,maxSize[10],minSize[9]"
								id="phoneNumber" type="text"
								class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="phoneNumber"></ul>
						</div>
					</div>

					<div class="form-group">

						<label
							class="control-label control-label col-md-3 col-sm-3 col-xs-3">Start
							Date:</label>
						<div
							class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
							<input type="text" class="form-control has-feedback-left"
								required="required"
								data-validation-engine="validate[required,custom[date]"
								id="startdate" name="daterang1"
								aria-describedby="inputSuccess2Status"> <span
								class="fa fa-calendar-o form-control-feedback left"
								aria-hidden="true"></span> <span id="" class="sr-only">(success)</span>
						</div>
						<label class="control-label col-md-2 col-sm-2 col-xs-2">Manager:</label>
						<div
							class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback"
							style="padding-left: 10px;">
							<input required="required"
								data-validation-engine="validate[required,maxSize[15]"
								id="txtManager" readonly="readonly" type="text"
								class="form-control col-md-7 col-xs-3">
							<ul class="parsley-errors-list" id="parsley-id-7168"></ul>
							<span class="input-group-btn">
								<button id="btnSelf" type="button" class="btn btn-primary">Self</button>
							</span> <span class="input-group-btn">
								<button id="btnManager" type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#select_manager">Select</button>
							</span>
						</div>
					</div>
					<div class="form-group">
						<p>If a user has no manager(itself), it can validate its leave
							request.</p>
					</div>

					<div class="ln_solid"></div>
					<!-- Buttons -->
					<div class="form-group">

						<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3"
							style="margin-left: 63%;">

							<input value="Create" type="button" id="btnCreate"
								class="btn btn-info" /> <a class="btn btn-success"
								href="<c:url value="/admin/lms_adm_006"/>">List Users</a>
							<!-- <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancel</button>
						 -->
						</div>
					</div>

				</form>
			</div>

		</div>
	</div>
</div>
<!-- End Modal User Edition-->

<%@include file="lms_adm_010p.jsp"%>
<!-- select position -->
<%@include file="lms_adm_009p.jsp"%>
<!-- select dept -->
<%@include file="lms_adm_008p.jsp"%>
<!-- select manager -->










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
        				<div style="margin-top:10px;">
                             
                                 <form class="form-horizontal form-label-left">

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-3">First Name :</label>
							<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                     	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                     </div>
							<label class="control-label col-md-2 col-sm-2 col-xs-2">Contract :</label>
							<div class="col-md-3 col-sm-3 col-xs-3">
								<select data-parsley-id="4308" id="heard" class="form-control">
									<option value="">Employee Term</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-3">Last Name :</label>
							<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                     	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                     </div>
                                     <label class="control-label col-md-2 col-sm-2 col-xs-2">Department :</label>
							<div class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback" style="padding-left:10px;">
                                     	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                     	<span class="input-group-btn">
                                         	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#select_dept">Select</button> 
                                     	</span>
                                     </div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-3">Role :</label>
							<div class="col-md-3 col-sm-3 col-xs-3">
                                     	<select data-parsley-id="4308" id="heard" class="form-control">
									<option value="">User</option>
									<option value="">HR Admin</option>
								</select>
                                     </div>
							<label class="control-label col-md-2 col-sm-2 col-xs-2">Position :</label>
							<div class="input-group col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback" style="padding-left:10px;">
                                     	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                     	<span class="input-group-btn">
                                         	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#select_position">Select</button> 
                                     	</span>
                                     </div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-3">Login :</label>
							<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                     	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                     </div>
                                     <label class="control-label col-md-2 col-sm-2 col-xs-2">Start Date :</label>
							<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
								<input type="text" class="form-control has-feedback-left" id="" name="daterang1" aria-describedby="inputSuccess2Status">
								<span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span> <span id="" class="sr-only">(success)
								</span>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-3">Email :</label>
							<div class="col-md-3 col-sm-3 col-xs-3 xdisplay_inputx form-group has-feedback">
                                     	<input type="text" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                     </div>
							<label class="control-label col-md-2 col-sm-2 col-xs-2">Identifier :</label>
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
                                     	<input type="password" class="form-control col-md-7 col-xs-3"><ul class="parsley-errors-list" id="parsley-id-7168"></ul>
                                     </div>
						</div>
						
						<div class="form-group">
							<p>If a user has no manager(itself), it can validate its leave request.</p>
						</div>
						
						<div class="ln_solid"></div>
						<!-- Buttons -->
						<div class="form-group">
							<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3" style="margin-left:63%;">
								<button type="submit" class="btn btn-success"><span class="fa fa-check-circle" aria-hidden="true"></span> Request Leave</button>
								<button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancel</button>
							</div>
						</div>
					</form>
                  </div>
	        	
	      	</div>
	    </div>
	</div>
	<!-- End Modal User Edition-->
	
	<%@include file="lms_adm_010p.jsp"%> <!-- select position -->
	<%@include file="lms_adm_009p.jsp"%> <!-- select dept -->
	<%@include file="lms_adm_008p.jsp"%> <!-- select manager -->










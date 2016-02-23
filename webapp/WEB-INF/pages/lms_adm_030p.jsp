
<div class="modal fade" id="otModal">
	<div class="modal-dialog modal-sg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">x</button>
				<h2 class="modal-title">View Overtime Request</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal form-label-left" id="otModalForm">
					<div class="form-group">
						<label
							class="control-label control-label col-md-3 col-sm-3 col-xs-3">Start
							Date: </label> <label
							class="control-label control-label col-md-1 col-sm-1 col-xs-1"></label>
						<div class="col-md-6 col-sm-6 col-xs-6 xdisplay_inputx form-group has-feedback">
							<input type="text" class="form-control has-feedback-left" id="otDate"
								name="daterang1" disabled="disabled"
								aria-describedby="inputSuccess2Status"> <span
								class="fa fa-calendar-o form-control-feedback right"
								aria-hidden="true"></span> <span id="" class="sr-only">(success)
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-3">Duration:</label>
						<label
							class="control-label control-label col-md-1 col-sm-1 col-xs-1"></label>
						<div class="col-md-3 col-sm-3 col-xs-3">
							<input class="form-control" disabled="disabled"
								data-inputmask="'mask': '99/99/9999'" type="text" id="otDuration">
						</div>
						
						<div class="col-md-3 col-sm-3 col-xs-3">
							<select data-parsley-id="4308" disabled="disabled"
								class="form-control" required="" id="otType">
								<option value="1">Day(s)</option>
								<option value="2">Hour(s)</option>
							</select>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Reason:
							<span class="required">*</span>
						</label> <label
							class="control-label control-label col-md-1 col-sm-1 col-xs-1"></label>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<textarea class="form-control" rows="2" disabled="disabled" id="otReason"></textarea>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-3">Status:</label>
						<label
							class="control-label control-label col-md-1 col-sm-1 col-xs-1"></label>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<select data-parsley-id="4308" disabled="disabled"
								class="form-control" required="" id="otStatus">
								<option value="1">Planned</option>
								<option value="2">Approved</option>
								<option value="3">Rejected</option>
								<option value="4">Requested</option>
							</select>
						</div>
					</div>
				</form>
				<!-- end modal body -->
				<div class="modal-footer">
					<div class="col-md-12 col-sm-12 col-xs-12"> 
						<button type="submit" class="btn btn-primary" style="display:none" id="oTEditBtn">Edit</button>
						<button type="submit" class="btn btn-danger" data-dismiss="modal">Back	to List</button>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>


<!-- page content -->
<div class="modal fade" id="lms_adm_004p" tabindex="-1" role="dialog">
  <div class="AddDelegate">
    <div class="modal-dialog modal-sg" ><!-- style="width: 45%" -->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"
            aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
          <h4 class="modal-title" id="">View Leave Requested</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal form-label-left">
            <div class="form-group">
              <label  class="control-label control-label col-md-2 col-sm-2">StartDate: </label> 
              <label class="control-label control-label col-md-1 col-sm-1"></label>
              <div  class="col-md-5 col-sm-5 xdisplay_inputx form-group has-feedback">
                <input type="text" class="form-control has-feedback-left" id="startdate" disabled name="daterang1" aria-describedby="inputSuccess2Status"> 
                	<span class="fa fa-calendar-o form-control-feedback right" aria-hidden="true"></span> 
                	<span id="" class="sr-only">(success)</span>
              </div>
              <!-- combo box -->
              <div class="col-md-3 col-sm-3">
                <select data-parsley-id="4308" id="startDateType" class="form-control" required="" disabled>
                  <option value="morning">Morning</option>
                  <option value="afternoon">Afternoon</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="control-label control-label col-md-2 col-sm-2">EndDate: </label> 
              <label class="control-label control-label col-md-1 col-sm-1"></label>
              <div class="col-md-5 col-sm-5 xdisplay_inputx form-group has-feedback">
                <input type="text" class="form-control has-feedback-left" id="enddate" disabled name="daterang1" aria-describedby="inputSuccess2Status"> 
                <span class="fa fa-calendar-o form-control-feedback right" aria-hidden="true"></span> <span id="" class="sr-only">(success)</span>
              </div>
              <!-- combo box -->
              <div class="col-md-3 col-sm-3">
                <select data-parsley-id="4308" id="endDateType" class="form-control" required="" disabled>
                  <option value="morning">Morning</option>
                  <option value="afternoon">Afternoon</option>		
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-2 col-sm-2">Duration:</label>
              <label class="control-label control-label col-md-1 col-sm-1"></label>
              <div class="col-md-5 col-sm-5">
                <input class="form-control" data-inputmask="'mask': '99/99/9999'" type="text" value="" id="duration" disabled>
              </div>
              <label class="control-label col-md-1 col-sm-1" style="text-align: left;">Day(s)</label>
            </div>
            <br>
            <div class="form-group">
              <label class="control-label col-md-2 col-sm-2">Leave Type:</label> 
              <label class="control-label control-label col-md-1 col-sm-1"></label>
              <div class="col-md-5 col-sm-5">
                <select data-parsley-id="4308" id="selectLeaveType" class="form-control" required="" disabled>
                  <!-- <option value="plan">Annual Leave</option>
                  <option value="unplan">Option</option> -->
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-2 col-sm-2">Reason: <span class="required">*</span></label> 
              <label class="control-label control-label col-md-1 col-sm-1"></label>
              <div class="col-md-8 col-sm-8">
                <textarea class="form-control" rows="2" id="reason" disabled></textarea>
              </div>
            </div>

            <div class="form-group">
              <label class="control-label col-md-2 col-sm-2">Status:</label>
              <label class="control-label control-label col-md-1 col-sm-1"></label>
              <div class="col-md-5 col-sm-5">
                <select data-parsley-id="4308" id="selectSt" class="form-control" required="" disabled>
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
            <div class="col-md-11">
              <!-- <button type="submit" class="btn btn-success">Accept</button>
              <button type="submit" class="btn">Edit</button> -->
              <button type="submit" class="btn" data-dismiss="modal">Back to list</button>
            </div>
          </div>
        </div>

      </div>
    </div>
    <!-- /page content -->
  </div>

</div>
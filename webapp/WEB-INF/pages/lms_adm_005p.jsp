<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	<link href="fonts/css/font-awesome.min.css" rel="stylesheet">
	<link href="css/animate.min.css" rel="stylesheet">
	
	<!-- Custom styling plus plugins -->
	<link href="css/custom.css" rel="stylesheet">
	<link href="css/icheck/flat/green.css" rel="stylesheet">
	
	<!-- Full Calendar CSS included by Chitra -->
	<link href="css/calendar/fullcalendar.css" rel="stylesheet">
	<link href="css/calendar/fullcalendar.print.css" rel="stylesheet"
		media="print">
	<link href="csslms_adm_031.css" rel="stylesheet">
	<!-- That's all -->
	</head>

	<body class="nav-md">
		<div id="lms_adm_005p" class="modal fade" role="dialog"> 
  			<div class="modal-dialog">
	   			<!-- Modal content-->
	    		<div class="modal-content">
	      			<div class="modal-header">
	        			<button type="button" class="close" data-dismiss="modal">&times;</button>
	       				<h4 class="modal-title">View list request <small id="unserNm"></small></h4>
	     			</div>
				    <div class="modal-body">
				        
				        <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" >
							<div class="form-group">
							  
	                    		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Start date: </label>
	                        	<div class="col-md-6 col-sm-6 col-xs-12">
	                                <input type="text" id="startDate" required="required" class="form-control col-md-7 col-xs-12" data-parsley-id="1224" disabled ="disabled"><ul class="parsley-errors-list" id="parsley-id-1224"  ></ul>
	                            </div>
	                		</div>
			                <div class="form-group" id="divDuration">
			                    
			                </div>
			                <div class="form-group">
	                    		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Reason: </label>
	                        	<div class="col-md-6 col-sm-6 col-xs-12">
	                                <textarea type="text" id="reason" style="width:262px;height: 91px;" disabled ="disabled"></textarea>
	                            </div>
	                		</div>
			                <div class="form-group">
			                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Status: </label>
			                    <div class="col-md-6 col-sm-6 col-xs-12">
			                     	<select id="status" class="form-control" required="required" data-parsley-id="0188" disabled ="disabled">
			                     			<option value="1">Planned</option>
			                                <option value="2">Approved</option>
			                                <option value="3">Rejected</option>
			                                <option value="4">Requested</option>
			                        </select>
			                    </div>
			               </div> 
        				</form>
				    
				    </div>
					<div class="modal-footer">	
					    <div class="form-group">
			                   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3" style="width: 363px;margin-left: 71px;">
			                  	  <button type="button" id="appBtn" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-check"></i>&nbsp;&nbsp;Approved</button>
			                  	  <button type="button"id="rejBtn" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-close"></i>&nbsp;&nbsp;Rejected</button>
			                  	  <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-close"></i>&nbsp;&nbsp;Cancel</button>
			                  	    <input type="hidden" id="overtimeId">
			                       <!-- <button type="submit" class="btn btn-primary" id="backBtn">Back to list</button> -->
			                   </div>
		               	</div>
					</div>
	    		</div>
  			</div>
		</div>
		
		<script type="text/x-jquery-tmpl" id="templateDuration" >
							<label class="control-label col-md-3 col-sm-3 col-xs-12"  for="last-name">Duration </label>
			                    <div class="col-md-6 col-sm-6 col-xs-12">
			                        <input type="text"  name="last-name" required="required" id="duration" value = "{{= DURATION}}" class="form-control col-md-7 col-xs-12" data-parsley-id="3556"  disabled ="disabled"><small>({{= TYPE}})</small><ul class="parsley-errors-list" id="parsley-id-3556"></ul>
			                    </div>

		</script>
	</body>	
</html>
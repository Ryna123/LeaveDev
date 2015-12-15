<%@include file="/static/include/assetheader.jsp"%>


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
            <!-- Content title left -->
            <div class="title_left">
              <h3>
                <small>
                  <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">New leave</a></li>
                    <!--<li class="active">Data</li>-->
                  </ol>
                </small>
              </h3>
            </div>
            <!-- Content title right -->
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
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>If you are an employee, you here</h2>
                  <ul class="nav navbar-right panel_toolbox">
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content" style="display: block;">
                  <br>
                  <form class="form-horizontal form-label-left"
                    novalidate="">
                    <div class="form-group">
                      <label
                        class="control-label col-md-3 col-sm-3 col-xs-12">Leave
                        type:</label>
                      <div class="col-md-4 col-sm-3 col-xs-12">
                        <select class="form-control" id="selectLt">
                         
                        </select>
                        <ul class="parsley-errors-list" id=""></ul>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="middle-name"
                        class="control-label col-md-3 col-sm-3 col-xs-12">Start
                        date:</label>
                      <div
                        class="col-md-4 col-sm-3 col-xs-12 xdisplay_inputx form-group has-feedback">
                        <input type="text"
                          class="form-control has-feedback-left active"
                          id="" name="daterang1"
                          aria-describedby="inputSuccess2Status">
                        <span
                          class="fa fa-calendar-o form-control-feedback left"
                          aria-hidden="true"></span> <span id=""
                          class="sr-only">(success) </span>
                      </div>
                      <div class="col-md-2 col-sm-3 col-xs-12">
                        <select class="form-control">
                          <option>Morning</option>
                          <option>Afernoon</option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="middle-name"
                        class="control-label col-md-3 col-sm-3 col-xs-12">End
                        date:</label>
                      <div
                        class="col-md-4 col-sm-3 col-xs-12 xdisplay_inputx form-group has-feedback">
                        <input type="text"
                          class="form-control has-feedback-left active"
                          id="" name="daterang1"
                          aria-describedby="inputSuccess2Status">
                        <span
                          class="fa fa-calendar-o form-control-feedback left"
                          aria-hidden="true"></span> <span id=""
                          class="sr-only">(success) </span>
                      </div>
                      <div class="col-md-2 col-sm-3 col-xs-12">
                        <select class="form-control">
                          <option>Morning</option>
                          <option>Afternoon</option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group">
                      <label
                        class="control-label col-md-3 col-sm-3 col-xs-12">Duration:</label>
                      <div class="col-md-3 col-sm-2 col-xs-11">
                        <input id="birthday"
                          class="date-picker form-control"
                          required="required" type="text"
                          data-parsley-id="5319">
                        <ul class="parsley-errors-list"
                          id="parsley-id-5319"></ul>
                      </div>
                      <label
                        class="control-label col-md-1 col-sm-1 col-xs-1"
                        style="text-align: left;">Day(s)</label>
                    </div>
                    <div class="form-group">
                      <label
                        class="control-label col-md-3 col-sm-3 col-xs-12">Reason:</label>
                      <div class="col-md-4 col-sm-3 col-xs-12">
                        <textarea class="form-control" rows="3"></textarea>
                        <ul class="parsley-errors-list" id=""></ul>
                      </div>
                    </div>
                    <div class="form-group">
                      <label
                        class="control-label col-md-3 col-sm-3 col-xs-12">Status:</label>
                      <div class="col-md-4 col-sm-3 col-xs-12">
                        <select class="form-control">
                          <option>Planned</option>
                          <option>Option one</option>
                          <option>Option two</option>
                          <option>Option three</option>
                          <option>Option four</option>
                        </select>
                      </div>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                      <div
                        class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button type="submit" class="btn btn-primary">Cancel</button>
                        <button type="submit" class="btn btn-success">Request
                          leave</button>
                      </div>
                    </div>

                  </form>
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
  <script src="<c:url value="/static/js/actionjs/lms_adm_003.js" />"></script>
  <script id="mytemplate" type="text/html">
    <option value="{{= TI}}">{{= TN}}</option>
   </script>
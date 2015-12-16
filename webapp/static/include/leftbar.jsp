<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<input type="hidden" value="${users.id }"/>
<div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="<c:url value="home"/>" class="site_title"><i class="fa fa-paw"></i> <span>Leave Management</span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                    	<a hreft="lms_profile.jsp">
	                        <div class="profile_pic">
	                            <img src="<c:url value="/static/images/img.jpg" />"alt="${user}" class="img-circle profile_img">
	                        </div>
	                        <div class="profile_info">
	                            <span>Welcome,</span>
	                            <h2>${user}</h2>
	                        </div>
	                     </a>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <sec:authorize access="hasRole('ADMIN') ">
                                <li><a  href="javascript:"><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                    	<li><a href="#"><i class="fa fa-star-half-empty"></i> An Employee</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_001" />">Leave Balances</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_002" />">List Leave Requested</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_003" />">New Leaves</a>
                                        </li>
                                        <li><a href="#"><i class="fa fa-star-half-empty"></i> An Manager</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_004" />">All Leave Requests</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_005" />">All Overtime Request</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="javascript:"><i class="fa fa-key"></i> Admin <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/admin/lms_adm_006" />">List of Users</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_008" />">Create Users</a>
                                        </li>
                                        <li><a href="#"><i class="fa fa-star-half-empty"></i> Leaves</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_011" />">List of Types</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="javascript:"><i class="fa fa-lightbulb-o"></i> HR <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                    	<li><a href="javascript:"><i class="fa fa-star-half-empty"></i> EMPLOYEE</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_014" />">List of employees</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_015" />">Organization</a>
                                        </li>
                                        <li><a href="javascript:"><i class="fa fa-star-half-empty"></i> CONTRACTS</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_019" />">List of Contracts</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_021" />">List of Positions</a>
                                        </li>
                                        <li><a href="javascript:"><i class="fa fa-star-half-empty"></i> REPORTS</a>
                                        </li>
                                        <li><a href="<c:url value="/admin/lms_adm_023" />">leave Balance</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="javascript:"><i class="fa fa-cog"></i>Validation<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/admin/lms_adm_024" />">Delegations</a>
                                        </li>
                                    </ul>
                                </li>
                                <sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
	                                <li><a href="javascript:"><i class="fa fa-pencil-square-o"></i> Request <span class="fa fa-chevron-down"></span></a>
	                                    <ul class="nav child_menu" style="display: none">
	                                    	<li><a href="javascript:"><i class="fa fa-star-half-empty"></i> Leaves</a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_027" />">Request leaves</a>
	                                        </li>
	                                        <li><a href="javascript:"><i class="fa fa-star-half-empty"></i> OVERTIME</a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_028" />">List of OT </a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_029" />">Request OT </a>
	                                        </li>
	                                    </ul>
	                                </li>
	                                <li><a href="javascript:"><i class="fa fa-calendar"></i> Calendar <span class="fa fa-chevron-down"></span></a>
	                                    <ul class="nav child_menu" style="display: none">
	                                        <li><a href="<c:url value="/admin/lms_adm_031"/> ">My Calendar</a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_032"/> ">My workmate</a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_033"/> ">My collaborators</a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_034"/> ">Department</a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_035"/> ">Global </a>
	                                        </li>
	                                        <li><a href="<c:url value="/admin/lms_adm_036"/> ">Tabular </a>
	                                        </li>
	                                    </ul>
	                                </li>
	                           </sec:authorize>
	                           </sec:authorize>
                            </ul>
                        </div>
                        <!-- <div class="menu_section">
                            <h3>Live On</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-bug"></i> Calendar <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="e_commerce.html">E-commerce</a>
                                        </li>
                                        <li><a href="projects.html">Projects</a>
                                        </li>
                                        <li><a href="project_detail.html">Project Detail</a>
                                        </li>
                                        <li><a href="contacts.html">Contacts</a>
                                        </li>
                                        <li><a href="profile.html">Profile</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="page_404.html">404 Error</a>
                                        </li>
                                        <li><a href="page_500.html">500 Error</a>
                                        </li>
                                        <li><a href="plain_page.html">Plain Page</a>
                                        </li>
                                        <li><a href="login.html">Login Page</a>
                                        </li>
                                        <li><a href="pricing_tables.html">Pricing Tables</a>
                                        </li>

                                    </ul>
                                </li>
                                <li><a><i class="fa fa-laptop"></i> Calendar <span class="label label-success pull-right">Coming Soon</span></a>
                                </li>
                            </ul>
                        </div> -->

                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>
            
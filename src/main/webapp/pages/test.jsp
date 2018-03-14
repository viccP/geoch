<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>MagmaLab</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/bootstrap.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/jquery-ui.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ui.jqgrid.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ace-fonts.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/css/main.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/select2.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/chosen.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/bootstrapvalidator/css/bootstrapValidator.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/tipped/tipped.css">

<!--[if lte IE 9]>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ace-part2.css" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ace-ie.css" />
<![endif]-->
<script src="<%=request.getContextPath()%>/resource/ace/js/ace-extra.js"></script>

<!--[if lte IE 8]>
	<script src="<%=request.getContextPath()%>/resource/ace/js/html5shiv.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/respond.js"></script>
<![endif]-->

</head>
<body class="no-skin">
	<!-- #section:basics/navbar.layout -->
	<div id="navbar" class="navbar navbar-default">
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand">
					<small>
						<i class="fa fa-cube"></i>
						MagmaLab
					</small>
				</a>
			</div>
			<div class="navbar-header pull-right">
				<ul class="nav ace-nav">
					<li class="grey">
						<span class="user-info" id="userInfo">
							<i class="ace-icon fa fa-user-circle-o"></i>
							你好，${tmUser.userName}
						</span>
					</li>
					<li>
						<a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false">
							<i class="ace-icon fa fa-bell"></i>
							<span class="badge badge-danger" id="tipNum"></span>
						</a>
						<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header" id="titleNum"></li>

							<li class="dropdown-content ace-scroll" style="position: relative;">
								<div class="scroll-track" style="display: block; height: 200px;">
									<div class="scroll-bar" style="height: 111px; top: 0px;"></div>
								</div>
								<div class="scroll-content" style="max-height: 200px;">
									<ul class="dropdown-menu dropdown-navbar" id="todoList"></ul>
								</div>
							</li>
							<li class="dropdown-footer">
								<a href="#" id="viewAll">
									查看所有
									<i class="ace-icon fa fa-arrow-right"></i>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#" id="logout">
							<i class="ace-icon fa fa-power-off"></i>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<div id="sidebar" class="sidebar responsive menu-min">
			<ul class="nav nav-list" id="menuCtn"></ul>
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content" id="pageContent">
					
				</div>
			</div>
		</div>
	</div>

	<!-- 修改用户信息模态框 -->
	<div class="modal fade" id="selfModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog create-user-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<i class="confirm-close fa fa-times"></i>
					</button>
					<h4 class="modal-title">
						<i class="ace-icon fa fa-address-card"></i>
						修改个人资料
					</h4>
				</div>
				<div class="modal-body" style="border-radius: 0px 0px 8px 8px;">
					<div class="signup-box widget-box no-border visible" id="signup-box">
						<div class="widget-body">
							<div class="widget-main">
								<div class="tabbable">
									<ul class="nav nav-tabs" id="myTab">
										<li class="active">
											<a data-toggle="tab" href="#password" aria-expanded="true">
												<i class="green ace-icon fa fa-lock bigger-120"></i>
												密码
											</a>
										</li>

										<li class="">
											<a data-toggle="tab" href="#basicInfo" aria-expanded="false">
												<i class="red ace-icon fa fa-user bigger-120"></i>
												个人信息
											</a>
										</li>
									</ul>
									<div class="tab-content">
										<div id="password" class="tab-pane fade active in">
											<form id="editPwdfForm">
												<input class="form-control input-mask-date" type="hidden" name="userId">
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-btn">
															<button class="btn btn-sm btn-info btn-user-tag" type="button">
																<i class="ace-icon fa fa-lock bigger-110"></i>
																旧的密码
															</button>
														</span>
														<input class="form-control input-mask-date" type="password" name="oldPwd">
													</div>
												</div>
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-btn">
															<button class="btn btn-sm btn-info btn-user-tag" type="button">
																<i class="ace-icon fa fa-unlock bigger-110"></i>
																新的密码
															</button>
														</span>
														<input class="form-control input-mask-date" type="password" name="newPwd">
													</div>
												</div>
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-btn">
															<button class="btn btn-sm btn-info btn-user-tag" type="button">
																<i class="ace-icon fa fa-unlock-alt bigger-110"></i>
																确认密码
															</button>
														</span>
														<input class="form-control input-mask-date" type="password" name="confirmPwd">
													</div>
												</div>
												<div class="space-12"></div>
												<div class="clearfix" style="width: 200px; margin: 0 auto;">
													<button class="width-45 pull-left btn btn-sm btn-default btn4" type="reset">
														<i class="ace-icon fa fa-refresh"></i>
														<span class="bigger-110">重置</span>
													</button>
													<button class="width-45 pull-right btn btn-sm btn-info" type="submit">
														<span class="bigger-110">确定</span>
														<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</form>
										</div>
										<div id="basicInfo" class="tab-pane fade">
											<form id="editSelfForm">
												<input class="form-control input-mask-date" type="hidden" name="userId">
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-btn">
															<button class="btn btn-sm btn-info btn-user-tag" type="button">
																<i class="ace-icon fa fa-user bigger-110"></i>
																登录名称
															</button>
														</span>
														<input class="form-control input-mask-date disabled" type="text" name="loginId" disabled="disabled">
													</div>
												</div>
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-btn">
															<button class="btn btn-sm btn-info btn-user-tag" type="button">
																<i class="ace-icon fa fa-ticket bigger-110"></i>
																用户姓名
															</button>
														</span>
														<input class="form-control input-mask-date" type="text" name="userName">
													</div>
												</div>
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-btn">
															<button class="btn btn-sm btn-info btn-user-tag" type="button">
																<i class="ace-icon fa fa-phone bigger-110"></i>
																联系方式
															</button>
														</span>
														<input class="form-control input-mask-date" type="text" name="phoneNo">
													</div>
												</div>
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-btn">
															<button class="btn btn-sm btn-info btn-user-tag" type="button">
																<i class="ace-icon fa fa-male bigger-110"></i>
																性别
															</button>
														</span>
														<select class="chosen-select form-control" name="sex" id="selfSex" data-placeholder="请选择性别...">
															<option value=""></option>
															<option value="0">女</option>
															<option value="1">男</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<textarea placeholder="请填写备注..." class="form-control" name="memo"></textarea>
												</div>
												<div class="space-12"></div>
												<div class="clearfix" style="width: 200px; margin: 0 auto;">
													<button class="width-45 pull-left btn btn-sm btn-default btn4" type="reset">
														<i class="ace-icon fa fa-refresh"></i>
														<span class="bigger-110">重置</span>
													</button>
													<button class="width-45 pull-right btn btn-sm btn-info" type="submit">
														<span class="bigger-110">确定</span>
														<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="footer">
		<div class="footer-inner">
			<!-- #section:basics/footer -->
			<div class="footer-content">
				<span class="bigger-120">
					<span class="blue bolder">MagmaLab</span>
					&copy; 2018
				</span>

				&nbsp; &nbsp;
				<span class="action-buttons">
					<a href="#">
						<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
					</a>
					<a href="#">
						<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
					</a>
					<a href="#">
						<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
					</a>
				</span>
			</div>
		</div>
	</div>

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery || document.write("<script src='<%=request.getContextPath()%>/resource/ace/js/jquery.js'>"+ "<"+"/script>");
	</script>
	<!-- <![endif]-->

	<!--[if IE]>
		<script type="text/javascript">
			 window.jQuery || document.write("<script src='<%=request.getContextPath()%>/resource/ace/js/jquery1x.js'>"+"<"+"/script>");
		</script>
	<![endif]-->
	<script src="<%=request.getContextPath()%>/resource/ace/js/bootstrap.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/jquery-ui.custom.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/jquery.knob.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/fuelux/fuelux.spinner.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.scroller.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.colorpicker.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.fileinput.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.typeahead.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.wysiwyg.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.spinner.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.treeview.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.wizard.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/elements.aside.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.ajax-content.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.touch-drag.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.sidebar.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.sidebar-scroll-1.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.submenu-hover.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.widget-box.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.settings.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.settings-rtl.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.settings-skin.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.widget-on-reload.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.searchbox-autocomplete.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/spin.js"></script>
	<script src="<%=request.getContextPath()%>/resource/common/base.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/bootbox.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/jqGrid/jquery.jqGrid.src.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/jqGrid/i18n/grid.locale-cn.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/select2.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/chosen.jquery.js"></script>
	<script src="<%=request.getContextPath()%>/resource/bootstrapvalidator/js/bootstrapValidator.js"></script>
	<script src="<%=request.getContextPath()%>/resource/echart/echarts.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/ace/js/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/resource/tipped/tipped.js"></script>
	<script src="<%=request.getContextPath()%>/resource/common/md5.js"></script>
</body>
</html>

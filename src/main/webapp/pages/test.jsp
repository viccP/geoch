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
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/bootstrap-editable.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/chosen.css">
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
							你好，${TM_USER.userName}
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
					<div class="col-xs-12 col-sm-9">
						<div class="profile-user-info profile-user-info-striped">
							<div class="profile-info-row">
								<div class="profile-info-name">H</div>
								<div class="profile-info-value">
									<span class="editable ele-tag">0.025</span>
								</div>
								<div class="profile-info-name">H</div>
								<div class="profile-info-value">
									<span class="editable ele-tag">0.025</span>
								</div>
								<div class="profile-info-name">H</div>
								<div class="profile-info-value">
									<span class="editable ele-tag">0.025</span>
								</div>
								<div class="profile-info-name">H</div>
								<div class="profile-info-value">
									<span class="editable ele-tag">0.025</span>
								</div>
								<div class="profile-info-name">H</div>
								<div class="profile-info-value">
									<span class="editable ele-tag">0.025</span>
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
	<script src="<%=request.getContextPath()%>/resource/ace/js/x-editable/bootstrap-editable.js"></script>

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
	<script>
	//editables on first profile page
	$.fn.editable.defaults.mode = 'inline';
	$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
    $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'+
                                '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';   
                                
    $('.ele-tag').editable({
		type: 'text'
    });
	</script>
	
</body>
</html>

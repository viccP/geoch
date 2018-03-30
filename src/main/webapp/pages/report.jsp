<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>实验报告</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/bootstrap.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/jquery-ui.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ui.jqgrid.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ace-fonts.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/bootstrap-editable.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/css/main.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/select2.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/chosen.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/bootstrapvalidator/css/bootstrapValidator.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/tipped/tipped.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/summernote/summernote.css">

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
	<div class="main-container" id="main-container">
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content" style="padding: 48px 120px 24px;">
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
	<script src="<%=request.getContextPath()%>/resource/ace/js/x-editable/ace-editable.js"></script>
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
	<script src="<%=request.getContextPath()%>/resource/summernote/summernote.js"></script>
	<script src="<%=request.getContextPath()%>/resource/summernote/lang/summernote-zh-CN.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/common/base64.js"></script>
	<script src="<%=request.getContextPath()%>/pages/js/report.js"></script>
</body>
</html>

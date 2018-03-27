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
				<div class="page-content" id="pageContent">
					<div class="click2edit">
						这是测试
						<p>这是测试
						<p>这是测试
						<p>这是测试
						<p>这是测试
						<p>
					</div>
					<button id="edit" class="btn btn-primary" onclick="edit()" type="button">Edit 1</button>
					<button id="save" class="btn btn-primary" onclick="save()" type="button">Save 2</button>
				</div>
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
	<script src="<%=request.getContextPath()%>/resource/summernote/summernote.js"></script>
	<script src="<%=request.getContextPath()%>/resource/summernote/lang/summernote-zh-CN.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/common/md5.js"></script>
	<script type="text/javascript">
		var edit = function() {
		  $('.click2edit').summernote({
			  focus: true,
			  lang:'zh-CN'
			});
		};

		var save = function() {
		  var markup = $('.click2edit').summernote('code');
		  $('.click2edit').summernote('destroy');
		  console.log(markup);
		};
	</script>
</body>
</html>

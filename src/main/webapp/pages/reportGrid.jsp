<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/reportGrid.js"></script>
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="well well-sm">
			<form class="form-inline" id="reportForm">
				<select class="chosen-select fix-select" name="userId" data-placeholder="请选择报告提交人...">
					<option value=""></option>
				</select>
				<select class="chosen-select fix-select" name="reportStatus" data-placeholder="请实验报告状态...">
					<option value=""></option>
					<option value="0">未批阅</option>
					<option value="1">已批阅</option>
				</select>
				<select class="chosen-select fix-select" name="reportScore" data-placeholder="请选择分数...">
					<option value=""></option>
				</select>
				<button type="button" class="btn btn-info btn-sm" id="searchReport">
					<i class="ace-icon fa fa-search bigger-110"></i>
					查询
				</button>
			</form>
		</div>
		<table id="grid-table"></table>
		<div id="grid-pager"></div>
	</div>
</div>
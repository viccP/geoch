<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/parameter.js"></script>
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="well well-sm">
			<form class="form-inline" id="searchUserForm">
				<select class="chosen-select" name="dataType" data-placeholder="请选择数据类型...">
					<option value="0">初始岩浆</option>
					<option value="1">初始熔体</option>
					<option value="2">标准化值</option>
					<option value="3">混染物体</option>
				</select>
				<select class="chosen-select" name="dataName" data-placeholder="请选择数据名称...">
				</select>
				<button type="button" class="btn btn-info btn-sm" id="addUser">
					<i class="ace-icon fa fa-plus-square-o bigger-110"></i>
					新建
				</button>
				<button type="button" class="btn btn-info btn-sm" id="addUser">
					<i class="ace-icon fa fa-cloud-upload bigger-110"></i>
					导入
				</button>
			</form>
		</div>

		<div class="row">
			<div id="user-profile-1" class="user-profile row">
				<div class="profile-user-info profile-user-info-striped" id="ele-tbl"></div>
			</div>
		</div>
		<div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="button">
					<i class="ace-icon fa fa-check bigger-110"></i>
					Save
				</button>

				&nbsp; &nbsp;
				<button class="btn" type="reset">
					<i class="ace-icon fa fa-undo bigger-110"></i>
					Reset
				</button>
			</div>
		</div>
	</div>
</div>
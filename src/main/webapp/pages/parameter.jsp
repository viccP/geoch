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
				<button type="button" class="btn btn-info btn-sm" id="addBasicData">
					<i class="ace-icon fa fa-plus-square-o bigger-110"></i>
					新建
				</button>
				<button type="button" class="btn btn-info btn-sm" id="importBasicData">
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
		<div class="clearfix form-actions" id="basic-save-div"></div>
	</div>
</div>

<!-- 新增模态框 -->
<div class="modal fade" id="basicDataModal" tabindex="-1" role="dialog" aria-labelledby="basicDataModal" aria-hidden="true">
	<div class="modal-dialog create-user-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="confirm-close fa fa-times"></i>
				</button>
				<h4 class="modal-title">
					<i class="ace-icon fa fa-save"></i>
					保存基础数据
				</h4>
			</div>
			<div class="modal-body" style="border-radius: 0px 0px 0px 0px;">
				<div class="signup-box widget-box no-border visible" id="signup-box">
					<div>
						<label for="form-field-select-3">数据类型</label>
						<br>
						<select class="chosen-select" name="dataTypeM" data-placeholder="请选择数据类型...">
							<option value="0">初始岩浆</option>
							<option value="1">初始熔体</option>
							<option value="2">标准化值</option>
							<option value="3">混染物体</option>
						</select>
					</div>
					<div class="space-12"></div>
					<hr>
					<div>
						<label for="form-field-select-3">数据名称</label>
						<br>
						<input class="form-control" id="dataNameM" type="text">
					</div>

					<div class="space-12"></div>
					<div class="clearfix" style="width: 200px; margin: 0 auto;">
						<button class="width-45 pull-right btn btn-sm btn-info" type="button" id="mSubmit">
							<span class="bigger-110">确定</span>
							<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
						</button>
						<button class="width-45 pull-left btn btn-sm btn-default btn4" type="button" id="mClose">
							<i class="ace-icon fa fa-remove"></i>
							<span class="bigger-110">取消</span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

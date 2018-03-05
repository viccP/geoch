<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/applyRecord.js"></script>
<div class="row">
	<div class="col-xs-12" id="applyMain">
		<!-- PAGE CONTENT BEGINS -->
		<div class="well well-sm">
			<form class="form-inline" id="searchApplyForm">
				<select class="chosen-select fix-select" name="status" data-placeholder="请选择状态...">
					<option value=""></option>
					<option value="">全部</option>
					<option value="0">完成</option>
					<option value="1">待审批</option>
					<option value="2">驳回</option>
				</select>
				<input name="applyId" type="hidden">
				<button type="button" class="btn btn-info btn-sm" id="searchUser">
					<i class="ace-icon fa fa-search bigger-110"></i>
					查询
				</button>
			</form>
		</div>
		<table id="grid-table"></table>
		<div id="grid-pager"></div>
	</div>
</div>

<!-- 审批模态框 -->
<div class="modal fade" id="approveModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog create-user-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="confirm-close fa fa-times"></i>
				</button>
				<h4 class="modal-title">
					<i class="ace-icon fa fa-comment-o"></i>
					审批操作
				</h4>
			</div>
			<div class="modal-body" style="border-radius: 0px 0px 8px 8px;">
				<div class="signup-box widget-box no-border visible" id="signup-box">
					<div class="widget-body">
						<div class="widget-main">
							<form id="approveForm">
								<div class="control-group">
									<div class="radio">
										<label>
											<input name="status" type="radio" class="ace" value="0">
											<span class="lbl"> 通过</span>
										</label>
									</div>

									<div class="radio">
										<label>
											<input name="status" type="radio" class="ace" value="2">
											<span class="lbl"> 驳回</span>
										</label>
									</div>
								</div>
								<input name="applyId" type="hidden">
								<div class="space-12"></div>
								<div class="form-group">
									<textarea placeholder="请填写审批意见..." class="form-control" name="rejectMsg"></textarea>
								</div>
								<div class="space-12"></div>
								<div class="clearfix" style="width: 200px; margin: 0 auto;">
									<button class="width-45 pull-left btn btn-sm btn-default btn4" type="reset">
										<i class="ace-icon fa fa-refresh"></i>
										<span class="bigger-110">重置</span>
									</button>
									<button class="width-45 pull-right btn btn-sm btn-info" type="button" id="approveBtn">
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
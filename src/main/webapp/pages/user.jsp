<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/user.js"></script>
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="well well-sm">
			<form class="form-inline" id="searchUserForm">
				<input class="input-large" placeholder="请输入登录用户名" type="text" name="loginId">
				<input class="input-large" placeholder="请输入用户姓名" type="text" name="userName">
				<select class="chosen-select fix-select" name="sex" data-placeholder="请选择性别...">
					<option value=""></option>
					<option value="">全部</option>
					<option value="0">女</option>
					<option value="1">男</option>
				</select>
				<select class="chosen-select fix-select" name="pwdStatus" data-placeholder="请选择密码状态...">
					<option value=""></option>
					<option value="">全部</option>
					<option value="0">初始密码</option>
					<option value="1">已经修改</option>
				</select>
				<button type="button" class="btn btn-info btn-sm" id="searchUser">
					<i class="ace-icon fa fa-search bigger-110"></i>
					查询
				</button>
				<button type="button" class="btn btn-info btn-sm" id="addUser">
					<i class="ace-icon fa fa-plus-square-o bigger-110"></i>
					新建
				</button>
			</form>
		</div>
		<table id="grid-table"></table>
		<div id="grid-pager"></div>
	</div>
</div>

<!-- 用户模态框 -->
<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog create-user-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="confirm-close fa fa-times"></i>
				</button>
				<h4 class="modal-title">
					<i class="ace-icon fa fa-users"></i>
					新建用户
				</h4>
			</div>
			<div class="modal-body" style="border-radius: 0px 0px 8px 8px;">
				<div class="signup-box widget-box no-border visible" id="signup-box">
					<div class="widget-body">
						<div class="widget-main">
							<form id="createUserForm">
								<input class="form-control input-mask-date" type="hidden" name="userId">
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-btn">
											<button class="btn btn-sm btn-info btn-user-tag" type="button">
												<i class="ace-icon fa fa-user bigger-110"></i>
												登录名称
											</button>
										</span>
										<input class="form-control input-mask-date" type="text" name="loginId">
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
										<select class="chosen-select form-control" name="sex" id="sex" data-placeholder="请选择性别...">
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
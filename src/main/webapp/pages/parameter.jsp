<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/parameter.js"></script>
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

		<div class="row">
			<div id="user-profile-1" class="user-profile row">
				<div class="profile-user-info profile-user-info-striped">
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">He|氦</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
						<div class="profile-info-name">H|氢</div>
						<div class="profile-info-value">
							<span class="editable username">0.0065</span>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
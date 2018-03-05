/**
 * 
 */
$(function() {

	//清除页面数据
	cleanBodyData();
	
	//根据权限重置菜单
	$("#menuCtn").empty();
	$.ajax({
		url : $.cxt + '/index/isAdmin',
		type : "POST",
		dataType:"json",
		async:false,
		success : function(json) {
			if(json.data){
				$("#menuCtn")
				.append(
					$("<li></li>").append(
						$("<a></a>").addClass("dropdown-toggle menu-anchor").attr({"href":"#","path":$.cxt+"/pages/user.jsp"})
						.append($("<i></i>").addClass("menu-icon fa fa-user"))
						.append($("<span></span>").addClass("menu-text").append("用户管理"))
					)
				)
//				.append(
//					$("<li></li>").append(
//						$("<a></a>").addClass("dropdown-toggle menu-anchor").attr({"href":"#","path":$.cxt+"/pages/applyRecord.jsp"})
//						.append($("<i></i>").addClass("menu-icon fa fa-history"))
//						.append($("<span></span>").addClass("menu-text").append("申请记录"))
//					)
//				)
			}
			else{
				$("#menuCtn")
				.append(
					$("<li></li>").append(
						$("<a></a>").addClass("dropdown-toggle menu-anchor").attr({"href":"#","path":$.cxt+"/pages/crystal.jsp"})
						.append($("<i></i>").addClass("menu-icon fa fa-sitemap"))
						.append($("<span></span>").addClass("menu-text").append("结晶过程"))
					)
				)
//				.append(
//					$("<li></li>").append(
//						$("<a></a>").addClass("dropdown-toggle menu-anchor").attr({"href":"#","path":$.cxt+"/pages/applyRecord.jsp"})
//						.append($("<i></i>").addClass("menu-icon fa fa-history"))
//						.append($("<span></span>").addClass("menu-text").append("申请记录"))
//					)
//				)
			}
		}
	});
	
	$('#selfSex').chosen({
		disable_search : true,
		width : "100%"
	});
	
	//初始化菜单点击事件
	$(".menu-anchor").on("click", function() {

		//清空容器
		$("#pageContent").empty();
		cleanBodyData();
		//加载页面
		$.get($(this).attr("path"), function(data) {
			$("#pageContent").html(data);//初始化加载界面  
		});
	});
	
	
	//提示栏事件
	$("#viewAll").on("click",function(){
		//加载页面
		$.get($.cxt+"/pages/applyRecord.jsp", function(data) {
			$("#pageContent").html(data);//初始化加载界面  
		});
	});

	//初始加载
	initFirstPage();
	
	//初始化个人资料修改
	$("#userInfo").on("click",function(){
		openModalMain();
	});
	
	//初始化修改密码
	initPwd();
	
	//初始化修改基本信息
	initBasicInfo();
	
	//密码状态检验
	validatePwd();
	
	//初始化待办列表
	initTodoList();
	
	//初始化登出按钮
	$("#logout").on("click",function(){
		//提示框打开
	    bootbox.confirm({
	        title: "消息提示",
	        message: "确定退出么?",
	        size:"small",
	        buttons: {
	            cancel: {
	                label: '<i class="fa fa-times"></i> 取消'
	            },
	            confirm: {
	                label: '<i class="fa fa-check"></i> 确定'
	            }
	        },
	        callback: function (result) {
	        		if(result){
	        			$.ajax({
	        				url : $.cxt + '/index/logout',
	        				type : "POST",
	        				dataType:"json",
	        				success : function(json) {
	        					if (json.code == '0') {
	        						location.href = $.cxt+"/pages/login.jsp";
	        					}
	        				}
	        			});
	        		}
	        }
	    });
	});

});

/**
 * 初始加载第一页
 * @returns
 */
function initFirstPage() {
	//获取链接地址
	var path = $(".menu-anchor:first").attr("path");

	//清空容器
	$("#pageContent").empty();

	//加载页面
	$.get(path, function(data) {
		$("#pageContent").html(data);//初始化加载界面  
	});
}

/**
 * 打开模态框
 * @returns
 */
function openModalMain(customMsg){
	$("#selfModal").modal({
		backdrop : 'static',
		keyboard : false,
		show : true
	});
	
	// 清除form的验证状态
	$('#editPwdfForm').bootstrapValidator('resetForm', 'true');
	document.getElementById("editPwdfForm").reset();
	
	$('#editSelfForm').bootstrapValidator('resetForm', 'true');
	document.getElementById("editSelfForm").reset();
	if(customMsg){
		$("#selfModal .modal-title").empty().append($("<i></i>").addClass("ace-icon fa fa-pencil-square-o")).append(customMsg);
	}else{
		$("#selfModal .modal-title").empty().append($("<i></i>").addClass("ace-icon fa fa-address-card")).append("修改个人资料");
	}
	
	//获取个人信息
	$.ajax({
		url : $.cxt + '/user/get',
		type : "POST",
		dataType:"json",
		success : function(json) {
			if (json.code == "0") {
				$.each(json.data,function(key,value){
					$("#editSelfForm input[name="+key+"]").val(value);
					if(key=="sex"){
						$("#selfSex").val(value);
						$("#selfSex").trigger('chosen:updated');
					}
					if(key=="memo"){
						$("#editSelfForm textarea[name="+key+"]").val(value);
					}
				});
			}
		}
	});
}

/**
 * 初始化修改密码
 * @returns
 */
function initPwd(){
	$('#editPwdfForm').bootstrapValidator({
		fields : {
			oldPwd : {
				validators : {
					notEmpty : {message : '请输入旧的密码'},
					regexp : {regexp : /^.*$/,message : '旧密码验证错误，请重新输入旧密码'}
				}
			},
			newPwd : {
				validators : {
					notEmpty : {message : '请输入新的密码'},
					regexp : {regexp : /^.{8,}$/,message : '请输入超过7位字符'}
				}
			},
			confirmPwd : {validators : {
					notEmpty : {message : '请输入确认密码'},
					regexp : {regexp : /^.*$/,message : '新密码两次输入不一致，请重新输入'}
				}
			}
		},
		submitHandler : function(validator, form, submitButton) {
			var oldPwd = $.md5($("#editPwdfForm input[name=oldPwd]").val());
			var newPwd = $.md5($("#editPwdfForm input[name=newPwd]").val());
			var confirmPwd = $.md5($("#editPwdfForm input[name=confirmPwd]").val());
			$.ajax({
				url : $.cxt + '/index/modifyPwd',
				data : {"oldPwd":oldPwd,"newPwd":newPwd,"confirmPwd":confirmPwd},
				type : "POST",
				dataType:"json",
				async:false,
				loading:true,
				success : function(data) {
					if (data.code == "1") {
						validator.updateStatus("oldPwd",'INVALID', "regexp");
					} else if (data.code == "2") {
						validator.updateStatus("confirmPwd",'INVALID', "regexp");
					} else{
						// 关闭窗口
						$('#selfModal').modal('hide');
					}
			}});
		}
	});
}

/**
 * 检查密码状态
 * @returns
 */
function validatePwd(){
	$.ajax({
		url : $.cxt + '/index/vlidatePwd',
		type : "POST",
		dataType:"json",
		async:false,
		loading:true,
		success : function(data) {
			if (data.code == "1") {
				openModalMain("您的密码为初始密码，建议您尽快修改");
			}
		}
	});
}

/**
 * 初始化个人信息修改
 * @returns
 */
function initBasicInfo(){
	$('#editSelfForm').bootstrapValidator({
		fields : {
			userName : {validators : {
					notEmpty : {message : '请输入用户名称'}
				}
			},
			phoneNo : {validators : {
					regexp : {regexp : /^[0-9_]{11}$/,message : '手机号码格式不正确'}
				}
			},
			sex : {
				validators : {
					regexp : {regexp : /^.*$/,message : '请选择性别'}
				}
			}
		},
		submitHandler : function(validator, form, submitButton) {
			$.ajax({
				url : $.cxt + '/user/edit',
				data : JSON.stringify($('#editSelfForm').serializeObject()),
				type : "POST",
				contentType: "application/json",
				dataType:"json",
				loading:true,
				success : function(data) {
					if (data.code == "2") {
						validator.updateStatus("sex",'INVALID', "regexp");
					} else{
						// 关闭窗口
						$('#selfModal').modal('hide');
					}
			}});}
		});
}

/**
 * 初始化待办列表
 * @returns
 */
function initTodoList(){
	$.ajax({
		url : $.cxt + '/index/getTodoList',
		type : "POST",
		dataType:"json",
		success : function(json) {
			var tipNum=json.data.length;
			
			//设置提数数目
			$("#tipNum").empty()
			if(tipNum>0){
				$("#tipNum").append(tipNum);
			}
			$("#titleNum").empty().append($("<i></i>").addClass("ace-icon fa fa-envelope-o")).append(tipNum+"条待办");
			
			//生成下拉菜单
			$("#todoList").empty();
			$.each(json.data,function(index,val){
				$("#todoList").append($("<li></li>").append(
					$("<a></a>").attr({"href":"#","applyId":val.applyId}).addClass("clearfix").append(
						$("<span></span>").addClass("msg-body")
						.append(
							$("<span></span>").addClass("msg-title").append($("<span></span>").addClass("blue").append(val.applyUser+":")).append(val.proType)
						)
						.append(
							$("<span></span>").addClass("msg-time")
							.append($("<i></i>").addClass("ace-icon fa fa-clock-o"))
							.append($($("<span></span>")).append(val.applyTime))
						)
					)
					.on("click",function(){
						//加载页面
						$.get($.cxt+"/pages/applyRecord.jsp?", function(data) {
							$("body").data("applyIdArgs",val.applyId);
							$("#pageContent").html(data);//初始化加载界面  
						});
					})
				));
			});
		}
	});
}

/**
 * 清除页面数据
 * @returns
 */
function cleanBodyData(){
	$("body").data("applyIdArgs","");
	$("body").data("applyPro","");
}
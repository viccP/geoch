/**
 * 
 */
$(function() {

	//清除页面数据
	cleanBodyData();
	
	// 初始化用户下拉菜单
	$('.fix-select').chosen({
		disable_search : true,
		width : "10%"
	});
	
	
	$('#sex').chosen({
		disable_search : true,
		width : "100%"
	});
	
	
	// 初始化列表
	initGrid();
	
	// 初始化搜索按钮
	$('#searchUser').on('click', function() {
		doSearch();
	});
	
	// 打开新增窗口
	$("#addUser").on("click",function(){
		openModal(true);
	});
	
	// 提交修改
	$('#createUserForm').bootstrapValidator({
		fields : {
			loginId : {
				validators : {
					notEmpty : {message : '请输入登录名称'},
					regexp : {regexp : /^[a-zA-Z0-9_]+$/,message : '登录名称不合法或者登录名称已经存在'}
				}
			},
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
				data : JSON.stringify($('#createUserForm').serializeObject()),
				type : "POST",
				contentType: "application/json",
				dataType:"json",
				loading:true,
				success : function(data) {
					if (data.code == "1") {
						validator.updateStatus("loginId",'INVALID', "regexp");
					} else if (data.code == "2") {
						validator.updateStatus("sex",'INVALID', "regexp");
					} else{
						// 关闭窗口
						$('#userModal').modal('hide');
						// 刷新页面
						$("#grid-table").jqGrid().trigger('reloadGrid');
					}
			}});}
		});
});

/**
 * 初始化列表
 * 
 * @returns
 */
function initGrid() {
	$('#grid-table').jqGrid({
		url : $.cxt + "/user/list",
		ajaxGridOptions:{contentType: "application/json"},
		serializeGridData: function (postData)
         {
             if (postData.searchField === undefined) postData.searchField = null;
             if (postData.searchString === undefined) postData.searchString = null;
             if (postData.searchOper === undefined) postData.searchOper = null;
             return JSON.stringify(postData);
         },
		datatype : "json",
		mtype : "POST",
		height : 370,
		// autowidth : true,
		width : $(".page-content").width() - 20,
		colNames : [ '用户ID', '登录用户名', '用户姓名', '用户性别', '联系方式', '更新时间', '密码状态', '备注', '操作' ],
		colModel : [ 
					{ name : 'userId', align : 'center', index : 'userId', sorttype : "int", editable : false, hidden : true }, 
					{ name : 'loginId', align : 'center', index : 'login', sorttype : "int", editable : false }, 
					{ name : 'userName', align : 'center', index : 'userName', sorttype : "int", editable : false },
					{ name : 'sex', align : 'center', index : 'sex', sorttype : "int", editable : false, formatter : encodeSex },
					{ name : 'phoneNo', align : 'center', index : 'phoneNo', sorttype : "int", editable : false },
					{ name : 'updTime', align : 'center', index : 'updTime', sorttype : "date", editable : false,formatter:"date",formatoptions: {srcformat:'u',newformat:'Y-m-d H:i:s'}}, 
					{ name : 'pwdStatus', align : 'center', index : 'pwdStatus', sorttype : "int", editable : false,formatter : encodePwdStatus}, 
					{ name : 'memo', align : 'center', index : 'memo', sorttype : "int", editable : false }, 						
					{ name : 'act', align : 'center', index : 'act', search : false, sortable : false, editable : false, formatter : renderOperation } 
				], 
		viewrecords : true, 
		rowNum : 10, 
		rowList : [ 10, 20, 30 ], 
		pager : '#grid-pager', 
		altRows : true,
		multiselect : true, 
		multiboxonly : true, 
		loadComplete : function() {
			var table=this;
			setTimeout(function() {arrageGrid(table);}, 0);
		}, 
		caption : "用户信息列表" 
	});
}

/**
 * 调整列表
 * 
 * @returns
 */
function arrageGrid(table) {
	
	// 1.标题居中
	$('.ui-jqgrid-sortable').css("text-align", "center");
	
	// 2.更换分页图标
	var replacement = {
		'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
		'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
		'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
		'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
		};
	
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
		var icon = $(this);
		var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
		if ($class in replacement)
			icon.attr('class', 'ui-icon ' + replacement[$class]);
	})
	
	// 3.激活提示
	$('.navtable .ui-pg-button').tooltip({
		container : 'body'
	});
	$(table).find('.ui-pg-div').tooltip({
		container : 'body'
	});

}

/**
 * 转义用户性别
 * 
 * @param cellvalue
 * @returns
 */
function encodeSex(cellvalue) {
	return cellvalue == '1' ? '男' : '女';
}

/**
 * 转义密码状态
 * 
 * @param cellvalue
 * @returns
 */
function encodePwdStatus(cellvalue){
	return cellvalue == '1' ? '已经修改' : '初始密码';
}


/**
 * 渲染操作列
 */
function renderOperation(cellvalue, options, cell) {
	var container = $("<div><div>")
				.append(
					$("<button></button>")
					.append($("<i></i>").addClass("ace-icon bigger-130 fa fa-pencil-square-o green"))
					.attr("onclick", "editUser('" + cell.userId + "')")
					.addClass("btn btn-xs grid-btn grids-btn")
					.attr("title", "编辑")
				)
				.append(
					$("<button></button>")
					.append($("<i></i>").addClass("ui-icon bigger-130 fa fa fa-trash-o red"))
					.attr("onclick","delUser('" + cell.userId + "')")
					.addClass("btn btn-xs grid-btn grids-btn")
					.attr("title", "删除")
				)
				.append(
					$("<button></button>")
					.append($("<i></i>").addClass("ui-icon bigger-130 fa fa-recycle  blue"))
					.attr("onclick", "initPwd('" + cell.userId + "')")
					.addClass("btn btn-xs grid-btn grids-btn")
					.attr("title", "初始化密码")
				)
	return container.html();
}

/**
 * 检索
 * 
 * @returns
 */
function doSearch(){
	$("#grid-table").jqGrid('setGridParam', {
		url : $.cxt + "/user/list",
		datatype : 'json',
		postData : {"tmUser" : $('#searchUserForm').serializeObject()},
	}).trigger('reloadGrid');
}

/**
 * 删除用户
 * @param userId
 * @returns
 */
function delUser(userId){
	//提示框打开
    bootbox.confirm({
        title: "消息提示",
        message: "确定删除该用户?",
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
        				url : $.cxt + '/user/delete',
        				data : {"userId" : userId},
        				type : "POST",
        				dataType:"json",
        				success : function(data) {
        					// 刷新页面
        					$("#grid-table").jqGrid().trigger('reloadGrid');
        				}
        			});
        		}
        }
    });
}

/**
 * 编辑用户
 * @param userId
 * @returns
 */
function editUser(userId){
	$.ajax({
		url : $.cxt + '/user/get',
		data : {"userId" : userId},
		type : "POST",
		dataType:"json",
		success : function(json) {
			// 刷新页面
			if(json.code=="0"){
				openModal(false);
				$.each(json.data,function(key,value){
					$("#createUserForm input[name="+key+"]").val(value);
					if(key=="sex"){
						$("#sex").val(value);
						$("#sex").trigger('chosen:updated');
					}
					
					if(key=="memo"){
						$("#createUserForm textarea[name="+key+"]").val(value);
					}
				});
			}
		}
	});
}

/**
 * 初始化密码
 * @param userId
 * @returns
 */
function initPwd(userId){
	//提示框打开
    bootbox.confirm({
        title: "消息提示",
        message: "确定重置该用户密码么?",
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
        				url : $.cxt + '/user/initPwd',
        				data : {"userId" : userId},
        				type : "POST",
        				dataType:"json",
        				success : function(data) {
        					// 刷新页面
        					$("#grid-table").jqGrid().trigger('reloadGrid');
        				}
        			});
        		}
        }
    });
}




/**
 * 打开用户模态框
 * @param flag
 * @returns
 */
function openModal(flag){
	$("#userModal").modal({
		backdrop : 'static',
		keyboard : false,
		show : true
	});
	//清除下拉框状态
	$("#sex").val("");
	$("#sex").trigger("chosen:updated");
	
	// 清除form的验证状态
	$('#createUserForm').bootstrapValidator('resetForm', 'true');
	document.getElementById("createUserForm").reset();
	if(!flag){
		$("#userModal .modal-title").empty().append($("<i></i>").addClass("ace-icon fa fa-pencil-square-o")).append("编辑用户");
	}
}
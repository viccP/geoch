/**
 * 
 */
$(function() {

	//获取URL参数
	var applyId=$("body").data("applyIdArgs")||"";
	
	// 初始化用户下拉菜单
	$('.fix-select').chosen({
		disable_search : true,
		width : "10%"
	});

	// 初始化列表
	initGrid(applyId);
	
	//初始化Form
	$.ajax({
		url : $.cxt + '/index/isAdmin',
		type : "POST",
		dataType:"json",
		async:false,
		success : function(json) {
			// 刷新页面
			if(json.data){
				
				//添加搜索项
				$("#searchApplyForm").prepend(
					$("<input></input>").addClass("input-large").attr({"placeholder":"请输入申请人用户名","type":"text","name":"applyUser"})
				);
			}
		}
	});
	
	// 初始化搜索按钮
	$('#searchUser').on('click', function() {
		doSearch();
	});
	
	//初始化审批提交按钮
	$("#approveBtn").on("click",function(){
		$.ajax({
			url : $.cxt + '/apply/approve',
			type : "POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify($('#approveForm').serializeObject()),
			success : function(data) {
				// 关闭窗口
				$('#approveModal').modal('hide');
				// 刷新页面
				$("#grid-table").jqGrid().trigger('reloadGrid');
				//更新tip数
				initTodoList();
			}
		});
	});
	
});

/**
 * 初始化列表
 * 
 * @returns
 */
function initGrid(applyId) {
	$('#grid-table').jqGrid({
		url : $.cxt + "/apply/getApplyRecords",
		ajaxGridOptions:{contentType: "application/json"},
		serializeGridData: function (postData)
         {
             if (postData.searchField === undefined) postData.searchField = null;
             if (postData.searchString === undefined) postData.searchString = null;
             if (postData.searchOper === undefined) postData.searchOper = null;
             return JSON.stringify(postData);
         },
		datatype : "json",
		postData : {"applyId":applyId},
		mtype : "POST",
		height : 370,
		// autowidth : true,
		width : $(".page-content").width() - 20,
		colNames : [ '申请ID', '申请人', '产品',"车型", '申请金额','申请状态', '申请时间','审批意见', '操作' ],
		colModel : [ 
					{ name : 'applyId', align : 'center',  editable : false, hidden : true }, 
					{ name : 'applyUser', align : 'center',width:"5%", editable : false }, 
					{ name : 'proType', align : 'center',width:"15%",  editable : false },
					{ name : 'applyCar', align : 'center',width:"20%",  editable : false },
					{ name : 'loanVal', align : 'center',width:"10%",  editable : false },
					{ name : 'status', align : 'center',  width:"10%",editable : false,formatter : encodeStatus}, 
					{ name : 'applyTime', align : 'center',width:"20%", editable : false},
					{ name : 'rejectMsg', align : 'center', width:"20%",align:"left",editable : false },
					{ name : 'act', align : 'center', width:"10%",search : false, sortable : false, editable : false, formatter : renderOperation } 
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
		caption : "申请记录列表" 
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
 * 转义申请状态
 * 
 * @param cellvalue
 * @returns
 */
function encodeStatus(cellvalue){
	if(cellvalue=='0'){
		return "完成";
	}
	else if(cellvalue=='1'){
		return "待审批";
	}
	else{
		return "驳回";
	}
}


/**
 * 渲染操作列
 */
function renderOperation(cellvalue, options, cell) {
	var container = $("<div><div>");
	if(cell.admin){
		if(cell.status=="1"){
			container.append(
				$("<button></button>")
				.append($("<i></i>").addClass("ui-icon bigger-130 fa fa-commenting-o red"))
				.attr("onclick","approve('" + cell.applyId + "')")
				.addClass("btn btn-xs grid-btn grids-btn")
				.attr("title", "审批")
			)
		}else if(cell.status=="2"){
			container.append(
				$("<button></button>")
				.append($("<i></i>").addClass("ui-icon bigger-130 fa fa-spinner fa-spin orange"))
				.addClass("btn btn-xs grid-btn grids-btn")
				.attr("title", "等待用户回执")
			)
		} else{
			container.append(
				$("<button></button>")
				.append($("<i></i>").addClass("ui-icon bigger-130 fa fa-check green"))
				.addClass("btn btn-xs grid-btn grids-btn")
				.attr("title", "完成")
			)
		}
	}
	else{
		if(cell.status=="1"){
			container.append(
				$("<button></button>")
				.append($("<i></i>").addClass("ui-icon bigger-130 fa fa-spinner fa-spin orange"))
				.addClass("btn btn-xs grid-btn grids-btn")
				.attr("title", "等待管理员审批")
			)
		}else if(cell.status=="2"){
			container.append(
				$("<button></button>")
				.append($("<i></i>").addClass("ui-icon bigger-130 fa fa-pencil-square-o green"))
				.attr("onclick","edit('" + cell.applyId + "')")
				.addClass("btn btn-xs grid-btn grids-btn")
				.attr("title", "重新填写")
			)
		} else{
			container.append(
				$("<button></button>")
				.append($("<i></i>").addClass("ui-icon bigger-130 fa fa-check green"))
				.addClass("btn btn-xs grid-btn grids-btn")
				.attr("title", "完成")
			)
		}	
	}
	return container.html();
}

/**
 * 检索
 * 
 * @returns
 */
function doSearch(){
	$("#grid-table").jqGrid('setGridParam', {
		postData : $('#searchApplyForm').serializeObject(),
	}).trigger('reloadGrid');
}

/**
 * 审批
 * @param userId
 * @returns
 */
function approve(applyId){
	$("#approveModal").modal({
		backdrop : 'static',
		keyboard : false,
		show : true
	});
	$("#approveForm input[name=applyId]").val(applyId);
}

/**
 * 重新填写
 * @param applyId
 * @returns
 */
function edit(applyId){
	//加载页面
	$.get($.cxt+"/pages/apply.jsp", function(data) {
		$("body").data("applyIdArgs",applyId);
		$("#pageContent").html(data);//初始化加载界面  
	});
}



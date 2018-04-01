/**
 * 
 */
$(function() {

	$.ajax({
		url : $.cxt+'/index/isTeacher',
		type : "POST",
		dataType:"json",
		success : function(json) {
			if(json.data){
				//初始化学生下拉菜单
				initSelect({
					"id":".chosen-select[name=userId]",
					"url":$.cxt + '/report/userSelect'
				});
			}
			else{
				$(".chosen-select[name=userId]").remove();
			}
		}
	});
	
	
	//初始化分数下拉菜单
	initSelect({
		"id":".chosen-select[name=reportScore]",
		"url":$.cxt + '/report/scoreSelect'
	});
	
	
	//初始化报告状态下拉菜单
	initSelect({"id":".chosen-select[name=reportStatus]"});
	
	// 初始化列表
	initGrid();
	
	// 初始化搜索按钮
	$('#searchReport').on('click', function() {
		doSearch();
	});
});

/**
 * 初始化列表
 * 
 * @returns
 */
function initGrid() {
	$('#grid-table').jqGrid({
		url : $.cxt + "/report/list",
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
		colNames : [ '实验报告ID','提交人', '更新时间', '报告状态', '分数', '操作' ],
		colModel : [ 
					{ name : 'reportId', align : 'center', index : 'reportId', editable : false, hidden : true }, 
					{ name : 'userName', align : 'center', index : 'userName',editable : false },
					{ name : 'updTime', align : 'center', index : 'updTime', sorttype : "date", editable : false,formatter:"date",formatoptions: {srcformat:'u',newformat:'Y-m-d H:i:s'}}, 
					{ name : 'reportStatus', align : 'center', index : 'reportStatus',editable : false,formatter:decodeStatus}, 
					{ name : 'reportScore', align : 'center', index : 'reportScore',editable : false }, 						
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
 * 转义实验报告状态
 * 
 * @param cellvalue
 * @returns
 */
function decodeStatus(cellvalue) {
	return cellvalue == '1' ? '已批阅' : '未批阅';
}


/**
 * 渲染操作列
 */
function renderOperation(cellvalue, options, cell) {
	var container = $("<div><div>")
				.append(
					$("<button></button>")
					.append($("<i></i>").addClass("ace-icon bigger-130 fa fa-eye green"))
					.attr("onclick", "view('" + cell.reportId + "','"+cell.teacher + "')")
					.addClass("btn btn-xs grid-btn grids-btn")
					.attr("title", "查看")
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
		url : $.cxt + "/report/list",
		datatype : 'json',
		postData : $('#reportForm').serializeObject(),
	}).trigger('reloadGrid');
}

/**
 * 查看报告
 * @param reportId
 * @param isTeacher
 * @returns
 */
function view(reportId){
	$.ajax({
		url : $.cxt+'/report/refresh',
		type : "POST",
		dataType:"json",
		data:{id:reportId},
		success:function(){
			initTodoList();
			window.open($.cxt + '/pages/reportView.jsp?reportId='+reportId);
		}
	});
}

/**
 * 获取下拉菜单
 * @param opt{id,url,data}
 * @returns
 */
 function initSelect(opt){
 	var _this=$(opt.id);
 	if(opt.url){
		//增加提示值
		if(!opt.multiple){
			_this.append(
				$("<option></option>").attr("value","").append(_this.attr("data-placeholder"))	
				)
		}
		$.ajax($.extend({data:opt.data},{
			url:opt.url,
			type : "POST",
			dataType:"json",
			async:false,
			success : function(json) {
				//生成列表
				$.each(json.data,function(index,val){
					_this
					.append(
						$("<option></option>").attr("value",val.code).append(val.value)
						)
				});
				
				//初始化下拉菜单
				_this.chosen({
					disable_search : true,
					width:'20%'
				});
			}
		}));
	}
	else{
		//增加提示值
		if(!opt.multiple){
			_this.prepend(
				$("<option></option>").attr("value","").append(_this.attr("data-placeholder"))	
				)
		}
		//初始化下拉菜单
		_this.chosen({
			disable_search : true,
			width:'20%'
		});
	}
}
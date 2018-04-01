$(function(){
	
	//加载页面
	initReport();
	
});

/**
 * 初始化报告
 * @returns
 */
function initReport(){
	$(".page-content").empty()
	.append($("<div></div>").attr("id","pageContent"))
	.append(
		$("<div></div>").addClass("clearfix form-actions")
		.append(
			$("<div></div>").addClass("col-md-offset-9 col-md-3")
			.append(
				$("<button></button>").addClass("btn btn-info").attr("type","button")
				.append($("<i></i>").addClass("ace-icon fa fa-check bigger-110").append("提交"))
				.on('click',function(){
					
					
					var markup = $('#pageContent').summernote('code');
					$('#pageContent').summernote('destroy');
					var base64Markup=Base64.encode(markup);
					$.ajax({
						url : $.cxt+'/report/save',
						type : "POST",
						dataType:"json",
						loading:true,
						data:{html:base64Markup}
					});
				})
			)
			.append("  ")
			.append(
				$("<button></button>").addClass("btn").attr("type","button")
				.append($("<i></i>").addClass("ace-icon fa fa-eye bigger-110").append("预览"))
				.on('click',function(){
					preview(this);
				})
			)
		)
	);
	
	$.get($.cxt+'/template/1.jsp', function(data) {
		$('#pageContent').html(data);//初始化加载界面  
		initSummerNode();
	});
}

/**
 * 预览
 * @param _this
 * @returns
 */
function preview(_this){
	$('#pageContent').summernote('destroy');
	$(_this).empty().append($("<i></i>").addClass("ace-icon fa fa-eye-slash bigger-110").append("取消预览"));
	$(_this).off();
	$(_this).on('click',function(){
		canclePreview(_this);
	})
}


/**
 * 取消预览
 * @returns
 */
function canclePreview(_this){
	initSummerNode();
	$(_this).empty().append($("<i></i>").addClass("ace-icon fa fa-eye bigger-130").append("预览"));
	$(_this).off();
	$(_this).on('click',function(){
		preview(_this);
	})
}

/**
 * 初始化编辑器
 * @returns
 */
function initSummerNode(){
	$('#pageContent').summernote({
		focus : true,
		lang : 'zh-CN',
		toolbar: [
		['style', ['style']],
		['font', ['bold', 'underline', 'clear','superscript', 'subscript']],
		['fontname', ['fontname']],
		['fontsize', ['fontsize']],
		['color', ['color']],
		['para', ['ul', 'ol', 'paragraph']],
		['table', ['table']],
		['insert', ['link', 'picture', 'video']],
		['view', ['fullscreen', 'codeview', 'help']]
		],
	});
}
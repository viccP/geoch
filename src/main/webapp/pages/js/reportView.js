$(function(){
	//获取实验报告ID并缓存
	var reportId=$.getArgs("reportId");
	$("body").data("reportId",reportId);
	//加载页面
	initReport();
	
});

/**
 * 初始化报告
 * @returns
 */
function initReport(){
	$.ajax({
		url : $.cxt+'/index/isTeacher',
		type : "POST",
		dataType:"json",
		success : function(json) {
			$(".page-content").empty()
			.append($("<div></div>").attr("id","pageContent"));
			
			if(json.data){
				$(".page-content")
				.append(
					$("<div></div>").addClass("clearfix form-actions")
					.append(
						$("<div></div>").addClass("col-md-offset-9 col-md-3")
						.append(
							$("<button></button>").addClass("btn btn-info pull-right").attr("type","button")
							.append($("<i></i>").addClass("ace-icon fa fa-check bigger-110").append("批阅"))
							.on('click',function(){
								alterReport(this);
							})
						)
					)
				);
			}
			
			$.get($.cxt+'/labreport/'+$("body").data("reportId"), function(data) {
				$('#pageContent').html(data);//初始化加载界面  
			});
		}
	});
}

/**
 * 修改报告
 * @returns
 */
function alterReport(_this){
	initSummerNode();
	$(_this).empty().append($("<i></i>").addClass("ace-icon fa fa-send-o bigger-110").append("提交"));
	$(_this).off();
	$(_this).on('click',function(){
		submitReport(_this);
	});
	$(_this)
	.after("  ")
	.after(
		$("<button></button>").addClass("btn").attr("type","button")
		.append($("<i></i>").addClass("ace-icon fa fa-eye bigger-110").append("预览"))
		.on('click',function(){
			preview(this);
		})
	);
}

/**
 * 提交报告
 * @param _this
 * @returns
 */
function submitReport(_this){
	
	bootbox.prompt({ 
		size: "small",
		title: "请为实验报告打分", 
		callback: function(name){
			if(name!=null){
				var markup = $('#pageContent').summernote('code');
				$('#pageContent').summernote('destroy');
				var base64Markup=Base64.encode(markup);
				$.ajax({
					url : $.cxt+'/report/check',
					type : "POST",
					dataType:"json",
					loading:true,
					data:{html:base64Markup,reportId:$("body").data("reportId"),score:name}
				});
			}
		}
	});
}

/**
 * 预览
 * @param _this
 * @returns
 */
function preview(_this){
	$('#pageContent').summernote('destroy');
	$(_this).empty().append($("<i></i>").addClass("ace-icon fa fa-eye-slash bigger-110").append("继续批阅"));
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
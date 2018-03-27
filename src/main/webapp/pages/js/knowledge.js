/**
 * 
 */
$(function() {
	
	//加载页面
	$.get($.cxt+'/template/0.jsp', function(data) {
		$('.click2edit').html(data);//初始化加载界面  
	});
	
	$.ajax({
		url : $.cxt+'/index/isTeacher',
		type : "POST",
		dataType:"json",
		success : function(json) {
			if(json.data){
				$("#ace-settings-container").empty().append(
					$("<div></div>").addClass("btn btn-app btn-xs btn-success ace-settings-btn").attr("title","编辑").append(
						$("<i></i>").addClass("ace-icon fa fa-edit bigger-130")	
					).on('click', function() {
						$("#ace-settings-container").empty().append(
							$("<div></div>").addClass("btn btn-app btn-xs btn-success ace-settings-btn").attr("title","取消编辑").append(
								$("<i></i>").addClass("ace-icon fa fa-close bigger-130")	
							).on('click',function(){window.location.reload()})
						);
							
						$("#ace-settings-container").after(
							$("<div></div>").addClass("ace-settings-container-1").append(
								$("<div></div>").addClass("btn btn-app btn-xs btn-info ace-settings-btn").attr({"id":"save","title":"保存"}).append(
									$("<i></i>").addClass("ace-icon fa fa-save bigger-130")
								).on('click', function() {
									var markup = $('.click2edit').summernote('code');
									$('.click2edit').summernote('destroy');
									var base64Markup=Base64.encode(markup);
									$.ajax({
										url : $.cxt+'/knowledge/save',
										type : "POST",
										dataType:"json",
										data:{"index":0,"html":base64Markup},
										success : function(json) {
										}
									});
								})
							)
						)
						.after(
							$("<div></div>").addClass("ace-settings-container-2").append(
								$("<div></div>").addClass("btn btn-app btn-xs btn-warning ace-settings-btn").attr({"id":"preview","title":"预览"}).append(
									$("<i></i>").addClass("ace-icon fa fa-eye bigger-130")
								).on('click',function(){
									perviewEvent(this);
								})
							)
						)
						
						initSummerNode();
					})
				);
			}
		}
	});
});

/**
 * 初始化编辑框
 * @returns
 */
function initSummerNode(){
	$('.click2edit').summernote({
		focus : true,
		lang : 'zh-CN',
	 	toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear','superscript', 'subscript']],
            ['fontname', ['fontname']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ],
	});
}

/**
 * 预览事件
 * @returns
 */
function perviewEvent(_this){
	$('.click2edit').summernote('destroy');
	$(_this).empty().attr("title","取消预览").append($("<i></i>").addClass("ace-icon fa fa-eye-slash bigger-130"));
	$(_this).off();
	$(_this).on('click',function(){
		editEvent(_this);
	})
}

/**
 * 编辑事件
 * @returns
 */
function editEvent(_this){
	initSummerNode();
	$(_this).empty().attr("title","预览").append($("<i></i>").addClass("ace-icon fa fa-eye bigger-130"));
	$(_this).off();
	$(_this).on('click',function(){
		perviewEvent(_this);
	})
}
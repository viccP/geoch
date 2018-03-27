/**
 * 
 */
$(function() {
	
	//加载页面
	$.get($.cxt+'/template/0.jsp', function(data) {
		$('.click2edit').html(data);//初始化加载界面  
	});
	
	$("#edit").on('click', function() {
		$('.click2edit').summernote({
			focus : true,
			lang : 'zh-CN'
		});
	});

	$("#save").on('click', function() {
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
	});
});
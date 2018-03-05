$(function(){
	
	//获取连接数据
	var id=$.getArgs("id");
	
	$.ajax({
		url : $.cxt + '/video/get',
		type : "post",
		data : {"id" : id},
		dataType:"json",
		success : function(data) {
			$('.video_name').append(data.videoName);
			$('#uniquePlayer-1').videoPlayer({
				name: data.videoName,
				media: {
					flv:$.cxt+data.videoUrl,
					poster:$.cxt+data.videoPicUrl
				},
				size: {
					width: $('#playerContainer').width(),
					height: '570px'
				}
			});
		}
	});
});
/**
 * 
 */
$(function() {
	
	//获取视频数据
	$.ajax({
		url : $.cxt + '/video/list',
		type : "GET",
		dataType:"json",
		success : function(data) {
			// 渲染页面
			$.each(data,function(key,val){
				$("#videoContainer").append(
					$("<li></li>")
					.attr("id",key)
					.append(
						$("<a></a>")
						.attr({"href":$.cxt+"/pages/play.jsp?id="+key,"data-rel":"colorbox"})
						.addClass("cboxElement")
						.append(
							$("<img></img>")
							.attr({"height":"150","width":"150","alt":"150x150","src":$.cxt+val.videoPicUrl})
						)
						.append(
							$("<div></div>").addClass("text").append(
								$("<div></div>").addClass("inner").append(val.videoName)
							)
						)
					)
				);
			})
		}
	});
});
/**
 * 
 */
$(function(){
	
	//清除页面数据
	cleanBodyData();
	
	//设置遮罩
	var hVal=$(".mask").parent().height();
	$(".mask").height(hVal);
	$(".mask").width($(".mask").parent().width());
	$(".mask").css("line-height",hVal+"px")
	
	//绑定点击事件
	$(".apply-span").on("click",function(e){
		//停止冒泡
		e.stopPropagation();
		var applyPro=$(this).attr("data");
		
		//加载页面
		$.get($.cxt+"/pages/apply.jsp", function(data) {
			$("body").data("applyPro",applyPro);
			$("#pageContent").html(data);//初始化加载界面  
		});
	});
});
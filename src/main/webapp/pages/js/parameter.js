/**
 * 
 */
$(function($) {

	$(".chosen-select[name=dataType]").chosen({
		disable_search : true,
		width : "20%"
	});
	//绑定事件
	$(".chosen-select[name=dataType]").on('change',function(){
		//清除下拉菜单
		$(".chosen-select[name=dataName]").empty();
				
		//初始岩浆下拉菜单
		initSelect({
			"id":".chosen-select[name=dataName]",
			"url":$.cxt + '/basic/dataName',
			"data":{"dataType":$(this).val()}
		});
		
		$(".chosen-select[name=dataName]").trigger("chosen:updated");  
		
		//初始化元素列表
		initEleTbl();
	});
	
	//初始数据名称下拉菜单
	initSelect({
		"id":".chosen-select[name=dataName]",
		"url":$.cxt + '/basic/dataName',
		"data":{"dataType":$(".chosen-select[name=dataType]").val()}
	});
	//绑定事件
	$(".chosen-select[name=dataName]").on('change',function(){
		//初始化元素列表
		initEleTbl();
	});
	
	//初始化元素列表
	initEleTbl();
});


/**
 * 获取元素表
 * @returns
 */
function initEleTbl(){
	//清除数据
	$("#ele-tbl").empty();
	//数据类型
	var dataType=$(".chosen-select[name=dataType]").val();
	//数据名称
	var dataId=$(".chosen-select[name=dataName]").val();
	//生成元素列表
	$.ajax({
		url : $.cxt+'/basic/dataValue',
		type : "POST",
		dataType:"json",
		data:{"dataType":dataType,"dataId":dataId},
		success : function(json) {
			$.each(json.data,function(index,val){
				//添加行
				if(index%8==0){
					$("#ele-tbl").append($("<div></div>").addClass("profile-info-row"));
				}
				//添加数据
				$("#ele-tbl>div.profile-info-row:last")
				.append(
					$("<div></div>")
					.addClass("profile-info-name")
					.append(val.elementCode)
				)
				.append(
					$("<div></div>")
					.addClass("profile-info-name")
					.append(val.elementName)
				)
				.append(
					$("<div></div>")
					.addClass("profile-info-value")
					.append(
						$("<span></span>").addClass("editable ele-val").append(val.elementValue)
					)
				)
			})
			
			//text editable
			$('.ele-val').editable({
				type : 'text',
				name : 'elementValue',
				url : function(val) {
					console.log(val)
				}
			});
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
	$.ajax($.extend({data:opt.data},{
		url:opt.url,
		type : "POST",
		dataType:"json",
		async:false,
		success : function(json) {
			//生成列表
			$.each(json.data,function(index,val){
				_this.append(
					$("<option></option>").attr("value",val.code).append(val.value)
				)
			});
			
			//初始化下拉菜单
			_this.chosen({
				disable_search : true
			});
		}
	}));
}
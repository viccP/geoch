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
		refreshTbl();
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
		initEleTbl($(".chosen-select[name=dataType]").val(),$(".chosen-select[name=dataName]").val());
	});
	
	//初始化元素列表
	initEleTbl($(".chosen-select[name=dataType]").val(),$(".chosen-select[name=dataName]").val());
	
	//初始化新建按钮
	$("#addBasicData").on('click',function(){
		initEleTbl($(".chosen-select[name=dataType]").val());
	});
});


/**
 * 获取元素表
 * @returns
 */
function initEleTbl(dataType,dataId){
	//清除数据
	$("#ele-tbl").empty();
	//生成元素列表
	$.ajax({
		url : $.cxt+'/basic/dataValue',
		type : "POST",
		dataType:"json",
		data:{"dataType":dataType,"dataId":dataId||""},
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
						$("<span></span>").addClass("editable ele-val").append(val.elementValue).attr("ele-key",val.index)
					)
				)
			})
			
			//判断是否为新增
			if(dataId){
				$('.ele-val').editable({
					type : 'text',
					name : 'elementValue',
					pk:function() {
					    return $(this).attr("ele-key");
					},
					url : function(val) {
						$.ajax({
							url:$.cxt + '/basic/editDataValue',
							type : "POST",
							dataType:"json",
							loading:true,
							data:{"value":val.value,"index":val.pk,"dataId":$(".chosen-select[name=dataName]").val()}
						});
					},
					validate: function(value) {
						if($.trim(value) == '') {
							return '请填写数值';
						} else if(isNaN(value)){
							return '请输入合法的数值类型';
						}
					}
				});
				
				//添加按钮
				createButton({
					buttons:[
						{
							name:"另存为",
							click:function(){
								addBasicData();
							},
							color:"btn-warning"
						},
						{
							name:"删除",
							click:function(){
								addBasicData();
							},
							icon:"ace-icon fa fa-remove bigger-110",
							color:"btn-danger",
							click:function(){
								delBasicData();
							}
						}
					],
					position:"col-md-offset-10 col-md-2"
				});
			}
			else{
				$('.ele-val').editable({
					type : 'text',
					name : 'elementValue',
					validate: function(value) {
						if($.trim(value) == '') {
							return '请填写数值';
						} else if(isNaN(value)){
							return '请输入合法的数值类型';
						}
					}
				});
				
				//添加按钮
				createButton({
					buttons:[
						{
							name:"保存",
							click:function(){
								addBasicData();
							}
						}
					],
					position:"col-md-offset-11 col-md-1"
				});
			}
		}
	});
}

/**
 * 添加按钮
 * @param opts
 * @returns
 */
function createButton(opts){
	var defalut={
		color:"btn-info",
		icon:"ace-icon fa fa-check bigger-110"
	};
	
	$("#basic-save-div").empty();
	var container=$("<div></div>").addClass(opts.position).appendTo("#basic-save-div");
	//添加按钮
	var count=0;
	$.each(opts.buttons,function(key,val){
		var result=$.extend({},defalut,val)
		container
		.append(
			$("<button></button>")
			.addClass("btn").addClass(result.color)
			.attr("type","button")
			.append(
				$("<i></i>").addClass(result.icon)
			)
			.append(val.name)
			.on('click',result.click)
		)
		if(opts.buttons.length>1){
			container.append("&nbsp;&nbsp")
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

/**
 * 添加基础数据
 * @returns
 */
function addBasicData(){
	bootbox.prompt({ 
		size: "small",
		title: "请输入基础数据名称", 
		callback: function(name){
			if(name!=null){
				var json={dataType:{},dataValLst:{}};
				json.dataType.dataType=$(".chosen-select[name=dataType]").val();
				json.dataType.dataName=name;
				json.dataValLst=[];
				$.each($("#ele-tbl").find(".profile-info-value>span"),function(){
					json.dataValLst.push({
						eleIndex:$(this).attr("ele-key"),
						dataValue:$(this).text()
					});
				});
				
			    	$.ajax({
			    		url : $.cxt + "/basic/addDataValue",
			    		data:JSON.stringify(json),
			    		type : "POST",
			    		contentType: "application/json",
			    		dataType: "json",
			    		success : function(json) {
			    			refreshTbl();
			    		}
			    	});
			}
		}
	});
}

/**
 * 删除基础数据
 * @returns
 */
function delBasicData(){
	 var dataId=$(".chosen-select[name=dataName]").val();
	 var dataName=$(".chosen-select[name=dataName]>option[value="+dataId+"]").text();
	 bootbox.confirm({
	        title: "消息提示",
	        message: "确定删除当前数据["+dataName+"]?",
	        size:"small",
	        buttons: {
	            cancel: {
	                label: '<i class="fa fa-times"></i> 取消'
	            },
	            confirm: {
	                label: '<i class="fa fa-check"></i> 确定'
	            }
	        },
	        callback: function (result) {
	        	if(result){
	        		$.ajax({
	        			url : $.cxt + "/basic/delDataValue",
	        			data:{dataId:dataId},
	        			type : "POST",
	        			dataType: "json",
	        			loading:true,
	        			success : function(json) {
	        				refreshTbl();
	        			}
	        		});
	        	}
	      }
	  });
}

/**
 * 刷新表格
 * @returns
 */
function refreshTbl(){
	//清除下拉菜单
	$(".chosen-select[name=dataName]").empty();
			
	//初始岩浆下拉菜单
	initSelect({
		"id":".chosen-select[name=dataName]",
		"url":$.cxt + '/basic/dataName',
		"data":{"dataType":$(".chosen-select[name=dataType]").val()}
	});
	
	$(".chosen-select[name=dataName]").trigger("chosen:updated");  
	
	//初始化元素列表
	initEleTbl($(".chosen-select[name=dataType]").val(),$(".chosen-select[name=dataName]").val());
}
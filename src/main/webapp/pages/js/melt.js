/**
 * 
 */
$(function() {

	// 初始化IntroJs
	initIntroJs();

	//初始化图表
	initEchart();
	
	/**
	 * 实验基本信息
	 */
	//熔体类型下拉菜单
	initSelect({"id":"#melt-style"});
	//绑定事件
	$("#melt-style").on('change',function(){
		doDraw($.cxt + "/chart/draw",true);
	});
	
	//初始岩浆下拉菜单
	initSelect({
		"id":"#inital-magma",
		"url":$.cxt + '/basic/dataName',
		"data":{"dataType":1}
	});
	//绑定事件
	$("#inital-magma").on('change',function(){
		$.ajax({
			url : $.cxt+'/chart/initial',
			type : "POST",
			dataType:"json",
			data:{"initialId":$(this).val(),"stdId":$("#std-val").val(),"legend":"初始熔体"},
			success : function(json) {
				renderChart(json.data);
			}
		});
	});
	
	//样品数据下拉菜单
	initSelect({
		"id":"#sample-data",
		"url":$.cxt + '/lab/sample',
		"data":{"sampleType":1},
		"multiple":true
	});
	bindSampleSelectEvent();
	
	//标准化值类型下拉菜单
	initSelect({
		"id":"#std-val",
		"url":$.cxt + '/basic/dataName',
		"data":{"dataType":2}
	});
	//绑定事件
	$("#std-val").on('change',function(){
		$.ajax({
			url : $.cxt+'/chart/standard',
			type : "POST",
			dataType:"json",
			data:{"stdId":$(this).val()},
			success : function(json) {
				renderChart(json.data);
			}
		});
	});
	
	//定量模型下拉菜单
	initSelect({
		"id":"#crystal-style",
		"url":$.cxt+'/lab/exprType',
		"data":{"exprType":1}
	});
	
	//添加事件
	$("#crystal-style").on('change',function(){
		var val=	$(this).val();
		//绘图
		if(val!='-1'){
			doDraw($.cxt + "/chart/draw",true);
		}
	});
	
	/**
	 * 矿物比例
	 */
	initMineralSpinner();
	
	/**
	 * 参数
	 */
	//初始化tip
	Tipped.create(".prm-set", "您的输入有误，请输入最大值与最小值之间的整数",{
		close: true,
		hideOn: false,
		showOn:false,
		position: 'bottomleft'
	});
	
	// 初始化滑动条
	initSpinner($(".prm-div").width()*0.75);
	
	/**
	 * 按钮
	 */
	//导入按钮
	$("#importData").on('click',function(e){
		e.preventDefault();
		var fileObj=$("<input id='fileField'></input>").attr("type","file").attr("name","file").on("change",function(){
			var data = new FormData();
			data.append('file', fileObj[0].files[0]);
			data.append('dataType', 1);
			$.ajax({
	    			url : $.cxt + "/lab/upload",
	    			data:data,
	    			type : "POST",
	    			dataType: "json",
	    			loading:true,
	    			contentType: false, 
	    			processData: false,
	    			success:function(json){
	    				updateSampleData(json);
	    			}
			});
		});
		fileObj.trigger("click");
	});
	
	//绘图按钮
	$("#drawChart").on('click',function(e){
		e.preventDefault();
		doDraw($.cxt + "/chart/draw",false);
	});
	
	//重绘按钮
	$("#reDrawChart").on('click',function(e){
		e.preventDefault();
		doDraw($.cxt + "/chart/reDraw",false);
	});
	
	//添加提交按钮
	addSubmitButn();
});

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
				$("<option></option>").attr("value","-1").append(_this.attr("data-placeholder"))	
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
					disable_search : true
				});
			}
		}));
	}
	else{
		//增加提示值
		if(!opt.multiple){
			_this.prepend(
				$("<option></option>").attr("value","-1").append(_this.attr("data-placeholder"))	
			)
		}
		//初始化下拉菜单
		_this.chosen({
			disable_search : true
		});
	}
}

/**
 * 初始化滑块
 * @returns
 */
function initSpinner(width){
	var slide_styles = ['', 'green','red','purple','orange', 'dark'];
	var ii = 0;
	$(".slider-opts").each(function() {
		var $this = $(this);
		$this.closest('div').find("input.prm-set").val($this.val());
		$this.hide().after('<span />');
		$this.next().addClass('ui-slider-small')
		.addClass("inline ui-slider-"+slide_styles[ii++ % slide_styles.length])
		.width(width).slider({
			value:parseInt($this.val()),
			range: "min",
			animate:true,
			min: parseInt($this.attr('data-min')),
			max: parseInt($this.attr('data-max')),
			step: parseFloat($this.attr('data-step')) || 1,
			slide: function( event, ui ) {
				$this.val(ui.value);
				$this.closest('div').find("input.prm-set").val(ui.value);
				spinnerUpdate();
			}
		});
	});
	
	$(".prm-set").each(function(){
		var twinsObj=$(this).closest('div').find("input.slider-opts");
		var min=parseInt(twinsObj.attr('data-min'));
		var max=parseInt(twinsObj.attr('data-max'));
		$(this).on("blur",function(){
			var inStr=$(this).val();
			if(!inStr.match(/^[0-9]*$/)){
				Tipped.show("#"+$(this).attr("id"));
				$(this).val(0);
			}
			else{
				var inVal=parseInt(inStr);
				if(inVal<min){
					Tipped.show("#"+$(this).attr("id"));
					$(this).val(min)
				}
				else if(inVal>max){
					Tipped.show("#"+$(this).attr("id"));
					$(this).val(max)
					spinnerUpdateValue(width);
				}else{
					spinnerUpdateValue(width);
				}
			}
		})
	});
}

/**
 * 更新滑块
 * @returns
 */
function spinnerUpdate() {
	var opts = {};
	$('#spinner-opts input[type=text]').each(function() {
		opts[this.name] = parseFloat(this.value);
	});
	opts['left'] = 'auto';
	$('#spinner-preview').spin(opts);
	
	//绘图
	doDraw($.cxt + "/chart/draw",true);
}

/**
 * 通过更改值更新滑块
 * @returns
 */
function spinnerUpdateValue(width) {
	var slide_styles = ['', 'green','red','purple','orange', 'dark'];
	var ii = 0;
	$(".slider-opts").each(function() {
		var $this = $(this);
		$this.parent().find("span").remove();
		$this.closest('div').find("input.docker-set").val($(this).parent().parent().find("input").val());
		$this.hide().after('<span />');
		$this.next().addClass('ui-slider-small')
		.addClass("inline ui-slider-"+slide_styles[ii++ % slide_styles.length])
		.width(width).slider({
			value:parseInt($(this).parent().parent().find("input").val()),
			range: "min",
			animate:true,
			min: parseInt($this.attr('data-min')),
			max: parseInt($this.attr('data-max')),
			step: parseFloat($this.attr('data-step')) || 1,
			slide: function( event, ui ) {
				$this.val(ui.value);
				$this.closest('div').find("input.prm-set").val(ui.value);
				spinnerUpdate();
			}
		});
	});
	
	//绘图
	doDraw($.cxt + "/chart/draw",true);
}

/**
 * 初始化矿物spinner
 * @returns
 */
function initMineralSpinner(){
	$.ajax({
		url : $.cxt+'/lab/mineralType',
		type : "POST",
		dataType:"json",
		async:false,
		success : function(json) {
			//增加矿物列
			$.each(json.data,function(index,val){
				$(".mineral-lst")
				.append(
					$("<div></div>").addClass("input-group")
					.append(
						$("<span></span>").addClass("input-group-addon").append(val.value)
					)
					.append(
						$("<input></input>").attr({"type":"text","name":"originPhases"}).addClass("mineral-spinner").width(60)
					)
					.append(
						$("<input></input>").attr({"type":"hidden","name":"hOriginPhases"}).val(val.code)
					)
					.append(
						$("<input></input>").attr({"type":"text","name":"meltPhases"}).addClass("mineral-spinner").width(60)
					)
					.append(
						$("<input></input>").attr({"type":"hidden","name":"hMeltPhases"}).val(val.code)
					)
				)
			});
			
			//初始化矿物spinner
			$('.mineral-spinner').ace_spinner({
				value : '0%',
				min : 0,
				max : 100,
				step : 1,
				speed:'medium',
				units: ['%'],
				defaultUnit: '%',
				touch_spinner : true,
				icon_up : 'ace-icon fa fa-caret-up bigger-110',
				icon_down : 'ace-icon fa fa-caret-down bigger-110'
			})
			.closest('.ace-spinner')
			.on('changed.fu.spinbox', function(){
				//获取矿物比例
				setMineralStatus("originPhases");
				setMineralStatus("meltPhases");
				//绘图
				doDraw($.cxt + "/chart/draw",true);
			});;
		}
	});
}

/**
 * 更新熔体类型下拉菜单
 * @param json
 * @returns
 */
function updateSampleData(json){
	if(json.code=='0'){
		//清除下拉菜单
		$("#sample-data-container").empty();
		$("#sample-data-container")
		.append(
			$("<label></label>").attr("for","form-field-select-3").append("样品数据")
		)
		.append("<br>")
		.append(
			$("<select></select>")
			.addClass("chosen-select form-control")
			.attr({"id":"sample-data","data-placeholder":"请选择样品...","multiple":"multiple"})
			.append(
				$("<option></option>").attr("value","")
			)
		)
		
		//样品数据下拉菜单
		initSelect({
			"id":"#sample-data",
			"url":$.cxt + '/lab/sample',
			"data":{"sampleType":1}
		});
		bindSampleSelectEvent();
		
		//初始化tip
		Tipped.create("#sample_data_chosen", "样品数据导入成功请下拉查看",{
			close: true,
			hideOn: false,
			showOn:false,
			position: 'bottomleft'
		});
		Tipped.show("#sample_data_chosen");
	}
}

/**
 * 初始化echart图表
 */
function initEchart(){
	//定义echart实例
	$.ajax({
		url : $.cxt+'/lab/clearCache',
		type : "POST",
		dataType:"json",
		success : function(json) {
			var rtn={};
			rtn.reeChart = echarts.init(document.getElementById('ree-chart'));
			rtn.traceSpiderChart = echarts.init(document.getElementById('trace-spider-chart'));

			//稀土元素配分模式图
			rtn.reeChart.setOption({
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:[]
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['La','Ce','Pr','Nd','Sm','Eu','Gd','Tb','Dy','Ho','Er','Tm','Yb','Lu']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'log'
			        }
			    ],
			    series : []
			});
			
			//微量元素蛛网图
			rtn.traceSpiderChart.setOption({
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:[]
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['Rb','Ba','Th','U','Nb','La','Ce','Pr','Sr','Nd','Zr','Hf','Sm','Eu','Y','Ho','Yb','Yb']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'log'
			        }
			    ],
			    series : []
			});
			
			$("body").data("echarts",rtn);
		}
	});
}

/**
 * 样品下拉框绑定事件
 * @returns
 */
function bindSampleSelectEvent(echartInstance){
	$("#sample-data").on('change',function(){
		var sampleCodes=$(this).val()||['-1'];
		var stdId=$("#std-val").val();
		$.ajax({
			url : $.cxt+'/chart/sample',
			type : "POST",
			dataType:"json",
			data:{"sampleCodes":sampleCodes,"stdId":stdId,"sampleType":1},
			success : function(json) {
				//绘图
				renderChart(json.data);
			}
		});
	});
}

/**
 * 渲染图形
 * @param sampleOpt
 * @returns
 */
function renderChart(chartOpt){
	//获取echart实例
	var echartInstance=$("body").data("echarts");
	
	//稀土元素配分模式图
	var reeOption=echartInstance.reeChart.getOption();
	reeOption.legend[0].data=chartOpt.legend;
	reeOption.series=chartOpt.ree;
	echartInstance.reeChart.setOption(reeOption,true);
	
	//微量元素蛛网图
	var traceOption=echartInstance.traceSpiderChart.getOption();
	traceOption.legend[0].data=chartOpt.legend;
	traceOption.series=chartOpt.trace;
	echartInstance.traceSpiderChart.setOption(traceOption,true);
}

/**
 * 绘制图形
 * @param url
 * @returns
 */
function doDraw(url,preview){
	var data={};
	data.exprId=$("#crystal-style").val();
	data.magmaType=$("#melt-style").val();
	data.stdId=$("#std-val").val();
	data.mineralsD=[];
	data.mineralsP=[];
	data.fVal=$("#crystalF").val()/100;
	data.cR=$("#crystalSr").val()/100;
	data.mR=$("#crystalBr").val()/100;
	data.mixId=$("#mix-obj").val();
	data.preview=preview;
	
	//获取矿物比例(D)
	$.each($(".mineral-lst>div.input-group"),function(index,val){
		var displayVal=$(val).find("input[name=originPhases]").val().replace("%","");;
		data.mineralsD.push({
			"code":$(val).find("input[name=hOriginPhases]").val(),
			"value":displayVal/100
		});
	});
	
	//获取矿物比例(P)
	$.each($(".mineral-lst>div.input-group"),function(index,val){
		var displayVal=$(val).find("input[name=meltPhases]").val().replace("%","");;
		data.mineralsP.push({
			"code":$(val).find("input[name=hMeltPhases]").val(),
			"value":displayVal/100
		});
	});
	
	//判断是否为预览
	if(preview){
		data.legend="图形预览";
		$.ajax({
			url : url,
			data:JSON.stringify(data),
			type : "POST",
			dataType: "json",
			contentType: "application/json",
			success:function(json){
				renderChart(json.data);
			}
		});
	}
	else{
		//输入图例提示
		bootbox.prompt({ 
			size: "small",
			title: "请输入图例名称", 
			callback: function(name){
				if(name!=null){
					data.legend=name;
					$.ajax({
						url : url,
						data:JSON.stringify(data),
						type : "POST",
						dataType: "json",
						contentType: "application/json",
						success:function(json){
							renderChart(json.data);
						}
					});
				}
			}
		});
	}
}

/**
 * 设置矿物状态
 * @returns
 */
function setMineralStatus(name){
	debugger
	var sum=0;
	$.each($(".mineral-lst>div.input-group").find("input[name="+name+"]"),function(index,val){
		var displayVal=parseFloat($(this).val().replace("%",""));
		sum=sum+displayVal;
	});
	if(sum==100){
		$.each($(".mineral-lst>div.input-group").find("input[name="+name+"]"),function(){
			if($(this).val()!='0%'){
				$(this).css("background-color","yellow");
			}
			else{
				$(this).css("background-color","");
			}
		});
	}
	else{
		$.each($(".mineral-lst>div.input-group").find("input[name="+name+"]"),function(){
			if($(this).val()!='0%'){
				$(this).css("background-color","red");
			}
			else{
				$(this).css("background-color","");
			}
		});
	}
}

/**
 * 初始化介绍
 * @returns
 */
 function initIntroJs() {
	$.ajax({
		url : $.cxt + '/intro/get',
		type : "GET",
		dataType : "json",
		data:{"type":"melt","size":15},
		success : function(json) {
			var intro = introJs();
			intro.setOptions({
				skipLabel : "跳过",
				doneLabel : "完成",
				prevLabel : '后退',
				nextLabel : '前进',
				steps : json.data,
				exitOnOverlayClick : false,
				keyboardNavigation : false
			});
			intro.onexit(function(){
				$("#ace-settings-container-2").empty();
			});
			intro.start();
			
			$("body").data("intro",intro);
			
			$.ajax({
				url : $.cxt+'/index/isTeacher',
				type : "POST",
				dataType:"json",
				success : function(json) {
					if(json.data){
						$(".introjs-tooltipbuttons")
						.prepend(
							$("<a></a>").addClass("introjs-button").append("编辑").on('click',function(){
								doEdit(this);
							})
						);
					}
				}
			});
		}
	});
}

/**
 * 初始化编辑器
 * @returns
 */
function initSummerNode(){
	$('.introjs-tooltip').width(800);
	$('.introjs-tooltiptext').summernote({
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

/**
 * 添加保存按钮
 * @returns
 */
function addSaveTipBtn(){
	$(".introjs-tooltipbuttons").prepend(
			$("<a></a>").addClass("introjs-button").append("保存").on('click',function(){
				var markup = $('.introjs-tooltiptext').summernote('code');
				$('.introjs-tooltiptext').summernote('destroy');
				var base64Markup=Base64.encode(markup);
				var index=$(".introjs-helperNumberLayer").text();
				$.ajax({
					url : $.cxt + '/intro/save',
					type : "POST",
					dataType : "json",
					data : {"index" : index,"html" : base64Markup,"type":"melt"},
					success:function(json){
						$("body").data("intro")._introItems[index-1].intro=markup;
						$('.introjs-tooltip').css('width','');
						$(".introjs-tooltipbuttons>a:eq(0)").remove();
						$(".introjs-tooltipbuttons>a:eq(0)").empty().append("编辑");
						$(".introjs-tooltipbuttons>a:eq(0)").off();
						$(".introjs-tooltipbuttons>a:eq(0)").on('click',function(){
							doEdit(this);
						})
					}
				});
			})
		)
}

/**
 * 编辑按钮
 * @param _this
 * @returns
 */
function doEdit(_this){
	initSummerNode();
	addSaveTipBtn();
	$(_this).off();
	$(_this).empty().append("取消编辑");
	$(_this).on('click',function(){
		cancelEdit(_this);
	})
}

/**
 * 取消编辑
 * @param _this
 * @returns
 */
function cancelEdit(_this){
	$(".introjs-tooltipbuttons>a:eq(0)").remove();
	$('.introjs-tooltip').css('width','');  
	$('.introjs-tooltiptext').summernote('destroy');
	$(_this).empty().append("编辑");
	$(_this).off();
	$(_this).on('click',function(){
		doEdit(_this);
	})
}


/**
 * 添加提交按钮
 * @returns
 */
function addSubmitButn(){
	$.ajax({
		url : $.cxt+'/index/isTeacher',
		type : "POST",
		dataType:"json",
		success : function(json) {
			if(!json.data){
				$(".melt-btn-area").append(
					$("<a></a>").attr({"href":$.cxt+"/pages/report.jsp","target":"_blank"}).addClass("btn btn-app btn-pink btn-xs intro-step16")
					.append($("<i></i>").addClass("ace-icon fa fa-send-o bigger-160"))
					.append("提交")
				)
			}
		}
	});
}
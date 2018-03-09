/**
 * 
 */
$(function() {

	//初始化图表
	var echartInstance=initEchart();
	
	/**
	 * 实验基本信息
	 */
	//熔体类型下拉菜单
	initSelect({"id":"#melt-style"});
	
	//初始岩浆下拉菜单
	initSelect({
		"id":"#inital-magma",
		"url":$.cxt + '/common/initial',
		"data":{"initialType":0}
	});
	
	//样品数据下拉菜单
	initSelect({
		"id":"#sample-data",
		"url":$.cxt + '/common/sampleData',
		"data":{"sampleType":0}
	});
	
	//混染物类型下拉菜单
	initSelect({
		"id":"#mix-obj",
		"url":$.cxt + '/common/mixType'
	});
	
	//标准化值类型下拉菜单
	initSelect({
		"id":"#std-val",
		"url":$.cxt + '/common/stdType'
	});
	
	//定量模型下拉菜单
	initSelect({
		"id":"#crystal-style",
		"url":$.cxt+'/common/exprType',
		"data":{"exprType":0}
	});
	
	//添加事件
	$("#crystal-style").on('change',function(){
		var val=	$(this).val();
		if(val=="4" || val=="5"){
			unDisableCoponent("#crystalBrDiv");
			unDisableCoponent("#crystalSrDiv");
			unDisableCoponent("#crystalBrDiv");
			disableCoponent("#crystalSrDiv");
		}
		else if(val=="3"){
			unDisableCoponent("#crystalBrDiv");
			unDisableCoponent("#crystalSrDiv");
		}
		else{
			unDisableCoponent("#crystalBrDiv");
			unDisableCoponent("#crystalSrDiv");
			disableCoponent("#crystalBrDiv");
			disableCoponent("#crystalSrDiv");
		}
	});
	
	$("#sample-data").on('change',function(){
		var sampleCode=$(this).val();
		var sampleName=$(this).children("option[value="+stdId+"]").text();
		var stdId=$("#std-val").val();
		$.ajax({
			url : $.cxt+'/common/simpleChart',
			type : "POST",
			dataType:"json",
			data:{"sampleCode":sampleCode,"sampleName":sampleName,"stdId":stdId},
			success : function(json) {
				echartInstance.reeOption.series.push(json.data.reeSeries);
				echartInstance.reeOption.legend.data.push(json.data.legend);
				echartInstance.reeChart.setOption(echartInstance.reeOption);
			}
		});
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
	initSpinner();
	
	//设置禁用
	disableCoponent("#crystalBrDiv");
	disableCoponent("#crystalSrDiv");
	
	
	/**
	 * 按钮
	 */
	$("#importData").on('click',function(e){
		e.preventDefault();
		var fileObj=$("<input id='fileField'></input>").attr("type","file").attr("name","file").on("change",function(){
			var data = new FormData();
			data.append('file', fileObj[0].files[0]);
			data.append('dataType', 0);
			$.ajax({
	    			url : $.cxt + "/common/upload",
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
	
	
	/**
	 * 图形区域
	 */
	$(".axes-select").chosen({
		disable_search : true
	});
	
});


/**
 * 获取下拉菜单
 * @param opt{id,url,data}
 * @returns
 */
function initSelect(opt){
	var _this=$(opt.id);
	if(opt.url){
		if(opt.data){
			$.ajax({
				url : opt.url,
				type : "POST",
				dataType:"json",
				data:opt.data,
				async:false,
				success : function(json) {
					doInitSelect(json,_this);
				}
			});
		}
		else{
			$.ajax({
				url : opt.url,
				type : "POST",
				dataType:"json",
				async:false,
				success : function(json) {
					doInitSelect(json,_this);
				}
			});
		}
	}
	else{
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
function initSpinner(){
	var slide_styles = ['', 'green','red','purple','orange', 'dark'];
	var ii = 0;
	$(".slider-opts").each(function() {
		var $this = $(this);
		$this.closest('div').find("input.prm-set").val($this.val());
		$this.hide().after('<span />');
		$this.next().addClass('ui-slider-small')
		.addClass("inline ui-slider-"+slide_styles[ii++ % slide_styles.length])
		.css('width','400px').slider({
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
					spinnerUpdateValue();
				}else{
					spinnerUpdateValue();
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
}

/**
 * 通过更改值更新滑块
 * @returns
 */
function spinnerUpdateValue() {
	var slide_styles = ['', 'green','red','purple','orange', 'dark'];
	var ii = 0;
	$(".slider-opts").each(function() {
		var $this = $(this);
		$this.parent().find("span").remove();
		$this.closest('div').find("input.docker-set").val($(this).parent().parent().find("input").val());
		$this.hide().after('<span />');
		$this.next().addClass('ui-slider-small').
		addClass("inline ui-slider-"+slide_styles[ii++ % slide_styles.length]).
		css('width','400px').slider({
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
}

/**
 * 设置禁用
 * @param id
 * @returns
 */
function disableCoponent(id){
	 var shadeDiv=$("<div class='disable-coponent' style='opacity:0.55;background:black'></div>").css({ 
		   position:'absolute', 
		   top:0, 
		   left:0, 
		   zIndex:300,
		 });
	 var targetDiv=$(id).children(".input-group");
	 shadeDiv.width(targetDiv.width())
	 shadeDiv.height(targetDiv.height())
	 targetDiv.append(shadeDiv);
}

/**
 * 解除禁用
 * @param id
 * @returns
 */
function unDisableCoponent(id){
	$(id).children(".input-group").children("div.disable-coponent").remove();
}

/**
 * 初始化矿物spinner
 * @returns
 */
function initMineralSpinner(){
	$.ajax({
		url : $.cxt+'/common/mineralType',
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
						$("<input></input>").attr("type","text").addClass("mineral-spinner")
					)
					.append(
						$("<input></input>").attr("type","hidden").val(val.code)
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
			});
		}
	});
}

/**
 * 生成下拉菜单
 * @param json
 * @param _this
 * @returns
 */
function doInitSelect(json,_this){
	//增加提示值
	_this
	.append(
		$("<option></option>").attr("value","-1").append(_this.attr("data-placeholder"))	
	)
	
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
		.append("<br></br>")
		.append(
			$("<select></select>")
			.addClass("chosen-select form-control")
			.attr({"id":"original-melt-body","data-placeholder":"请选择样品..."})
			.append(
				$("<option></option>").attr("value","")
			)
		)
		
		//初始熔体下拉菜单
		initSelect({
			"id":"#sample-data",
			"url":$.cxt + '/common/sampleData',
			"data":{"dataType":0}
		});
		
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
 * @returns
 */
function initEchart(){
	//定义echart实例
	var rtn={};
	rtn.traceCovariantChart = echarts.init(document.getElementById('trace-covariant'));
	rtn.reeChart = echarts.init(document.getElementById('ree-chart'));
	rtn.traceSpiderChart = echarts.init(document.getElementById('trace-spider-chart'));

	// 微量元素协变图
	rtn.traceCovariantOpt = {
		xAxis : {
			scale : true
		},
		yAxis : {
			scale : true
		},
		series : []
	};
	rtn.traceCovariantChart.setOption(rtn.traceCovariantOpt);
	
	//稀土元素配分模式图
	rtn.reeOption = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:[]
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
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
		};
	rtn.reeChart.setOption(rtn.reeOption);
	
	//微量元素蛛网图
	rtn.traceOption = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:[]
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
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
		};
	rtn.traceSpiderChart.setOption(rtn.traceOption);
	
	return rtn;
}
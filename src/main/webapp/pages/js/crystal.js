/**
 * 
 */
$(function() {

	//定义echart实例
	var traceCovariant = echarts.init(document.getElementById('trace-covariant'));
	var reeChart = echarts.init(document.getElementById('ree-chart'));
	var traceSpiderChart = echarts.init(document.getElementById('trace-spider-chart'));

	// 指定图表的配置项和数据
	var option1 = {
		legend : {
			data : [ 'HQ01', 'HQ02' ],
			left : 'center'
		},
		xAxis : {
			scale : true
		},
		yAxis : {
			scale : true
		},
		series : [
				{
					name : 'HQ01',
					type : 'scatter',
					data : [ [ 170.2, 59.1 ], [ 161.3, 70.5 ], [ 167.6, 52.7 ],
							[ 167.6, 62.7 ], [ 165.1, 86.3 ], [ 162.6, 66.4 ],
							[ 152.4, 67.3 ], [ 168.9, 63.0 ], [ 170.2, 73.6 ],
							[ 175.2, 62.3 ], [ 175.2, 57.7 ], [ 160.0, 55.4 ],
							[ 165.1, 104.1 ], [ 174.0, 55.5 ], [ 170.2, 77.3 ],
							[ 160.0, 80.5 ], [ 167.6, 64.5 ], [ 167.6, 72.3 ],
							[ 167.6, 61.4 ], [ 154.9, 58.2 ], [ 162.6, 81.8 ],
							[ 175.3, 63.6 ], [ 171.4, 53.4 ], [ 157.5, 54.5 ],
							[ 165.1, 53.6 ], [ 160.0, 60.0 ], [ 174.0, 73.6 ],
							[ 162.6, 61.4 ], [ 174.0, 55.5 ], [ 162.6, 63.6 ],
							[ 161.3, 60.9 ], [ 156.2, 60.0 ], [ 149.9, 46.8 ],
							[ 169.5, 57.3 ], [ 160.0, 64.1 ], [ 175.3, 63.6 ],
							[ 169.5, 67.3 ], [ 160.0, 75.5 ], [ 172.7, 68.2 ],
							[ 162.6, 61.4 ], [ 157.5, 76.8 ], [ 176.5, 71.8 ],
							[ 164.4, 55.5 ], [ 160.7, 48.6 ], [ 174.0, 66.4 ],
							[ 163.8, 67.3 ] ]
				},
				{
					name : 'HQ02',
					type : 'scatter',
					data : [ [ 161.2, 51.6 ], [ 167.5, 59.0 ], [ 159.5, 49.2 ],
							[ 157.0, 63.0 ], [ 155.8, 53.6 ], [ 170.0, 59.0 ],
							[ 159.1, 47.6 ], [ 166.0, 69.8 ], [ 176.2, 66.8 ],
							[ 160.2, 75.2 ], [ 172.5, 55.2 ], [ 170.9, 54.2 ],
							[ 172.9, 62.5 ], [ 153.4, 42.0 ], [ 160.0, 50.0 ],
							[ 147.2, 49.8 ], [ 168.2, 49.2 ], [ 175.0, 73.2 ],
							[ 157.0, 47.8 ], [ 167.6, 68.8 ], [ 168.9, 62.0 ],
							[ 175.3, 63.6 ], [ 159.4, 53.2 ], [ 160.0, 53.4 ],
							[ 170.2, 55.0 ], [ 162.6, 70.5 ], [ 167.6, 54.5 ],
							[ 162.6, 54.5 ], [ 160.7, 55.9 ], [ 160.0, 59.0 ],
							[ 157.5, 63.6 ], [ 162.6, 54.5 ], [ 152.4, 47.3 ],
							[ 170.2, 67.7 ], [ 165.1, 80.9 ], [ 172.7, 70.5 ] ]
				}

		]
	};
	traceCovariant.setOption(option1);
	
	var reeOption = {
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
	reeChart.setOption(reeOption);
	
	var traceOption = {
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
		            data : ['Rb','Ba','Th','U','Nb','La','Ce','Pr','Sr','Nd','Zr','Hf','Sm','Eu','Y','Ho','Yb','Rb']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'log'
		        }
		    ],
		    series : []
		};
	traceSpiderChart.setOption(traceOption);
	
	
	/**
	 * 实验基本信息
	 */
	//熔体类型下拉菜单
	initSelect({"id":"#melt-style"});
	
	//初始熔体下拉菜单
	initSelect({
		"id":"#original-melt-body",
		"url":$.cxt + '/common/meltBody',
		"data":{"dataType":0}
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
	
	$("#std-val").on('change',function(){
		var stdId=$(this).val();
		var stdName=$(this).children("option[value="+stdId+"]").text();
		$.ajax({
			url : $.cxt+'/common/stdChart',
			type : "POST",
			dataType:"json",
			data:{"stdId":stdId,"stdName":stdName},
			success : function(json) {
				reeOption.series.push(json.data.reeSeries);
				reeOption.legend.data.push(json.data.legend);
				reeChart.setOption(reeOption);
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
	    				updateMeltBody(json);
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
function updateMeltBody(json){
	if(json.code=='0'){
		
		//清除下拉菜单
		$("#original-melt-body-container").empty();
		$("#original-melt-body-container")
		.append(
			$("<label></label>").attr("for","form-field-select-3").append("初始熔体")
		)
		.append("<br></br>")
		.append(
			$("<select></select>")
			.addClass("chosen-select form-control")
			.attr({"id":"original-melt-body","data-placeholder":"请选择初始熔体..."})
			.append(
				$("<option></option>").attr("value","")
			)
		)
		
		//初始熔体下拉菜单
		initSelect({
			"id":"#original-melt-body",
			"url":$.cxt + '/common/meltBody',
			"data":{"dataType":0}
		});
		
		//初始化tip
		Tipped.create("#original_melt_body_chosen", "初始熔体导入成功请下拉查看",{
			close: true,
			hideOn: false,
			showOn:false,
			position: 'bottomleft'
		});
		
		Tipped.show("#original_melt_body_chosen");
	}
}
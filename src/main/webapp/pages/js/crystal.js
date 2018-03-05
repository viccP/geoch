/**
 * 
 */
$(function() {

	$(".chosen-select").chosen({
		disable_search : true
	});
	
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
	
	$(".knob").knob({
		"format": function(v) {return v+"%";},
		'release' : function (v) { 
			if(v<=50){
				this.o.fgColor='#87B87F';
				this.o.inputColor='#87B87F';
			}
			else if(v>50 && v<80){
				this.o.fgColor='#efad62';
				this.o.inputColor='#efad62';
			}
			else{
				this.o.fgColor='#d36e6e';
				this.o.inputColor='#d36e6e';
			}
		}
	});

	var myChart = echarts.init(document.getElementById('main'));
	var reeChart = echarts.init(document.getElementById('ree-chart'));
	var traceSpiderChart = echarts.init(document.getElementById('trace-spider-chart'));

	// 指定图表的配置项和数据
	option1 = {
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

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option1);
	
	option2 = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['HQ01','HQ02','HQ03','HQ04','HQ05']
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
		            data : ['La','Ce','Pr','Nd','Sm','Eu','Gb','Tb','Dy','Ho','Er','Tm','Yb','Lu']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'log'
		        }
		    ],
		    series : [
		        {
		            name:'HQ01',
		            type:'line',
		            stack: '总量',
		            data:[120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210]
		        },
		        {
		            name:'HQ02',
		            type:'line',
		            stack: '总量',
		            data:[220, 182, 191, 234, 290, 330, 310,220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'HQ03',
		            type:'line',
		            stack: '总量',
		            data:[150, 232, 201, 154, 190, 330, 410,150, 232, 201, 154, 190, 330, 410]
		        },
		        {
		            name:'HQ04',
		            type:'line',
		            stack: '总量',
		            data:[320, 332, 301, 334, 390, 330, 320,320, 332, 301, 334, 390, 330, 320]
		        },
		        {
		            name:'HQ05',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290, 1330, 1320,820, 932, 901, 934, 1290, 1330, 1320]
		        }
		    ]
		};
		                    
	reeChart.setOption(option2);
	
	option3 = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['HQ01','HQ02','HQ03','HQ04','HQ05']
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
		    series : [
		        {
		            name:'HQ01',
		            type:'line',
		            stack: '总量',
		            data:[120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210,134, 90, 230, 210]
		        },
		        {
		            name:'HQ02',
		            type:'line',
		            stack: '总量',
		            data:[220, 182, 191, 234, 290, 330, 310,220, 182, 191, 234, 290, 330, 310,134, 90, 230, 210]
		        },
		        {
		            name:'HQ03',
		            type:'line',
		            stack: '总量',
		            data:[150, 232, 201, 154, 190, 330, 410,150, 232, 201, 154, 190, 330, 410,134, 90, 230, 210]
		        },
		        {
		            name:'HQ04',
		            type:'line',
		            stack: '总量',
		            data:[320, 332, 301, 334, 390, 330, 320,320, 332, 301, 334, 390, 330, 320,134, 90, 230, 210]
		        },
		        {
		            name:'HQ05',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290, 1330, 1320,820, 932, 901, 934, 1290, 1330, 1320,134, 90, 230, 210]
		        }
		    ]
		};
		                    
	traceSpiderChart.setOption(option3);
});
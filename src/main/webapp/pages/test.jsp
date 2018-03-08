<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=request.getContextPath()%>/resource/ace/js/jquery.js'>" + "<"+"/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
	<script type="text/javascript">
		 window.jQuery || document.write("<script src='<%=request.getContextPath()%>/resource/ace/js/jquery1x.js'>"+"<"+"/script>");
	</script>
<![endif]-->
<script src="<%=request.getContextPath()%>/resource/echart/echarts.min.js"></script>
</head>
<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="width: 800px; height: 400px;"></div>
	<div id="main1" style="width: 800px; height: 400px;"></div>
	<input type="button" value="增加系列" id="add">
	<script type="text/javascript">
	
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var myChart1 = echarts.init(document.getElementById('main1'));

        // 指定图表的配置项和数据
        var option = {
        	    tooltip: {
        	        trigger: 'axis'
        	    },
        	    legend: {
        	        data:['邮件营销','联盟广告','视频广告','直接访问']
        	    },
        	    toolbox: {
    		        show : true,
    		        feature : {
    		            dataView : {show: true, readOnly: false},
    		            restore : {show: true},
    		            saveAsImage : {show: true}
    		        }
    		    },
        	    xAxis: {
        	        type: 'category',
        	        boundaryGap: false,
        	        data: ['周一','周二','周三','周四','周五','周六','周日']
        	    },
        	    yAxis: {
        	        type: 'value'
        	    },
        	    series: [
        	        {
        	            name:'邮件营销',
        	            type:'line',
        	            stack: '含量',
        	            data:[120, 132, 101, 134, 90, 230, 210]
        	        },
        	        {
        	            name:'联盟广告',
        	            type:'line',
        	            stack: '含量',
        	            data:[220, 182, 191, 234, 290, 330, 310]
        	        },
        	        {
        	            name:'视频广告',
        	            type:'line',
        	            stack: '含量',
        	            data:[150, 232, 201, 154, 190, 330, 410]
        	        },
        	        {
        	            name:'直接访问',
        	            type:'line',
        	            stack: '含量',
        	            data:[320, 332, 301, 334, 390, 330, 320]
        	        }
        	    ]
        	};

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
        var option1= {
        		legend : {
        			icon:'roundRect',
        			data : [ 'test1', 'test2' ],
        			right : '1%',
        			bottom:'middle',
        			orient:'vertical'
        		},
        		 toolbox: {
     		        show : true,
     		        feature : {
     		            dataView : {show: true, readOnly: false},
     		            restore : {show: true},
     		            saveAsImage : {show: true}
     		        }
     		    },
        		xAxis : {
        			scale : true,
        			name:'Rb',
        			nameLocation:'middle',
        			nameTextStyle:{
        				fontWeight:'bold',
        				fontSize:18
        			},
        			nameGap:25
        		},
        		yAxis : {
        			scale : true,
        			name:'Sr',
        			nameLocation:'middle',
        			nameRotate:360,
        			nameTextStyle:{
        				fontWeight:'bold',
        				fontSize:18
        			},
        			nameGap:35
        		},
        		series : [
        				{
        					name : 'test1',
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
        					name : 'test2',
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
        myChart1.setOption(option1);
        
        
		$("#add").on('click',function(){
			option.series.push({
				name:'搜索引擎',
				type:'line',
				stack: '含量',
				data:[820, 932, 901, 934, 1290, 1330, 1320]
			})
			option.legend.data.push("搜索引擎");
			
			myChart.setOption(option);
		});
    </script>
</body>
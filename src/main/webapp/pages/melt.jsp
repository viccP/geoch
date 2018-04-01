<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/introjs/introjs.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/summernote/summernote.css">
<script src="<%=request.getContextPath()%>/resource/summernote/summernote.js"></script>
<script src="<%=request.getContextPath()%>/resource/summernote/lang/summernote-zh-CN.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/introjs/intro.js"></script>
<script src="<%=request.getContextPath()%>/resource/common/base64.js"></script>
<script src="<%=request.getContextPath()%>/pages/js/melt.js"></script>
<div class="row">
	<div class="col-xs-12 col-sm-3 intro-step1">
		<div>
			<h4 class="header smaller lighter purple">
				<i class="ace-icon fa fa-cogs"></i>
				设置实验基本信息
			</h4>
		</div>
		<div class="intro-step2">
			<label for="form-field-select-3">熔体类型</label>
			<br>
			<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择熔体类型..." title="">
				<option value=""></option>
				<option value="1">基性熔体</option>
				<option value="2">中性熔体</option>
				<option value="3">酸性熔体</option>
			</select>
		</div>
		<hr>
		<div class="space-12"></div>
		<div class="intro-step3">
			<label for="form-field-select-3">初始熔体</label>
			<br>
			<select class="chosen-select form-control" id="inital-magma" data-placeholder="请选择初始熔体...">
				<option value=""></option>
			</select>
		</div>
		<hr>
		<div class="space-12"></div>
		<div id="sample-data-container" class="intro-step4">
			<label for="form-field-select-3">样品数据</label>
			<br>
			<select class="chosen-select form-control" id="sample-data" multiple data-placeholder="请选择样品...">
				<option value=""></option>
			</select>
		</div>
		<hr>
		<div class="space-12"></div>
		<div class="intro-step5">
			<label for="form-field-select-3">标准化值</label>
			<br>
			<select class="chosen-select form-control" id="std-val" data-placeholder="请选择标准化值...">
				<option value=""></option>
			</select>
		</div>
	</div>

	<div class="col-xs-12 col-sm-4 mineral-lst intro-step6">
		<div>
			<h4 class="header smaller lighter purple">
				<i class="ace-icon fa fa-sliders"></i>
				设置矿物比例（矿物名称/原始固相/熔体）
			</h4>
		</div>
	</div>

	<div class="col-xs-12 col-sm-5 prm-div intro-step7">
		<div>
			<h4 class="header smaller lighter purple">
				<i class="ace-icon fa fa-flask"></i>
				参数设置
			</h4>
		</div>
		<div class="col-xs-12 col-sm-12">
			<div class="intro-step8">
				<label for="form-field-select-3">熔融定量模型</label>
				<br>
				<select class="chosen-select form-control" id="crystal-style" data-placeholder="请选择熔融定量模型...">
					<option value=""></option>
				</select>
			</div>
			<hr>
			<div class="space-12"></div>
			<div class="space-12"></div>
			<div id="crystalFDiv" class="intro-step9">
				<label for="form-field-mask-2">
					熔融程度(F)
					<small class="text-warning">1~100(%)</small>
				</label>
				<div class="input-group">
					<span class="input-group-addon">
						<i class="ace-icon fa fa-server"></i>
					</span>
					<input class="form-control input-mask-phone prm-set" id="crystalF" name="crystalF" type="text" title="">
					<span class="input-group-addon">
						<input class="hidden slider-opts" type="text" id="crystalFSliderId" data-min="0" data-max="100" data-step="1" value="0" />
					</span>
				</div>
			</div>
			<hr>
			<div class="space-12"></div>
			<div class="space-12"></div>
			<div class="space-12"></div>
			<div class="space-12"></div>
			<div class="space-12"></div>
			<div class="pull-left melt-btn-area">
				<a href="#" class="btn btn-app btn-purple btn-xs intro-step10" id="importData">
					<i class="ace-icon fa fa-cloud-upload bigger-160"></i>
					导入
				</a>
				<a href="#" class="btn btn-app btn-success btn-xs intro-step11" id="reDrawChart">
					<i class="ace-icon fa fa-refresh bigger-160"></i>
					重绘
				</a>
				<a href="#" class="btn btn-app btn-warning btn-xs intro-step12" id="drawChart">
					<i class="ace-icon fa fa-pencil bigger-160"></i>
					保存
				</a>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-12 col-sm-12">
		<div>
			<h4 class="header smaller lighter purple">
				<i class="ace-icon fa fa-line-chart"></i>
				图形区
			</h4>
		</div>
	</div>
</div>
<div class="row intro-step13">
	<div class="col-xs-12 col-sm-6 intro-step14">
		<div class="widget-box">
			<div class="widget-header">
				<h6 class="widget-title">稀土元素配分模式图</h6>
			</div>
			<div class="widget-body" style="display: block;">
				<div class="widget-main">
					<div id="ree-chart" style="width: 600px; height: 300px;"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 intro-step15">
		<div class="widget-box">
			<div class="widget-header">
				<h6 class="widget-title">微量元素蛛网图</h6>
			</div>
			<div class="widget-body" style="display: block;">
				<div class="widget-main">
					<div id="trace-spider-chart" style="width: 600px; height: 300px;"></div>
				</div>
			</div>
		</div>
	</div>
</div>
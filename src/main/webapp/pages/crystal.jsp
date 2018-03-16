<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/crystal.js"></script>
<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.settings.js"></script>
<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.settings-rtl.js"></script>
<script src="<%=request.getContextPath()%>/resource/ace/js/ace/ace.settings-skin.js"></script>
<div class="row">
	<div class="col-xs-12 col-sm-4">
		<div>
			<h4 class="header smaller lighter purple">
				<i class="ace-icon fa fa-cogs"></i>
				设置实验基本信息
			</h4>
		</div>
		<div>
			<label for="form-field-select-3">岩浆类型</label>
			<br>
			<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择岩浆类型..." title="">
				<option value=""></option>
				<option value="1">基性岩浆</option>
				<option value="2">中性岩浆</option>
				<option value="3">酸性岩浆</option>
			</select>
		</div>
		<hr>
		<div>
			<label for="form-field-select-3">初始岩浆</label>
			<br>
			<select class="chosen-select form-control" id="inital-magma" data-placeholder="请选择初始岩浆...">
				<option value=""></option>
			</select>
		</div>
		<hr>
		<div id="sample-data-container">
			<label for="form-field-select-3">样品数据</label>
			<br>
			<select class="chosen-select form-control" id="sample-data" multiple data-placeholder="请选择样品...">
				<option value=""></option>
			</select>
		</div>
		<hr>
		<div>
			<label for="form-field-select-3">混染物</label>
			<br>
			<select class="chosen-select form-control" id="mix-obj" data-placeholder="请选择混染物...">
				<option value=""></option>
			</select>
		</div>
		<hr>
		<div>
			<label for="form-field-select-3">标准化值</label>
			<br>
			<select class="chosen-select form-control" id="std-val" data-placeholder="请选择标准化值...">
				<option value=""></option>
			</select>
		</div>
	</div>

	<div class="col-xs-12 col-sm-3 mineral-lst">
		<div>
			<h4 class="header smaller lighter purple">
				<i class="ace-icon fa fa-sliders"></i>
				设置矿物比例
			</h4>
		</div>
	</div>

	<div class="col-xs-12 col-sm-5">
		<div>
			<h4 class="header smaller lighter purple">
				<i class="ace-icon fa fa-flask"></i>
				参数设置
			</h4>
		</div>
		<div class="col-xs-12 col-sm-12">
			<div>
				<label for="form-field-select-3">结晶定量模型</label>
				<br>
				<select class="chosen-select form-control" id="crystal-style" data-placeholder="请选择结晶定量模型...">
					<option value=""></option>
				</select>
			</div>
			<hr>
			<div id="crystalFDiv">
				<label for="form-field-mask-2">
					结晶程度(F)
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
			<div id="crystalBrDiv">
				<label for="form-field-mask-2">
					混染程度(R)
					<small class="text-warning">1~100(%)</small>
				</label>
				<div class="input-group" style="position: relative">
					<span class="input-group-addon">
						<i class="ace-icon fa fa-window-restore"></i>
					</span>
					<input class="form-control input-mask-phone prm-set" id="crystalBr" name="crystalBr" type="text" title="">
					<span class="input-group-addon">
						<input class="hidden slider-opts" type="text" id="crystalBrSliderId" data-min="0" data-max="100" data-step="1" value="0" />
					</span>
				</div>
			</div>
			<hr>
			<div id="crystalSrDiv">
				<label for="form-field-mask-2">
					同化作用速率（Ma）与分离结晶速率（Mc）的比值(r)
					<small class="text-warning">0~90(%)</small>
				</label>
				<div class="input-group">
					<span class="input-group-addon">
						<i class="ace-icon fa fa-cubes"></i>
					</span>
					<input class="form-control input-mask-phone prm-set" id="crystalSr" name="crystalSr" type="text" title="">
					<span class="input-group-addon">
						<input class="hidden slider-opts" type="text" id="crystalSrSliderId" data-min="0" data-max="90" data-step="10" value="0" />
					</span>
				</div>
			</div>
			<hr>
			<div class="pull-left">
				<a href="#" class="btn btn-app btn-purple btn-xs" id="importData">
					<i class="ace-icon fa fa-cloud-upload bigger-160"></i>
					导入
				</a>
				<a href="#" class="btn btn-app btn-success btn-xs" id="reDrawChart">
					<i class="ace-icon fa fa-refresh bigger-160"></i>
					重绘
				</a>
				<a href="#" class="btn btn-app btn-warning btn-xs" id="drawChart">
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
<div class="row">
	<div class="col-xs-12 col-sm-6">
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
	<div class="col-xs-12 col-sm-6">
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
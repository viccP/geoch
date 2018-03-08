<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/crystal.js"></script>
<div class="row">
	<div class="col-xs-12 col-sm-4">
		<div>
			<h3 class="header smaller lighter purple">
				<i class="ace-icon fa fa-cogs"></i>
				设置实验基本信息
			</h3>
		</div>
		<div>
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
		<div id="original-melt-body-container">
			<label for="form-field-select-3">初始熔体</label>
			<br>
			<select class="chosen-select form-control" id="original-melt-body" data-placeholder="请选择初始熔体...">
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
		<hr>
		<div>
			<label for="form-field-select-3">结晶定量模型</label>
			<br>
			<select class="chosen-select form-control" id="crystal-style" data-placeholder="请选择结晶定量模型...">
				<option value=""></option>
			</select>
		</div>
	</div>

	<div class="col-xs-12 col-sm-3 mineral-lst">
		<div>
			<h3 class="header smaller lighter purple">
				<i class="ace-icon fa fa-sliders"></i>
				设置矿物比例
			</h3>
		</div>
	</div>


	<div class="col-xs-12 col-sm-5">
		<div>
			<h3 class="header smaller lighter purple">
				<i class="ace-icon fa fa-flask"></i>
				参数设置
			</h3>
		</div>
		<div class="col-xs-12 col-sm-12">
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
			<div class="space-12"></div>
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
			<div class="space-12"></div>
			<hr>
			<div id="crystalSrDiv">
				<label for="form-field-mask-2">
					同化作用速率（Ma）与分离结晶速率（Mc）的比值(r)
					<small class="text-warning">1~100(%)</small>
				</label>
				<div class="input-group">
					<span class="input-group-addon">
						<i class="ace-icon fa fa-cubes"></i>
					</span>
					<input class="form-control input-mask-phone prm-set" id="crystalSr" name="crystalSr" type="text" title="">
					<span class="input-group-addon">
						<input class="hidden slider-opts" type="text" id="crystalSrSliderId" data-min="0" data-max="100" data-step="1" value="0" />
					</span>
				</div>
			</div>
			<div class="space-12"></div>
			<hr>
			<div class="pull-left">
				<a href="#" class="btn btn-app btn-purple" id="importData">
					<i class="ace-icon fa fa-cloud-upload bigger-200"></i>
					导入数据
				</a>
				<a href="#" class="btn btn-app btn-success">
					<i class="ace-icon fa fa-refresh bigger-230"></i>
					重新绘制
				</a>
				<a href="#" class="btn btn-app btn-warning">
					<i class="ace-icon fa fa-pencil bigger-230"></i>
					绘制
				</a>
			</div>
		</div>
	</div>
</div>
</div>

<div class="row">
	<div class="col-xs-12 col-sm-12">
		<div>
			<h3 class="header smaller lighter purple">图形区</h3>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<div class="widget-box">
			<div class="widget-header">
				<h4 class="widget-title">稀土元素配分模式图</h4>
			</div>
			<div class="widget-body" style="display: block;">
				<div class="widget-main">
					<div id="ree-chart" style="width: 600px; height: 350px;"></div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-xs-12 col-sm-6">
		<div class="widget-box">
			<div class="widget-header">
				<h4 class="widget-title">微量元素蛛网图</h4>
			</div>
			<div class="widget-body" style="display: block;">
				<div class="widget-main">
					<div id="trace-spider-chart" style="width: 600px; height: 350px;"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-12 col-sm-12">
		<div class="widget-box">
			<div class="widget-header">
				<h4 class="widget-title">微量元素协变图</h4>
			</div>
			<div class="widget-body" style="display: block;">
				<div class="widget-main">
					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<div>
								<label for="form-field-select-3">X轴</label>
								<br>
								<div class="row">
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择元素...">
											<option value=""></option>
											<option value="1">Th</option>
											<option value="2">U</option>
											<option value="3">Rb</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择操作符...">
											<option value=""></option>
											<option value="1">+</option>
											<option value="2">-</option>
											<option value="3">*</option>
											<option value="3">/</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择元素...">
											<option value=""></option>
											<option value="1">Th</option>
											<option value="2">U</option>
											<option value="3">Rb</option>
										</select>
									</div>
								</div>
							</div>
							<div class="space-12"></div>
							<div>
								<div class="row">
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择坐标轴类型...">
											<option value=""></option>
											<option value="1">对数坐标</option>
											<option value="2">普通坐标</option>
										</select>
									</div>
								</div>
							</div>
							<div class="space-12"></div>
							<div class="space-12"></div>
							<div>
								<label for="form-field-select-3">Y轴</label>
								<br>
								<div class="row">
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择元素...">
											<option value=""></option>
											<option value="1">Th</option>
											<option value="2">U</option>
											<option value="3">Rb</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择操作符...">
											<option value=""></option>
											<option value="1">+</option>
											<option value="2">-</option>
											<option value="3">*</option>
											<option value="3">/</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择元素...">
											<option value=""></option>
											<option value="1">Th</option>
											<option value="2">U</option>
											<option value="3">Rb</option>
										</select>
									</div>
								</div>
							</div>
							<div class="space-12"></div>
							<div>
								<div class="row">
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control axes-select" id="melt-style" data-placeholder="请选择坐标轴类型...">
											<option value=""></option>
											<option value="1">对数坐标</option>
											<option value="2">普通坐标</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6">
							<div id="trace-covariant" style="width: 600px; height: 350px;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



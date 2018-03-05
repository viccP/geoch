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
			<label for="form-field-select-3">初始熔体</label>
			<br>
			<select class="chosen-select form-control" id="original-melt-body" data-placeholder="请选择初始熔体...">
				<option value=""></option>
				<option value="1">HQ01</option>
				<option value="2">HQ02</option>
				<option value="3">HQ03</option>
				<option value="4">HQ04</option>
			</select>
		</div>
		<hr>
		<div>
			<label for="form-field-select-3">熔体类型</label>
			<br>
			<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择熔体类型...">
				<option value=""></option>
				<option value="1">基性熔体</option>
				<option value="2">中性熔体</option>
				<option value="3">酸性熔体</option>
			</select>
		</div>
		<hr>
		<div>
			<label for="form-field-select-3">混染物</label>
			<br>
			<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择混染物...">
				<option value=""></option>
				<option value="1">呼兰群数据</option>
				<option value="2">亏损地幔成分估值（McDonough.2003）</option>
				<option value="3">原始地幔成分估值(Palme et al.2003)</option>
				<option value="4">原始地幔成分估值(McDonough.2003）</option>
				<option value="5">上地壳成分估值（Rudnick and Gao.2003）</option>
				<option value="6">下地壳成分估值（Rudnick and Gao.2003）</option>
			</select>
		</div>
		<hr>
		<div>
			<label for="form-field-select-3">标准化值</label>
			<br>
			<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择标准化值...">
				<option value=""></option>
				<option value="1">球粒陨石（Masuda et al.(1973）</option>
				<option value="2">N-MORB (Sun & McDonough 1989)</option>
				<option value="3">PM (Sun & McDonough 1989)</option>
				<option value="3">C1-chondrite (Sun & McDonough 1989)</option>
			</select>
		</div>
		<hr>
		<div>
			<label for="form-field-select-3">结晶定量模型</label>
			<br>
			<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择结晶定量模型...">
				<option value=""></option>
				<option value="1">EC(平衡结晶)</option>
				<option value="2">FC</option>
				<option value="3">AFC</option>
				<option value="4">C0</option>
				<option value="5">先结晶后混染</option>
				<option value="6">先混染后结晶</option>
			</select>
		</div>
	</div>

	<div class="col-xs-12 col-sm-3">
		<div>
			<h3 class="header smaller lighter purple">
				<i class="ace-icon fa fa-sliders"></i>
				设置矿物比例
			</h3>
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 橄榄石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 斜方辉石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 单斜辉石 </span>
			<input type="text" class="mineral-spinner" />
		</div>

		<div class="input-group">
			<span class="input-group-addon"> 石榴石 </span>
			<input type="text" class="mineral-spinner" />
		</div>

		<div class="input-group">
			<span class="input-group-addon"> 尖晶石 </span>
			<input type="text" class="mineral-spinner" />
		</div>

		<div class="input-group">
			<span class="input-group-addon"> 角闪石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 黑云母 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 碱性长石 </span>
			<input type="text" class="mineral-spinner" />
		</div>

		<div class="input-group">
			<span class="input-group-addon"> 斜长石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 磷灰石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 磁铁矿 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 榍石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 钛铁矿 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 锆石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
		<div class="input-group">
			<span class="input-group-addon"> 褐帘石 </span>
			<input type="text" class="mineral-spinner" />
		</div>
	</div>


	<div class="col-xs-12 col-sm-5">
		<div>
			<h3 class="header smaller lighter purple">
				<i class="ace-icon fa fa-flask"></i>
				结晶程度(F)
			</h3>
		</div>
		<div class="center" style="margin-top: 40px;">
			<div class="knob-container inline">
				<input type="text" class="input-small knob" value="41" data-min="0" data-max="100" data-width="400" data-height="320" data-thickness=".2" data-inputcolor="#87B87F" data-fgcolor="#87B87F" data-displayprevious="true" data-anglearc="250" data-angleoffset="-125" />
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
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择元素...">
											<option value=""></option>
											<option value="1">Th</option>
											<option value="2">U</option>
											<option value="3">Rb</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择操作符...">
											<option value=""></option>
											<option value="1">+</option>
											<option value="2">-</option>
											<option value="3">*</option>
											<option value="3">/</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择元素...">
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
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择坐标轴类型...">
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
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择元素...">
											<option value=""></option>
											<option value="1">Th</option>
											<option value="2">U</option>
											<option value="3">Rb</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择操作符...">
											<option value=""></option>
											<option value="1">+</option>
											<option value="2">-</option>
											<option value="3">*</option>
											<option value="3">/</option>
										</select>
									</div>
									<div class="col-xs-12 col-sm-4">
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择元素...">
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
										<select class="chosen-select form-control" id="melt-style" data-placeholder="请选择坐标轴类型...">
											<option value=""></option>
											<option value="1">对数坐标</option>
											<option value="2">普通坐标</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6">
							<div id="main" style="width: 600px; height: 350px;"></div>
						</div>
					</div>
				</div>
			</div>
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
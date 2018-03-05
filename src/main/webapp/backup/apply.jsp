<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/apply.js"></script>
<style type="text/css">
#applyInfo textarea, 
#applyInfo input[type="text"], 
#applyInfo input[type="password"], 
#applyInfo input[type="datetime"],
#applyInfo input[type="datetime-local"], 
#applyInfo input[type="date"], 
#applyInfo input[type="month"],
#applyInfo input[type="time"], 
#applyInfo input[type="week"], 
#applyInfo input[type="number"], 
#applyInfo input[type="email"],
#applyInfo input[type="url"], 
#applyInfo input[type="search"], 
#applyInfo input[type="tel"], 
#applyInfo input[type="color"]
	{
	background-color: #ffffff;
	border: 1px solid #d5d5d5 !important;
	border-radius: 0;
	box-shadow: none;
	color: #858585;
	font-family: inherit;
	font-size: 14px;
	padding: 0;
	transition-duration: 0.1s;
	border-width: 0 0 1px !important;
}

.easy-pie-chart {
	cursor: pointer;
}
</style>

<div class="row">
	<div class="col-xs-12">
		<div id="applyInfo" class="tab-pane active">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<div class="widget-box transparent">
						<div class="widget-header widget-header-small">
							<h4 class="widget-title smaller">
								<i class="ace-icon fa fa-check-square-o bigger-110"></i>
								基本情况
							</h4>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div class="profile-user-info profile-user-info-striped">
									<div class="profile-info-row">
										<div class="profile-info-name">性别/性别/年龄</div>
										<div class="profile-info-value">
											<div class="grid3">
												<input class="input-small" placeholder="请输入姓名" type="text" name="name">
											</div>
											<div class="grid3">
												<label class="col-sm-6 no-margin no-padding">
													<input name="sex" class="ace" type="checkbox">
													<span class="lbl">男</span>
												</label>
												<label class="col-sm-6 no-margin no-padding">
													<input name="sex" class="ace" type="checkbox">
													<span class="lbl">女</span>
												</label>
											</div>
											<div class="grid3">
												<input class="input-small" placeholder="请输入年龄" type="text" name="age">
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">婚姻/子女状况</div>
										<div class="profile-info-value">
											<div class="grid2">
												<label class="col-sm-6 no-margin no-padding">
													<input name="isMarried" class="ace" type="checkbox">
													<span class="lbl">有配偶</span>
												</label>
												<label class="col-sm-6 no-margin no-padding">
													<input name="isMarried" class="ace" type="checkbox">
													<span class="lbl">无配偶</span>
												</label>
											</div>
											<div class="grid2">
												<label class="col-sm-6 no-margin no-padding">
													<input name="hasChild" class="ace" type="checkbox">
													<span class="lbl">有子女</span>
												</label>
												<label class="col-sm-6 no-margin no-padding">
													<input name="hasChild" class="ace" type="checkbox">
													<span class="lbl">无子女</span>
												</label>
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">证件类型</div>
										<div class="profile-info-value">
											<div class="grid2 clear-boder">
												<label class="col-sm-6 no-margin no-padding">
													<input name="idCodeType" class="ace" type="checkbox">
													<span class="lbl">居民身份证</span>
												</label>
												<label class="col-sm-6 no-margin no-padding">
													<input name="idCodeType" class="ace" type="checkbox">
													<span class="lbl">军官证</span>
												</label>
											</div>
											<div class="grid2 clear-boder">
												<label class="col-sm-6 no-margin no-padding">
													<input name="idCodeType" class="ace" type="checkbox">
													<span class="lbl">护照</span>
												</label>
												<label class="col-sm-6 no-margin no-padding">
													<input name="idCodeType" class="ace" type="checkbox">
													<span class="lbl">其他</span>
												</label>
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">证件号码/户口派出所</div>
										<div class="profile-info-value">
											<div class="grid2">
												<input class="input-large" placeholder="请输入证件号码" type="text" name="idCode">
											</div>
											<div class="grid2">
												<input class="input-large" placeholder="请输入户口派出所" type="text" name="idPolice">
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">身份证地址/邮编</div>
										<div class="profile-info-value">
											<div class="grid2">
												<input class="input-large" placeholder="请输入身份证地址" type="text" name="idAddr">
											</div>
											<div class="grid2">
												<input class="input-large" placeholder="请输入邮编" type="text" name="idAddrPostCode">
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">户籍类型/居住年限</div>
										<div class="profile-info-value">
											<div class="grid2">
												<label class="col-sm-4 no-margin no-padding">
													<input name="rsdType" class="ace" type="checkbox">
													<span class="lbl">本地</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="rsdType" class="ace" type="checkbox">
													<span class="lbl">本地临时</span>
												</label>
												<label class="col-sm-3 no-margin no-padding">
													<input name="rsdType" class="ace" type="checkbox">
													<span class="lbl">外地</span>
												</label>
											</div>
											<div class="grid2">
												<input class="input-large" placeholder="请输入居住年限" type="text" name="rsdAge">
											</div>
										</div>
									</div>
									<div class="profile-info-row">
										<div class="profile-info-name">家庭住址/邮编</div>
										<div class="profile-info-value">
											<div class="grid2">
												<input class="input-large" placeholder="请输入现在家庭住址" type="text" name="addr">
											</div>
											<div class="grid2">
												<input class="input-large" placeholder="请输入邮编" type="text" name="addrPostCode">
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">学历</div>
										<div class="profile-info-value">
											<div class="grid2 clear-boder">
												<label class="col-sm-5 no-margin no-padding">
													<input name="eduLevel" class="ace" type="checkbox">
													<span class="lbl">博士以上</span>
												</label>
												<label class="col-sm-4 no-margin no-padding">
													<input name="eduLevel" class="ace" type="checkbox">
													<span class="lbl">硕士</span>
												</label>
												<label class="col-sm-3 no-margin no-padding">
													<input name="eduLevel" class="ace" type="checkbox">
													<span class="lbl">学士</span>
												</label>
											</div>
											<div class="grid2 clear-boder">
												<label class="col-sm-6 no-margin no-padding">
													<input name="eduLevel" class="ace" type="checkbox">
													<span class="lbl">高中</span>
												</label>
												<label class="col-sm-6 no-margin no-padding">
													<input name="eduLevel" class="ace" type="checkbox">
													<span class="lbl">高中以下</span>
												</label>
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">单位名称/工作岗位</div>
										<div class="profile-info-value">
											<div class="grid2">
												<input class="input-large" placeholder="请输入单位名称" type="text" name="compName">
											</div>
											<div class="grid2">
												<input class="input-large" placeholder="请输入工作岗位" type="text" name="career">
											</div>
										</div>
									</div>
									<div class="profile-info-row">
										<div class="profile-info-name">单位地址/单位邮编</div>
										<div class="profile-info-value">
											<div class="grid2">
												<input class="input-large" placeholder="请输入单位地址" type="text" name="compAddr">
											</div>
											<div class="grid2">
												<input class="input-large" placeholder="请输入单位邮编" type="text" name="compPostCode">
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">单位类型</div>
										<div class="profile-info-value">
											<div class="grid2 clear-boder">
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">机关事业</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">三资企业</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">金融保险</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">部队系统</span>
												</label>
											</div>
											<div class="grid2 clear-boder">
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">集团企业</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">私营企业</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">个体工商</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="compType" class="ace" type="checkbox">
													<span class="lbl">自由职业</span>
												</label>
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">职务</div>
										<div class="profile-info-value">
											<div class="grid2 clear-boder">
												<label class="col-sm-5 no-margin no-padding">
													<input name="position" class="ace" type="checkbox">
													<span class="lbl">公司主管</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="position" class="ace" type="checkbox">
													<span class="lbl">部门主管</span>
												</label>
											</div>
											<div class="grid2 clear-boder">
												<label class="col-sm-5 no-margin no-padding">
													<input name="position" class="ace" type="checkbox">
													<span class="lbl">项目经理</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="position" class="ace" type="checkbox">
													<span class="lbl">一般职员</span>
												</label>
											</div>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">职称</div>
										<div class="profile-info-value">
											<div class="grid2 clear-boder">
												<label class="col-sm-5 no-margin no-padding">
													<input name="jobTitle" class="ace" type="checkbox">
													<span class="lbl">无</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="jobTitle" class="ace" type="checkbox">
													<span class="lbl">初级</span>
												</label>
											</div>
											<div class="grid2 clear-boder">
												<label class="col-sm-5 no-margin no-padding">
													<input name="jobTitle" class="ace" type="checkbox">
													<span class="lbl">高级</span>
												</label>
												<label class="col-sm-5 no-margin no-padding">
													<input name="jobTitle" class="ace" type="checkbox">
													<span class="lbl">高级以上</span>
												</label>
											</div>
										</div>
									</div>
									<div class="profile-info-row">
										<div class="profile-info-name">电话</div>
										<div class="profile-info-value">
											<div class="grid3">
												<input class="input-large" placeholder="请输入家庭电话" type="text" name="telNo">
											</div>
											<div class="grid3">
												<input class="input-large" placeholder="请输入单位电话" type="text" name="compNo">
											</div>
											<div class="grid3">
												<input class="input-large" placeholder="请输入手机电话" type="text" name="cellNo">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<div class="widget-box transparent">
						<div class="widget-header widget-header-small header-color-blue2">
							<h4 class="widget-title smaller">
								<i class="ace-icon fa fa-lightbulb-o bigger-120"></i>
								家庭信息
							</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main padding-16">
								<div class="clearfix">
									<div class="grid3 center">
										<!-- #section:plugins/charts.easypiechart -->
										<div class="easy-pie-chart percentage" data-percent="45" data-color="#CA5952" style="height: 72px; width: 72px; line-height: 71px; color: rgb(202, 89, 82);">
											<span class="percent" name="wagesPm"></span>
											¥
											<canvas height="72" width="72"></canvas>
										</div>
										<div class="space-2"></div>
										<span>个人月收入(工资)</span>
									</div>

									<div class="grid3 center">
										<div class="center easy-pie-chart percentage" data-percent="90" data-color="#59A84B" style="height: 72px; width: 72px; line-height: 71px; color: rgb(89, 168, 75);">
											<span class="percent" name="annualE"></span>
											¥
											<canvas height="72" width="72"></canvas>
										</div>

										<div class="space-2"></div>
										<span>家庭年收入</span>
									</div>

									<div class="grid3 center">
										<div class="center easy-pie-chart percentage" data-percent="80" data-color="#9585BF" style="height: 72px; width: 72px; line-height: 71px; color: rgb(149, 133, 191);">
											<span class="percent" name="paymentPm"></span>
											¥
											<canvas height="72" width="72"></canvas>
										</div>

										<div class="space-2"></div>
										<span>月供</span>
									</div>
								</div>

								<div class="hr hr-16"></div>
								<div class="space-6"></div>
								<div class="space-6"></div>
								<div class="space-6"></div>
								<div class="space-6"></div>


								<!-- #section:pages/profile.skill-progress -->
								<div class="profile-skills">
									<div class="profile-user-info profile-user-info-striped">
										<div class="profile-info-row">
											<div class="profile-info-name">配偶性别/性别/职务</div>
											<div class="profile-info-value">
												<div class="grid3">
													<input class="input-large" placeholder="请输入配偶姓名" type="text" name="spouseName">
												</div>
												<div class="grid3">
													<input class="input-large" placeholder="请输入配偶年龄" type="text" name="spouseAge">
												</div>
												<div class="grid3">
													<input class="input-large" placeholder="输入配偶职务/职称" type="text" name="spouseJobTitle">
												</div>
											</div>
										</div>


										<div class="profile-info-row">
											<div class="profile-info-name">居住地派出所</div>
											<div class="profile-info-value">
												<div class="grid2">
													<input class="input-large" placeholder="请输入配偶居住地派出所" type="text" name="spousePolice">
												</div>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">身份证号码/月收入</div>
											<div class="profile-info-value">
												<div class="grid2">
													<input class="input-large" placeholder="请输入配偶身份证号码" type="text" name="spouseIdCode">
												</div>
												<div class="grid2">
													<input class="input-large" placeholder="请输入配偶月收入(¥)" type="text" name="spouseWagesPm">
												</div>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">身份证地址</div>
											<div class="profile-info-value">
												<div class="grid2">
													<input class="input-large" placeholder="请输入配偶身份证地址" type="text" name="spouseIdAddr">
												</div>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">工作单位</div>
											<div class="profile-info-value">
												<div class="grid2">
													<input class="input-large" placeholder="请输入配偶工作单位" type="text" name="spouseCompAddr">
												</div>
											</div>
										</div>


										<div class="profile-info-row">
											<div class="profile-info-name">单位地址</div>
											<div class="profile-info-value">
												<div class="grid2">
													<input class="input-large" placeholder="请输入配偶单位地址" type="text" name="spouseComp">
												</div>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">电话/邮编</div>
											<div class="profile-info-value">
												<div class="grid3">
													<input class="input-large" placeholder="输入配偶单位电话" type="text" name="spouseCellNo">
												</div>
												<div class="grid3">
													<input class="input-large" placeholder="输入配偶手机号码" type="text" name="spouseCompNo">
												</div>
												<div class="grid3">
													<input class="input-large" placeholder="输入配偶单位邮编" type="text" name="spouseCompPostCode">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<div class="widget-box transparent">
						<div class="widget-header widget-header-small">
							<h4 class="widget-title smaller">
								<i class="ace-icon fa fa-check-square-o bigger-110"></i>
								车辆信息
							</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div class="profile-user-info profile-user-info-striped">
									<div class="profile-info-row">
										<div class="profile-info-name">车型</div>
										<div class="profile-info-value">
											<input class="input-large" placeholder="请输入车型" type="text" name="carType">
										</div>
									</div>
									<div class="profile-info-row">
										<div class="profile-info-name">车价</div>
										<div class="profile-info-value">
											<input class="input-large" placeholder="请输入车价" type="text" name="carPrice">
										</div>
									</div>
									<div class="profile-info-row">
										<div class="profile-info-name">按揭贷款金额</div>
										<div class="profile-info-value">
											<input class="input-large" placeholder="请输入按揭贷款金额" type="text" name="loanVal">
										</div>
									</div>
									<div class="profile-info-row">
										<div class="profile-info-name">贷款期限</div>
										<div class="profile-info-value">
											<input class="input-large" placeholder="请输入贷款期限" type="text" name="loanAge">
										</div>
									</div>
									<div class="profile-info-row">
										<div class="profile-info-name">首付款比例</div>
										<div class="profile-info-value">
											<input class="input-large" placeholder="请输入首付款比例" type="text" name="adPaymentPt">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<div class="widget-box transparent">
						<div class="widget-header widget-header-small">
							<h4 class="widget-title blue smaller">
								<i class="ace-icon fa fa-cloud-upload orange"></i>
								上传凭证
							</h4>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-8">
								<div id="uploads" class="profile-feed">
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"> </i>
											请上传车辆登记证照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="carRegPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传车辆照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="carPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传房产证或租房合同照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="homePic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传户口本照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="householdPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传驾驶证照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="drivePic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传结婚证照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="marriedPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传考察照片照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="examPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传申请人及配偶身份证照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="idPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传收入证明与银行流水照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="bankPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传行驶证照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="driveUsePic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
									<div class="profile-activity clearfix">
										<div>
											<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
											请上传征信照片
										</div>

										<div class="tools action-buttons">
											<a href="#" class="blue upload" name="creditPic">
												<i class="ace-icon fa fa-upload bigger-125"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="center">
						<button type="button" class="btn btn-sm btn-primary btn-white btn-round" id="savebtn">
							<i class="ace-icon fa fa-rss bigger-150 middle orange2"></i>
							<span class="bigger-110">提交页面</span>
							<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
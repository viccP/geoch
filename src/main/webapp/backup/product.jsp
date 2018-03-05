<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/pages/js/product.js"></script>
<div class="row">
	<div class="col-sm-6 widget-container-col ui-sortable">
		<div class="widget-box ui-sortable-handle">
			<div class="widget-header widget-header-small">
				<h5 class="widget-title smaller">友卡贷</h5>

				<!-- #section:custom/widget-box.tabbed -->
				<div class="widget-toolbar no-border">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
							<a data-toggle="tab" href="#home" aria-expanded="true">新车</a>
						</li>

						<li class="">
							<a data-toggle="tab" href="#profile" aria-expanded="false">二手车</a>
						</li>
					</ul>
				</div>

				<!-- /section:custom/widget-box.tabbed -->
			</div>

			<div class="widget-body">
				<div class="widget-main padding-6">
					<div class="tab-content">
						<div id="home" class="tab-pane active">
							<div class="row">
								<!-- #section:pages/pricing.small-header -->
								<div class="col-xs-2 col-sm-2 pricing-span-header">
									<div class="widget-box transparent">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">项目说明</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main no-padding">
												<ul class="list-unstyled list-striped pricing-table-header">
													<li>产品对象</li>
													<li>开放地区</li>
													<li>贷款资质</li>
													<li>月利率</li>
													<li>首付比例</li>
													<li>计息方式</li>
												</ul>
											</div>
										</div>
									</div>
								</div>

								<!-- /section:pages/pricing.small-header -->

								<!-- #section:pages/pricing.small-body -->
								<div class="col-xs-10 col-sm-10 pricing-span-body">
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-red3">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品A</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>延边</li>
														<li>身份证/驾驶证/银行卡</li>
														<li>0.48</li>
														<li>20%</li>
														<li>分期</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友卡贷/新车/产品A">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-orange">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品B</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>延边</li>
														<li>身份证/驾驶证/银行卡</li>
														<li>0.48</li>
														<li>20%</li>
														<li>分期</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友卡贷/新车/产品B">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-blue">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品C</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>延边</li>
														<li>身份证/驾驶证/银行卡</li>
														<li>0.48</li>
														<li>20%</li>
														<li>分期</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友卡贷/新车/产品C">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /section:pages/pricing.small-body -->
							</div>
						</div>

						<div id="profile" class="tab-pane">
							<div class="row">
								<!-- #section:pages/pricing.small-header -->
								<div class="col-xs-2 col-sm-2 pricing-span-header">
									<div class="widget-box transparent">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">项目说明</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main no-padding">
												<ul class="list-unstyled list-striped pricing-table-header">
													<li>产品对象</li>
													<li>开放地区</li>
													<li>
														贷款资质
														<br>
														<br>
													</li>
													<li>月利率</li>
													<li>首付比例</li>
												</ul>
											</div>
										</div>
									</div>
								</div>

								<!-- /section:pages/pricing.small-header -->

								<!-- #section:pages/pricing.small-body -->
								<div class="col-xs-10 col-sm-10 pricing-span-body">
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-red3">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品D</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>延边</li>
														<li>
															身份证/驾驶证/银行卡
															<br>
															<br>
														</li>
														<li>0.48</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友卡贷/二手车/产品D">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-orange">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品E</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>延边</li>
														<li>身份证/驾驶证/银行卡/直系亲属资料/流水/房产</li>
														<li>0.48</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友卡贷/二手车/产品E">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-blue">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品F</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>延边</li>
														<li>身份证/驾驶证/银行卡/直系亲属资料/流水/房产</li>
														<li>0.48</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友卡贷/二手车/产品F">
														<span>申请</span>
													</a>
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
		</div>
	</div>
	<div class="col-sm-6 widget-container-col ui-sortable">
		<div class="mask">建设中</div>
		<div class="widget-box ui-sortable-handle">
			<div class="widget-header widget-header-small">
				<h5 class="widget-title smaller">友吉贷</h5>

				<!-- #section:custom/widget-box.tabbed -->
				<div class="widget-toolbar no-border">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
							<a data-toggle="tab" href="#fln" aria-expanded="true">新车</a>
						</li>

						<li class="">
							<a data-toggle="tab" href="#flo" aria-expanded="false">二手车</a>
						</li>
					</ul>
				</div>

				<!-- /section:custom/widget-box.tabbed -->
			</div>

			<div class="widget-body">
				<div class="widget-main padding-6">
					<div class="tab-content">
						<div id="fln" class="tab-pane active">
							<div class="row">
								<!-- #section:pages/pricing.small-header -->
								<div class="col-xs-2 col-sm-2 pricing-span-header">
									<div class="widget-box transparent">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">项目说明</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main no-padding">
												<ul class="list-unstyled list-striped pricing-table-header">
													<li>产品对象</li>
													<li>开放地区</li>
													<li>
														贷款资质
														<br>
														<br>
													</li>
													<li>月利率</li>
													<li>首付比例</li>
												</ul>
											</div>
										</div>
									</div>
								</div>

								<!-- /section:pages/pricing.small-header -->

								<!-- #section:pages/pricing.small-body -->
								<div class="col-xs-10 col-sm-10 pricing-span-body">
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-red3">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品A</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>
															身份证/驾驶证/银行卡
															<br>
															<br>
														</li>
														<li>无</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger" data="二手车/产品一">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-orange">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品B</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>身份证/驾驶证/银行卡/直系亲属资料/流水/房产</li>
														<li>无</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：12-20万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger" data="二手车/产品一">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-blue">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品C</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>身份证/驾驶证/银行卡/直系亲属资料/流水/房产</li>
														<li>无</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：20-90万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger" data="二手车/产品一">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /section:pages/pricing.small-body -->
							</div>
						</div>

						<div id="flo" class="tab-pane">
							<div class="row">
								<!-- #section:pages/pricing.small-header -->
								<div class="col-xs-2 col-sm-2 pricing-span-header">
									<div class="widget-box transparent">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">项目说明</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main no-padding">
												<ul class="list-unstyled list-striped pricing-table-header">
													<li>产品对象</li>
													<li>开放地区</li>
													<li>
														贷款资质
														<br>
														<br>
													</li>
													<li>月利率</li>
													<li>首付比例</li>
												</ul>
											</div>
										</div>
									</div>
								</div>

								<!-- /section:pages/pricing.small-header -->

								<!-- #section:pages/pricing.small-body -->
								<div class="col-xs-10 col-sm-10 pricing-span-body">
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-red3">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品D</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>身份证/驾驶证/银行卡/直系亲属资料/流水/房产</li>
														<li>无</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-12万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger" data="二手车/产品一">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-orange">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品E</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>身份证/驾驶证/银行卡/直系亲属资料/流水/房产</li>
														<li>无</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：12-20万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger" data="二手车/产品一">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-blue">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品F</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>身份证/驾驶证/银行卡/直系亲属资料/流水/房产</li>
														<li>无</li>
														<li>20%</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：20-50万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger" data="二手车/产品一">
														<span>申请</span>
													</a>
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
		</div>
	</div>

</div>
<div class="row">
	<div class="col-sm-6 widget-container-col ui-sortable">
		<div class="widget-box ui-sortable-handle">
			<div class="widget-header widget-header-small">
				<h5 class="widget-title smaller">友帮贷</h5>

				<!-- #section:custom/widget-box.tabbed -->
				<div class="widget-toolbar no-border">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
							<a data-toggle="tab" href="#fhn" aria-expanded="true">新车</a>
						</li>

						<li class="">
							<a data-toggle="tab" href="#fho" aria-expanded="false">二手车</a>
						</li>
					</ul>
				</div>

				<!-- /section:custom/widget-box.tabbed -->
			</div>

			<div class="widget-body">
				<div class="widget-main padding-6">
					<div class="tab-content">
						<div id="fhn" class="tab-pane active">
							<div class="row">
								<!-- #section:pages/pricing.small-header -->
								<div class="col-xs-2 col-sm-2 pricing-span-header">
									<div class="widget-box transparent">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">项目说明</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main no-padding">
												<ul class="list-unstyled list-striped pricing-table-header">
													<li>产品对象</li>
													<li>开放地区</li>
													<li>贷款资质</li>
													<li>月利率</li>
													<li>首付比例</li>
												</ul>
											</div>
										</div>
									</div>
								</div>

								<!-- /section:pages/pricing.small-header -->

								<!-- #section:pages/pricing.small-body -->
								<div class="col-xs-10 col-sm-10 pricing-span-body">
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-red3">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品A</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>无</li>
														<li>无</li>
														<li>无</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-90万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友帮贷/新车/产品A">
														<span>申请</span>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /section:pages/pricing.small-body -->
							</div>
						</div>

						<div id="fho" class="tab-pane">
							<div class="row">
								<!-- #section:pages/pricing.small-header -->
								<div class="col-xs-2 col-sm-2 pricing-span-header">
									<div class="widget-box transparent">
										<div class="widget-header">
											<h5 class="widget-title bigger lighter">项目说明</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main no-padding">
												<ul class="list-unstyled list-striped pricing-table-header">
													<li>产品对象</li>
													<li>开放地区</li>
													<li>贷款资质</li>
													<li>月利率</li>
													<li>首付比例</li>
												</ul>
											</div>
										</div>
									</div>
								</div>

								<!-- /section:pages/pricing.small-header -->

								<!-- #section:pages/pricing.small-body -->
								<div class="col-xs-10 col-sm-10 pricing-span-body">
									<div class="pricing-span">
										<div class="widget-box pricing-box-small widget-color-red3">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">产品B</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table">
														<li>7座以下</li>
														<li>全国</li>
														<li>无</li>
														<li>无</li>
														<li>无</li>
													</ul>

													<div class="price">
														<span class="label label-lg label-inverse arrowed-in arrowed-in-right"> 融资额度：0-50万 </span>
													</div>
												</div>

												<div>
													<a href="#" class="btn btn-block btn-sm btn-danger apply-span" data="友帮贷/二手车/产品B">
														<span>申请</span>
													</a>
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
		</div>
	</div>
</div>
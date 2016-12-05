<div ng-app="mainApp">
	<div ng-controller="bmiController">
		<div class="pre-header">
			<div class="container">
				<div class="row">
					<!-- BEGIN TOP BAR LEFT PART -->
					<div class="col-md-6 col-sm-6 additional-shop-info">
						<ul class="list-unstyled list-inline">

						</ul>
					</div>
					<!-- END TOP BAR LEFT PART -->
					<!-- BEGIN TOP BAR MENU -->
					<div class="col-md-6 col-sm-6 additional-nav">
						<ul class="list-unstyled list-inline pull-right">
							<li><a href="#/loginPage">Log In</a></li>
							<li><a href="#/signUpPage">Sign Up</a></li>
						</ul>
					</div>
					<!-- END TOP BAR MENU -->
				</div>
			</div>
		</div>
		<!-- END TOP BAR -->
		<!-- BEGIN HEADER -->
		<div class="header">
			<div class="container">
				<a class="site-logo" href="index.jsp"><img
					src="${pageContext.request.contextPath}/resources/assets/corporate/img/logos/peoplesHealth.png"
					alt="people's health"></a> <a href="javascript:void(0);"
					class="mobi-toggler"><i class="fa fa-bars"></i></a>

				<!-- BEGIN NAVIGATION -->
				<div class="header-navigation pull-right font-transform-inherit">
					<ul>
						<li><a href="#/">Home</a></li>

						<li><a href="#/bmi">BMI</a></li>

						<li><a href="#/foodActivity">Food and Activity</a></li>

						<li><a href="#/analytics">Analytics</a></li>

					</ul>
				</div>
				<!-- END NAVIGATION -->
			</div>
		</div>
		<!-- Header END -->

		<div class="main">
			<div class="container">

				<div class="row margin-bottom-40">
					<!-- BEGIN CONTENT -->
					<div class="col-md-12 col-sm-12">
						<h1>BMI Overview</h1>
						<h2>Welcome {{name}}!</h2>
						<div class="content-page">
							<div class="row">
								<div class="col-md-3 col-sm-3">
									<ul ng-init="tab = 1" class="tabbable faq-tabbable">
										<li class="active"><a href ng-click="tab = 1"
											data-toggle="tab">View BMI</a></li>
										<li><a href ng-click="tab = 2" data-toggle="tab">Weight
												and Height</a></li>
										<li><a href ng-click="tab = 3" data-toggle="tab">Note
												to Self</a></li>
									</ul>
								</div>
								<div class="col-md-9 col-sm-9">
									<div class="tab-content" style="padding: 0; background: #fff;">
										<!-- START TAB 1 -->
										<div class="tab-pane active" id="tab_1" ng-show="tab===1">
											<div class="panel-group" id="accordion1">
												<div class="panel panel-default">
													<div class="panel-heading">
														<h4 class="panel-title">
															<a href="#accordion1_1" data-parent="#accordion1"
																data-toggle="collapse" class="accordion-toggle">
																Body Mass Index </a>
														</h4>
													</div>
													<div class="panel-collapse collapse in" id="accordion1_1">
														<div class="panel-body">{{bmi_text}}</div>
													</div>
												</div>



											</div>
										</div>
										<!-- END TAB 1 -->
										<!-- START TAB 2 -->
										<div class="tab-pane active" id="tab_2" ng-show="tab===2">
											<div class="panel-group" id="accordion2">
												<div class="panel panel-default">
													<div class="panel-heading">
														<h4 class="panel-title">
															<a href="#accordion2_1" data-parent="#accordion1"
																data-toggle="collapse" class="accordion-toggle">
																Update Weight and Height </a>
														</h4>
													</div>
													<div class="panel-collapse collapse  in" id="accordion2_1">
														<div class="panel-body">
															<p>Change fields below to update weight or height. Your BMI will be updated according to the new values you enter.</p>
															<form class="form-horizontal form-without-legend"
																role="form">
																<div class="form-group">
																	<label for="weight" class="col-lg-4 control-label">Weight
																		(kg)
																	</label>
																	<div class="col-lg-8">
																		<input type="text" class="form-control"
																			ng-model="weight">
																	</div>
																</div>
																<div class="form-group">
																	<label for="weight" class="col-lg-4 control-label">Height
																		(cm)
																	</label>
																	<div class="col-lg-8">
																		<input type="text" class="form-control"
																			ng-model="height">
																	</div>
																</div>
																<div class="row">
																	<div
																		class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
																		<button type="submit" class="btn btn-primary"
																			ng-click="updateWeightHeight()">Update</button>
																	</div>
																</div>
															</form>
															
														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- END TAB 3 -->
										<!-- START TAB 3 -->
										<div class="tab-pane active" id="tab_3" ng-show="tab===3">
											<div class="panel-group" id="accordion3">
												<div class="panel panel-default">
													<div class="panel-heading">
														<h4 class="panel-title">
															<a href="#accordion3_1" data-parent="#accordion1"
																data-toggle="collapse" class="accordion-toggle">
																Update Note to Self </a>
														</h4>
													</div>
													<div class="panel-collapse collapse  in" id="accordion3_1">
														<div class="panel-body">
															<p>Form for note</p>

														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- END TAB 3 -->
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- END CONTENT -->
				</div>
			</div>
		</div>
	</div>
</div>

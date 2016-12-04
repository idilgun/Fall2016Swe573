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
							<ul class="tabbable faq-tabbable">
								<li class="active"><a href="#tab_1" data-toggle="tab">View
										BMI</a></li>
								<li><a href="#tab_2" data-toggle="tab">Update Weight
										and Height</a></li>
								<li><a href="#tab_3" data-toggle="tab">Update Note to
										Self</a></li>
							</ul>
						</div>
						<div class="col-md-9 col-sm-9">
							<div class="tab-content" style="padding: 0; background: #fff;">
								<!-- START TAB 1 -->
								<div class="tab-pane active" id="tab_1">
									<div class="panel-group" id="accordion1">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a href="#accordion1_1" data-parent="#accordion1"
														data-toggle="collapse" class="accordion-toggle"> Body
														Mass Index </a>
												</h4>
											</div>
											<div class="panel-collapse collapse in" id="accordion1_1">
												<div class="panel-body">BMI calculation will be shown
													here</div>
											</div>
										</div>



									</div>
								</div>
								<!-- END TAB 1 -->
								<!-- START TAB 2 -->
								<div class="tab-pane" id="tab_2">
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
													<p>Form for weight</p>
													<p>Form for height</p>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- END TAB 3 -->
								<!-- START TAB 3 -->
								<div class="tab-pane" id="tab_3">
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

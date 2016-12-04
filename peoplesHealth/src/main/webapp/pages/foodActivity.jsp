<div ng-app="mainApp">
	<div>
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


				<!-- BEGIN SIDEBAR & CONTENT -->
				<div class="row margin-bottom-40">
					<!-- BEGIN CONTENT -->
					<div class="col-md-12 col-sm-12">
						<h1>What have you been up to?</h1>
						<div class="content-page">

							<div class="row">
								<!-- TABS -->
								<div class="col-md-7 tab-style-1">
									<ul class="nav nav-tabs">
										<li class="active"><a data-toggle="tab" href="#tab-1">Food
												Consumption</a></li>
										<li class=""><a data-toggle="tab" href="#tab-2">Activity</a></li>
									</ul>
									<div class="tab-content">
										<div id="tab-1" class="tab-pane row fade active in">
											<div class="col-md-9">
												<p class="margin-bottom-10">Food consumption interface
													will be provided here</p>
											</div>
										</div>
										<div id="tab-2" class="tab-pane row fade">
											<div class="col-md-9">
												<p>Activity interface will be provided here</p>
											</div>
										</div>
									</div>
								</div>
								<!-- END TABS -->

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
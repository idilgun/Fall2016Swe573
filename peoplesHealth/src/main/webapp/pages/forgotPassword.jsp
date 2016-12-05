<div ng-app="mainApp">
	<div ng-controller="forgottenController">
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
					<div class="col-md-9 col-sm-9">
						<h1>Forgot Your Password?</h1>
						<div class="content-form-page">
							<div class="row">
								<div class="col-md-7 col-sm-7">
									<div class="alert alert-success" ng-show="showSuccessAlert">
										<button type="button" class="close"
											data-ng-click="switchBool('showSuccessAlert')">×</button>
										<strong>Done!</strong> {{successTextAlert}}
									</div>
									<form class="form-horizontal form-without-legend" role="form">
										<div class="form-group">
											<label for="email" class="col-lg-4 control-label">Email</label>
											<div class="col-lg-8">
												<input type="text" class="form-control" id="email"
													ng-model="forgotten_email">
											</div>
										</div>
										<div class="row">
											<div
												class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-5">
												<button ng-click="sendPassword()" type="submit"
													class="btn btn-primary">Send</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- END CONTENT -->
				</div>
				<!-- END SIDEBAR & CONTENT -->
			</div>
		</div>
	</div>
</div>
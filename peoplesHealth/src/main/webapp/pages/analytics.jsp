<div ng-app="mainApp">
	<div ng-controller="analyticsController">
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
							<li><a href="#/loginPage" ng-click="logOut()">Log Out</a></li>
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
						<h1>Analytics</h1>
						<div class="content-page">
							<div class="filter-v1">
								<ul class="mix-filter">
									<li data-filter="all" class="filter active">Calorie
										Analytics</li>
									<li data-filter="category_1" class="filter">Nutrient
										Analytics</li>
									<li data-filter="category_2" class="filter">BMI Analytics</li>
								</ul>
								<div class="row mix-grid thumbnails">
									<div class="col-md-6 col-sm-6 mix category_1 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img1.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img1.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 mix category_2 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img2.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img2.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 mix category_3 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img3.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img3.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div
										class="col-md-6 col-sm-6 mix category_1 category_2 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img4.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img4.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div
										class="col-md-6 col-sm-6 mix category_2 category_1 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img5.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img5.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div
										class="col-md-6 col-sm-6 mix category_1 category_2 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img6.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img6.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div
										class="col-md-6 col-sm-6 mix category_2 category_3 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img1.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img1.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div
										class="col-md-6 col-sm-6 mix category_1 category_2 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img2.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img2.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 mix category_3 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img4.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img4.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 mix category_1 mix_all"
										style="display: block; opacity: 1;">
										<div class="mix-inner">
											<img alt=""
												src="${pageContext.request.contextPath}/resources/assets/pages/img/works/img3.jpg"
												class="img-responsive">
											<div class="mix-details">
												<h4>Cascusamus et iusto odio</h4>
												<p>At vero eos et accusamus et iusto odio digniss imos
													duc sasdimus qui sint blanditiis prae sentium voluptatum
													deleniti atque corrupti quos dolores.</p>
												<a class="mix-link"><i class="fa fa-link"></i></a> <a
													data-rel="fancybox-button" title="Project Name"
													href="assets/pages/img/works/img3.jpg"
													class="mix-preview fancybox-button"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- END CONTENT -->
				</div>
				<!-- BEGIN SIDEBAR & CONTENT -->
			</div>
		</div>
	</div>
</div>
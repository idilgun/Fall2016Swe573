<!DOCTYPE html>
<!--
Template: Metronic Frontend Freebie - Responsive HTML Template Based On Twitter Bootstrap 3.3.4
Version: 1.0.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase Premium Metronic Admin Theme: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
<meta charset="utf-8">
<title>Create new account | People's Health</title>

<link rel="shortcut icon" href="favicon.ico">

<!-- Fonts START -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<!-- Fonts END -->

<!-- Global styles START -->
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link
	href="${pageContext.request.contextPath}/resources/assets/pages/css/components.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/assets/corporate/css/style.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/assets/corporate/css/style-responsive.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/assets/corporate/css/themes/green.css"
	rel="stylesheet" id="style-color">
<link
	href="${pageContext.request.contextPath}/resources/assets/corporate/css/custom.css"
	rel="stylesheet">
<!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">

	<!-- BEGIN TOP BAR -->
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
						<li><a href="page-login.jsp">Log In</a></li>
						<li><a href="page-reg-page.jsp">Sign Up</a></li>
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

					<li><a href="index.jsp">Home</a></li>

					<li><a href="page-faq.jsp">BMI</a></li>

					<li><a href="page-services.jsp">Food and Activity</a></li>

					<li><a href="portfolio-2.jsp">Analytics</a></li>

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
					<h1>Create an account</h1>
					<div class="content-form-page">
						<div class="row">
							<div class="col-md-7 col-sm-7">
								<form class="form-horizontal" role="form" id="signUpForm">
									<fieldset>
										<legend>Sign Up Details</legend>
										<div class="form-group">
											<label for="firstname" class="col-lg-4 control-label">How
												should we call you? <span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input type="text" class="form-control" id="signUp_name">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-lg-4 control-label">Your
												Email? <span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input type="text" class="form-control" id="signUp_email">
											</div>
										</div>
										<div class="form-group">
											<label for="birthDay" class="col-lg-4 control-label">When
												were you born? <span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<table>
													<tr>
														<td>Day <select class="form-control" name='day'
															id="signUp_dateOfBirth_day">
																<option value='1'>1</option>
																<option value='2'>2</option>
																<option value='3'>3</option>
																<option value='4'>4</option>
																<option value='5'>5</option>
																<option value='6'>6</option>
																<option value='7'>7</option>
																<option value='8'>8</option>
																<option value='9'>9</option>
																<option value='10'>10</option>
																<option value='11'>11</option>
																<option value='12'>12</option>
																<option value='13'>13</option>
																<option value='14'>14</option>
																<option value='15'>15</option>
																<option value='16'>16</option>
																<option value='17'>17</option>
																<option value='18'>18</option>
																<option value='19'>19</option>
																<option value='20'>20</option>
																<option value='21'>21</option>
																<option value='22'>22</option>
																<option value='23'>23</option>
																<option value='24'>24</option>
																<option value='25'>25</option>
																<option value='26'>26</option>
																<option value='27'>27</option>
																<option value='28'>28</option>
																<option value='29'>29</option>
																<option value='30'>30</option>
																<option value='31'>31</option>
														</select></td>
														<td>Month <select class="form-control" name='month'
															id="signUp_dateOfBirth_month">
																<option value='1'>1</option>
																<option value='2'>2</option>
																<option value='3'>3</option>
																<option value='4'>4</option>
																<option value='5'>5</option>
																<option value='6'>6</option>
																<option value='7'>7</option>
																<option value='8'>8</option>
																<option value='9'>9</option>
																<option value='10'>10</option>
																<option value='11'>11</option>
																<option value='12'>12</option>
														</select></td>
														<td>Year <select class="form-control" name='day'
															id="signUp_dateOfBirth_year">
																<option value='1960'>1960</option>
																<option value='1961'>1961</option>
																<option value='1962'>1962</option>
																<option value='1963'>1963</option>
																<option value='1964'>1964</option>
																<option value='1965'>1965</option>
																<option value='1966'>1966</option>
																<option value='1967'>1967</option>
																<option value='1968'>1968</option>
																<option value='1969'>1969</option>
																<option value='1970'>1970</option>
																<option value='1971'>1971</option>
																<option value='1972'>1972</option>
																<option value='1973'>1973</option>
																<option value='1974'>1974</option>
																<option value='1975'>1975</option>
																<option value='1976'>1976</option>
																<option value='1977'>1977</option>
																<option value='1978'>1978</option>
																<option value='1979'>1979</option>
																<option value='1980'>1980</option>
																<option value='1981'>1981</option>
																<option value='1982'>1982</option>
																<option value='1983'>1983</option>
																<option value='1984'>1984</option>
																<option value='1985'>1985</option>
																<option value='1986'>1986</option>
																<option value='1987'>1987</option>
																<option value='1988'>1988</option>
																<option value='1989'>1989</option>
																<option value='1990'>1990</option>
																<option value='1991'>1991</option>
																<option value='1992'>1992</option>
																<option value='1993'>1993</option>
																<option value='1994'>1994</option>
																<option value='1995'>1995</option>
																<option value='1996'>1996</option>
																<option value='1997'>1997</option>
																<option value='1998'>1998</option>
																<option value='1999'>1999</option>
																<option value='2000'>2000</option>
																<option value='2001'>2001</option>
																<option value='2002'>2002</option>
																<option value='2003'>2003</option>
																<option value='2004'>2004</option>
																<option value='2005'>2005</option>
																<option value='2006'>2006</option>
																<option value='2007'>2007</option>
																<option value='2008'>2008</option>
																<option value='2009'>2009</option>
																<option value='2010'>2010</option>
																<option value='2011'>2011</option>
																<option value='2012'>2012</option>
																<option value='2013'>2013</option>
																<option value='2014'>2014</option>

														</select></td>
													</tr>
												</table>
											</div>
										</div>
										<div class="form-group">
											<label for="gender" class="col-lg-4 control-label">Gender
												<span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<label class="radio-inline"> <input type="radio"
													id="signUp_genderFemale" name="signUpGender">Female
												</label> <label class="radio-inline"> <input type="radio"
													id="signUp_genderMale" name="signUpGender">Male
												</label>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend>Your password</legend>
										<div class="form-group">
											<label for="password" class="col-lg-4 control-label">Password
												<span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input type="text" class="form-control" id="signUp_password">
											</div>
										</div>
										<div class="form-group">
											<label for="confirm-password" class="col-lg-4 control-label">Confirm
												password <span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input type="text" class="form-control"
													id="signUp_confirmPassword">
											</div>
										</div>
									</fieldset>
									<div class="row">
										<div
											class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
											<button type="submit" class="btn btn-primary"
												id="signUp_submitButton">Create an account</button>
											<button type="button" class="btn btn-default">Cancel</button>
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
	
	<script type="text/javascript"
					src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$('#signUp_submitButton').on("click", function() {
							
							
							
				});
	</script>





	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/respond.min.js"></script>
    <![endif]-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/corporate/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initUniform();
			Layout.initTwitter();
		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
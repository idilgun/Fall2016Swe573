<html ng-app="loginModule">
<head>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/Script.js"></script>
	
	<meta charset="utf-8">
  <title>People's Health</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <link rel="shortcut icon" href="favicon.ico">

  <!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="${pageContext.request.contextPath}/resources/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="${pageContext.request.contextPath}/resources/assets/pages/css/animate.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/assets/plugins/owl.carousel/assets/owl.carousel.css" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="${pageContext.request.contextPath}/resources/assets/pages/css/components.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/assets/pages/css/slider.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/assets/corporate/css/style.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/assets/corporate/css/style-responsive.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/assets/corporate/css/themes/green.css" rel="stylesheet" id="style-color">
  <link href="${pageContext.request.contextPath}/resources/assets/corporate/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
	
</head>
<body ng-controller="loginController">
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
        <a class="site-logo" href="index.jsp"><img src="${pageContext.request.contextPath}/resources/assets/corporate/img/logos/peoplesHealth.png" alt="people's health"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

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

    <!-- BEGIN SLIDER -->
    <div class="page-slider margin-bottom-40">
        <div id="carousel-example-generic" class="carousel slide carousel-slider">


            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <!-- First slide -->
                <div class="item carousel-item-eight active">
                    <div class="container">
                        <div class="carousel-position-six text-uppercase text-center">
                            <h2 class="margin-bottom-20 animate-delay carousel-title-v5" data-animation="animated fadeInDown">
                                Start a healthy trend!<br/>
                                <span class="carousel-title-normal">Be Happy</span>
                            </h2>
                            <p class="carousel-subtitle-v5 border-top-bottom margin-bottom-30" data-animation="animated fadeInDown">We will help you</p>
                            <a class="carousel-btn-green" href="page-reg-page.jsp" data-animation="animated fadeInUp">Sign Up Now!</a>
                        </div>
                    </div>
                </div>
        </div>
    </div>
    <!-- END SLIDER -->

    <div class="main">
      <div class="container">




        <!-- BEGIN STEPS -->
        <div class="row margin-bottom-40 front-steps-wrapper front-steps-count-3">
          <div class="col-md-4 col-sm-4 front-step-col">
            <div class="front-step front-step1">
              <h2>Record what you eat</h2>
              <p>Enter what you eat daily, see calorie and nutrition values</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4 front-step-col">
            <div class="front-step front-step2">
              <h2>Record your activity</h2>
              <p>Enter daily tasks like walking your dog or a session in the gym, this will be a reason to actually go</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4 front-step-col">
            <div class="front-step front-step3">
              <h2>See the improvement</h2>
              <p>You won't believe how awareness changes you! Analyse how your eating and fitness behaviour impacts you</p>
            </div>
          </div>
        </div>
        <!-- END STEPS -->

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>
    <![endif]--> 
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="${pageContext.request.contextPath}/resources/assets/corporate/scripts/back-to-top.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/owl.carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->

    <script src="${pageContext.request.contextPath}/resources/assets/corporate/scripts/layout.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/pages/scripts/bs-carousel.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initTwitter();
            //Layout.initFixHeaderWithPreHeader(); /* Switch On Header Fixing (only if you have pre-header) */
            //Layout.initNavScrolling(); 
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
    
    
	<input type="text" ng-model="name">
	<div ng-bind="name"></div>
	
	<div> First Name: {{ user.firstName }}</div>
	<div> Last Name: {{ user.lastName }}</div>

	<h2>Fall2016Swe573</h2>
	<h4>Semester project on nutrition tracking for Bogazici University
		SWE 573</h4>
	<p>This project is most generally a web application where users can
		get information about what they eat. The higest level requirement is
		the user of the web application should to be insipired to undertake a
		healtier life style.</p>

	<form id="signUpForm" class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="signUp_email"
					placeholder="Enter email">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Password:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="signUp_password"
					placeholder="Enter password">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="signUp_name"
					placeholder="Enter name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dateOfBirth">Date
				of Birth:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="signUp_dateOfBirth"
					placeholder="Enter date of birth">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="gender">Select Gender:</label>
			<label class="radio-inline"> <input type="radio" id="signUp_genderFemale"
				name="signUpGender">Female</label> 
			<label class="radio-inline"> <input type="radio" id="signUp_genderMale"
				name="signUpGender">Male</label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button id="signUp_submitButton" type="submit"
					class="btn btn-default">Submit</button>
			</div>
		</div>
	</form>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>

	<script>
		$('#signUp_submitButton')
				.on(
						"click",
						function() {

							var postObj = {};
							postObj.email = document
									.getElementById('signUp_email').value
							postObj.password = document
									.getElementById('signUp_password').value
							postObj.gender = "F";
							postObj.dateOfBirth = document
									.getElementById('signUp_dateOfBirth').value
							postObj.name = document
									.getElementById('signUp_name').value
							
							console.log(postObj);

							console.log();

							$
									.ajax({
										url : '../peoplesHealth/newUser',
										type : 'post',
										dataType : 'json',
										data : JSON.stringify(postObj),
										contentType : 'application/json; charset=utf-8',
										success : function(data) {
											console.log(data);
										},
										error : function(data) {
											console.log(data);
										}
									});
						});
	</script>

</body>
</html>

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<script
	src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/angular-route.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/index.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/registerScript.js"></script>



<meta charset="utf-8">
<title>People's Health</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

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
	href="${pageContext.request.contextPath}/resources/assets/pages/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/owl.carousel/assets/owl.carousel.css"
	rel="stylesheet">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link
	href="${pageContext.request.contextPath}/resources/assets/pages/css/components.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/assets/pages/css/slider.css"
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
<body ng-app="mainApp">
	<div ng-view></div>

	<!-- END STEPS -->

	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>
    <![endif]-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->

	<!-- END PAGE LEVEL JAVASCRIPTS -->

</body>
</html>

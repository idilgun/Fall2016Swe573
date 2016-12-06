var app = angular.module('mainApp', ['ngRoute', 'registerModule', 'foodActivityModule']);

app.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl: 'pages/welcome.jsp'
		})
		.when('/signUpPage', {
			templateUrl: 'pages/signUp.jsp'
		})
		.when('/loginPage', {
			templateUrl: 'pages/login.jsp'
		})
		.when('/forgotPassword', {
			templateUrl: 'pages/forgotPassword.jsp'
		})
		.when('/bmi', {
			resolve: {
				"check" : function($location, $rootScope){
					if(!$rootScope.loggedIn){
						$location.path('/loginPage');
					}
				}
			},
			templateUrl: 'pages/bmi.jsp'
		})
		.when('/foodActivity', {
			resolve: {
				"check" : function($location, $rootScope){
					if(!$rootScope.loggedIn){
						$location.path('/loginPage');
					}
				}
			},
			templateUrl: 'pages/foodActivity.jsp'
		})
		.when('/analytics', {
			resolve: {
				"check" : function($location, $rootScope){
					if(!$rootScope.loggedIn){
						$location.path('/loginPage');
					}
				}
			},
			templateUrl: 'pages/analytics.jsp'
		})
		.otherwise({
			redirectTo: '/'
		});
});
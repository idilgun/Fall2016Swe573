var app = angular.module('mainApp', ['ngRoute', 'registerModule']);

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
		.when('/bmi', {
			resolve: {
				"check" : function($location, $rootScope){
					if(!$rootScope.loggedIn){
						$location.path('/loginPage');
						console.log("leggedIn: " + $rootScope.loggedIn);
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
						console.log("leggedIn: " + $rootScope.loggedIn);
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
						console.log("leggedIn: " + $rootScope.loggedIn);
					}
				}
			},
			templateUrl: 'pages/analytics.jsp'
		})
		.otherwise({
			redirectTo: '/'
		});
});
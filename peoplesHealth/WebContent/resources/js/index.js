var app = angular.module('mainApp', ['ngRoute', 'registerModule']);

app.config(['$routeProvider', function($routeProvider) {
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
			templateUrl: 'pages/bmi.jsp'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);
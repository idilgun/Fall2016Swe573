

var loginApp = angular.module('loginModule',[]);

loginApp.controller('loginController', function($scope) {
	
	var user = {
			firstName : "Idil",
			lastName : "Gun",
			gender : "Female",
	};
	
	
	$scope.user = user;
});

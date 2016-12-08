var analyticsApp = angular.module('analyticsModule', [ 'ngRoute',
		'mainApp' ]);

foodActivityApp
		.controller(
				'analyticsController',
				[
						'$scope',
						'$http',
						'$window',
						'$location',
						'$rootScope',
						function($scope, $http, $window, $location, $rootScope) {
							
							$scope.logOut = function() {
								$rootScope.loggedIn = false;
							};
							
						
}]);

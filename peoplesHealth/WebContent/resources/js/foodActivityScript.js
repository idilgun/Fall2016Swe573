var foodActivityApp = angular.module('foodActivityModule', [ 'ngRoute',
		'mainApp' ]);

foodActivityApp.controller('foodConsumptionController', [ '$scope', '$http',
		'$window', '$location', '$rootScope',
		function($scope, $http, $window, $location, $rootScope) {

			var currentDate = new Date();
			
			$scope.foodConsumption_date_day = currentDate.getUTCDate();
			$scope.foodConsumption_date_month = currentDate.getUTCMonth() + 1;
			$scope.foodConsumption_date_year = currentDate.getUTCFullYear();
			
			$scope.foodName = "";
			$scope.foodGroup = "";
			
			$scope.todaysDate = $scope.foodConsumption_date_day + " / " + $scope.foodConsumption_date_month + " / " + $scope.foodConsumption_date_year;
			
			console.log($scope.foodConsumption_date_day);
			console.log($scope.foodConsumption_date_month);
			console.log($scope.foodConsumption_date_year);


			$scope.getUrl = function() {
				if (location.hostname == "localhost") {
					return "http://" + location.host + "/peoplesHealth";
				} else {
					return "http://" + location.host;
				}
			};

			$scope.searchFoodByName = function(){
				
				console.log($scope.foodName);
				console.log($scope.foodGroup);
			};

		} ]);
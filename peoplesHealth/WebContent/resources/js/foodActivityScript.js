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
				$http.get($scope.getUrl() + '/searchFood/' 
						+ $scope.foodName + "/" + $scope.foodGroup, {}, {
					'Accept' : 'text/plain;charset=ISO-8859-1',
					'Content-Type' : 'text/plain'
				}).success(function(data, status, headers, config) {
					console.log(data);
					$scope.foodOptions = data.list.item;
				}).error(function(data, status, headers, config) {
					window.alert("We couldn't find any food items for this search");
				});
			};
			
			console.log($scope.$parent.selected);
			
			$scope.printSelection = function(){
				console.log("The function works");
				console.log($scope.$parent.selected);
			};

		} ]);
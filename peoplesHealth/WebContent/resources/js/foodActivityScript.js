var foodActivityApp = angular.module('foodActivityModule', [ 'ngRoute',
		'mainApp' ]);

foodActivityApp
		.controller(
				'foodConsumptionController',
				[
						'$scope',
						'$http',
						'$window',
						'$location',
						'$rootScope',
						function($scope, $http, $window, $location, $rootScope) {

							$scope.foodName = "";
							$scope.foodGroup = "";
							$scope.selectedItem = {};
							$scope.selectedUnit = "";
							$scope.foodAmount = "";
							$scope.selectedNdbno = "";
							
							$scope.logOut = function() {
								$rootScope.loggedIn = false;
							};

							$scope.initDatePicker = function() {
								var currentDate = new Date();

								$scope.foodConsumption_date_year = (currentDate
										.getUTCFullYear()).toString();
								$scope.foodConsumption_date_day = currentDate
										.getUTCDate().toString();
								$scope.foodConsumption_date_month = (currentDate
										.getUTCMonth() + 1).toString();

								$scope.todaysDate = $scope.foodConsumption_date_day
										+ " / "
										+ $scope.foodConsumption_date_month
										+ " / "
										+ $scope.foodConsumption_date_year;

								console.log($scope.foodConsumption_date_day);
								console.log($scope.foodConsumption_date_month);
								console.log($scope.foodConsumption_date_year);
							};

							$scope.getUrl = function() {
								if (location.hostname == "localhost") {
									return "http://" + location.host
											+ "/peoplesHealth";
								} else {
									return "http://" + location.host;
								}
							};

							$scope.searchFoodByName = function() {

								$scope.showItems = true;
								$scope.showItemDetails = false;
								$scope.showSelectedItem = false;
								$scope.showSelectedItemUnits = false;

								$http
										.get(
												$scope.getUrl()
														+ '/searchFood/'
														+ $scope.foodName + "/"
														+ $scope.foodGroup,
												{},
												{
													'Accept' : 'text/plain;charset=ISO-8859-1',
													'Content-Type' : 'text/plain'
												})
										.success(
												function(data, status, headers,
														config) {
													console.log(data);
													$scope.foodOptions = data.list.item;
												})
										.error(
												function(data, status, headers,
														config) {
													window
															.alert("We couldn't find any food items for this search");
												});
							};

							$scope.selectItem = function(item) {

								$scope.showItems = false;
								$scope.showSelectedItem = true;
								$scope.selectedItemName = item.name;
								$scope.selectedNdbno = item.ndbno;

								$http
										.get(
												$scope.getUrl()
														+ '/foodItemUnits/'
														+ item.ndbno,
												{},
												{
													'Accept' : 'text/plain;charset=ISO-8859-1',
													'Content-Type' : 'text/plain'
												})
										.success(
												function(data, status, headers,
														config) {
													console.log(data);
													$scope.showSelectedItemUnits = true;
													$scope.unitOptions = data;
													$scope.selectedUnit = data[0];
												})
										.error(
												function(data, status, headers,
														config) {
													window
															.alert("Something went wrong, please try again.");
												});
							};

							$scope.addFoodItem = function() {
								console.log($scope.selectedUnit);
								console.log($scope.foodAmount);
								console.log($scope.selectedNdbno);
								console.log($rootScope.email);
							};

							$scope.getDetailsOfItem = function() {
								$http
										.get(
												$scope.getUrl()
														+ '/foodDetails/'
														+ $scope.selectedNdbno,
												{
													params : {
														unit : $scope.selectedUnit,
														amount : $scope.foodAmount
													}
												},
												{
													'Accept' : 'text/plain;charset=ISO-8859-1',
													'Content-Type' : 'text/plain'
												})
										.success(
												function(data, status, headers,
														config) {
													console.log(data);
													$scope.nutritionValues = data;
													$scope.showItemDetails = true;
												})
										.error(
												function(data, status, headers,
														config) {
													window
															.alert("Something went wrong, please try again.");
												});
							};

						} ]);
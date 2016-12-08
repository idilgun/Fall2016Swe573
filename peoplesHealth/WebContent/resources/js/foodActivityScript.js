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
							
							$scope.activityName = "";
							$scope.selectedActivityItem = {};
							$scope.selectedActivityItemName = "";
							$scope.activityHours = "";
							
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
								
								if ($scope.foodConsumption_date_day < 10) {
									$scope.foodConsumption_date_day = "0"
											+ $scope.foodConsumption_date_day;
								}

								if ($scope.foodConsumption_date_month < 10) {
									$scope.foodConsumption_date_month = "0"
											+ $scope.foodConsumption_date_month;
								}

								var foodConsumption = {

									email : $rootScope.email,
									ndbno : $scope.selectedNdbno,
									itemUnit : $scope.selectedUnit,
									amount : $scope.foodAmount,
									date : $scope.foodConsumption_date_year
											+ $scope.foodConsumption_date_month
											+ $scope.foodConsumption_date_day
									
								};
								
								$http.post($scope.getUrl() + '/addFoodConsumption', foodConsumption, {
									'Content-Type' : 'application/json'
								}).success(function(data, status, headers, config) {
									$location.path('/analytics');
								}).error(function(data, status, header, config) {
									window.alert(data.message);
								});
								
								
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
							
							
							
							$scope.searchActivity = function(){
								$scope.showSelectedItemHours = false;
								$scope.showSelectedActivityItem = false;
								$http
								.get(
										$scope.getUrl()
												+ '/searchActivity',
										{
											params : {
												activityName : $scope.activityName,
											}
										},
										{
											'Accept' : 'text/plain;charset=ISO-8859-1',
											'Content-Type' : 'text/plain'
										})
								.success(
										function(data, status, headers,
												config) {
											$scope.showActivityItems = true;
											$scope.activityItems = data;
											console.log(data);
										})
								.error(
										function(data, status, headers,
												config) {
											window
													.alert("oops, something went wrong, please enter activity name again");
										});
							};
							
							$scope.selectActivityItem = function(item){
								$scope.showActivityItems = false;
								$scope.showSelectedActivityItem = true;
								$scope.selectedActivityItem = item;
								$scope.selectedActivityItemName = item.activityName;
								$scope.showSelectedItemHours = true;
								
							};
							
							$scope.addActivity = function(){
								
								if ($scope.foodConsumption_date_day < 10) {
									$scope.foodConsumption_date_day = "0"
											+ $scope.foodConsumption_date_day;
								}

								if ($scope.foodConsumption_date_month < 10) {
									$scope.foodConsumption_date_month = "0"
											+ $scope.foodConsumption_date_month;
								}
								
								$http
								.get(
										$scope.getUrl()
												+ '/addActivity',
										{
											params : {
												email : $rootScope.email,
												activityId : $scope.selectedActivityItem.activityId,
												date : $scope.foodConsumption_date_year
												+ $scope.foodConsumption_date_month
												+ $scope.foodConsumption_date_day,
												hours : $scope.activityHours
											}
										},
										{
											'Accept' : 'text/plain;charset=ISO-8859-1',
											'Content-Type' : 'text/plain'
										})
								.success(
										function(data, status, headers,
												config) {
											$location.path('/analytics');
										})
								.error(
										function(data, status, headers,
												config) {
											window
													.alert("oops, something went wrong, please add activity again");
										});
							};

						} ]);
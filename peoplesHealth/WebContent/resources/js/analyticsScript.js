var analyticsApp = angular.module('analyticsModule', [ 'ngRoute', 'mainApp' ]);

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

							$scope.selectedFoodEntry = {};

							$scope.initDatePicker = function() {
								var currentDate = new Date();

								$scope.analytics_date_year = (currentDate
										.getUTCFullYear()).toString();
								$scope.analytics_date_day = currentDate
										.getUTCDate().toString();
								$scope.analytics_date_month = (currentDate
										.getUTCMonth() + 1).toString();

								$scope.todaysDate = $scope.analytics_date_day
										+ " / " + $scope.analytics_date_month
										+ " / " + $scope.analytics_date_year;

								$scope.getFoodAndActivityForDate();

							};

							$scope.getUrl = function() {
								if (location.hostname == "localhost") {
									return "http://" + location.host
											+ "/peoplesHealth";
								} else {
									return "http://" + location.host;
								}
							};

							$scope.logOut = function() {
								$rootScope.loggedIn = false;
							};

							$scope.getFoodAndActivityForDate = function() {

								if ($scope.analytics_date_day < 10) {
									$scope.analytics_date_day = "0"
											+ $scope.analytics_date_day;
								}

								if ($scope.analytics_date_month < 10) {
									$scope.analytics_date_month = "0"
											+ $scope.analytics_date_month;
								}

								$http
										.get(
												$scope.getUrl()
														+ '/getFoodActivityHistory',
												{
													params : {
														email : $rootScope.email,
														date : $scope.analytics_date_year
																+ $scope.analytics_date_month
																+ $scope.analytics_date_day,
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
													console.log(data);
													$scope.foodHistory = data.foodConsumptionHistory;

													$scope.activityHistory = data.activityHistory;
													$scope.totalCalorieConsumed = data.totalCalorieConsumption;
													$scope.totalCalorieBurned = data.totalCalorieBurn;
												})
										.error(
												function(data, status, headers,
														config) {
													window
															.alert("oops, something went wrong, couldn't load history");
												});

							};

							$scope.selectItem = function($index) {
								$scope.selectedFoodEntry = $scope.foodHistory[$index];
								console.log($scope.selectedFoodEntry);
							};

							$scope.initWeightChart = function() {
								
								$http
								.get(
										$scope.getUrl()
												+ '/getUserWeightHistory',
										{
											params : {
												email : $rootScope.email,
											}
										},
										{
											'Accept' : 'text/plain;charset=ISO-8859-1',
											'Content-Type' : 'text/plain'
										})
								.success(
										function(historyData, status, headers,
												config) {
											console.log(historyData);
											$scope.weightHistory = historyData;
											
											if(historyData.length == 0){
												$scope.userHasData = false;
												$scope.showNoData = true;
											}
											
											var weightItems = [];
											for ( var i = 0; i < historyData.length; i++) { 
												$scope.userHasData = true;
												$scope.showNoData = false;
												var weightItem = [historyData[i].id.dateTime, historyData[i].weight ];
												weightItems.push(weightItem);
											}
											

											Highcharts
											.chart(
													'weightChart',
													{
														chart : {
															type : 'spline'
														},
														title : {
															text : 'Weight Change'
														},
														subtitle : {
															text : ''
														},
														xAxis : {
															type : 'datetime',
															dateTimeLabelFormats : {
																hour : '%H:%M',
																day : '%e. %b'
															},
															title : {
																text : 'Date'
															}
														},
														yAxis : {
															title : {
																text : 'Weight (kg)'
															},
															min : 50
														},
														tooltip : {
															headerFormat : '<b>{series.name}</b><br>',
															pointFormat : '{point.x:%e. %b}: {point.y:.0f} kg'
														},

														plotOptions : {
															spline : {
																marker : {
																	enabled : true
																}
															}
														},

														series : [ {
															name : 'Weight',
															data : weightItems
														} ]
													});
											
											
										})
								.error(
										function(data, status, headers,
												config) {
											window
													.alert("oops, something went wrong, couldn't load weight history");
										});
								
								
								
							};

						} ]);

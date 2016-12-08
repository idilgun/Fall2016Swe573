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
										+ " / "
										+ $scope.analytics_date_month
										+ " / "
										+ $scope.analytics_date_year;
								
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
							
							$scope.getFoodAndActivityForDate = function(){
								
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
							
							$scope.selectItem = function($index){
								$scope.selectedFoodEntry = $scope.foodHistory[$index];
								console.log($scope.selectedFoodEntry);
							};
							
							$scope.weightChartInit = function(){
								Highcharts.chart('container', {
							        title: {
							            text: 'Monthly Average Temperature',
							            x: -20 //center
							        },
							        subtitle: {
							            text: 'Source: WorldClimate.com',
							            x: -20
							        },
							        xAxis: {
							            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
							                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
							        },
							        yAxis: {
							            title: {
							                text: 'Temperature (°C)'
							            },
							            plotLines: [{
							                value: 0,
							                width: 1,
							                color: '#808080'
							            }]
							        },
							        tooltip: {
							            valueSuffix: '°C'
							        },
							        legend: {
							            layout: 'vertical',
							            align: 'right',
							            verticalAlign: 'middle',
							            borderWidth: 0
							        },
							        series: [{
							            name: 'Tokyo',
							            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
							        }, {
							            name: 'New York',
							            data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
							        }, {
							            name: 'Berlin',
							            data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
							        }, {
							            name: 'London',
							            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
							        }]
							    });
							};
							
						
}]);

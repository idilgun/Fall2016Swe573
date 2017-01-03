var loginApp = angular.module('registerModule', [ 'ngRoute', 'mainApp' ]);

loginApp.factory('UserService', function() {
	var user = {};

	return {
		setUser : setUser,
		getUser : getUser
	};

	function setUser(inputUser) {
		user = inputUser;
	}
	function getUser() {
		return user;
	}
});

loginApp.controller('registerController', [
		'$scope',
		'$http',
		'$window',
		'UserService',
		'$location',
		'$rootScope',
		function($scope, $http, $window, UserService, $location, $rootScope) {

			$scope.getUrl = function() {
				if (location.hostname == "localhost") {
					return "http://" + location.host + "/peoplesHealth";
				} else {
					return "http://" + location.host;
				}
			};

			$scope.signUp_gender = "";
			$scope.signUp_name = "";
			$scope.signUp_email = "";
			$scope.signUp_dateOfBirth_day = "";
			$scope.signUp_dateOfBirth_month = "";
			$scope.signUp_dateOfBirth_year = "";
			$scope.signUp_genderFemale = "";
			$scope.signUp_genderMale = "";
			$scope.signUp_password = "";
			$scope.signUp_confirmPassword = "";

			$scope.signUp = function() {

				if ($scope.signUp_password != $scope.signUp_confirmPassword) {
					window.alert("passwords don't match, please try again");
					return;
				}

				if ($scope.signUp_dateOfBirth_day < 10) {
					$scope.signUp_dateOfBirth_day = "0"
							+ $scope.signUp_dateOfBirth_day;
				}

				if ($scope.signUp_dateOfBirth_month < 10) {
					$scope.signUp_dateOfBirth_month = "0"
							+ $scope.signUp_dateOfBirth_month;
				}

				var user = {

					name : $scope.signUp_name,
					email : $scope.signUp_email,
					gender : $scope.signUp_gender,
					password : $scope.signUp_password,
					dateOfBirth : $scope.signUp_dateOfBirth_year
							+ $scope.signUp_dateOfBirth_month
							+ $scope.signUp_dateOfBirth_day
				};

				// console.log(user);
				// we need to add peoplesHealth to the url for local host and
				// remove it for deployment???

				$http.post($scope.getUrl() + '/newUser', user, {
					'Content-Type' : 'application/json'
				}).success(function(data, status, headers, config) {
					$rootScope.email = $scope.signUp_email;
					$rootScope.password = $scope.signUp_password;
					$rootScope.loggedIn = true;
					UserService.setUser(user);
					$location.path('/bmi');
				}).error(function(data, status, header, config) {
					window.alert(data);
				});
			};

		} ]);

loginApp.controller('loginController', [ '$scope', '$http', '$window',
		'UserService', '$location', '$rootScope',
		function($scope, $http, $window, UserService, $location, $rootScope) {
			$scope.login_email = "";
			$scope.login_password = "";

			$scope.getUrl = function() {
				if (location.hostname == "localhost") {
					return "http://" + location.host + "/peoplesHealth";
				} else {
					return "http://" + location.host;
				}
			};

			$scope.login = function() {
				$http.get($scope.getUrl() + '/authorizeUser', {
					params : {
						email : $scope.login_email,
						password : $scope.login_password
					}
				}, {
					'Accept' : 'text/plain;charset=ISO-8859-1',
					'Content-Type' : 'text/plain'
				}).success(function(data, status, headers, config) {
					$rootScope.email = $scope.login_email;
					$rootScope.password = $scope.login_password;
					$rootScope.loggedIn = true;
					UserService.setUser(data);
					$location.path('/bmi');
				}).error(function(data, status, headers, config) {
					window.alert("The password or the email you entered is incorrect");
				});
			};
		} ]);

loginApp.controller('bmiController', [
		'$scope',
		'$http',
		'$window',
		'UserService',
		'$rootScope',
		'$location',
		function($scope, $http, $window, UserService, $rootScope, $location) {

			$scope.getUrl = function() {
				if (location.hostname == "localhost") {
					return "http://" + location.host + "/peoplesHealth";
				} else {
					return "http://" + location.host;
				}
			};

			$scope.updateBmi = function() {
				var user = UserService.getUser();
				$scope.name = user.name;
				if(user.notes!=null){
					$scope.noteToSelf = "Remember you said to yourself: " + user.notes;
				}
				$scope.bmi_text = "Please enter weight and height to view BMI";
				console.log(user.weight);
				if (user.weight != null && user.height != null) {
					var bmi = parseFloat(
							user.weight
									/ (user.height / 100 * user.height / 100))
							.toFixed(2);
					var bmiMeaning = "normal weighted";
					if (bmi < 18.5) {
						bmiMeaning = "underweight";
					} else if (bmi < 23) {
					} else if (bmi < 25) {
						bmiMeaning = "overweight, at risk";
					} else if (bmi < 30) {
						bmiMeaning = "overweight, moderately obese";
					} else {
						bmiMeaning = "overweight, severely obese";
					}
					$scope.bmi_text = "Your BMI is " + bmi
							+ " That means that you are " + bmiMeaning + ".";
				}
			};

			$scope.setWeightHeight = function() {
				var user = UserService.getUser();
				if (user.weight == null) {
					$scope.user_weight = "unknown";
				} else {
					$scope.user_weight = user.weight + " kg";
					$scope.weight = user.weight;
				}
				if (user.height == null) {
					$scope.user_height = "unknown";
				} else {
					$scope.user_height = user.height + " cm";
					$scope.height = user.height;
				}
			};

			$scope.updateBmi();
			$scope.setWeightHeight();

			$scope.updateWeightHeight = function() {
				var user = UserService.getUser();
				user.weight = $scope.weight;
				user.height = $scope.height;

				$http.post($scope.getUrl() + '/updateUserInformation', user, {
					'Content-Type' : 'application/json'
				}).success(function(data, status, headers, config) {
					UserService.setUser(user);
					$scope.setWeightHeight();
					$scope.updateBmi();
					$scope.tab = 1;

				}).error(function(data, status, header, config) {
					window.alert("please try again");
				});
			};
			
			$scope.updateNoteToSelf = function() {
				var user = UserService.getUser();
				user.notes = $scope.newNote;

				$http.post($scope.getUrl() + '/updateUserInformation', user, {
					'Content-Type' : 'application/json'
				}).success(function(data, status, headers, config) {
					$rootScope.email = $scope.signUp_email;
					UserService.setUser(user);
					$scope.setWeightHeight();
					$scope.updateBmi();
					$scope.tab = 1;

				}).error(function(data, status, header, config) {
					window.alert("please try again");
				});
			};
			
			$scope.logOut = function() {
				$rootScope.loggedIn = false;
			};

		} ]);

loginApp.controller('forgottenController', [ '$scope', '$http', '$window',
		'$location', function($scope, $http, $window, $location) {

			$scope.getUrl = function() {
				if (location.hostname == "localhost") {
					return "http://" + location.host + "/peoplesHealth";
				} else {
					return "http://" + location.host;
				}
			};

			$scope.sendPassword = function() {
				$http.get($scope.getUrl() + '/forgotPassword', {
					params : {
						email : $scope.forgotten_email,
					}
				}, {
					'Accept' : 'text/plain;charset=ISO-8859-1',
					'Content-Type' : 'text/plain'
				}).success(function(message, status, headers, config) {
					window.alert(message.message);
					$location.path('/loginPage');
				}).error(function(message, status, headers, config) {
					window.alert(message.message);
				});
			};

		} ]);

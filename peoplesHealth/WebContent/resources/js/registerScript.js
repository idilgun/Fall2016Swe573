

var loginApp = angular.module('registerModule',['ngRoute', 'mainApp']);



loginApp.service('authenticationService', function() {
	return {
		userCredentials : {
			email : $scope.login_email,
			password : $scope.login_password
		}
	};
});

loginApp.factory('NameService', function() {
  var name = "";
  
  return {
	  setName : setName,
	  getName : getName
  };
  
  function setName(inputName) {
      name=inputName;
   }
  function getName(){
	  return name;
  }
});



loginApp.controller('registerController', ['$scope','$http', '$window','NameService','$location', '$rootScope', function($scope,  $http, $window, NameService, $location, $rootScope){
	
	$scope.signUp_gender = "";
	$scope.signUp_name = "";
	$scope.signUp_email = "";
	$scope.signUp_dateOfBirth_day = "";
	$scope.signUp_dateOfBirth_month ="";
	$scope.signUp_dateOfBirth_year ="";
	$scope.signUp_genderFemale ="";
	$scope.signUp_genderMale ="";
	$scope.signUp_password ="";
	$scope.signUp_confirmPassword ="";
		
	
	$scope.signUp = function () {
		
		if($scope.signUp_password != $scope.signUp_confirmPassword){
			window.alert("passwords don't match, please try again");
			return;
		}
		
		if($scope.signUp_dateOfBirth_day<10){
			$scope.signUp_dateOfBirth_day = "0" + $scope.signUp_dateOfBirth_day;
		}
		
		if($scope.signUp_dateOfBirth_month<10){
			$scope.signUp_dateOfBirth_month = "0" + $scope.signUp_dateOfBirth_month;
		}
		
		 var user = {
					
					name : $scope.signUp_name,
					email : $scope.signUp_email,
					gender : $scope.signUp_gender,
					password : $scope.signUp_password,
					dateOfBirth : $scope.signUp_dateOfBirth_year + $scope.signUp_dateOfBirth_month + $scope.signUp_dateOfBirth_day
			};
			
		//console.log(user);
// we need to add peoplesHealth to the url for local host and remove it for deployment???
		 
		 if(location.hostname == "localhost"){
			 $http.post('../peoplesHealth/newUser', user, {'Content-Type': 'application/json'})
		        .success(function (data, status, headers, config) {
		        	$rootScope.email = $scope.signUp_email;
		        	$rootScope.password = $scope.signUp_password;
		        	$rootScope.loggedIn = true;
		        	NameService.setName(user.name);
			    	$location.path('/bmi');
		        })
		        .error(function (data, status, header, config) {
		        	window.alert("please try again");
		        }); 
		 }
		 else{
			 $http.post('../newUser', user, {'Content-Type': 'application/json'})
		        .success(function (data, status, headers, config) {
		        	NameService.setName(data.name);
			    	$location.path('/bmi');
		        })
		        .error(function (data, status, header, config) {
		        	window.alert("please try again");
		        });
		 }
     };
	
	
	
}]);

loginApp.controller('loginController', ['$scope','$http', '$window','NameService', '$location', '$rootScope', function($scope,  $http, $window, NameService, $location, $rootScope){
	$scope.login_email = "";
	$scope.login_password = "";

	$scope.login = function () {
		if(location.hostname == "localhost"){
			$http
		    .get('../peoplesHealth/authorizeUser', {
		        params: {
		        	email: $scope.login_email,
		        	password: $scope.login_password
		        }
		     }, {'Accept': 'text/plain;charset=ISO-8859-1', 'Content-Type': 'text/plain'})
		     .success(function (data, status, headers, config) {
		    	$rootScope.email = $scope.signUp_email;
		        $rootScope.password = $scope.signUp_password;
		        $rootScope.loggedIn = true;
		    	NameService.setName(data.name);
		    	$location.path('/bmi');
		     })
		     .error(function (data, status, headers, config) {
		    	 window.alert("The password you entered is incorrect");
	        });
		}
		else{
			$http
		    .get('../authorizeUser', { 
		        params: {
		        	email: $scope.login_email,
		        	password: $scope.login_password
		        }
		     }, {'Accept': 'text/plain;charset=ISO-8859-1', 'Content-Type': 'text/plain'})
		     .success(function (data, status, headers, config) {
		    	 NameService.setName(data.name);
		    	 $location.path('/bmi');
		     })
		     .error(function (data, status, headers, config) {
		    	 window.alert("The password you entered is incorrect");
	        });
		}
		
	};
}]);

loginApp.controller('bmiController', ['$scope','$http', '$window','NameService', '$rootScope', function($scope, $http, $window, NameService, $rootScope){
	$scope.name = NameService.getName();
}]);

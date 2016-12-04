

var loginApp = angular.module('registerModule',['ngRoute']);

loginApp.config(function($routeProvider) {    
	$routeProvider
        .when('/', {
        	controller: 'loginController',
        	templateUrl: 'page-login.jsp'
        })
        .when('/bmi', {
        	controller: 'bmiController',
        	templateUrl: 'page-faq.jsp'
        })
        .otherwise({
        	controller: 'loginController',
        	redirectTo: '/page-faq.jsp'
        });
});

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



loginApp.controller('registerController', ['$scope','$http', '$window', function($scope,  $http, $window){
	
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
		        	console.log("got it !");
		        	$window.location.href = '/peoplesHealth/page-faq.jsp';
		        })
		        .error(function (data, status, header, config) {
		        	console.log("error !");
		        }); 
		 }
		 else{
			 $http.post('../newUser', user, {'Content-Type': 'application/json'})
		        .success(function (data, status, headers, config) {
		        	console.log("got it !");
		        	$window.location.href = '/page-faq.jsp';
		        })
		        .error(function (data, status, header, config) {
		        	console.log("error !");
		        });
		 }
     };
	
	
	
}]);

loginApp.controller('loginController', ['$scope','$http', '$window','NameService', '$location', function($scope,  $http, $window, NameService, $location){
	$scope.login_email = "";
	$scope.login_password = "";
	
	
	$scope.login = function () {
		var name = NameService.getName();
		if(location.hostname == "localhost"){
			$http
		    .get('../peoplesHealth/authorizeUser', {
		        params: {
		        	email: $scope.login_email,
		        	password: $scope.login_password
		        }
		     }, {'Accept': 'text/plain;charset=ISO-8859-1', 'Content-Type': 'text/plain'})
		     .success(function (data, status, headers, config) {
		    	 NameService.setName(data.name);
		    	 $location.path('/bmi');
		    	 //$scope.$apply();
		     })
		     .error(function (data, status, headers, config) {
		    	 window.alert("wrong password");
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
		    	 $window.location.href = '/page-faq.jsp';
		     })
		     .error(function (data, status, headers, config) {
		    	 window.alert("wrong password");
	        });
		}
		
	};
}]);

loginApp.controller('bmiController', ['$scope','$http', '$window','NameService', function($scope, $http, $window, NameService){
	$scope.name = NameService.getName();
	console.log(NameService.getName());
	NameService.setName("aaa");
	console.log(NameService.getName());
}]);

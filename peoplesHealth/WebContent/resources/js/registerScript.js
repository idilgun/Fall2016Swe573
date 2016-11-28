

var loginApp = angular.module('registerModule',[]);

loginApp.controller('registerController', ['$scope',function($scope){
	
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
			
		console.log(user);
     };
	
	
	
}]);

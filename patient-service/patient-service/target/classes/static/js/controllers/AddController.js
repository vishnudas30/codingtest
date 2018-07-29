app.controller('AddController', function($scope, $http,$location){
	
	$scope.addPatient = function() {		
		$http({
		    method : "POST",
		    url : "http://localhost:8080/v1/doctor/addpatient",
		    data : angular.toJson($scope.form),
		    headers : {
		        'Content-Type' : 'application/json'
		    }
		})
		
		$location.path('/');
	};
	
});



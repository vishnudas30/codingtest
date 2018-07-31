app.controller('AddController', function($scope, $http,$location){
	
	$scope.addPatient = function() {
		
		//$scope.addrs = [];
		var addrs1 = [ 
        {
            "addLine1": $scope.form.addLine1,
            "addLine2": $scope.form.addLine2,
            "city":$scope.form.city,
            "country":$scope.form.country,
            "postalCode":$scope.form.postalCode
        }];
		
        $scope.form.addrs=addrs1;
        delete $scope.form.addLine1;
        delete $scope.form.addLine2;
        delete $scope.form.city;
        delete $scope.form.country;
        delete $scope.form.postalCode;
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



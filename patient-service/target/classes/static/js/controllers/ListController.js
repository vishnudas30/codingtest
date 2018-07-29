app.controller('ListController', function($scope, $http, $location) {
  
  $http.get('http://localhost:8080/v1/doctor/getpatients').
        then(function(response) {
            $scope.patients = response.data;
            console.log($scope.patients);
        });
  
  
  $scope.deletePatient = function(pat) {	
		$http({
		    method : "DELETE",
		    url : "http://localhost:8080/v1/doctor/deletepatinet/"+pat.patientId+"/",
		    headers : {
		        'Content-Type' : 'application/json'
		    }
		})
		
		$location.path('/');
 
};

$scope.editPatient = function(pat) {
	
	$http.get("http://localhost:8080/v1/doctor/getpatient/"+pat.patientId+"/").
    then(function(response) {
        $scope.patients = response.data;
    });
	$location.path('/v1/doctor/edit/'+pat.patientId+'');
	
};   
});

 
app.controller('EditController', ['$scope','$location','$http', '$routeParams', '$firebaseObject', 'FBURL',   
    function($scope, $location, $http, $routeParams, $firebaseObject, FBURL){
    
	//var patientId = $routeParams.params;
	var patientId=$location.path().split('/').pop();
	  $http.get("http://localhost:8080/v1/doctor/getpatient/"+patientId+"/").
      then(function(response) {
          $scope.patient = response.data;
          console.log($scope.patient);
      });
	  

    
    $scope.editPatient = function() {
    	console.log("update...");
		$http({
		    method : "PUT",
		    url : "http://localhost:8080/v1/doctor/updatepatient",
		    data : angular.toJson($scope.patient),
		    headers : {
		        'Content-Type' : 'application/json'
		    }
		})
		$location.path('/');
        
    };
     
}]);
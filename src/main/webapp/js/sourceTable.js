function formController($scope,$http) {
	var base_url = window.location.origin;
	
    $scope.submit = function() {
    	var url1 = base_url+"/SD/getSourceTableName";
    	$http.get(url1).success(function(response){
    		$scope.arraySources = response;
    	} );
    }
    
   
    $scope.submit1 = function() {
    	 var url1 = base_url+"/SD/getSourceColumnName/"+$scope.sourceTable;
    	$http.get(url1).success(function(response){
    		$scope.arraySources = response;
    	} );
    }
    
    $scope.submit2 = function() {
    	var url1 = base_url+"/SD/getDestinationTableName";
    	$http.get(url1).success(function(response){
    		$scope.arraySources = response;
    	} );
    }
    
    $scope.submit3 = function() {
   	 var url1 = base_url+"/SD/getDestinationColumnName/"+$scope.destinationTable;
   	$http.get(url1).success(function(response){
   		$scope.arraySources = response;
   	} );
   }

}
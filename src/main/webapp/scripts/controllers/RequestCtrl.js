angular.module('recruitApp.controller')
.controller('RequestCtrl', ['$scope', 'restClient', '$routeParams', '$rootScope', function($scope, restClient, $routeParams, $rootScope) {
    
    $scope.initRequest= function() {
    	
    	var requestID = $routeParams.jobRequestID;
    	
        restClient.post(RestfulAPI.JOB_REQUEST_DETAIL, {jobRequestID :requestID}).then(function(){
            $scope.jobRequest = restClient.getResponse();
        });
    };
    
    $scope.operationRequest = function(boolean) {
    	var user = $rootScope.currentUser;
    	var statusID;
    	if (user.roleID == 4){
    		if (boolean) {
    			statusID = 2;
    		} else {
    			statusID = 3;
    		}
    	} else if (user.roleID == 3) {
    		if (boolean) {
    			statusID = 4;
    		} else {
    			statusID = 5;
    		}
    	} else {
    		if (boolean) {
    			statusID = 6;
    		} else {
    			statusID = 7;
    		}
    	}
    	
    	var operation = {};
    	operation.opinion = $scope.opinion;
    	operation.statusID = statusID;
    	operation.jobRequestID = $scope.jobRequest.jobrequestid;
    	
    	restClient.post(RestfulAPI.JOB_REQUEST_STATUS_CHANGE, {}, operation).then(function(){

    	});
    };
    
}]);
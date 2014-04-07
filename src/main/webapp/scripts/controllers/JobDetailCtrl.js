angular.module('recruitApp.controller').controller('JobDetailCtrl', [ '$scope', '$rootScope', 'restClient', function($scope, $rootScope, restClient) {
    $scope.getJobDetail = function() {
        restClient.post(RestfulAPI.JOB_DETAIL, {jobRecruitID : 1}).then(function() {
        	$scope.jobRecruit = restClient.getResponse();
        });
    };
    
    $scope.init = function() {
    	$scope.getJobDetail();
    };
    
    $scope.jobRequest = function() {
    	if ($rootScope.currentUser.username == null || $rootScope.currentUser.username == undefined) {
    		alert("请先登录");
    		return false;
    	}
    	
    	var jobRecruitID = $scope.jobRecruit.jobrecruitid;
    	restClient.post(RestfulAPI.JOB_CREATE_JOB_REQUEST, {}, jobRecruitID).then(function() {
    		alert(申请成功);
    	});
    };
} ]);
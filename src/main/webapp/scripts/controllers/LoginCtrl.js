
angular.module('recruitApp.controller')

.controller('LoginCtrl', ['$scope', 'userService', 'restClient', function($scope, userService, restClient) {
    $scope.login = function() {
    	
        restClient.post(RestfulAPI.LOGIN, {}, $scope.user).then(function(){
        	userService.getCurrentUser();
        	window.location.href = "/Recruit";
        });
        
    };
}]);
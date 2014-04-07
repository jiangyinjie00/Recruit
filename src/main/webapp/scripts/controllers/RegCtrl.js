angular.module('recruitApp.controller')
.controller('RegCtrl', ['$scope', 'restClient', '$rootScope', function($scope, restClient, $rootScope) {
    $scope.register = function(invalid) {
        if (invalid) {
        	return false;
        }
        restClient.post(RestfulAPI.USER_REGISTER, {}, $scope.user).then(function(){
            window.location.href = "";
        });
    };
}]);
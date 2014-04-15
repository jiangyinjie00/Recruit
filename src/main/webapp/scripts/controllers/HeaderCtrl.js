
angular.module('recruitApp.controller')

.controller('HeaderCtrl', ['$scope', '$rootScope', 'restClient', 'dialogService', 'userService',
    function($scope, $rootScope, restClient, dialogService, userService) {

    $scope.logout = function() {
        restClient.post(RestfulAPI.LOGOUT, {}).then(function(){
            $rootScope.currentUser = {};
            window.location.href = "/Recruit";
        });
    };
    $scope.login = function() {
        var options = {
            title:"登录",
            onOK:function(user){
                restClient.post(RestfulAPI.LOGIN, {}, user).then(function(){
                    userService.getCurrentUser();
                    window.location.href = "/Recruit";
                });
            },
        };
        dialogService.openLogin(options);
    };
}]);
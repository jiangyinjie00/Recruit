
angular.module('recruitApp.controller')

.controller('HeaderCtrl', ['$scope', '$rootScope', 'restClient',
    function($scope, $rootScope, restClient) {

	$scope.logout = function() {
		restClient.post(RestfulAPI.LOGOUT, {}).then(function(){
			$rootScope.currentUser = {};
	    	window.location.href = "/Recruit";
	    });
	};
	
}]);
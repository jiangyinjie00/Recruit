
angular.module('recruitApp.controller')

.controller('HomeCtrl', ['$scope', 'restClient', 'userService', function($scope, restClient, userService) {
	$scope.search = function() {
		var url = "#/jobs?searchKey=";
		url += $scope.searchValue;
		window.location.href = url;
	};
}]);
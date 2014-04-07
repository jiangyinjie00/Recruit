/**
 * User services handle all user operation for restful. the controllers or other client
 * need to inject the userService, then invoke the service's function. 
 */
angular.module('recruitApp.services')
.factory('userService', ['$q', 'restClient', '$rootScope', '$location', function($q, restClient, $rootScope, $location) {
    // The current user definition, when login successfully, this object will be set value.
    $rootScope.currentUser = {};
    
    // Save the error message when restful  failed.
    var errorMessage = "";
    
    // Save logout result.
    var result = false;
    
    // Definite the service object.
    var service =  {
        
        // Return the current user, if user is empty, get it from session.
        getCurrentUser: function() {
            if (Object.keys($rootScope.currentUser).length === 0) {
                $.ajax({
                    url: RestfulAPI.USER,
                    async: false,
                    type: "GET",
                    success: function(response){
                      $rootScope.currentUser = response.response;
                    }
                });
            }
            
            return $rootScope.currentUser;
        },
    };
    
    return service;
}]);
angular.module('recruitApp', [ 'recruitApp.controller', 'recruitApp.services', 'recruitApp.directive', 'recruitApp.restful','ngGrid', 'ui.bootstrap.dialog']);
angular.module('recruitApp.controller', []);
angular.module('recruitApp.services', []);
//angular.module('ngGrid', []);
angular.module('recruitApp.directive', []);
angular.module('recruitApp.restful', [ 'ngResource' ]);
angular.module('recruitApp').config([ '$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
    $routeProvider.when('', {
        templateUrl : 'views/home.html',
        controller : 'HomeCtrl'
    }).when('/register', {
        templateUrl : 'views/register.html',
        controller : 'RegCtrl'
    }).when('/login', {
        templateUrl : 'views/login.html',
        controller : 'LoginCtrl'
    }).when('/jobDetail/:jobRecruitID', {
        templateUrl : 'views/jobDetail.html',
        controller : 'JobDetailCtrl'
    }).when('/resume', {
        templateUrl : 'views/resume.html',
        controller : 'ResumeCtrl'
    }).when('/jobs', {
    	templateUrl : 'views/recruit.html',
    	controller : 'RecruitCtrl'
    }).when('/addRecruit', {
    	templateUrl : 'views/addRecruit.html',
    	controller : 'RecruitCtrl'
    }).when('/backStage', {
	templateUrl : 'views/backStage.html',
	controller : 'BackStageCtrl'
    }).when('/resume/:userID', {
        templateUrl : 'views/resumeDetail.html',
        controller : 'ResumeCtrl'
    }).when('/request/:jobRequestID', {
		templateUrl : 'views/requestDetail.html',
		controller : 'RequestCtrl'
	}).when('/audition', {
		templateUrl : 'views/audition.html',
		controller : 'AuditionCtrl'
	}).when('/ownRequests', {
		templateUrl : 'views/ownRequests.html',
		controller : 'RequestCtrl'
	}).when('/editRecruit/:jobRecruitID', {
		templateUrl : 'views/addRecruit.html',
		controller : 'RecruitCtrl'
	}).when('/editRecruit', {
		templateUrl : 'views/editRecruit.html',
		controller : 'EditRecruitCtrl'
});
    
    $httpProvider.responseInterceptors.push([ '$rootScope', '$q', '$location', function($rootScope, $q, $location) {
        return function(promise) {
            return promise.then(
            // if success, don't intercept
            function success(response) {
                if (response.data && (response.data.status == -1 || response.data.status == -2)) {
                    $rootScope.globalErrorMessage = response.data.errorMessage;
                    $rootScope.$broadcast('event:serverError');
                }
                
                return response;
            },

            function error(response) {
                
                // test true SecurityRegExp.test(response.config.url)
                if (true) {
                    // if 401, broadcast an login required event.
                    if (response.status === 401) {
                        $rootScope.$broadcast('event:loginRequired');
                    }
                    
                    // if 404, broadcast an not found required event.
                    if (response.status === 404) {
                        $rootScope.$broadcast('event:notFoundRequired');
                    }
                    
                    // if 403, broadcast an access denied required event.
                    if (response.status === 403) {
                        $rootScope.$broadcast('event:accessDenied');
                    }
                }
                
                return $q.reject(response);
            });
        };
    } ]);
    
} ]);

// Run the recruit module.
angular.module('recruitApp').run([ '$rootScope', '$location', 'userService', function($rootScope, $location, userService) {
    $rootScope.report = 0;
    $rootScope.$on('event:serverError', function() {
        if ($location.path() !== "/login") {
            $location.path("/500");
        }
    });
    
    $rootScope.$on('$routeChangeStart', function(event, next, current){
    	
        //Get current user and set it to root scope
        userService.getCurrentUser();
        
    });
    
    $rootScope.$on('event:loginRequired', function() {
        window.location.href = "login.html";
    });
    
    $rootScope.$on('event:notFoundRequired', function() {
        $location.path("/404");
    });
    
    $rootScope.$on('event:loginRequired', function() {
        $location.path("/403");
    });
} ]);

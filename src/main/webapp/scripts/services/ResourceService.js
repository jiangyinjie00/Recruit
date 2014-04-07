/**
 *  Restful client object to handle HTTP request.
 *  The service support get, put, post and delete function to match HTTP GET, PUT, POST and POST method.
 *  
 *  @param url : HTTP request url with parameter express like  rest/asstes/automobile/:mobileid/inspection/:insid
 *  @param parameters : parameters will match the express in url like {mobileid:1,insid:3}
 */
angular.module('recruitApp.restful')
.factory('restClient', ['$resource','$q','$http', function($resource, $q, $http) {
    // HTTP request response.
    var response = {};
    var errorMessage = {};
    var statusCode = StatusCode.HTTP_SUCCESS;
    var extendParams = {};
    
    // Generate resource URL.
    var generateResource = function(url, parameters) {
        var requestUrl = url;
        for (var index in parameters) {
            requestUrl = requestUrl.replace(":"+index, parameters[index]);
        };
        //requestUrl = requestUrl + COMMON_PARAM;
        
        for (var index in extendParams) {
            requestUrl += "&" + index + "=" + extendParams[index];
        }

        extendParams = [];
        return $resource(requestUrl, {}, {
            'put': { method: 'PUT'},
            'putArray' : { method: 'PUT', isArray: true},
            'del': { method: 'DELETE'},
            'delArray' : { method: 'DELETE',isArray: true,
               headers: {'Content-Type': 'application/json'}},
            'jsonp' :{method:'JSONP'}
        });
    };
    
    // Request success callback.
    var successCallback = function(data, defer) {
        if (data && data.status == StatusCode.HTTP_SUCCESS) {
            response = data.response;
            defer.resolve();
        } else {
            errorMessage = data.errorMessage;
            statusCode = data.status;
            defer.reject();
        }
    };
    
    // request failed callback.
    var failedCallback = function(data, defer) {
        errorMessage = data.errorMessage;
        statusCode = data.status;
        defer.reject();
    };
    
    // Rest client object.
    var client = {
            // HTTP GET request with URL and parameters.
            get : function(url, parameters) {
                var defer = $q.defer();
                generateResource(url, parameters).get(
                    function(data) {
                        successCallback(data, defer);
                    },
                    function(data){
                        failedCallback(data, defer);
                    }
                );
                
                return defer.promise;
            },
         // HTTP PUT request with URL and parameters.
            put : function(url, parameters, data) {
                var defer = $q.defer();
                generateResource(url, parameters).put(data,
                    function(data) {
                        successCallback(data, defer);
                    },
                    function(data){
                        failedCallback(data, defer);
                    }
                );
                
                return defer.promise;
            },
            // HTTP PUT request with URL and parameters array formatted.
            putArray : function(url, parameters, data) {
                var defer = $q.defer();
                generateResource(url, parameters).putArray(data,
                    function(data) {
                        successCallback(data, defer);
                    },
                    function(data){
                        failedCallback(data, defer);
                    }
                );
                
                return defer.promise;
            },

            // HTTP POST request with URL and parameters.
            post : function(url, parameters, data) {
                var defer = $q.defer();
                generateResource(url, parameters).save(data,
                    function(data) {
                        successCallback(data, defer);
                    },
                    function(data){
                        failedCallback(data, defer);
                    }
                );
                
                return defer.promise;
            },
            // HTTP GET request with URL and parameters.
            del : function(url, parameters) {
                var defer = $q.defer();
                generateResource(url, parameters).del(
                    function(data) {
                        successCallback(data, defer);
                    },
                    function(data){
                        failedCallback(data, defer);
                    }
                );
                
                return defer.promise;
            },
            //Delete multi-resource
            delArray : function(url, parameters, data) {
                var defer = $q.defer();
                generateResource(url, parameters).delArray(data,
                    function(data) {
                        successCallback(data, defer);
                    },
                    function(data){
                        failedCallback(data, defer);
                    }
                );
                return defer.promise;
            },
            
            // Return HTTP response data.
            getResponse: function() {
                return response;
            },
            
            // Response HTTP error message;
            getErrorMessage : function() {
                return errorMessage;
            },
            
            getStatusCode : function() {
                return statusCode;
            },
            setExtendParam : function(params) {
                extendParams = params;
                return this;
            },
            addExtendParam : function(params) {
            	 for (var index in params) {
                     extendParams[index] = params[index];
                 }
            }
    };
    
    return client; 
    }
]);
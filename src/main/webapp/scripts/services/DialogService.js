angular.module('recruitApp.services').factory('dialogService',
[ '$dialog', 'restClient', '$rootScope', '$window', function($dialog, restClient, $rootScope, $window) {

    var body = $("body");
    // only one dialog can be opened at one time.
    function checkDialogOpen() {
        return body.hasClass("hiddenScroll");
    };
    
    var service = {
            openAudition : function(options) {
                if(checkDialogOpen()) {
                    return;
                }
                var dialogOptions = {};
                dialogOptions.dialogClass = 'modal assign-dialog';
                dialogOptions.templateUrl = 'views/auditionRelease.html';
                dialogOptions.backdropClick = false;
                dialogOptions.controller = ['$scope', 'dialog', function($scope, dialog) {
                    $scope.title = options.title;
                    $scope.tips = options.tips;
                    $scope.cancelBtnText = options.cancelBtnText ? options.cancelBtnText : "com.button.cancel";
                    $scope.okBtnText = options.okBtnText ? options.okBtnText : "com.button.ok";
                    
                    $scope.cancel = function() {
                        dialog.close();
                    };
                    
                    $scope.ok =  function() {
                        dialog.close();
                        if(options && options.onOK) {
                            options.onOK($scope.audition);//send this object to method.
                        }
                        
                    };
                }];
                var dialog = $dialog.dialog(dialogOptions);
                dialog.open();
                
            },
            openLogin : function(options) {
                if(checkDialogOpen()) {
                    return;
                }
                var dialogOptions = {};
                dialogOptions.dialogClass = 'modal assign-dialog';
                dialogOptions.templateUrl = 'views/login.html';
                dialogOptions.backdropClick = false;
                dialogOptions.controller = ['$scope', 'dialog', function($scope, dialog) {
                    $scope.title = options.title;
                    $scope.tips = options.tips;
                    $scope.cancelBtnText = options.cancelBtnText ? options.cancelBtnText : "com.button.cancel";
                    $scope.okBtnText = options.okBtnText ? options.okBtnText : "com.button.ok";
                    
                    $scope.cancel = function() {
                        dialog.close();
                    };
                    
                    $scope.ok =  function() {
                        var message;
                        restClient.post(RestfulAPI.LOGIN, {}, $scope.user).then(function(){
                            message = restClient.getResponse();
                            if (message == 0) {
                                dialog.close();
                                options.onOK($scope.user);
                            } else {
                                $("#login-error").css("display", "block");
                            }
                        });
                        
                        
                    };
                }];
                var dialog = $dialog.dialog(dialogOptions);
                dialog.open();
                
            }
            
    };

    return service;
} ]);
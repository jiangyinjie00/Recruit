angular.module('recruitApp.services').factory('dialogService',
[ '$dialog', 'restClient', '$rootScope', '$window', function($dialog, restClient, $rootScope, $window) {

    var body = $("body");
    // only one dialog can be opened at one time.
    function checkDialogOpen() {
        return body.hasClass("hiddenScroll");
    };
    
    var service = {
            /**
             * 
             * @param options
             * {
             *   title : "",
             *   tips : "",
             *   okBtnText: "",
             *   cancelBtnText: "",
             *   onOK:function(){ //ok button call back
             *      
             *   }
             * }
             */
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
                
            }
            
    };

    return service;
} ]);
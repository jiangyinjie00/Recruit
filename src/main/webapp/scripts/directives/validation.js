angular.module('recruitApp.directive')
.directive('recruitRequired', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link : function(scope, elm, attr, ctrl){
            if (!ctrl) return;
            ctrl.requiredError = false;
            ctrl.requiredOK = false;
            
            var validator = function(value) {
              var result = null;
              if (CommonUtil.isEmpty(value)) {
                  ctrl.$setValidity('required', false);
              } else {
                  ctrl.$setValidity('required', true);
                  result = value;
              }
              ctrl.requiredError = ctrl.$dirty && ctrl.$error['required'];
              ctrl.requiredOK = ctrl.$dirty && !ctrl.$error['required'];
              
              return result;
            };

            ctrl.$parsers.unshift(validator);
            ctrl.$formatters.push(validator);

            elm.bind('blur', function () {
                if (!scope.$$phase) {
                    scope.$apply(function() {
                        ctrl.$setViewValue(elm.val());
                    });   
                }
            });
        }
    };
})

//Password directive use to validate the password field with blur event.
.directive('recruitPassword', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link :function(scope, elm, attr, ctrl) {
            if( !ctrl) {
                return;
            }
            
            var validator = function(value) {
                if (CommonUtil.isEmpty(value)) {
                    ctrl.$setValidity('required', false);
                    return;
                } else {
                    ctrl.$setValidity('required', true);
                    return value;
                }
            };
            
            ctrl.$parsers.unshift(validator);
            ctrl.$formatters.push(validator);
            
             elm.bind('blur', function () {
                 if(!scope.$$phase) {
                     scope.$apply(function() {
                         ctrl.$setViewValue(elm.val());
                         if(!CommonUtil.isEmpty(scope.userForm.confirmPassword.$modelValue)) {
                             scope.userForm.confirmPassword.$setViewValue(scope.userForm.confirmPassword.$modelValue);
                         }
                     });    
                 }
            });
        }
    };
})
.directive('recruitPasswordConfirm', function(){
    return {
        restrict: 'A',
        require: 'ngModel',
        link :function(scope, elm, attr, ctrl) {
            if( !ctrl) {
                return;
            }
            
            var validator = function(value) {
                
                if(CommonUtil.isEmpty(value)) {
                    ctrl.$setValidity('required', false);
                    ctrl.$setValidity('matched', true);
                    return;
                } else if(CommonUtil.isEmpty(scope.userForm.password.$modelValue) || scope.userForm.password.$modelValue != value) {
                    ctrl.$setValidity('required', true);
                    ctrl.$setValidity('matched', false);
                    return value;
                } else {
                    ctrl.$setValidity('required', true);
                    ctrl.$setValidity('matched', true);
                    return value;
                }
                
            };
            
            ctrl.$parsers.unshift(validator);
            ctrl.$formatters.push(validator);
            
            elm.bind('blur', function () {
                if(!scope.$$phase) {
                    scope.$apply(function() {
                        ctrl.$setViewValue(elm.val());
                    });    
                }
            });
        }
    };
})
// Email confirm directive use to validate the email fields with blur event.
.directive('recruitEmail', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link : function(scope, elm, attr, ctrl){
            if (!ctrl) return;
            var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
            var opts=JSON.parse(attr.fleetEmail);
            var emailMaxLength = opts.length < 1 ? DEFAULT_EMAIL_MAX_LENGTH : opts.length;
            
            var isEmail = function(value) {
                var result = false;
                if(CommonUtil.isEmpty(value)) {
                    ctrl.$setValidity('required', false);
                    ctrl.$setValidity('format', true);
                    result = false;
                } else {
                    ctrl.$setValidity('required', true);
                    
                    if (pattern.test(value) && value.length <= emailMaxLength) {
                        ctrl.$setValidity('format', true);
                        result = true;
                    } else {
                        ctrl.$setValidity('format', false);
                        result = false;
                    }
                }
                
                return result;
            };
            
            var validator = function(value) {
                if (isEmail(value)) {
                    return value;
                };
                return;
            };

            var setok = function(value){
                if (validator(value)) {
                    ctrl.ok = true;
                    ctrl.confirmFailed = false;
                } else {
                    ctrl.ok = false;
                    ctrl.confirmFailed = true;
                }
            };

            ctrl.$parsers.unshift(validator);
            ctrl.$formatters.push(validator);

            elm.bind('blur keyup', function () {
                scope.$apply(function() {
                    setok(elm.val());
                    ctrl.$setViewValue(elm.val());
                });
            });
        }
    };
});
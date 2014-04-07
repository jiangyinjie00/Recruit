/**
 * time picker directives.
 * This directive is redesign from angular-ui, the "bsTimepicker" ignore the configuration.
 * now , we can use this directive by 
 *  <input fleet-timepicker="{showMeridian: false}" ></input>
 */

angular.module('recruitApp.directive')
// Required directive use to validate the required fields with blur event.
.directive('recruitTimepicker', ['$parse', function($parse) {
 
    return function (scope, element, attrs, controller) {
        var ngModel = $parse(attrs.ngModel);
        $(function(){
            element.timepicker({
                onSelect:function(value) {
                    scope.$apply(function(scope){
                        // Change binded variable
                        ngModel.assign(scope, value);
                    });
                },
                timeFormat: 'HH:mm',
                length: 7
            });
        });
    };
}]);
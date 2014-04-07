/**
 * Admin base controller. This controller contains all common assets function
 * and variables, the children controller can overwrite each function and
 * variables before use it.
 * 
 * @param $scope
 *            The base controller scope.
 * @param $dialogService
 *            Dialog service which support all kind of dialog templates.
 * @param $routeParams
 *            the URL parameters object, thus, we can get variables from url.
 * @param $location
 *            service which use to redirect to other page.
 * @param $restClient
 *            service which contains fleet HTTP requests.
 * 
 */
function BaseCtrl($scope, $rootScope, $routeParams, $location, $window, restClient) {
    // The criteria object use to get assets list data. the criteria format
    // defined in CommonUtil.
    $scope.criteria = {};
    // The grid data to collect the grid data.
    $scope.list = {};
    // The login user.
    $scope.currentUser = $rootScope.currentUser;
    // The selected organizations in organization tree filter.
    $scope.selectedOrgs = [];
    // Parameters from url.
    $scope.routeParams = $routeParams;

    $scope.gridOptions = {
            data : 'list.data',
            columnDefs : []
        };


    /**
     * Search
     */
    // Search key changed.
    $scope.searchKeyChanged = function(newSearchKey) {
        $scope.searchItem.selectedKey = newSearchKey;
    };

    // Search.
    $scope.search = function() {
        if ($scope.searchItem) {
            $scope.criteria.searchItem.searchValue = $scope.searchItem.searchValue ;
        }
        $scope.resetPaging();
        $scope.refresh();
        
    };
    
    $scope.resetPaging = function() {
    	var pageModel = {
        		pageSize : '3',
        		currPage : '1',
        		orderBy : 'StartTime',
        		isDesc : 'true'
        };
    	$scope.criteria.pageModel = pageModel;
    };

    // Reset
    $scope.reset = function() {
        $scope.listInit();
    };

    // Init list.
    $scope.listInit = function() {
        console.warn("Not implement listInit function.");
    };

    

    // Execute page filter.
    $scope.onSelectPage = function(pageNumber) {
        // prevent invalid page number.
        if (pageNumber > $scope.list.paging.pageCount || pageNumber < 1) {
            return;
        }
        $scope.criteria.pageModel.currPage = pageNumber;
        $scope.refresh();
    };


    // Redirect to other pages by path;
    $scope.redirect = function(path) {
        $location.path(path);
    };


    // Refresh grid list data, children controller have to over write this
    // function.
    $scope.refresh = function() {
        console.warn("Not implement refresh function.");
    };

    // Refined gridOptions column after change width
    /*$scope.$on(BroadcastEvent.NG_GRID_COLUMN, function(scope, columns) {
        for ( var i = 0; i < columns.length; i++) {
            $scope.gridOptions.columnDefs[i].width = columns[i].width;
        }
    });*/


}

BaseCtrl.$inject = [ '$scope', '$rootScope', '$routeParams', '$location', '$window',
        'restClient'];
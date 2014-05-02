angular.module('recruitApp.controller')
.controller('recruitRestartCtrl', ['$scope', 'restClient', '$injector', '$routeParams', '$rootScope', function($scope, restClient, $injector, $routeParams, $rootScope) {
	$injector.invoke(BaseCtrl, this, {$scope: $scope});
  $scope.headerCellTemplate = '<div class="ngHeaderSortColumn {{col.headerClass}}" ng-style="{\'cursor\': col.cursor}" ng-class="{ \'ngSorted\': !noSortVisible }">'+
  '<div ng-click="col.sort($event)" class="ngHeaderText">6666</div>'+
  '<div class="ngSortButtonDown" ng-class="{ngSortButtonDown_white: true==col.showSortButtonUp()}"></div>'+
  '<div class="ngSortButtonUp" ng-class="{ngSortButtonUp_white: true==col.showSortButtonDown()}"></div>'+
  '<div class="ngSortPriority">{{col.sortPriority}}</div>'+
  '<div ng-class="{ ngPinnedIcon: col.pinned, ngUnPinnedIcon: !col.pinned }" ng-click="togglePin(col)" ng-show="col.pinnable"></div>'+
  '</div>'+
  '<div ng-show="col.resizable" class="ngHeaderGrip" ng-click="col.gripClick($event)" ng-mousedown="col.gripOnMouseDown($event)"></div>';


  $scope.gridOptions = {
      data : 'list.data',
     
      columnDefs : []
  };
  
    $scope.init = function() {
        $scope.criteria = {};
        $scope.resetPaging();
        $scope.refresh();
    };
    
    
    
    $scope.refresh = function() {
    	restClient.post(RestfulAPI.JOB_FINSHED_JOBS, {}, $scope.criteria).then(function() {
        	$scope.list = restClient.getResponse();
        	$scope.readRecords = false;
            $scope.hasRecords = $scope.list.data.length == 0 ? false : true;
            if ($scope.list.paging) {
                $scope.list.paging.pageCount = Math.ceil($scope.list.paging.rowCount / $scope.list.paging.pageSize);
                $scope.list.paging.currPageBeginItem = ($scope.list.paging.currPage - 1) * $scope.list.paging.pageSize + 1;
                $scope.list.paging.currPageEndItem = $scope.list.paging.currPage == $scope.list.paging.pageCount ? 
                        $scope.list.paging.rowCount : $scope.list.paging.currPage * $scope.list.paging.pageSize;
            }
        });
    };
    
    var template_operation = '<div class="ngCellText"><a href="#/jobDetail/{{COL_FIELD}}">查看</a></div>';
 // Initialize the grid option.
    $scope.gridOptions.columnDefs = [
             {
                 field: 'jobEntityExt.name',
                 displayName: '职位名称',
                 //cellTemplate: template,
                 //headerCellTemplate: $scope.headerCellTemplate,
                 width:180
             },
             {
                 field: 'type',
                 displayName: "职位类别",
                 //cellTemplate: template,
                 //headerCellTemplate: $scope.headerCellTemplate,
                 width:180
             },
             {
                 field: 'person',
                 displayName: "人数",
                 //cellTemplate: template,
                 //headerCellTemplate: $scope.headerCellTemplate,
                 width:120
             },
             {
                 field: 'city',
                 displayName: "地点",
                 //cellTemplate: template,
                 //headerCellTemplate: $scope.headerCellTemplate,
                 width:120
             },
             {
                 field: 'startTimeFormat',
                 displayName: "发布时间",
                 //cellTemplate: template,
                 //headerCellTemplate: $scope.headerCellTemplate,
                 width:150
             },
             {
            	 field: 'expireTimeFormat',
            	 displayName: "结束时间",
            	 //cellTemplate: template,
            	 //headerCellTemplate: $scope.headerCellTemplate,
            	 width:150
             },
             {
            	 field: 'jobrecruitid',
            	 displayName: "查看",
            	 cellTemplate: template_operation,
            	 //headerCellTemplate: $scope.headerCellTemplate,
            	 width:98
             }
    ];
}]);
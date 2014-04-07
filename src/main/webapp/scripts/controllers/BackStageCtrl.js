angular.module('recruitApp.controller')
.controller('BackStageCtrl', ['$scope', 'restClient', '$injector', '$rootScope', function($scope, restClient, $injector, $rootScope) {
    $injector.invoke(BaseCtrl, this, {$scope: $scope});
    
    $scope.selectedRows = [];
    
    $scope.gridOptions = {
              data : 'list.data',
              enableSorting: false,
              columnDefs : [],
    selectedItems:$scope.selectedRows
          };
          
    $scope.init = function() {
    	$scope.criteria = {};
    	$scope.criteria.statusid = 1;
    	$scope.resetPaging();
        $scope.refresh();
    };
            
    var template_operation = '<div class="ngCellText"><a href="#/request/{{COL_FIELD}}">查看</a></div>';
    var template_resume_operation = '<div class="ngCellText"><a href="#/resume/{{COL_FIELD}}">查看</a></div>';
    // Initialize the grid option.
       $scope.gridOptions.columnDefs = [
                {
                    field: 'userEntityExt.name',
                    displayName: '姓名',
                    //cellTemplate: template,
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:180
                },
                {
                    field: 'jobRecruitEntityExt.jobEntityExt.name',
                    displayName: "职位名称",
                    //cellTemplate: template,
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:180
                },
                {
                    field: 'jobRecruitEntityExt.departmentEntityExt.name',
                    displayName: "部门",
                    //cellTemplate: template,
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:150
                },
                {
                    field: 'jobRecruitEntityExt.city',
                    displayName: "地点",
                    //cellTemplate: template,
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:180
                },
                {
                    field: 'timestamp',
                    displayName: "申请时间",
                    //cellTemplate: template,
                    //headerCellTemplate: $scope.headerCellTemplate,
                    width:100
                },
                {
               	 field: 'jobrequestid',
               	 displayName: "查看请求",
               	 cellTemplate: template_operation,
               	 //headerCellTemplate: $scope.headerCellTemplate,
               	 width:75
                },
                {
                	field: 'userid',
                	displayName: "查看简历",
                	cellTemplate: template_resume_operation,
                	//headerCellTemplate: $scope.headerCellTemplate,
                	width:75
                },
       ];
    $scope.refresh = function() {
        restClient.post(RestfulAPI.JOB_REQUESTS, {}, $scope.criteria).then(function() {
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
}]);
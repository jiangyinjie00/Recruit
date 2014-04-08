angular.module('recruitApp.controller')
.controller('RequestCtrl', ['$scope', 'restClient', '$routeParams', '$rootScope', '$injector', function($scope, restClient, $routeParams, $rootScope, $injector) {
	$injector.invoke(BaseCtrl, this, {$scope: $scope});
	
    $scope.initRequest= function() {
    	
    	var requestID = $routeParams.jobRequestID;
    	
        restClient.post(RestfulAPI.JOB_REQUEST_DETAIL, {jobRequestID :requestID}).then(function(){
            $scope.jobRequest = restClient.getResponse();
        });
    };
    
    $scope.operationRequest = function(boolean) {
    	var user = $rootScope.currentUser;
    	var statusID;
    	if (user.roleID == 4){
    		if (boolean) {
    			statusID = 2;
    		} else {
    			statusID = 3;
    		}
    	} else if (user.roleID == 3) {
    		if (boolean) {
    			statusID = 4;
    		} else {
    			statusID = 5;
    		}
    	} else {
    		if (boolean) {
    			statusID = 6;
    		} else {
    			statusID = 7;
    		}
    	}
    	
    	var operation = {};
    	operation.opinion = $scope.opinion;
    	operation.statusID = statusID;
    	operation.jobRequestID = $scope.jobRequest.jobrequestid;
    	
    	restClient.post(RestfulAPI.JOB_REQUEST_STATUS_CHANGE, {}, operation).then(function(){

    	});
    };
    
    $scope.gridOptions = {
            data : 'list.data',
            enableSorting: false,
            showSelectionCheckbox: true,
            columnDefs : [],
  selectedItems:$scope.selectedRows
        };
        
  $scope.initOwnRequests = function() {
  	$scope.criteria = {};
  	$scope.criteria.statusid = 1;
  	$scope.resetPaging();
      $scope.refresh();
  };
          
  var template_operation = '<div class="ngCellText"><a href="#/request/{{COL_FIELD}}">查看</a></div>';
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
              }
     ];
  $scope.refresh = function() {
      restClient.post(RestfulAPI.JOB_OWNJOBREQUESTS, {}, $scope.criteria).then(function() {
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
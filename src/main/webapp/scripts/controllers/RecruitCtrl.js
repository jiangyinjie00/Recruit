angular.module('recruitApp.controller')
.controller('RecruitCtrl', ['$scope', 'restClient', '$injector', '$routeParams', '$rootScope', function($scope, restClient, $injector, $routeParams, $rootScope) {
	$injector.invoke(BaseCtrl, this, {$scope: $scope});
    $scope.getUrlVar = function(name ){
        var vars = [], hash;
        var url = window.location.href;
        var hashes = url.slice(url.indexOf('?') + 1).split('&');
        for(var i = 0; i < hashes.length; i++) {
          hash = hashes[i].split('=');
          vars.push(hash[0]);
          vars[hash[0]] = hash[1];
        }
        if (vars[name] != undefined) {
        	return vars[name];
        }
        return null;
      };
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
    	$scope.city = 0;
        $scope.criteria = {};
        var searchItem = {searchKey : 'Name'};
        if (CityStatus[$scope.getUrlVar("city")] == undefined) {
        	$scope.criteria.city = null;
        } else {
        	$scope.criteria.city = CityStatus[$scope.getUrlVar("city")];
        	$scope.city = $scope.getUrlVar("city");
        }
        
        if (TypeStatus[$scope.getUrlVar("type")] == undefined) {
        	$scope.criteria.type = null;
        } else {
        	$scope.criteria.type = TypeStatus[$scope.getUrlVar("type")];
        	$scope.type = $scope.getUrlVar("type");
        }
        searchItem.searchValue = $scope.getUrlVar("searchKey");
        $scope.criteria.searchItem = searchItem;
        $scope.searchValue = searchItem.searchValue;
        $scope.resetPaging();
        $scope.refresh();
        
    };
    
    
    
    $scope.refresh = function() {
    	restClient.post(RestfulAPI.JOB_JOBS, {}, $scope.criteria).then(function() {
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
    
    $scope.searchCity = function(city) {
    	$scope.criteria.city = CityStatus[city];
    	$scope.city = city;
        $scope.resetPaging();
    	$scope.refresh();
    };
    
    $scope.searchType = function(type) {
    	$scope.criteria.type = TypeStatus[type];
    	$scope.type = type;
        $scope.resetPaging();
    	$scope.refresh();
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
                 width:100
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
 
    $scope.initAddOrEditRecruit = function() {
    	restClient.post(RestfulAPI.JOB_JOBENTITYS, {}).then(function() {
        	$scope.jobList = restClient.getResponse();
        });
        
        $scope.citys = Citys;
        $scope.types = Types;
    	var url = window.location.href;
    	if (url.indexOf("add") > 0) {
    		$scope.initAddRecruit();
    	} else {
    		 $scope.initEditRecruit();
    	}
    };
    
    $scope.initEditRecruit = function() {
    	restClient.post(RestfulAPI.JOB_DETAIL, {jobRecruitID : 1}).then(function() {
        	$scope.jobRecruit = restClient.getResponse();
        	$scope.jobRequireList = $scope.jobRecruit.jobRequireEntityExts;
            $scope.deleteJobRequireList = [];
            $scope.jobResponsibilityList = $scope.jobRecruit.jobResponsibilityEntityExts;
            $scope.deleteJobResponsibilityList = [];
            if ($scope.jobRequireList.length == 0) {
            	$scope.newJobRequire = {
                        num : 1,
                        description : ''
                };
                $scope.jobRequireList.push($scope.newJobRequire);
            }
            if ($scope.jobResponsibilityList.length == 0) {
            	$scope.newJobResponsibility = {
            			num : 1,
            			description : ''
            	};
            	$scope.jobResponsibilityList.push($scope.newJobResponsibility);
            }
            $scope.jobRecruit.job = $scope.jobList[$scope.jobRecruit.jobid-1];
        });
    	
    	
    	
    	
    };
    
    $scope.initAddRecruit = function() {
        $scope.jobRequireList = [];
        $scope.deleteJobRequireList = [];
        $scope.jobResponsibilityList = [];
        $scope.deleteJobResponsibilityList = [];
        if ($scope.jobRequireList.length == 0) {
        	$scope.newJobRequire = {
                    num : 1,
                    description : ''
            };
            $scope.jobRequireList.push($scope.newJobRequire);
        }
        if ($scope.jobResponsibilityList.length == 0) {
        	$scope.newJobResponsibility = {
        			num : 1,
        			description : ''
        	};
        	$scope.jobResponsibilityList.push($scope.newJobResponsibility);
        }
        
        
    };
    
    $scope.addJobRequire = function() {
        $scope.newJobRequire = {
                num : $scope.jobRequireList.length + 1,
                description : ''
        };
        $scope.jobRequireList.push($scope.newJobRequire);
    };
    
    $scope.deleteJobRequire = function(num) {
        var index = $scope.getJobRequireIndexByNum(num);
        var deleteJobRequire = $scope.jobRequireList[index];
        if (undefined != deleteJobRequire.jobrequireid && 0 != deleteJobRequire.jobrequireid) {
            $scope.deleteJobRequireList.push(deleteJobRequire);
        }
        $scope.jobRequireList.splice(index,1);
        $scope.resortJobRequires(index);
        
    };
    
    $scope.resortJobRequires = function(index){
         var length = $scope.jobRequireList.length;
         for(var i=index; i<length; i++){
                $scope.jobRequireList[i].num -= 1;
         }
    };
    
    $scope.getJobRequireIndexByNum = function(number) {
        var index = -1;
        var length = $scope.jobRequireList.length;
        for(var i=0; i<length; i++){
            if(number === $scope.jobRequireList[i].num){
                index = i;
                break;
            };
        }
        return index;
    };
    
    
    
    $scope.addJobResponsibility = function() {
        $scope.newJobResponsibility = {
                num : $scope.jobResponsibilityList.length + 1,
                description : ''
        };
        $scope.jobResponsibilityList.push($scope.newJobResponsibility);
    };
    
    $scope.deleteJobResponsibility = function(num) {
        var index = $scope.getJobResponsibilityIndexByNum(num);
        var deleteJobResponsibility = $scope.jobResponsibilityList[index];
        if (undefined != deleteJobResponsibility.jobresponsibilityid && 0 != deleteJobResponsibility.jobresponsibilityid) {
            $scope.deleteJobResponsibilityList.push(deleteJobResponsibility);
        }
        $scope.jobResponsibilityList.splice(index,1);
        $scope.resortJobResponsibilitys(index);
        
    };
    
    $scope.resortJobResponsibilitys = function(index){
         var length = $scope.jobResponsibilityList.length;
         for(var i=index; i<length; i++){
                $scope.jobResponsibilityList[i].num -= 1;
         }
    };
    
    $scope.getJobResponsibilityIndexByNum = function(number) {
        var index = -1;
        var length = $scope.jobResponsibilityList.length;
        for(var i=0; i<length; i++){
            if(number === $scope.jobResponsibilityList[i].num){
                index = i;
                break;
            };
        }
        return index;
    };
    
    $scope.saveJobRecruit = function() {
    	$scope.jobRecruit.jobid = $scope.jobRecruit.job.jobid;
    	delete $scope.jobRecruit.job;
    	
    	for(var index in $scope.deleteJobRequireList) {
            $scope.deleteJobRequireList[index].markfordelete = true;
            $scope.jobRequireList.push($scope.deleteJobRequireList[index]);
        }
    	
    	for(var index in $scope.deleteJobResponsibilityList) {
    		$scope.deleteJobResponsibilityList[index].markfordelete = true;
    		$scope.jobResponsibilityList.push($scope.deleteJobResponsibilityList[index]);
    	}
    	
        for(var index in $scope.jobRequireList) {
            delete $scope.jobRequireList[index].$$hashKey;
        }
        
        for(var index in $scope.jobResponsibilityList) {
        	delete $scope.jobResponsibilityList[index].$$hashKey;
        }
        
        $scope.jobRecruit.jobRequireEntityExts = $scope.jobRequireList;
        $scope.jobRecruit.jobResponsibilityEntityExts = $scope.jobResponsibilityList;
        
        if ($rootScope.currentUser.roleID == 3 || $rootScope.currentUser.roleID == 2) {
        	 restClient.post(RestfulAPI.JOB_UPDATE_JOB_RECRUIT, {}, $scope.jobRecruit).then(function() {
        		 alert("提交成功！");
             	window.location.href = "#/editRecruit";
             });
        } else {
        	 restClient.post(RestfulAPI.JOB_CREATE_JOB_RECRUIT, {}, $scope.jobRecruit).then(function() {
             	alert("创建成功 !");
             	window.location.href = "#/backStage";
             });
        }
        
       
    };
    
    $scope.restartJobRecruit = function() {
    	$scope.jobRecruit.jobid = $scope.jobRecruit.job.jobid;
    	delete $scope.jobRecruit.job;
    	
    	for(var index in $scope.deleteJobRequireList) {
    		$scope.deleteJobRequireList[index].markfordelete = true;
    		$scope.jobRequireList.push($scope.deleteJobRequireList[index]);
    	}
    	
    	for(var index in $scope.deleteJobResponsibilityList) {
    		$scope.deleteJobResponsibilityList[index].markfordelete = true;
    		$scope.jobResponsibilityList.push($scope.deleteJobResponsibilityList[index]);
    	}
    	
    	for(var index in $scope.jobRequireList) {
    		delete $scope.jobRequireList[index].$$hashKey;
    	}
    	
    	for(var index in $scope.jobResponsibilityList) {
    		delete $scope.jobResponsibilityList[index].$$hashKey;
    	}
    	
    	$scope.jobRecruit.jobRequireEntityExts = $scope.jobRequireList;
    	$scope.jobRecruit.jobResponsibilityEntityExts = $scope.jobResponsibilityList;
    	
		restClient.post(RestfulAPI.JOB_RESTART_JOB_RECRUIT, {}, $scope.jobRecruit).then(function() {
			alert("重启成功！");
			window.location.href = "#/editRecruit";
		});
    	
    	
    };
    
    $scope.updateJobRecruit = function() {
    	for(var index in $scope.deleteJobRequireList) {
    		$scope.deleteJobRequireList[index].markfordelete = true;
    		$scope.jobRequireList.push($scope.deleteJobRequireList[index]);
    	}
    	
    	for(var index in $scope.deleteJobResponsibilityList) {
    		$scope.deleteJobResponsibilityList[index].markfordelete = true;
    		$scope.jobResponsibilityList.push($scope.deleteJobResponsibilityList[index]);
    	}
    	
    	for(var index in $scope.jobRequireList) {
    		delete $scope.jobRequireList[index].$$hashKey;
    	}
    	
    	for(var index in $scope.jobResponsibilityList) {
    		delete $scope.jobResponsibilityList[index].$$hashKey;
    	}
    	
    	$scope.jobRecruit.jobRequireEntityExt = $scope.jobRequireList;
    	$scope.jobRecruit.jobResponsibilityEntityExt = $scope.jobResponsibilityList;
    };
    
}]);
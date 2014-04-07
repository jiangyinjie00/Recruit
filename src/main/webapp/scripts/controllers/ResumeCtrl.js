angular.module('recruitApp.controller')
.controller('ResumeCtrl', ['$scope', 'restClient', function($scope, restClient) {
    
    $scope.saveUserInfo = function() {
        restClient.post(RestfulAPI.USER_SAVE_INFORMATION, {}, $scope.information).then(function(){
            $scope.activeTab = 1;
        });
    };
    
    $scope.saveExperience = function() {
        restClient.post(RestfulAPI.USER_SAVE_EXPERIENCE, {}, $scope.experience).then(function(){
            $scope.activeTab = 0;
        });
    };
    
    $scope.initResume = function() {
        $scope.educationList = [];
        $scope.deleteEducationList = [];
        restClient.post(RestfulAPI.USER_RESUME, {userID : 7}).then(function(){
            var user = restClient.getResponse();
            $scope.information = user.userInfoEntityExt;
            $scope.educationList = user.educationEntityExtList;
            $scope.experience = user.experienceEntityExt;
        });
        if ($scope.educationList.length == 0) {
        	$scope.newEducation = {
                    num : 1,
                    degree : '',
                    graduationdate : new Date(),
                    major : '',
                    majorranking : '',
                    academy : ''
            };
            $scope.educationList.push($scope.newEducation);
        }
    };
    
    $scope.addEducation = function() {
        $scope.newEducation = {
                num : $scope.educationList.length + 1,
                degree : '',
                graduationdate : new Date(),
                major : '',
                majorranking : '',
                academy : ''
        };
        $scope.educationList.push($scope.newEducation);
    };
    
    $scope.deleteEducation = function(num) {
        var index = $scope.getEducationIndexByNum(num);
        var deleteEducation = $scope.educationList[index];
        if (undefined != deleteEducation.educationid && 0 != deleteEducation.educationid) {
            $scope.deleteEducationList.push(deleteEducation);
        }
        $scope.educationList.splice(index,1);
        $scope.resortEducations(index);
        
    };
    
    $scope.resortEducations = function(index){
         var length = $scope.educationList.length;
         for(var i=index; i<length; i++){
                $scope.educationList[i].num -= 1;
         }
    };
    
    $scope.getEducationIndexByNum = function(number) {
        var index = -1;
        var length = $scope.educationList.length;
        for(var i=0; i<length; i++){
            if(number === $scope.educationList[i].num){
                index = i;
                break;
            };
        }
        return index;
    };
    
    $scope.saveEducation = function() {
        for(var index in $scope.deleteEducationList) {
            $scope.deleteEducationList[index].markfordelete = 1;
            $scope.educationList.push($scope.deleteEducationList[index]);
        }
        
        for(var index in $scope.educationList) {
            delete $scope.educationList[index].$$hashKey;
        }
        
        $scope.user = {};
        $scope.user.educationEntityExtList = $scope.educationList;
        restClient.post(RestfulAPI.USER_SAVE_EDUCATION, {}, $scope.user).then(function(){
            $scope.activeTab = 2;
        });
    };
}]);
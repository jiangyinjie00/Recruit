var StatusCode = {
        // Common from 100010001.
        "HTTP_SUCCESS"                      : "0",
        "HTTP_FIAL"                         : "1"
};

var CityStatus = {
		0 : null,
		1 : "上海",
		2 : "扬州",
		3 : "常州"
};

var Citys = {
		1 : "上海",
		2 : "扬州",
		3 : "常州"
};

var TypeStatus = {
		0 : null,
        1 : "技术类",
        2 : "市场类",
        3 : "设计类"
};

var Types = {
		1 : "技术类",
		2 : "市场类",
		3 : "设计类"
};

var Years = {
		2018 : 2018,
		2017 : 2017,
		2016 : 2016,
		2015 : 2015,
		2014 : 2014,
		2013 : 2013,
		2012 : 2012,
		2011 : 2011,
		2010 : 2010
};

var RestfulAPI = {
        "USER_REGISTER" : "user/register",
        "LOGIN" : "user/login",
        "LOGOUT" : "user/logout",
        "USER" : "user",
        "USER_SAVE_INFORMATION" : "user/saveInfo",
        "USER_SAVE_EXPERIENCE" : "user/saveExperience",
        "USER_SAVE_EDUCATION" : "user/saveEducation",
        "USER_RESUME" : "user/getResume/:userID",
        "JOB_DETAIL" : "job/jobDetail/:jobRecruitID",
        "JOB_JOBS" : "job/jobs",
        "JOB_FINSHED_JOBS" : "job/finishedJobs",
        "JOB_JOBSNOTAPPROVE" : "job/jobsNotApprove",
        "JOB_CREATE_JOB_REQUEST" : "job/createJobRequest",
        "JOB_CREATE_JOB_RECRUIT" : "job/createJobRecruit",
        "JOB_UPDATE_JOB_RECRUIT" : "job/updateJobRecruit",
        "JOB_RESTART_JOB_RECRUIT" : "job/createRestartJobRecruit",
        "JOB_JOBENTITYS" : "job/jobEntitys",
        "JOB_REQUESTS" : "job/jobRequests",
        "JOB_OWNJOBREQUESTS" : "job/ownJobRequests",
        "JOB_AUDITIONJOBREQUESTS" : "job/auditionJobRequests",
        "JOB_REQUEST_DETAIL" : "job/requestDetail/:jobRequestID",
        "JOB_REQUEST_STATUS_CHANGE" : "job/requestStatusChange",
        "JOB_AUDITION_RESPONSE" : "job/auditionResponse",
        "JOB_AUDITION" : "job/audition"
};
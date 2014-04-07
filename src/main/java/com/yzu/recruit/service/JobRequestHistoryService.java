package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.dataaccess.model.JobRequestHistoryEntityExt;

public interface JobRequestHistoryService {

    int addJobRequestHistory(JobRequestHistoryEntityExt jobRequestHistoryEntityExt);

    List<JobRequestHistoryEntityExt> queryJobRequestHistorysByJobrequestid(int jobrequestId);

    void deleteJobRequestHistory(JobRequestHistoryEntityExt jobRequestHistoryEntityExt);

}

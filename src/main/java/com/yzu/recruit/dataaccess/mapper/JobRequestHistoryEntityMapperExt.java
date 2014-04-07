package com.yzu.recruit.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.JobRequestHistoryEntityMapper;
import com.yzu.recruit.dataaccess.model.JobRequestHistoryEntityExt;

public interface JobRequestHistoryEntityMapperExt extends JobRequestHistoryEntityMapper {

    int insertJobRequestHistory(JobRequestHistoryEntityExt jobRequestHistoryEntityExt);

    List<JobRequestHistoryEntityExt> queryJobRequestHistorysByJobrequestid(int jobrequestId);

    void deleteJobRequestHistory(@Param("jobRequestHistoryID")int jobRequestHistoryID);

}

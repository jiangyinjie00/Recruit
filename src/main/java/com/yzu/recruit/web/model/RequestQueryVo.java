package com.yzu.recruit.web.model;

import com.yzu.recruit.common.pagination.PageModel;

public class RequestQueryVo {
    private int statusid;
    private PageModel pageModel;
    public int getStatusid() {
        return statusid;
    }
    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }
    public PageModel getPageModel() {
        return pageModel;
    }
    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }


}

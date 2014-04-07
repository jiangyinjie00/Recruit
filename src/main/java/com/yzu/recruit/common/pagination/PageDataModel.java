package com.yzu.recruit.common.pagination;

import java.util.List;

public class PageDataModel<T> {

    private PageModel paging;

    private List<T> data;

    public PageModel getPaging() {
        return paging;
    }

    public void setPaging(PageModel paging) {
        this.paging = paging;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}

package com.yzu.recruit.web.model;

import com.yzu.recruit.common.pagination.PageModel;

public class RecruitQueryVo {
    private String city;
    private String type;
    private SearchItem searchItem;
    private PageModel pageModel;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public SearchItem getSearchItem() {
        return searchItem;
    }
    public void setSearchItem(SearchItem searchItem) {
        this.searchItem = searchItem;
    }
    public PageModel getPageModel() {
        return pageModel;
    }
    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }


}

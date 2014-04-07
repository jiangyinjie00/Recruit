package com.yzu.recruit.web.model;

public class SearchItem {

    private String searchKey;
    private String searchValue;

    /**
     *
     * @param searchKey
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    /**
	 *
	 */
    public String getSearchKey() {
        return this.searchKey;
    }

    /**
     *
     * @param searchValue
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
	 *
	 */
    public String getSearchValue() {
        return this.searchValue;
    }

}

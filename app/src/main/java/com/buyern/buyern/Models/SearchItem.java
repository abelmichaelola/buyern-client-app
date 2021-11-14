package com.buyern.buyern.Models;

public class SearchItem {
    SearchItemType searchItemType;
    Object searchItem;

    public SearchItem() {
    }

    public SearchItem(SearchItemType searchItemType, Object searchItem) {
        this.searchItemType = searchItemType;
        this.searchItem = searchItem;
    }

    public SearchItemType getSearchItemType() {
        return searchItemType;
    }

    public void setSearchItemType(SearchItemType searchItemType) {
        this.searchItemType = searchItemType;
    }

    public Object getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(Object searchItem) {
        this.searchItem = searchItem;
    }
}

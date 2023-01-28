package com.socialsoul.base.beans.searchAzure;

import java.util.List;

public class SearchRequest {
    private String searchText;
    private int $top;
    private FiltersSearchRequest filters;

    public SearchRequest(String searchText,String project, List<String> repository, List<String> branch){
        this.searchText = searchText;
        this.filters = new FiltersSearchRequest();
        this.$top = 10;
        this.filters.setBranch(branch);
        this.filters.setProject(List.of(project));
        this.filters.setRepository(repository);
    }

    public SearchRequest(){};

    public String getSearchText() {
        return searchText;
    }
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    public int get$top() {
        return $top;
    }
    public void set$top(int $top) {
        this.$top = $top;
    }
    public FiltersSearchRequest getFilters() {
        return filters;
    }
    public void setFilters(FiltersSearchRequest filters) {
        this.filters = filters;
    }


}

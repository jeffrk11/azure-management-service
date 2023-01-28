package com.socialsoul.base.beans.searchAzure.searchresponse;

import java.util.List;

public class SearchResponse {
    
    private int count;
    private List<SearchFile> results;
    
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List<SearchFile> getResults() {
        return results;
    }
    public void setResults(List<SearchFile> results) {
        this.results = results;
    }

    
}

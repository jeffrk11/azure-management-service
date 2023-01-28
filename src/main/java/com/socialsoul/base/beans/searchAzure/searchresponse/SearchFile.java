package com.socialsoul.base.beans.searchAzure.searchresponse;

import java.util.List;

public class SearchFile {
    
    private String path;
    private SearchFileMatch matches;
    private SearchFileRepository repository;
    private List<SearchFileVersions> versions;
    
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public SearchFileMatch getMatches() {
        return matches;
    }
    public void setMatches(SearchFileMatch matches) {
        this.matches = matches;
    }
    public SearchFileRepository getRepository() {
        return repository;
    }
    public void setRepository(SearchFileRepository repository) {
        this.repository = repository;
    }
    public List<SearchFileVersions> getVersions() {
        return versions;
    }
    public void setVersions(List<SearchFileVersions> versions) {
        this.versions = versions;
    }

    
}

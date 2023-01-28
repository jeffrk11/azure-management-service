package com.socialsoul.base.beans.searchAzure;

import java.util.List;


public class FiltersSearchRequest {
    private List<String> Project;
    private List<String> Repository;
    private List<String> Branch;
    public List<String> getProject() {
        return Project;
    }
    public void setProject(List<String> project) {
        Project = project;
    }
    public List<String> getRepository() {
        return Repository;
    }
    public void setRepository(List<String> repository) {
        Repository = repository;
    }
    public List<String> getBranch() {
        return Branch;
    }
    public void setBranch(List<String> branch) {
        Branch = branch;
    }

    
}

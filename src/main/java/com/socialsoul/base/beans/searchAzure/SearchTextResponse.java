package com.socialsoul.base.beans.searchAzure;

import java.util.List;

public class SearchTextResponse {
    
    private String idRepository;
    private String nameRepository;
    private String path;
    private List<String> branchs;
    private List<String> textsFinded;


    public String getIdRepository() {
        return idRepository;
    }
    public void setIdRepository(String idRepository) {
        this.idRepository = idRepository;
    }
    public List<String> getBranchs() {
        return branchs;
    }
    public void setBranchs(List<String> branchs) {
        this.branchs = branchs;
    }
    public List<String> getTextsFinded() {
        return textsFinded;
    }
    public void setTextsFinded(List<String> textFinded) {
        this.textsFinded = textFinded;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getNameRepository() {
        return nameRepository;
    }
    public void setNameRepository(String nameRepository) {
        this.nameRepository = nameRepository;
    }

    
}

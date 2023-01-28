package com.socialsoul.base.beans.repository;

import java.util.Optional;

import org.json.JSONObject;

public class PomProject {
    private String springVersion;
    private String name;
    private String description;
    private String version;
    private String javaVersion;

    public PomProject(JSONObject xml){
        
        this.springVersion = String.valueOf(xml.optQuery("/project/parent/version"));
        this.name = String.valueOf(xml.optQuery("/project/name"));
        this.description = String.valueOf(xml.optQuery("/project/description"));
        this.version = String.valueOf(xml.optQuery("/project/version"));
        this.javaVersion = String.valueOf(xml.optQuery("/project/properties/java.version"));
    }

    public String getSpringVersion() {
        return springVersion;
    }
    public void setSpringVersion(String springVersion) {
        this.springVersion = springVersion;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getJavaVersion() {
        return javaVersion;
    }
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    
}

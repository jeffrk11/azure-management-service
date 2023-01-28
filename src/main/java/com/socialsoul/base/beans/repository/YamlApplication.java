package com.socialsoul.base.beans.repository;

import org.json.JSONObject;

public class YamlApplication {
    private String contextPath;

    public YamlApplication(JSONObject yaml) {
        this.contextPath = (String) yaml.optQuery("/server/servlet/context-path");
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    
}

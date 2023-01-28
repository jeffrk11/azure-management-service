package com.socialsoul.base.beans.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RepositoriesAzure {
    private String id;
    private String name;
    private String webUrl;
    private boolean isDisabled;
    private boolean isInMaintenance;
    
    @JsonInclude(Include.NON_NULL)
    private String host;
    @JsonInclude(Include.NON_NULL)
    private String lastCommit;
    @JsonInclude(Include.NON_NULL)
    private String url_dev;
    @JsonInclude(Include.NON_NULL)
    private String url_hml;
    @JsonInclude(Include.NON_NULL)
    private String url_prd;
    @JsonInclude(Include.NON_NULL)
    private String liveness;
    @JsonInclude(Include.NON_NULL)
    private String readiness;
    @JsonInclude(Include.NON_NULL)
    private PomProject pom;
    @JsonInclude(Include.NON_NULL)
    private YamlApplication yamlDev;
    @JsonInclude(Include.NON_NULL)
    private YamlApplication yamlHml;
    @JsonInclude(Include.NON_NULL)
    private YamlApplication yamlPrd;
    

    //getters e setters
    
    public String getId() {
        return id;
    }
    
    public YamlApplication getYamlDev() {
        return yamlDev;
    }

    public void setYamlDev(YamlApplication yamlDev) {
        this.yamlDev = yamlDev;
    }

    public YamlApplication getYamlHml() {
        return yamlHml;
    }

    public void setYamlHml(YamlApplication yamlHml) {
        this.yamlHml = yamlHml;
    }

    public YamlApplication getYamlPrd() {
        return yamlPrd;
    }

    public void setYamlPrd(YamlApplication yamlPrd) {
        this.yamlPrd = yamlPrd;
    }

    public String getLiveness() {
        return liveness;
    }

    public void setLiveness(String liveness) {
        this.liveness = liveness;
    }

    public String getReadiness() {
        return readiness;
    }

    public void setReadiness(String readiness) {
        this.readiness = readiness;
    }

    public String getUrl_dev() {
        return url_dev;
    }
    public void setUrl_dev(String url_dev) {
        this.url_dev = url_dev;
    }
    public String getUrl_hml() {
        return url_hml;
    }
    public void setUrl_hml(String url_hml) {
        this.url_hml = url_hml;
    }
    public String getUrl_prd() {
        return url_prd;
    }
    public void setUrl_prd(String url_prd) {
        this.url_prd = url_prd;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public boolean isInMaintenance() {
        return isInMaintenance;
    }

    public void setInMaintenance(boolean isInMaintenance) {
        this.isInMaintenance = isInMaintenance;
    }

    public PomProject getPom() {
        return pom;
    }

    public void setPom(PomProject pom) {
        this.pom = pom;
    }

    public String getLastCommit() {
        return lastCommit;
    }

    public void setLastCommit(String lastCommit) {
        this.lastCommit = lastCommit;
    }

    
}

package com.socialsoul.base.business.repository;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import com.socialsoul.base.beans.repository.RepositoriesAzure;
import com.socialsoul.base.beans.repository.YamlApplication;
import com.socialsoul.base.service.repository.ApplicationService;

@Component
public class ApplicationBusiness implements RepositoryBusiness{

    @Autowired
    private ApplicationService application;

    private String environment = "dev";

    @Override
    public void populate(String file, RepositoriesAzure repository) {
        if(file == null) 
            return;
        JSONObject app = new JSONObject((Map) new Yaml().load(file));
        switch(environment){
            case "dev":
                repository.setYamlDev(new YamlApplication(app));
                environment = "hml";
                break;
            case "hml":
                repository.setYamlHml(new YamlApplication(app));
                environment = "prd";
                break;
            case "prd":
                repository.setYamlPrd(new YamlApplication(app));
                environment = "dev";
                break;
        }
    }

    @Override
    public String getFile(RepositoriesAzure repository) {
        application.setEnvironment(environment);
        return application.findFile(repository);
    }
}

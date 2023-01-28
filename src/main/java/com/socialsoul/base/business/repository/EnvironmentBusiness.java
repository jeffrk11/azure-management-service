package com.socialsoul.base.business.repository;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import com.socialsoul.base.beans.repository.RepositoriesAzure;
import com.socialsoul.base.service.repository.EnvironmentService;

@Component
public class EnvironmentBusiness implements RepositoryBusiness{

    @Autowired
    EnvironmentService environmentService;

    @Override
    public void populate(String file, RepositoriesAzure repository) {
        if(file == null)
            return;
        var jsonYaml = new JSONObject((Map) new Yaml().load(file));

        repository.setUrl_dev((String) jsonYaml.optQuery("/ingress/hosts/dev_d1/0/host"));
        repository.setUrl_hml((String) jsonYaml.optQuery("/ingress/hosts/qa_h1/0/host"));
        repository.setUrl_prd((String) jsonYaml.optQuery("/ingress/hosts/prod_p1/0/host"));
    }

    @Override
    public String getFile(RepositoriesAzure repository) {
        return environmentService.findFile(repository);
    }
    
}

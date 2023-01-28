package com.socialsoul.base.business.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialsoul.base.beans.repository.RepositoriesAzure;
import com.socialsoul.base.service.repository.DeploymentService;
import com.socialsoul.base.utils.YamlReader;

@Component
public class DeploymentFileBusiness implements RepositoryBusiness{

    @Autowired
    DeploymentService deploymentService;

    @Override
    public void populate(String file, RepositoriesAzure repository) {
        try{
            repository.setLiveness(YamlReader.findValue(List.of("livenessProbe:","httpGet:"),"path:",  file));
            repository.setReadiness(YamlReader.findValue(List.of("readinessProbe:","httpGet:"),"path:",  file));
        }catch(Exception e){
            repository.setLiveness(null);
            repository.setReadiness(null);
        }
    }

    @Override
    public String getFile(RepositoriesAzure repository) {
        return deploymentService.findFile(repository);
    }
    
}

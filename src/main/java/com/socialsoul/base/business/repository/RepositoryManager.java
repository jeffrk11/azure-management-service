package com.socialsoul.base.business.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialsoul.base.beans.repository.RepositoriesAzure;

@Component
public class RepositoryManager {
    
    @Autowired
    DeploymentFileBusiness deploymentFileBusiness;
    @Autowired
    EnvironmentBusiness environmentFileBusiness;
    @Autowired
    PomBusiness pomFileBusiness;
    @Autowired
    ApplicationBusiness applicationFileBusiness;
    @Autowired
    CommitBusiness commitBusiness;

    private List<RepositoryBusiness> business;

    public void populate(RepositoriesAzure repository){
        this.config();

        business.parallelStream().forEach(
            business -> {
                business.populate(business.getFile(repository), repository);
            }
        );
    }

    private void config(){
        business = new ArrayList<>();
        business.add(deploymentFileBusiness);
        business.add(environmentFileBusiness);
        business.add(pomFileBusiness);
        business.add(applicationFileBusiness);//dev
        business.add(applicationFileBusiness);//hml
        business.add(applicationFileBusiness);//prd  3x para cada ambiente
        business.add(commitBusiness);

    }
}

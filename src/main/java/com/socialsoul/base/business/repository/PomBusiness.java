package com.socialsoul.base.business.repository;

import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialsoul.base.beans.repository.PomProject;
import com.socialsoul.base.beans.repository.RepositoriesAzure;
import com.socialsoul.base.service.repository.PomService;

@Component
public class PomBusiness implements RepositoryBusiness{

    @Autowired
    PomService pomService;

    @Override
    public void populate(String file, RepositoriesAzure repository) {
        if(file == null)
            return;
        PomProject pom = new PomProject(XML.toJSONObject(file));
        repository.setPom(pom);
    }

    @Override
    public String getFile(RepositoriesAzure repository) {
        return pomService.findFile(repository);
    }
    
}

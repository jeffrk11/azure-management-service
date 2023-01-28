package com.socialsoul.base.business.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socialsoul.base.beans.repository.RepositoriesAzure;
import com.socialsoul.base.service.repository.CommitService;

@Component
public class CommitBusiness implements RepositoryBusiness{

    @Autowired
    CommitService commitService;

    @Override
    public void populate(String file, RepositoriesAzure repository) {
        String date = (String) new JSONObject(file).optQuery("/value/0/committer/date");
        if(date == null)
            return;
        
        SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");

        try {
            repository.setLastCommit(dateFor.format(from.parse(date)));
        } catch (ParseException e) {
            repository.setLastCommit(null);
        }
    }

    @Override
    public String getFile(RepositoriesAzure repository) {
        return commitService.findFile(repository);
    }
    
}

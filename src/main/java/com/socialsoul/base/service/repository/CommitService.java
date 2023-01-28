package com.socialsoul.base.service.repository;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.socialsoul.base.beans.repository.RepositoriesAzure;

@Service
public class CommitService implements AzureHandler{

    @Value("${azure.url}")
    private String url;

    @Autowired
    HttpHelper httpHelper;

    @Override
    public String findFile(RepositoriesAzure repository) {
        try {
            HttpResponse response = 
                httpHelper.doGet(url + "/_apis/git/repositories/"+repository.getId()+"/commits?api-version=7.0&$top=1");
            return response.statusCode() == 200 ? (String) response.body() : null;
        } catch (Exception e) {
            return null;
        }
    }
    
}

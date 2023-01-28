package com.socialsoul.base.service.repository;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.socialsoul.base.beans.repository.RepositoriesAzure;

@Service
public class PomService implements AzureHandler{

    @Value("${azure.url}")
    private String url;


    @Autowired
    HttpHelper httpHelper;

    @Override
    public String findFile(RepositoriesAzure repository) {
        try {
            HttpResponse pomResponse = 
                httpHelper.doGet(url + "/_apis/git/repositories/"+repository.getId()+"/items?api-version=7.0&path=/pom.xml");
            return pomResponse.statusCode() == 200 ? (String) pomResponse.body() : null;
        } catch (Exception e) {
            return null;
        }
    }
    
}

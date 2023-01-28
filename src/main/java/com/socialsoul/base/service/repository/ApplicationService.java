package com.socialsoul.base.service.repository;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.socialsoul.base.beans.repository.RepositoriesAzure;

@Service
public class ApplicationService implements AzureHandler{

    @Value("${azure.url}")
    private String url;

    @Autowired
    HttpHelper httpHelper;

    private String environment;

    @Override
    public String findFile(RepositoriesAzure repository) {
        try {
            HttpResponse application = httpHelper.doGet(url + "/_apis/git/repositories/"
                +repository.getId()+"/items?api-version=7.0&path=/src/main/resources/application-"+
                environment+".yaml");
            return application.statusCode() == 200 ? (String) application.body() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public void setEnvironment(String env){
        this.environment = env;
    }
    
}

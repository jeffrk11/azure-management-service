package com.socialsoul.base.service.repository;

import java.net.http.HttpResponse;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.socialsoul.base.beans.repository.RepositoriesAzure;
import com.socialsoul.base.beans.searchAzure.SearchRequest;

@Service
public class DeploymentService implements AzureHandler{

    @Value("${azure.url}")
    private String url;

    @Value("${azure.url-search}")
    private String urlSearch;

    @Autowired
    HttpHelper httpHelper;


    @Override
    public String findFile(RepositoriesAzure repository) {
        try {
            HttpResponse searchResponse = httpHelper.doPost(urlSearch, new Gson().toJson(
                                                    new SearchRequest("deployment.yaml", 
                                                                        "Lomadee", 
                                                                        List.of(repository.getName()), 
                                                                        List.of("master","develop"))));
            if(searchResponse.statusCode() != 200)
                return null;
            
            var json = new JSONObject((String) searchResponse.body());

            if(json.getInt("count") == 0)
                return null;

            var yamlFile = 
                httpHelper.doGet(url + "/_apis/git/repositories/"+repository.getId()
                +"/items?api-version=7.0&path="+(String) json.query("/results/0/path"));
            
            return yamlFile.statusCode() == 200 ? yamlFile.body(): null;
        } catch (Exception e) {
            return null;
        }
    }
    
}

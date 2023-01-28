package com.socialsoul.base.service.repository;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.socialsoul.base.beans.repository.ListRepositories;
import com.socialsoul.base.beans.repository.RepositoriesAzure;
import com.socialsoul.base.business.repository.RepositoryManager;
import com.socialsoul.base.exception.BusinessException;


@Service
public class AzureDev {
    
    @Value("${azure.url}")
    private String url;

    @Value("${azure.url-search}")
    private String urlSearch;

    @Autowired
    private RepositoryManager repositoryManager;

    @Autowired
    HttpHelper httpHelper;

    public List<RepositoriesAzure> listRepos(){
        try {
            HttpResponse resp = httpHelper.doGet(url + "/_apis/git/repositories?api-version=7.0");
            var repositories = new Gson().fromJson((String) resp.body(), ListRepositories.class);
            return repositories.getValue();

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public RepositoriesAzure findRepository(String id){
        HttpResponse resp;
        RepositoriesAzure repository = null;
        try {
            resp = httpHelper.doGet(url + "/_apis/git/repositories/"+id+"?api-version=7.0");
        } catch (Exception e) {
            return null;
        }
        if(resp.statusCode() == 200){
            repository = new Gson().fromJson((String) resp.body(), RepositoriesAzure.class);

            repositoryManager.populate(repository);

        }else{
            throw new BusinessException("Repositório não encontrado", HttpStatus.BAD_REQUEST);
        }

        return repository;
    }
}

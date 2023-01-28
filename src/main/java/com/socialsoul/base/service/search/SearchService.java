package com.socialsoul.base.service.search;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.socialsoul.base.beans.searchAzure.SearchRequest;
import com.socialsoul.base.beans.searchAzure.searchresponse.SearchResponse;
import com.socialsoul.base.service.repository.AzureDev;
import com.socialsoul.base.service.repository.HttpHelper;

@Service
public class SearchService {
    
    @Value("${azure.url}")
    private String url;

    @Value("${azure.url-search}")
    private String urlSearch;

    @Autowired
    private HttpHelper httpHelper;

    @Autowired 
    private AzureDev azureDev;

    public SearchResponse findTextByRequest(SearchRequest request){
        try {
            HttpResponse searchResponse = httpHelper.doPost(urlSearch, new Gson().toJson(
                                                        new SearchRequest(request.getSearchText(), 
                                                                            "Lomadee", 
                                                                            this.getAllRepos(), 
                                                                            List.of("master","develop"))));
            var searchJson = new Gson().fromJson((String) searchResponse.body(), SearchResponse.class);

            return searchJson;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public String getFile(String repositoryId, String path, String branch){
        try {
            HttpResponse application = httpHelper.doGet(url + "/_apis/git/repositories/"
                    +repositoryId+"/items?api-version=7.0&path="+path
                    +"&versionDescriptor.version="+branch);
            return application.statusCode() == 200 ? (String) application.body() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> getAllRepos(){
        return azureDev.listRepos().stream().map( r -> r.getName()).collect(Collectors.toList());
    }
}

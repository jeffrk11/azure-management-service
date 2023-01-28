package com.socialsoul.base.business.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.socialsoul.base.beans.searchAzure.SearchRequest;
import com.socialsoul.base.beans.searchAzure.SearchTextResponse;
import com.socialsoul.base.beans.searchAzure.searchresponse.SearchResponse;
import com.socialsoul.base.service.search.SearchService;
import com.socialsoul.base.utils.TextReader;

@Component
public class SearchBusiness {
    
    @Autowired
    SearchService searchService;

    public List<SearchTextResponse> findTextIn(SearchRequest searchRequest){
        
        SearchResponse response = searchService.findTextByRequest(searchRequest);

        List<SearchTextResponse> searchs = response.getResults().stream().map(
            search ->{
                var resp = new SearchTextResponse();
                resp.setPath(search.getPath());
                resp.setIdRepository(search.getRepository().getId());
                resp.setNameRepository(search.getRepository().getName());
                resp.setBranchs(search.getVersions().stream().map( v -> v.getBranchName()).collect(Collectors.toList()));
                String branch = search.getVersions().isEmpty() ? "master" : search.getVersions().get(0).getBranchName();
                String file = searchService.getFile(resp.getIdRepository(),resp.getPath(),branch);

                resp.setTextsFinded(search.getMatches().getContent().stream().map(
                    match ->{
                        return TextReader.codeSnippet(file, (int) match.getCharOffset(), 5);
                    }
                ).collect(Collectors.toList()));

                return resp;
            }
        ).collect(Collectors.toList());


        return searchs;
    } 
}

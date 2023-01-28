package com.socialsoul.base.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialsoul.base.beans.searchAzure.SearchRequest;
import com.socialsoul.base.business.search.SearchBusiness;

@RestController
public class SearchController {
    
    @Autowired
    private SearchBusiness searchBusiness;

    @PostMapping("/search")
    public ResponseEntity<?> listRepositories(@RequestBody SearchRequest search){
        System.out.println("starting search : "+ search.getSearchText());
        return new ResponseEntity<>(searchBusiness.findTextIn(search),HttpStatus.OK);
    }

}

package com.socialsoul.base.controller.repository;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.socialsoul.base.service.repository.AzureDev;

@RestController
public class CatalogController {
    
    @Autowired
    private AzureDev azureDev;

    @GetMapping("/repositories")
    public ResponseEntity<?> listRepositories(){
        return new ResponseEntity<>(azureDev.listRepos(),HttpStatus.OK);
    }
    @GetMapping("/repositories/detailed")
    public ResponseEntity<?> listRepositoriesDetailed(){
        var list = azureDev.listRepos().stream().map( r ->{
            return azureDev.findRepository(r.getId());
        }).collect(Collectors.toList());

        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/repositories/{id}")
    public ResponseEntity<?> repository(@PathVariable String id){
        return new ResponseEntity<>(azureDev.findRepository(id), HttpStatus.OK);
    }
}

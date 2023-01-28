package com.socialsoul.base.service.repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HttpHelper {
    
    @Value("${azure.token}")
    private String token;

    public HttpResponse<String> doGet(String url) throws Exception{
        var request = HttpRequest.newBuilder(new URI(url))
                                    .GET()
                                    .header("Authorization", token)
                                    .build();
        
        return HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
    }

    public HttpResponse<String> doPost(String url, String body) throws Exception{
        var request = HttpRequest.newBuilder(new URI(url))
                                    .POST(HttpRequest.BodyPublishers.ofString(body))
                                    .header("Content-Type", "application/json")
                                    .header("Authorization", token)
                                    .build();
        
        return HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
    }

}

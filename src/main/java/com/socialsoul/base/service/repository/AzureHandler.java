package com.socialsoul.base.service.repository;

import com.socialsoul.base.beans.repository.RepositoriesAzure;

public interface AzureHandler {
    
    /**
     * Find the file in the repository.
     * 
     * @param repository The repository you want to search in.
     * @return The file name.
     */
    public String findFile(RepositoriesAzure repository);
}

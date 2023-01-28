package com.socialsoul.base.business.repository;

import org.json.JSONObject;

import com.socialsoul.base.beans.repository.RepositoriesAzure;

public interface RepositoryBusiness {
    
    /**
     * It populates the repository with the data from the file.
     * 
     * @param file The name of the file to be read.
     * @param repository The repository object that will be populated with the data from the file.
     */
    public void populate(String file, RepositoriesAzure repository);

    /**
     * > This function returns the file from the repository
     * 
     * @param repository The repository object that you want to get the file from.
     * @return The file is being returned.
     */
    public String getFile(RepositoriesAzure repository);
}

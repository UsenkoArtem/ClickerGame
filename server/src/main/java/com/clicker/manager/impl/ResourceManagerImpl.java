package com.clicker.manager.impl;

import com.clicker.manager.ResourceManager;
import com.clicker.model.Resource;
import com.clicker.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ResourceManagerImpl implements ResourceManager {
    final ResourceRepository resourceRepository;

    @Autowired
    public ResourceManagerImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> getAllResources() {
        return (List<Resource>) resourceRepository.findAll();
    }

    @Override
    public Resource getResourceByName(String name) {
        return resourceRepository.getResourceByName(name);

    }
    @Override
    public  Resource getResourceById(Integer id){
        return resourceRepository.getResourceById(id);
    }
    @Override
    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public Resource deleteResourceByName(String name) {
        Resource resourceByName = resourceRepository.getResourceByName(name);
        resourceRepository.deleteByName(name);
        return  resourceByName;
    }

}

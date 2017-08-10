package com.clicker.manager;

import com.clicker.model.Resource;

import java.util.List;

public interface ResourceManager {
    List<Resource> getAllResources();

    Resource getResourceByName(String name);

    Resource addResource(Resource resource);

    void deleteResource(String name);
}

package com.clicker.manager;

import com.clicker.model.Resource;

import java.util.List;

public interface ResourceManager {
    List<Resource> getAllResources();

    Resource getResourceByName(String name);

    Resource getResourceById(Integer id);

    Resource addResource(Resource resource);

    Resource deleteResourceByName(String name);
}

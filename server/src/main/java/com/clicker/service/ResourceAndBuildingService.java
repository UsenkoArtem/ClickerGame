package com.clicker.service;

import com.clicker.model.Resource;

import java.util.List;

public interface ResourceAndBuildingService {
    List<Resource> getAllResources();
    Resource addResource(Resource resource);
    void deleteResource(String name);
}

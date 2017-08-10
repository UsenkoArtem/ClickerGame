package com.clicker.service.impl;

import com.clicker.manager.ResourceManager;
import com.clicker.manager.BuildingManager;
import com.clicker.model.Resource;
import com.clicker.service.ResourceAndBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceAndBuildingServiceImpl implements ResourceAndBuildingService {

    private final ResourceManager resourceManager;
    private final BuildingManager buildingManager;

    @Autowired
    public ResourceAndBuildingServiceImpl(ResourceManager resourceManager, BuildingManager buildingManager) {
        this.resourceManager = resourceManager;
        this.buildingManager = buildingManager;
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceManager.getAllResources();
    }

    @Override
    public Resource addResource(Resource resource) {
        return resourceManager.addResource(resource);
    }

    @Override
    public void deleteResource(String name) {
            resourceManager.deleteResource(name);
    }
}

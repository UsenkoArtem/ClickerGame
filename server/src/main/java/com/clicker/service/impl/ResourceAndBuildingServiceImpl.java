package com.clicker.service.impl;

import com.clicker.manager.BuildingManager;
import com.clicker.manager.ResourceManager;
import com.clicker.model.Building;
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
    public Resource getResourceById(Integer id) {
        return resourceManager.getResourceById(id);
    }

    @Override
    public Resource addResource(Resource resource) {
        return resourceManager.addResource(resource);
    }

    @Override
    public Resource deleteResource(String name) {
        return resourceManager.deleteResourceByName(name);
    }

    @Override
    public List<Building> getAllBuildings() {
        return buildingManager.getAllBuilding();
    }

    @Override
    public Building addBuilding(Building building) {
        return buildingManager.addBuilding(building);
    }

    @Override
    public Building deleteBuilding(String name) {
        return buildingManager.deleteBuildingByName(name);

    }
}

package com.clicker.service;

import com.clicker.model.Building;
import com.clicker.model.Resource;

import java.util.List;

public interface ResourceAndBuildingService {
    List<Resource> getAllResources();

    Resource getResourceById(Integer id);

    Resource addResource(Resource resource);

    Resource deleteResource(String name);

    List<Building> getAllBuildings();

    Building addBuilding(Building building);

    Building deleteBuilding(String name);
}

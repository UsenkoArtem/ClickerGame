package com.clicker.manager.impl;

import com.clicker.manager.BuildingManager;
import com.clicker.model.Building;
import com.clicker.repository.BuildingRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BuildingManagerImpl implements BuildingManager {
    final BuildingRepository buildingRepository;
    private static final Logger log = Logger.getLogger(BuildingManagerImpl.class);


    @Autowired
    public BuildingManagerImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
        log.info("Bean created");
    }

    @Override
    public List<Building> getAllBuilding() {
        List<Building> buildings = (List<Building>) buildingRepository.findAll();
        log.info("All buildings fetch successful: " + buildings);
        return buildings;
    }

    @Override
    public Building addBuilding(Building building) {
        Building savedBuilding = buildingRepository.save(building);
        log.info("Building added successful: " + savedBuilding);
        return savedBuilding;
    }

    @Override
    public Building deleteBuildingByName(String name) {
        Building building = buildingRepository.getBuildingByName(name);
        buildingRepository.deleteByName(name);
        log.info("Building deleted successful: " + name);
        return building;
    }

}

package com.clicker.controller;

import com.clicker.model.Building;
import com.clicker.model.Resource;
import com.clicker.service.ResourceAndBuildingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("admin")
@RestController
public class ResourceAndBuildingController {
    private static final Logger log = Logger.getLogger(ResourceAndBuildingController.class);
    private final ResourceAndBuildingService resourceAndBuildingService;

    @Autowired
    public ResourceAndBuildingController(ResourceAndBuildingService resourceAndBuildingService) {
        this.resourceAndBuildingService = resourceAndBuildingService;
    }

    @GetMapping("/initBuilding")
    public ResponseEntity<Building> initBuildings() {
        Resource inResource = new Resource();
        Set<Resource> setInResource = new HashSet<>();
        setInResource.add(inResource);


        Resource outResource = new Resource();
        Set<Resource> setOutResource = new HashSet<>();
        setOutResource.add(outResource);

        Building building = new Building();
        building.setBasicCost(70.0);
        building.setName("sawmill");
        building.setBasicLvlMultiplierProd(1.0);
        building.setBasicLvlUpMultiplierCost(1.32);
        building.setBasicProduction(2.5);
        building.setBasicConsume(1.5);
        building.setBasicQuality(1.0);
        building.setInResource(setInResource);
        building.setOutResource(setOutResource);
        inResource.setInBuilding(building);
        outResource.setOutBuilding(building);

        return new  ResponseEntity<>(resourceAndBuildingService.addBuilding(building), HttpStatus.OK);


    }
    @GetMapping("/dropBuilding")
    public ResponseEntity<List<Building>> dropBuilding(){
        resourceAndBuildingService.deleteBuilding("sawmill");
        resourceAndBuildingService.deleteResource("wood");
        resourceAndBuildingService.deleteResource("board");
        List<Building> buildings = resourceAndBuildingService.getAllBuildings();
        log.info("All buildings fetch successful");
        return new ResponseEntity<>(buildings, HttpStatus.OK);
    }
    @GetMapping("/resource")
    public ResponseEntity<List<Resource>> getAllResource() {
        List<Resource> resources = resourceAndBuildingService.getAllResources();
        log.info("All resources fetch successful");
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @PostMapping("/resource")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resource) {
        Resource addResource = resourceAndBuildingService.addResource(resource);
        log.info("resource added successful");
        return new ResponseEntity<>(addResource, HttpStatus.OK);
    }

    @DeleteMapping("/resource")
    public ResponseEntity<Resource> deleteResource(@RequestBody Resource resource) {
        Resource deleteResource = resourceAndBuildingService.deleteResource(resource.getName());
        log.info("resource deleted successful");
        return new ResponseEntity<Resource>(deleteResource, HttpStatus.OK);
    }

    @GetMapping("/building")
    public ResponseEntity<List<Building>> getAllBuilding() {
        List<Building> buildings = resourceAndBuildingService.getAllBuildings();
        log.info("All buildings fetch successful");
        return new ResponseEntity<>(buildings, HttpStatus.OK);
    }

    @PostMapping("/building")
    public ResponseEntity<Building> addBuilding(@RequestBody Building building) {
//        if (resourceAndBuildingService.getResourceById(building.getResourceID()) == null) {
//            log.info("resource added failed");
//            return new ResponseEntity<Building>(HttpStatus.BAD_GATEWAY);
//        } else
        log.info("resource added successful");
        return new ResponseEntity<Building>(resourceAndBuildingService.addBuilding(building), HttpStatus.OK);
    }

    @DeleteMapping("/building")
    public ResponseEntity<Building> deleteBuilding(@RequestBody Building building) {
        Building buildingDeleted = resourceAndBuildingService.deleteBuilding(building.getName());
        log.info("resource deleted successful");
        return new ResponseEntity<Building>(buildingDeleted, HttpStatus.OK);
    }

}

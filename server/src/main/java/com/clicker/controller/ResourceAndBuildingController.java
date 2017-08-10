package com.clicker.controller;

import com.clicker.model.Resource;
import com.clicker.service.ResourceAndBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin")
@RestController
public class ResourceAndBuildingController {
    private final ResourceAndBuildingService resourceAndBuildingService;

    @Autowired
    public ResourceAndBuildingController(ResourceAndBuildingService resourceAndBuildingService) {
        this.resourceAndBuildingService = resourceAndBuildingService;
    }

    @GetMapping("/resource")
    public ResponseEntity<List<Resource>> getAllResource() {
        return new ResponseEntity<>(resourceAndBuildingService.getAllResources(), HttpStatus.OK);
    }

    @PostMapping("/resource")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resource){
        return new ResponseEntity<>(resourceAndBuildingService.addResource(resource), HttpStatus.OK);
    }

    @DeleteMapping("/resource")
    public ResponseEntity<Resource> deleteResource(@RequestBody Resource resource){
        resourceAndBuildingService.deleteResource(resource.getName());
        return new ResponseEntity<Resource>(resource , HttpStatus.OK);
    }
}

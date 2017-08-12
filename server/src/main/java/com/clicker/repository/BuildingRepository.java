package com.clicker.repository;

import com.clicker.model.Building;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends CrudRepository<Building, Integer> {
    Building getBuildingByName(String name);
    void deleteByName(String name);
}

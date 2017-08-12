package com.clicker.manager;

import com.clicker.model.Building;

import java.util.List;

public interface BuildingManager {
    List<Building> getAllBuilding();

    Building addBuilding(Building building);

    Building deleteBuildingByName(String name);
}

package com.clicker.repository;


import com.clicker.model.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource,Integer> {

    Resource getResourceByName(String name);
    Resource getResourceById(Integer id);
    void deleteByName(String name);
}

package com.clicker.repository;

import com.clicker.model.Resource;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource,Integer> {

    Resource getResourceByName(String name);
    void deleteByName(String name);
}

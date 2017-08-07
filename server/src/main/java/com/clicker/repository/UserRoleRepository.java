package com.clicker.repository;

import com.clicker.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Query("select a.role from UserRole a where a.userLogin =?1")
    public List<String> findUserRolesByUserLogin(String login);

    public void deleteByUserLoginAndRole(String login, String role);
}

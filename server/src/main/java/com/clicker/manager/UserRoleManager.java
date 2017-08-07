package com.clicker.manager;

import com.clicker.model.User;
import com.clicker.model.UserRole;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface UserRoleManager {
    UserRole addUserRole(User user, String role) throws SQLIntegrityConstraintViolationException;
    UserRole deleteUserRole(User user, String role) throws SQLIntegrityConstraintViolationException;
    List<String> getAllUserRoles(User user) throws SQLIntegrityConstraintViolationException;
    List<UserRole> getAllRoles();
}

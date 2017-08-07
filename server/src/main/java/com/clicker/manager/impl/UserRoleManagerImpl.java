package com.clicker.manager.impl;

import com.clicker.manager.UserManager;
import com.clicker.manager.UserRoleManager;
import com.clicker.model.User;
import com.clicker.model.UserRole;
import com.clicker.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
@Repository
public class UserRoleManagerImpl implements UserRoleManager {

    UserManager userManager;
    UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleManagerImpl(UserRoleRepository userRoleRepository, UserManager userManager) {
        this.userRoleRepository = userRoleRepository;
        this.userManager = userManager;
    }

    private Boolean checkPresenceUser(User user) {
        System.out.println("check " + user);
        return (userManager.getUserById(user.getId()) != null);
    }

    @Override
    public UserRole addUserRole(User user, String role) throws SQLIntegrityConstraintViolationException {
        System.out.println(user);
        System.out.println(role);

        if (userManager.getUserById(user.getId()) != null)
            return userRoleRepository.save(new UserRole(null, user.getLogin(), role));
        throw new SQLIntegrityConstraintViolationException();
    }

    @Override
    public UserRole deleteUserRole(User user, String role) throws SQLIntegrityConstraintViolationException {
        if (checkPresenceUser(user)) {
            userRoleRepository.deleteByUserLoginAndRole(user.getLogin(), role);
        }
        throw new SQLIntegrityConstraintViolationException();
    }

    @Override
    public List<String> getAllUserRoles(User user) throws SQLIntegrityConstraintViolationException {
        if (checkPresenceUser(user))
            return userRoleRepository.findUserRolesByUserLogin(user.getLogin());
        throw new SQLIntegrityConstraintViolationException();
    }

    @Override
    public List<UserRole> getAllRoles() {
        return (List<UserRole>) userRoleRepository.findAll();
    }
}

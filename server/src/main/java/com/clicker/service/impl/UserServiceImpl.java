package com.clicker.service.impl;


import com.clicker.manager.UserManager;
import com.clicker.manager.UserRoleManager;
import com.clicker.model.User;
import com.clicker.model.UserRole;
import com.clicker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserManager userManager;
    private final UserRoleManager userRoleManager;
    @Autowired
    public UserServiceImpl(UserManager userManager, UserRoleManager userRoleManager) {
        this.userManager = userManager;
        this.userRoleManager = userRoleManager;
    }

    @Override
    public List<User> getAllUser() {
        return userManager.getAllUser();
    }

    @Override
    public User getUserById(int id) {
        return userManager.getUserById(id);
    }

    @Override
    public User deleteUserById(int id) {
        return userManager.deleteUser(id);
    }

    @Override
    public User updateUser(User user) {
        User userById = userManager.getUserById(user.getId());
        if (userById == null) return null;
        userById.setEmail(user.getEmail());
        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());
        userManager.addNewUser(userById);
        return userById;
    }
    @Override
   public List<UserRole> getAllUsersRoles(){
        return userRoleManager.getAllRoles();
    }
}

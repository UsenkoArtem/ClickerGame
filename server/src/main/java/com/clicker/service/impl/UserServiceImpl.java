package com.clicker.service.impl;


import com.clicker.manager.UserManager;
import com.clicker.model.User;
import com.clicker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserManager userManager;

    @Autowired
    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
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
}

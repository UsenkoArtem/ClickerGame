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
    public User addUser(User user) {
        return userManager.addNewUser(user);
    }

    @Override
    public Boolean loginUser(User user) {
        User userByLogin = userManager.getUserByLogin(user.getLogin());
        if (userByLogin == null) return false; else
        return userByLogin.getPassword().equals(user.getPassword());
    }

    @Override
    public User deleteUserById(int id) {
        return userManager.deleteUser(id);
    }


    @Override
    public Boolean findUser(String column, String param) {
        if (column.toLowerCase().equals("email")) {
            User userByEmail = userManager.getUserByEmail(param);
            System.out.println(param);
            System.out.println(userByEmail);
            return userByEmail != null;
        } else if (column.toLowerCase().equals("login")) {
            User userByLogin = userManager.getUserByLogin(param);
            System.out.println(param);
            System.out.println(userByLogin);
            return userByLogin != null;
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        System.out.println(user);
        User userById = userManager.getUserById(user.getId());
        userById.setEmail(user.getEmail());
        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());
        userManager.addNewUser(userById);
        return userById;
    }
}

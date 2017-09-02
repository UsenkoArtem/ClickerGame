package com.clicker.manager.impl;

import com.clicker.controller.AdminController;
import com.clicker.manager.UserManager;
import com.clicker.model.User;
import com.clicker.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserManagerImpl implements UserManager {
    final
    UserRepository userRepository;
    private static final Logger log = Logger.getLogger(AdminController.class);

    @Autowired
    public UserManagerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = (List<User>) userRepository.findAll();
        log.info("Users: " + userList);
        return userList;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(int id) {
        User userById = getUserById(id);
        userRepository.delete(userById);
        return userById;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}

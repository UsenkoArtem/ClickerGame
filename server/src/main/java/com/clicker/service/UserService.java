package com.clicker.service;

import com.clicker.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(int id);
    User deleteUserById(int  id);
    User updateUser(User user);
}

package com.clicker.service;

import com.clicker.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(int id);
    User addUser(User user);
    Boolean loginUser(User user);
    User deleteUserById(int  id);
    Boolean findUser(String column, String param);

}

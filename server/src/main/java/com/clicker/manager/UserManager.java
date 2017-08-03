package com.clicker.manager;


import com.clicker.model.User;

import java.util.List;

public interface UserManager {
    List<User> getAllUser();
    User getUserById(int id);
    User addNewUser(User user);
    User deleteUser(int id);
    User getUserByEmail(String email);
    User getUserByLogin(String param);
}

package com.clicker.service;


import com.clicker.dto.LoginDTO;
import com.clicker.model.User;

public interface RegAndLoginService {
    User login(LoginDTO loginDTO);

    User registration(User user);

    Boolean findUser(String column, String param);
}

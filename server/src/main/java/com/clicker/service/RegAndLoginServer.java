package com.clicker.service;


import com.clicker.dto.LoginDTO;
import com.clicker.model.User;

public interface RegAndLoginServer {
    User login(LoginDTO loginDTO);
    User registration(User user);
}

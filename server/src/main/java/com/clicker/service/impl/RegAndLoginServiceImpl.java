package com.clicker.service.impl;

import com.clicker.dto.LoginDTO;
import com.clicker.manager.UserManager;
import com.clicker.manager.UserRoleManager;
import com.clicker.model.User;
import com.clicker.service.RegAndLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class RegAndLoginServiceImpl implements RegAndLoginService {
    private final UserManager userManager;
    private final UserRoleManager userRoleManager;
    @Autowired
    public RegAndLoginServiceImpl(UserManager userManager, UserRoleManager userRoleManager) {
        this.userManager = userManager;
        this.userRoleManager = userRoleManager;
    }

    @Override
    public User login(LoginDTO loginDTO) {
        User userByLogin = userManager.getUserByLogin(loginDTO.getLogin());
        if (userByLogin == null) return null;
        if (userByLogin.getPassword().equals(loginDTO.getPassword())) return userByLogin;
        else
            return null;
    }

    @Override
    public User registration(User user) {
        String email = user.getEmail();
        String login = user.getLogin();
        User userByEmail = userManager.getUserByEmail(email);
        User userByLogin = userManager.getUserByLogin(login);
        if (userByEmail != null || userByLogin != null) return null;
        userManager.addNewUser(user);
        try {
            userRoleManager.addUserRole(user, "ROLE_USER");
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }
        return user;
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
}

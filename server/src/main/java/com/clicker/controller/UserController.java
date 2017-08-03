package com.clicker.controller;

import com.clicker.manager.UserManager;
import com.clicker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("user")
@Controller
public class UserController {
    private final UserManager userManager;


    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAllUser() {
        return userManager.getAllUser();
    }


    @GetMapping(value = "{id}")
    public @ResponseBody
    User getUser(@PathVariable("id") int id) {
        return userManager.getUserById(id);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User addUser(@RequestBody User user) {
        return userManager.addNewUser(user);
    }


    @DeleteMapping(value = "{id}")
    public @ResponseBody
    User deleteUser(@PathVariable("id") int id) {
        return userManager.deleteUser(id);
    }


    @GetMapping(value = "/search")
    public @ResponseBody
    Boolean getEmail(@RequestParam("column") String column, @RequestParam("param") String param) {
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

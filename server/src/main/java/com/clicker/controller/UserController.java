package com.clicker.controller;

import com.clicker.manager.UserManager;
import com.clicker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
@Controller
public class UserController {
    private final UserManager userManager;


    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAllUser() {
        return userManager.getAllUser();
    }

    @CrossOrigin
    @GetMapping(value = "{id}")
    public @ResponseBody
    User getUser(@PathVariable("id") int id) {
        return userManager.getUserById(id);
    }

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User addUser(@RequestBody User user) {
        return userManager.addNewUser(user);
    }

    @CrossOrigin
    @DeleteMapping(value = "{id}")
    public @ResponseBody
    User deleteUser(@PathVariable("id") int id) {
        return userManager.deleteUser(id);
    }

}

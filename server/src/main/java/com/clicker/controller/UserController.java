package com.clicker.controller;

import com.clicker.model.User;
import com.clicker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("user")
@Controller
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAllUser() {
        return userService.getAllUser();
    }


    @GetMapping(value = "{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    public @ResponseBody
    Boolean loginUser(@RequestBody User user) {
        return userService.loginUser(user);

    }

    @DeleteMapping(value = "{id}")
    public @ResponseBody
    User deleteUserById(@PathVariable("id") int id) {
        return userService.deleteUserById(id);
    }


    @GetMapping(value = "/isRegUser")
    public @ResponseBody
    Boolean isRegUser(@RequestParam("column") String column, @RequestParam("param") String param) {
        System.out.println(column + " " + param);
        return userService.findUser(column, param);
    }

    @CrossOrigin
    @PutMapping
    public @ResponseBody
    User updateUser(@RequestBody User user) {
        return userService.updateUser(user);

    }
}

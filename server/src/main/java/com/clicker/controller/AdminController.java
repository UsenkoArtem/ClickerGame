package com.clicker.controller;

import com.clicker.model.User;
import com.clicker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("admin")
@RestController
public class AdminController {
    private final UserService userService;


    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User userById = userService.getUserById(id);
        if (userById == null) return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        else
            return new ResponseEntity<>(userById, HttpStatus.OK);

    }

    @CrossOrigin
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id)

    {
        User user = userService.deleteUserById(id);
        if (user == null) return new ResponseEntity<User>(HttpStatus.BAD_GATEWAY); else
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @CrossOrigin
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        if (updateUser == null) return new ResponseEntity<User>(HttpStatus.BAD_GATEWAY); else
            return new ResponseEntity<User>(updateUser, HttpStatus.OK);

    }
}

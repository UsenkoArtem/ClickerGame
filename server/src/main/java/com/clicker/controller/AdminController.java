package com.clicker.controller;

import com.clicker.model.User;
import com.clicker.model.UserRole;
import com.clicker.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin")
@RestController
public class AdminController {
    private final UserService userService;
    private static final Logger log = Logger.getLogger(AdminController.class);

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> listOfUsers = userService.getAllUser();
        log.info("All users fetch successful");
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    //for debugging
    @GetMapping("user/roles")
    public ResponseEntity<List<UserRole>> getAllUsersRoles() {
        List<UserRole> listOfRoles = userService.getAllUsersRoles();
        log.info("All user roles fetch successful");
        return new ResponseEntity<>(listOfRoles, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User userById = userService.getUserById(id);
        if (userById == null) {
            log.info("User not found: " + id);
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        } else
            log.info("User founded:" + userById);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id) {
        User user = userService.deleteUserById(id);
        if (user == null) {
            log.info("User not found: " + id);
            return new ResponseEntity<User>(HttpStatus.BAD_GATEWAY);
        } else {
            log.info("User deleted");
            return new ResponseEntity<User>(user, HttpStatus.OK);

        }
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        log.info("user update: " + user);
        User updateUser = userService.updateUser(user);
        log.info("user udated: " + updateUser);
        if (updateUser == null) {
            log.info("User not found: " + user.getId());
            return new ResponseEntity<User>(HttpStatus.BAD_GATEWAY);
        } else {
            log.info("User updated");
            return new ResponseEntity<User>(updateUser, HttpStatus.OK);
        }


    }
}

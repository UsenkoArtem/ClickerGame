package com.clicker.controller;

import com.clicker.dto.LoginDTO;
import com.clicker.model.User;
import com.clicker.service.RegAndLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrance")
public class RegAndLoginController {

    private final RegAndLoginService regAndLoginService;

    @Autowired
    public RegAndLoginController(RegAndLoginService regAndLoginService) {
        this.regAndLoginService = regAndLoginService;
    }
    @CrossOrigin
    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        User registration = regAndLoginService.registration(user);
        if (registration == null) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        } else {
            return new ResponseEntity<>(registration, HttpStatus.OK);
        }

    }

    @CrossOrigin
    @PostMapping(value = "/signIn")
    public ResponseEntity<User> loginUser(@RequestBody LoginDTO loginDTO) {
        User login = regAndLoginService.login(loginDTO);
        if (login == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_GATEWAY);
        } else {
            return new ResponseEntity<User>(login, HttpStatus.OK);
        }
    }
    @CrossOrigin
    @GetMapping(value = "/isRegUser")
    public ResponseEntity<Boolean> isRegUser(@RequestParam("column") String column, @RequestParam("param") String param) {
        System.out.println(column + " " + param);
        Boolean user = regAndLoginService.findUser(column, param);
        if (user == null) return new ResponseEntity<Boolean>(HttpStatus.BAD_GATEWAY);
        return new ResponseEntity<Boolean>(user,HttpStatus.OK);
    }

}

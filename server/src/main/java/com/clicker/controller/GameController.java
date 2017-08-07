package com.clicker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @GetMapping
    public ResponseEntity<Boolean> isAccess() {
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}

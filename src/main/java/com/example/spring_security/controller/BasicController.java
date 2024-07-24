package com.example.spring_security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public ResponseEntity<String> base() {
        return new ResponseEntity<>("Welcome to Spring Security!", HttpStatus.OK);
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint() {
        return new ResponseEntity<>("Accessing public endpoint", HttpStatus.OK);
    }

    @GetMapping("/private")
    public ResponseEntity<String> privateEndpoint() {
        return new ResponseEntity<>("Accessing private endpoint", HttpStatus.OK);
    }

    // @GetMapping("/")
    // public String base() {
    //     return new String("Welcome to Spring Security!");
    // }
    
}

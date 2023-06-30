package com.example.simple_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ReadinessLivenessController {

    @GetMapping
    private ResponseEntity<String> getReadinessLiveness() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

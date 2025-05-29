package com.example.relaxer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simpleendpoint")
public class SimpleController {

    @GetMapping
    public String getSimpleText(){return "SimpleText";}
}

package com.IntegratedProjectSpring.IntegratedProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the app";
    }
}

package com.integratedproject.integratedproject.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

   @GetMapping("/home")
   public String home() {
      return "Este es el home del proyecto";
   }
}

package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping()
    public String welcome(){
        return "Welcome to Dentist!";
    }

    @PostMapping("/create")
    public Dentist createDentistHandler(@RequestBody Dentist dentist){
        return dentist;
    }

    @GetMapping("/search")
    public Dentist searchDentistHandler(int id){
        return null;
    }
    @GetMapping("/searchAll")
    public List<Dentist> searchAllDentistHandler(){
        return null;
    }
    @PostMapping("/update")
    public Dentist updateDentistHandler(@RequestBody Dentist dentist){
        return null;
    }
}

package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.AddressService;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public String welcome(){
        return "welcome to patient!";
    }
    @PostMapping("/create")
    public Patient createPatientHandler(@RequestBody Patient patient){
        patientService.create(patient);
       return patient;
    }
    @GetMapping("/search")
    public Patient searchPatientHandler(int id) {
       return null;
    }
    @GetMapping("/searchAll")
    public List<Patient> searchAllPatientHandler(){
       return null;
    }
}

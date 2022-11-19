package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.daos.AddressDaoH2;
import com.IntegratedProjectSpring.IntegratedProjectApplication.daos.PatientDaoH2;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public String welcome(){
        return "welcome to patient!";
    }
    @PostMapping("/create")
    public Patient createPatientHandler(@RequestBody Patient patient) throws SQLException {
        patientService.setPatientDao(new PatientDaoH2(new AddressDaoH2()));
       return patientService.create(patient);
    }
    @GetMapping("/search")
    public Patient searchPatientHandler(int id) throws SQLException {
        patientService.setPatientDao(new PatientDaoH2(new AddressDaoH2()));
       return patientService.search(id);
    }
    @GetMapping("/searchAll")
    public List<Patient> searchAllPatientHandler() throws SQLException {
        patientService.setPatientDao(new PatientDaoH2(new AddressDaoH2()));
       return patientService.searchAll();
    }
}

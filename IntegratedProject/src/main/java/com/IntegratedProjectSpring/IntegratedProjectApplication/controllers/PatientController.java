package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.daos.PatientDaoH2;
import com.IntegratedProjectSpring.IntegratedProjectApplication.entity.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/search")
    public Patient searchPatientHandler(int id) throws SQLException {
        patientService.setPatientDao(new PatientDaoH2());
       return patientService.search(id);
    }
    @GetMapping("/searchAll")
    public List<Patient> searchAllPatientHandler() throws SQLException {
        patientService.setPatientDao(new PatientDaoH2());
       return patientService.searchAll();
    }
}

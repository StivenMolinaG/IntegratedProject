package com.IntegratedProjectSpring.IntegratedProject.controllers;

import com.IntegratedProjectSpring.IntegratedProject.daos.PatientDaoH2;
import com.IntegratedProjectSpring.IntegratedProject.entity.Patient;
import com.IntegratedProjectSpring.IntegratedProject.services.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
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
}

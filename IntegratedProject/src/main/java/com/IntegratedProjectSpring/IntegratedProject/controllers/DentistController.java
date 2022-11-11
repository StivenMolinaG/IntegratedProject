package com.IntegratedProjectSpring.IntegratedProject.controllers;

import com.IntegratedProjectSpring.IntegratedProject.daos.DentistDaoH2;
import com.IntegratedProjectSpring.IntegratedProject.entity.Dentist;
import com.IntegratedProjectSpring.IntegratedProject.services.DentistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class DentistController {
    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/searchDentist")
    public Dentist searchDentistHandler(int id) throws SQLException {
        dentistService.setDentistDao(new DentistDaoH2());
        return dentistService.search(id);
    }
}

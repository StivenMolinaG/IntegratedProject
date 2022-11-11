package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.daos.DentistDaoH2;
import com.IntegratedProjectSpring.IntegratedProjectApplication.entity.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/search")
    public Dentist searchDentistHandler(int id) throws SQLException {
        dentistService.setDentistDao(new DentistDaoH2());
        return dentistService.search(id);
    }
    @GetMapping("/searchAll")
    public List<Dentist> searchAllDentistHandler() throws SQLException {
        dentistService.setDentistDao(new DentistDaoH2());
        return dentistService.searchAll();
    }
}

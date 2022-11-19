package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.daos.DentistDaoH2;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    public Dentist createPatient(@RequestBody Dentist dentist) throws SQLException {
        dentistService.setDentistDao(new DentistDaoH2());
        return dentistService.create(dentist);
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
    @PostMapping("/update")
    public Dentist updateDentistHandler(@RequestBody Dentist dentist) throws SQLException {
        dentistService.setDentistDao(new DentistDaoH2());
        return dentistService.update(dentist);
    }
}

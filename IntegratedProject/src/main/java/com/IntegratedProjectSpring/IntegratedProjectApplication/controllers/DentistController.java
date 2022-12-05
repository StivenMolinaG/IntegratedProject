package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Dentist createDentistsHandler(@RequestBody Dentist dentist){
        dentistService.create(dentist);
        return dentist;
    }
    @GetMapping("/search")
    public ResponseEntity<Dentist> searchDentistHandler(Integer id) {
        Dentist dentistResponse = dentistService.search(id);
        return ResponseEntity.ok(dentistResponse);
    }
    @GetMapping("/searchAll")
    public ResponseEntity<List<Dentist>> searchAllDentistHandler(){
        return ResponseEntity.ok(dentistService.searchAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Dentist> updatePatientHandler(@RequestBody Dentist dentist){
        ResponseEntity<Dentist> response = null;

        if(dentist.getId() != null && dentistService.search(dentist.getId()) != null){
            response = ResponseEntity.ok(dentistService.update(dentist));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePatientHandler(Integer id){
        ResponseEntity<String> response = null;

        if(dentistService.search(id)!= null){
            dentistService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dentist successfully deleted");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}

package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.PatientDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

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
    @GetMapping("/search/{id}")
    public ResponseEntity<Patient> searchPatientHandler(@PathVariable Integer id) {
        Patient patient = patientService.search(id);
        ResponseEntity response;
        if(patient!= null){
            response = ResponseEntity.ok(patient);
        }else{
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }
    @GetMapping("/searchAll")
    public ResponseEntity<Set<PatientDto>> searchAllPatientHandler(){
        ResponseEntity<Set<PatientDto>> response;
        Set<PatientDto> patientsDtos = patientService.searchAll();

        if(patientsDtos.isEmpty()){
            response= new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            response= ResponseEntity.ok(patientsDtos);
        }

        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatientHandler(@RequestBody Patient patient){
        ResponseEntity<Patient> response = null;

        if(patient.getDNI() != null && patientService.search(patient.getId()) != null){
            response = ResponseEntity.ok(patientService.update(patient));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatientHandler(@PathVariable Integer id){
        ResponseEntity<String> response = null;

        if(patientService.search(id)!= null){
            patientService.delete(id);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("Patient successfully deleted");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
            return response;
    }
}

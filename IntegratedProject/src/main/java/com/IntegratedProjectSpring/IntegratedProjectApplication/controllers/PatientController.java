package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.AddressService;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl.PatientServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Patient> searchPatientHandler(Long DNI) {
        Patient patientResponse = patientService.search(DNI);
       return ResponseEntity.ok(patientResponse);
    }
    @GetMapping("/searchAll")
    public ResponseEntity<List<Patient>> searchAllPatientHandler(){
       return ResponseEntity.ok(patientService.searchAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatientHandler(@RequestBody Patient patient){
        ResponseEntity<Patient> response = null;

        if(patient.getDNI() != null && patientService.search(patient.getDNI()) != null){
            response = ResponseEntity.ok(patientService.update(patient));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePatientHandler(Long DNI){
        ResponseEntity<String> response = null;

        if(patientService.search(DNI)!= null){
            patientService.delete(DNI);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Patient successfully deleted");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
            return response;
    }
}

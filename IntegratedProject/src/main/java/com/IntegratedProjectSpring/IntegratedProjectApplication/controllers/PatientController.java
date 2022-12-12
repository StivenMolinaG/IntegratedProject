package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.PatientDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.exceptions.ResourceNotFoundException;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private static final Logger logger = Logger.getLogger(PatientController.class);

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
    public ResponseEntity<Patient> searchPatientHandler(@PathVariable Integer id) throws ResourceNotFoundException {
        Patient patient = patientService.search(id);
        ResponseEntity response;
        if(patient!= null){
            logger.info("Patient founded correctly");
            response = ResponseEntity.ok(patient);
        }else{
            logger.error("Patient not found");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException("Not Exists any Patient with Id: " + id);
        }
        return response;
    }
    @GetMapping("/searchAll")
    public ResponseEntity<Set<PatientDto>> searchAllPatientHandler() throws ResourceNotFoundException {
        ResponseEntity<Set<PatientDto>> response;
        Set<PatientDto> patientsDtos = patientService.searchAll();
        if(patientsDtos.isEmpty()){
            logger.error("Patient not found");
            response= new ResponseEntity<>(HttpStatus.NO_CONTENT);
            throw new ResourceNotFoundException("Not Exists any Patient");
        }else{
            logger.info("Patient founded correctly");
            response= ResponseEntity.ok(patientsDtos);
        }

        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatientHandler(@RequestBody Patient patient) throws ResourceNotFoundException {
        ResponseEntity<Patient> response = null;

        if(patient.getDNI() != null && patientService.search(patient.getId()) != null){
            logger.info("Patient has id and founded in DataBase to update");
            response = ResponseEntity.ok(patientService.update(patient));
        }else {
            logger.error("Patient not found");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResourceNotFoundException("Not Exists any Patient with Id: " + patient.getId());
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatientHandler(@PathVariable Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;

        if(patientService.search(id)!= null){
            logger.info("Patient has id and founded in DataBase to delete");
            patientService.delete(id);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("Patient successfully deleted");
        }else {
            logger.error("Patient not found");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResourceNotFoundException("Not Exists any Patient with Id: " + id);
        }
            return response;
    }
}

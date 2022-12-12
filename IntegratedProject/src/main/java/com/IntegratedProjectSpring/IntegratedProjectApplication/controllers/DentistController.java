package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.DentistDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.exceptions.ResourceNotFoundException;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private static final Logger logger = Logger.getLogger(DentistController.class);
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
    public ResponseEntity<Dentist> searchDentistHandler(Integer id) throws ResourceNotFoundException {
        Dentist dentistResponse = dentistService.search(id);
        ResponseEntity response;
        if(dentistResponse != null){
            logger.info("Dentist founded correctly");
            response = ResponseEntity.ok(dentistResponse);
        }else {
            logger.error("Dentist not found");
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
            throw new ResourceNotFoundException("Not Exists any Dentist with Id: " + id);
        }
        return response;
    }
    @GetMapping("/searchAll")
    public ResponseEntity<Set<DentistDto>> searchAllDentistHandler() throws ResourceNotFoundException {
        ResponseEntity<Set<DentistDto>> response;
        Set<DentistDto> dentistDtoSet = dentistService.searchAll();
        if(dentistDtoSet.isEmpty()){
            logger.error("Dentist not found");
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
            throw new ResourceNotFoundException("Not Exists any Dentist");
        }else {
            logger.info("Dentist founded correctly");
            response = ResponseEntity.ok(dentistDtoSet);
        }
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<Dentist> updatePatientHandler(@RequestBody Dentist dentist) throws ResourceNotFoundException {
        ResponseEntity<Dentist> response = null;

        if(dentist.getId() != null && dentistService.search(dentist.getId()) != null){
            logger.info("Dentist has id and founded in DataBase to update");
            response = ResponseEntity.ok(dentistService.update(dentist));
        }else {
            logger.error("Dentist not founded in DataBase to update");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResourceNotFoundException("Not Exists any Dentist with Id: " + dentist.getId());
        }
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePatientHandler(Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;

        if(dentistService.search(id)!= null){
            logger.info("Dentist has id and founded in DataBase to delete");
            dentistService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dentist successfully deleted");
        }else {
            logger.info("Dentist not founded in DataBase to delete");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResourceNotFoundException("Not Exists any Dentist with Id: " + id);
        }
        return response;
    }
}

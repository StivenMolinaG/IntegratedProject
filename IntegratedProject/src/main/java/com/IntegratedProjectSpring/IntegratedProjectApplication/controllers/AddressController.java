package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.AddressDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.exceptions.ResourceNotFoundException;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.AddressService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {
    private static final Logger logger = Logger.getLogger(AddressController.class);
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address){
        addressService.create(address);
        return address;
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Address> searchAddressHandler(@PathVariable Integer id) throws ResourceNotFoundException {
        System.out.println("entro");
        Address addressResponse = addressService.search(id);
        ResponseEntity response;
        System.out.println("ADDRESS: " + ResponseEntity.ok(addressResponse));
        if(addressResponse != null){
            logger.info("Address is not null in search");
            response = ResponseEntity.ok(addressResponse);
        }else{
            logger.error("Address not found in search");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException("Not Exists any Address with Id: " + id);
        }
        return response;
    }
    @GetMapping("/searchAll")
    public ResponseEntity<Set<AddressDto>> searchAllAddressHandler() throws ResourceNotFoundException {
        ResponseEntity<Set<AddressDto>> response;
        Set<AddressDto> addressDtos = addressService.searchAll();
        if(addressDtos.isEmpty()){
            logger.error("Address is empty in searchAll");
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            throw new ResourceNotFoundException("Not Exists any Address");
        }else{
            logger.info("Address is not null in searchAll");
            response = ResponseEntity.ok(addressDtos);
        }
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<Address> updateAddressHandler(@RequestBody Address address) throws ResourceNotFoundException {
        ResponseEntity<Address> response = null;
        Address addressSearch = addressService.search(address.getId());
        if(address.getId() != null && addressSearch != null){
            logger.info("Address has id and founded in DataBase to update");
            response = ResponseEntity.ok(addressService.update(address));
        }else {
            logger.error("Address hasn't id or not found in DataBase to update successfully");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResourceNotFoundException("Not Exists any Address with Id: " + address.getId());
        }
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddressHandler(Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;

        if(addressService.search(id)!= null){
            logger.info("Address founded to delete successfully");
            addressService.delete(id);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("Address successfully deleted");
        }else {
            logger.error("Address not found in DataBase to delete successfully");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResourceNotFoundException("Not Exists any Address with Id: " + id);
        }
        return response;
    }
}

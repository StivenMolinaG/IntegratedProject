package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.AddressService;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address){
        addressService.create(address);
        return address;
    }

    @GetMapping("/search")
    public ResponseEntity<Address> searchAddressHandler(Integer id) {
        Address addressResponse = addressService.search(id);
        return ResponseEntity.ok(addressResponse);
    }
    @GetMapping("/searchAll")
    public ResponseEntity<List<Address>> searchAllAddressHandler(){
        return ResponseEntity.ok(addressService.searchAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Address> updateAddressHandler(@RequestBody Address address){
        ResponseEntity<Address> response = null;

        if(address.getId() != null && addressService.search(address.getId()) != null){
            response = ResponseEntity.ok(addressService.update(address));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddressHandler(Integer id){
        ResponseEntity<String> response = null;

        if(addressService.search(id)!= null){
            addressService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Address successfully deleted");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}

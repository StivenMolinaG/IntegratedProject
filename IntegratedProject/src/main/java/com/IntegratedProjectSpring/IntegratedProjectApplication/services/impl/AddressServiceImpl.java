package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.AddressRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.PatientRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address create(Address address) {
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address search(Integer id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> searchAll() {
        return addressRepository.findAll();
    }

    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public Address update(Address address) {
        return addressRepository.save(address);
    }
}

package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.AddressRepository;
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
        return null;
    }

    @Override
    public List<Address> searchAll() {
        return null;
    }
}

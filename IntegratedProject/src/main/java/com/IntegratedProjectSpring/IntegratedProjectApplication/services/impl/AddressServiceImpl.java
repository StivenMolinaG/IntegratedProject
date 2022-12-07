package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.AddressDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.AddressRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.PatientRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

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
    public Set<AddressDto> searchAll() {
        List<Address> addressList = addressRepository.findAll();
        Set<AddressDto> addressDtos = new HashSet<>();
        for (Address address : addressList) {
            AddressDto addressDto = mapper.convertValue(address, AddressDto.class);
            addressDtos.add(addressDto);
        }
        return addressDtos;
    }

    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public Address update(Address address) {
        return addressRepository.save(address);
    }
}

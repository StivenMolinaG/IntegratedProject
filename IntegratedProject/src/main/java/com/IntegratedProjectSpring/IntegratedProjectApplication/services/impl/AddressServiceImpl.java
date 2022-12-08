package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.AddressDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.AddressRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger logger = Logger.getLogger(AddressServiceImpl.class);
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Address create(Address address) {
        addressRepository.save(address);
        logger.info("Created address successfully");
        return address;
    }

    @Override
    public Address search(Integer id) {
        Address address = addressRepository.findAddressById(id);
        return address;
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
        logger.warn("Deleted address successfully");
    }

    public Address update(Address address) {
        logger.warn("Updating address successfully");
        return addressRepository.save(address);
    }
}

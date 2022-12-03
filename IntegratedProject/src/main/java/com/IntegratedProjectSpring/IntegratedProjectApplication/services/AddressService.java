package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address create(Address address);
    Address search(Integer id);
    List<Address> searchAll();

    Address update(Address address);

    void delete(Integer id);
}

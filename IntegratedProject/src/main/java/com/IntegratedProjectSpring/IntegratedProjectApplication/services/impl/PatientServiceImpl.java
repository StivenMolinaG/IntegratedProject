package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.AddressRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.PatientRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Patient create(Patient patient) {

        // Como dijimos que Patient viene con la data de de Address en su interior,
        // antes de guardar el patient, debemos guardar el Address que viene allí
        /*Address address = patient.getAddressReference();
        address.setPatient();
        addressRepository.save(patient.getAddressReference());
        System.out.println("Address" + patient.getAddressReference().toString());*/

        //patient.setDateOut(new Date());
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public Patient search(long id) {
        return null;
    }

    @Override
    public List<Patient> searchAll() {
        return null;
    }

}

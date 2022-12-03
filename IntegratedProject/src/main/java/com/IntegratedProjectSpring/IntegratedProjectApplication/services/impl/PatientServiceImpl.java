package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

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
        patient.setDateOut(new Date());
        System.out.println("Address" + patient.getAddressReference());
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public Patient search(Long DNI) {
        return patientRepository.findPatientByDNI(DNI);
    }

    @Override
    public List<Patient> searchAll() {
        return patientRepository.findAll();
    }

    public void delete(Long DNI) {
        patientRepository.deleteById(DNI);
    }

    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

}

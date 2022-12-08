package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.PatientDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.AddressRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.PatientRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Patient create(Patient patient) {
        Address address = patient.getAddressReference();
        addressRepository.save(address);
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public Patient search(Integer id) {
        return patientRepository.findPatientById(id);
    }

    @Override
    public Set<PatientDto> searchAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDto> patientsDTO = new HashSet<>();
        for (Patient patient : patients) {
            PatientDto patientDTO = mapper.convertValue(patient, PatientDto.class);
            patientsDTO.add(patientDTO);
        }
        return patientsDTO;
    }

    public void delete(Integer id) {
        patientRepository.deleteById(id);
    }

    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

}

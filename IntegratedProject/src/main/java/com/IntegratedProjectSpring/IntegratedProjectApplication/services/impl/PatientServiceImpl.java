package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.PatientDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Address;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.AddressRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.PatientRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {
    private static final Logger logger = Logger.getLogger(PatientServiceImpl.class);

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
        logger.info("Created address for patient successfully");
        patientRepository.save(patient);
        logger.info("created patient successfully");
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
        logger.warn("deleted patient successfully");
    }

    public Patient update(Patient patient) {
        logger.warn("deleted patient successfully");
        return patientRepository.save(patient);
    }

}

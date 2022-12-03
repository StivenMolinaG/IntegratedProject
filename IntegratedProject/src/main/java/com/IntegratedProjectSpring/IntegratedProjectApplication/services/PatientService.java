package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PatientService {

    Patient create(Patient patient);
    Patient search(Long DNI);
    List<Patient> searchAll();

    Patient update(Patient patient);

    void delete(Long id);
}
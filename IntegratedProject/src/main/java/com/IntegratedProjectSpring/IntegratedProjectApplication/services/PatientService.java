package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.PatientDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface PatientService {

    Patient create(Patient patient);
    Patient search(Integer id);
    Set<PatientDto> searchAll();

    Patient update(Patient patient);

    void delete(Integer id);
}
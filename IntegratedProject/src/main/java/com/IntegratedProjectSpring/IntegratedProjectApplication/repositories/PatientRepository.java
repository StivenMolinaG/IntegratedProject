package com.IntegratedProjectSpring.IntegratedProjectApplication.repositories;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.PatientDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientById(Integer id);
    void deleteById(Integer id);
}

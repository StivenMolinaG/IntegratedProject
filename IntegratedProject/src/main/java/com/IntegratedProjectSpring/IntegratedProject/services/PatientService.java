package com.IntegratedProjectSpring.IntegratedProject.services;

import com.IntegratedProjectSpring.IntegratedProject.daos.IDao;
import com.IntegratedProjectSpring.IntegratedProject.entity.Patient;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class PatientService {

    private IDao<Patient> patientDao;

    public void setPatientDao(IDao<Patient> patientDao) {
        this.patientDao = patientDao;
    }

    public Patient create(Patient patient) throws SQLException {
        return this.patientDao.create(patient);
    }

    public Patient search(int id) throws SQLException {
        return this.patientDao.search(id);
    }
}

package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.daos.IDao;
import com.IntegratedProjectSpring.IntegratedProjectApplication.entity.Patient;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
    public List<Patient> searchAll() throws SQLException {
        return this.patientDao.searchAll();
    }
}

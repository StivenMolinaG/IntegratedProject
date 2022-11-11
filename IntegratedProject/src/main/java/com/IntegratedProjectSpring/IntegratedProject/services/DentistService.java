package com.IntegratedProjectSpring.IntegratedProject.services;

import com.IntegratedProjectSpring.IntegratedProject.daos.IDao;
import com.IntegratedProjectSpring.IntegratedProject.entity.Dentist;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class DentistService {
    private IDao<Dentist> dentistDao;

    public void setDentistDao(IDao<Dentist> dentistDao) {
        this.dentistDao = dentistDao;
    }

    public Dentist create(Dentist dentist) throws SQLException {
        return this.dentistDao.create(dentist);
    }

    public Dentist search(int id) throws SQLException {
        return this.dentistDao.search(id);
    }
}

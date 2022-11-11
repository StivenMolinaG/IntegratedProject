package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.daos.IDao;
import com.IntegratedProjectSpring.IntegratedProjectApplication.entity.Dentist;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
    public List<Dentist> searchAll() throws SQLException {
        return this.dentistDao.searchAll();
    }
}

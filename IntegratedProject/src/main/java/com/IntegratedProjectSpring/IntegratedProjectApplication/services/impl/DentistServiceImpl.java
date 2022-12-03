package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.DentistRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public Dentist create(Dentist dentist) {
        dentistRepository.save(dentist);
        return dentist;
    }

    @Override
    public Dentist search(Integer id) {
        return dentistRepository.findById(id).get();
    }

    @Override
    public List<Dentist> searchAll() {
        return dentistRepository.findAll();
    }

    public void delete(Integer id) {
        dentistRepository.deleteById(id);
    }

    public Dentist update(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
}

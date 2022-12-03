package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DentistService {

    Dentist create(Dentist dentist);

    Dentist search(Integer id);
    List<Dentist> searchAll();
    Dentist update(Dentist dentist);

    void delete(Integer id);
}
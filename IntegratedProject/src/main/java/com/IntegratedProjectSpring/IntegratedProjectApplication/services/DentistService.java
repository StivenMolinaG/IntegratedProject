package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.DentistDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface DentistService {

    Dentist create(Dentist dentist);

    Dentist search(Integer id);
    Set<DentistDto> searchAll();
    Dentist update(Dentist dentist);

    void delete(Integer id);
}
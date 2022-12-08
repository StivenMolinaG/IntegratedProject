package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.DentistDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.DentistRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DentistServiceImpl implements DentistService {

    private static final Logger logger = Logger.getLogger(DentistServiceImpl.class);

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Dentist create(Dentist dentist) {
        dentistRepository.save(dentist);
        logger.info("Created dentist successfully");
        return dentist;
    }

    @Override
    public Dentist search(Integer id) {
        return dentistRepository.findDentistById(id);
    }

    @Override
    public Set<DentistDto> searchAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDto> dentistsDto = new HashSet<>();
        for (Dentist dentist : dentists) {
            DentistDto dentistDto = mapper.convertValue(dentist, DentistDto.class);
            dentistsDto.add(dentistDto);
        }
        return dentistsDto;
    }

    public void delete(Integer id) {
        dentistRepository.deleteById(id);
        logger.warn("deleted dentist successfully");
    }

    public Dentist update(Dentist dentist) {
        logger.info("updated dentist successfully");
        return dentistRepository.save(dentist);
    }
}

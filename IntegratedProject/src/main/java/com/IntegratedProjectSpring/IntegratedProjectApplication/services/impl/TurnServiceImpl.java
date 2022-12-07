package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.TurnDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Patient;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.TurnRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.TurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnServiceImpl implements TurnService {

    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Turn create(Turn turn) {
        turnRepository.save(turn);
        return turn;
    }

    @Override
    public Turn search(Integer id) {
        return turnRepository.findTurnById(id);
    }

    @Override
    public Set<TurnDto> searchAll() {
        List<Turn> turns = turnRepository.findAll();
        Set<TurnDto> turnsDto = new HashSet<>();
        for (Turn turn : turns) {
            TurnDto turnDto = mapper.convertValue(turn, TurnDto.class);
            turnsDto.add(turnDto);
        }
        return turnsDto;
    }

    public void delete(Integer id) {
        turnRepository.deleteById(id);
    }

    public Turn update(Turn turn) {
        return turnRepository.save(turn);
    }
}

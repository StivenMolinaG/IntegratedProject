package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.TurnDto;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.TurnRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.TurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnServiceImpl implements TurnService {
    private static final Logger logger = Logger.getLogger(TurnServiceImpl.class);

    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Turn create(Turn turn) {
        turn.setDateTime(new Date());
        turnRepository.save(turn);
        logger.info("Created Turn successfully");
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
        logger.warn("Deleted Turn successfully");
    }

    public Turn update(Turn turn) {
        logger.warn("Updated Turn successfully");
        return turnRepository.save(turn);
    }
}

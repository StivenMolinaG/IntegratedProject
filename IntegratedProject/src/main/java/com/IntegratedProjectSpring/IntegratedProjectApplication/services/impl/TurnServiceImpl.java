package com.IntegratedProjectSpring.IntegratedProjectApplication.services.impl;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.TurnRepository;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TurnServiceImpl implements TurnService {

    @Autowired
    private TurnRepository turnRepository;

    @Override
    public Turn create(Turn turn) {
        turnRepository.save(turn);
        return turn;
    }

    @Override
    public Turn search(Integer id) {
        return null;
    }

    @Override
    public List<Turn> searchAll() {
        return null;
    }
}

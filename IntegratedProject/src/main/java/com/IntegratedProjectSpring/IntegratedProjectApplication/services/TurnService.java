package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.TurnDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface TurnService {

    Turn create(Turn turn);
    Turn search(Integer id);
    Set<TurnDto> searchAll();

    void delete(Integer id);
    Turn update(Turn turn);
}

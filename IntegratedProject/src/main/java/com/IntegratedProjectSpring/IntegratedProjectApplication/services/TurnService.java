package com.IntegratedProjectSpring.IntegratedProjectApplication.services;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TurnService {

    Turn create(Turn patient);
    Turn search(Integer id);
    List<Turn> searchAll();
}

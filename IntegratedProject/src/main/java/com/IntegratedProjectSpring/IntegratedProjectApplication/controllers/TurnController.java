package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.TurnDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.TurnService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turn")
public class TurnController {
    private static final Logger logger = Logger.getLogger(TurnController.class);
    @Autowired
    private TurnService turnService;

    @GetMapping()
    public String welcome() {
        return "Welcome to turns";
    }

    @PostMapping("/create")
    public Turn createTurnHandler(@RequestBody Turn turn){
        turnService.create(turn);
        return turn;
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Turn> searchTurnHandler(@PathVariable Integer id){
        Turn turn = turnService.search(id);
        ResponseEntity response;
        if(turn != null){
            logger.info("Turn is not null in search");
            response = ResponseEntity.ok(turn);
        }else {
            logger.error("Turn not founded");
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/searchAll")
    public ResponseEntity<Set<TurnDto>> searchAllTurnsHandler() {
        ResponseEntity<Set<TurnDto>> response;
        Set<TurnDto> turnDtos = turnService.searchAll();
        if(turnDtos.isEmpty()){
            logger.error("Turn not found");
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            logger.info("Turn found");
            response = ResponseEntity.ok(turnDtos);
        }
        return response;
    }

    @PutMapping("/update")
    public Turn updateTurnHandler(@RequestBody Turn turn){
        Turn response;
        if(turn.getId() != null && turnService.search(turn.getId()) != null){
            logger.info("Turn is not null and founded to update");
            turnService.update(turn);
            response = turnService.search(turn.getId());
        }else {
            logger.error("Turn not founded, check the turn");
            response = turn;
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTurnHandler(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if(turnService.search(id) != null){
            logger.info("Turn founded");
            turnService.delete(id);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("Turn successfully deleted");
        }else{
            logger.info("Turn not found");
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turn not found");
        }
        return response;
    }
}

package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.TurnDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import com.IntegratedProjectSpring.IntegratedProjectApplication.services.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turn")
public class TurnController {
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
    public Turn searchTurnHandler(@PathVariable Integer id){
        return turnService.search(id);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<Set<TurnDto>> searchAllTurnsHandler() {
        return ResponseEntity.ok(turnService.searchAll());
    }

    @PutMapping("/update")
    public Turn updateTurnHandler(@RequestBody Turn turn){
        Turn response;
        if(turn.getId() != null && turnService.search(turn.getId()) != null){
            turnService.update(turn);
            response = turnService.search(turn.getId());
        }else {
            response = turn;
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTurnHandler(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if(turnService.search(id) != null){
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body("Turn successfully deleted");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turn not found");
        }
        return response;
    }
}

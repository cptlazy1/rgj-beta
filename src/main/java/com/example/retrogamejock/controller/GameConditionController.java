package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameConditionDto;
import com.example.retrogamejock.service.GameConditionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameConditionController {

    private final GameConditionService gameConditionService;

    // Constructor to inject GameConditionService
    public GameConditionController(GameConditionService gameConditionService) {
        this.gameConditionService = gameConditionService;
    }

    // GetMapping to get all gameConditions
    @GetMapping("/game-conditions")
    public ResponseEntity<List<GameConditionDto>> getAllGameConditions() {
        List<GameConditionDto> gameConditionDtos = gameConditionService.getAllGameConditions();
        return ResponseEntity.ok(gameConditionDtos);
    }


    // TODO: assigning gameCondition to game doesn't work yet. Fix please
    // PutMapping to assign gameCondition to game
    @PutMapping("/games/{gameID}/game-conditions/{gameConditionID}")
    public ResponseEntity<String> assignGameConditionToGame(@PathVariable("gameID") Long gameID, @PathVariable("gameConditionID") Long gameConditionID) {
        gameConditionService.assignGameConditionToGame(gameID, gameConditionID);
        return ResponseEntity.ok().body("GameCondition with the " + gameConditionID + " ID has been assigned to game with the " + gameID + " ID.");
    }

    // PutMapping to assign gameCondition to game using @PathVariable and @RequestBody
    @PutMapping("/games/{gameID}/game-conditions")
    public ResponseEntity<String> assignGameConditionToGame(@PathVariable("gameID") Long gameID, @RequestBody GameConditionDto gameConditionDto) {
        gameConditionService.assignGameConditionToGame(gameID, gameConditionDto.getGameConditionID());
        return ResponseEntity.ok().body("GameCondition with the " + gameConditionDto.getGameConditionID() + " ID has been assigned to game with the " + gameID + " ID.");
    }




}

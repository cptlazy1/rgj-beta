package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameConditionDto;
import com.example.retrogamejock.service.GameConditionService;
import com.example.retrogamejock.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameConditionController {

    private final GameConditionService gameConditionService;
    private final GameService gameService;

    // Constructor to inject GameConditionService
    public GameConditionController(GameConditionService gameConditionService, GameService gameService) {
        this.gameConditionService = gameConditionService;
        this.gameService = gameService;
    }

    // GetMapping to get all gameConditions
    @GetMapping("/game-conditions")
    public ResponseEntity<List<GameConditionDto>> getAllGameConditions() {
        List<GameConditionDto> gameConditionDtos = gameConditionService.getAllGameConditions();
        return ResponseEntity.ok(gameConditionDtos);
    }

}

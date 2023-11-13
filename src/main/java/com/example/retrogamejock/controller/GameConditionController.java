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

}

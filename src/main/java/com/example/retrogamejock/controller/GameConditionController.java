package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameConditionDto;
import com.example.retrogamejock.dto.GameConditionInputDto;
import com.example.retrogamejock.service.GameConditionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    // PostMapping to add gameCondition
    @PostMapping("/game-conditions")
    public ResponseEntity<GameConditionDto> addGameCondition(@Valid @RequestBody GameConditionInputDto gameConditionInputDto) {
        GameConditionDto savedGameConditionDto = gameConditionService.addGameCondition(gameConditionInputDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/game-conditions/{id}")
                .buildAndExpand(savedGameConditionDto.getGameConditionID())
                .toUriString());

        return ResponseEntity.created(uri).body(savedGameConditionDto);
    }

    // PutMapping to update gameCondition
    @PutMapping("/game-conditions/{gameConditionID}")
    public ResponseEntity<GameConditionDto> updateGameCondition(@PathVariable Long gameConditionID, @Valid @RequestBody GameConditionInputDto gameConditionInputDto) {
        GameConditionDto updatedGameConditionDto = gameConditionService.updateGameCondition(gameConditionID, gameConditionInputDto);
        return ResponseEntity.ok(updatedGameConditionDto);
    }

}

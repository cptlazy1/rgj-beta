package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameSystemConditionDto;
import com.example.retrogamejock.dto.GameSystemConditionInputDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.retrogamejock.service.GameSystemConditionService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class GameSystemConditionController {

    private final GameSystemConditionService gameSystemConditionService;

    public GameSystemConditionController(GameSystemConditionService gameSystemConditionService) {
        this.gameSystemConditionService = gameSystemConditionService;
    }

    // GetMapping to get all game system conditions
    @GetMapping("/game-system-conditions")
    public ResponseEntity<List<GameSystemConditionDto>> getAllGameSystemConditions() {
        List<GameSystemConditionDto> gameSystemConditionDtos = gameSystemConditionService.getAllGameSystemConditions();
        return ResponseEntity.ok(gameSystemConditionDtos);
    }

    // PostMapping to add game system condition
    @PostMapping("/game-system-conditions")
    public ResponseEntity<GameSystemConditionDto> addGameSystemCondition(@Valid @RequestBody GameSystemConditionInputDto gameSystemConditionInputDto) {
        GameSystemConditionDto gameSystemConditionDto = gameSystemConditionService.addGameSystemCondition(gameSystemConditionInputDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/game-system-conditions/{id}")
                .buildAndExpand(gameSystemConditionDto.getGameSystemConditionID())
                .toUriString());

        return ResponseEntity.created(uri).body(gameSystemConditionDto);
    }

    // PutMapping to assign gameSystemCondition to gameSystem
    @PutMapping("/game-systems/{gameSystemID}/game-system-conditions/{gameSystemConditionID}")
    public ResponseEntity<String> assignGameSystemConditionToGameSystem(@PathVariable("gameSystemID") Long gameSystemID, @PathVariable("gameSystemConditionID") Long gameSystemConditionID) {
        gameSystemConditionService.assignGameSystemConditionToGameSystem(gameSystemID, gameSystemConditionID);
        return ResponseEntity.ok().body("GameSystemCondition with ID " + gameSystemConditionID + " has been assigned to GameSystem with ID " + gameSystemID);
    }

    // Pumapping to update gameSystemCondition
    @PutMapping("/game-system-conditions/{gameSystemConditionID}")
    public ResponseEntity<GameSystemConditionDto> updateGameSystemCondition(@PathVariable("gameSystemConditionID") Long gameSystemConditionID, @Valid @RequestBody GameSystemConditionInputDto gameSystemConditionInputDto) {
        GameSystemConditionDto gameSystemConditionDto = gameSystemConditionService.updateGameSystemCondition(gameSystemConditionInputDto, gameSystemConditionID);
        return ResponseEntity.ok().body(gameSystemConditionDto);
    }


}

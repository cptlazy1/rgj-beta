package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameSystemDto;
import com.example.retrogamejock.dto.GameSystemInputDto;
import com.example.retrogamejock.service.GameSystemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameSystemController {

    private final GameSystemService gameSystemService;

    // Constructor
    public GameSystemController(GameSystemService gameSystemService) {
        this.gameSystemService = gameSystemService;
    }

    // GetMapping to get all game systems
    @GetMapping("/gamesystems")
    public ResponseEntity<List<GameSystemDto>> getAllGameSystems() {
        List<GameSystemDto> gameSystemDtos = gameSystemService.getAllGameSystems();
        return ResponseEntity.ok(gameSystemDtos);
    }

    // GetMapping to get game system by gameSystemID
    @GetMapping("/gamesystems/{id}")
    public ResponseEntity<GameSystemDto> getGameSystemByGameSystemID(@PathVariable("id") Long gameSystemID) {
        GameSystemDto gameSystemDto = gameSystemService.getGameSystemByGameSystemID(gameSystemID);
        return ResponseEntity.ok(gameSystemDto);
    }

    // PostMapping to add game system
    @PostMapping("/gamesystems")
    public ResponseEntity<GameSystemDto> addGameSystem(@Valid @RequestBody GameSystemInputDto gameSystemInputDto) {
        GameSystemDto gameSystemDto = gameSystemService.addGameSystem(gameSystemInputDto);
        return ResponseEntity.created(null).body(gameSystemDto);
    }



}
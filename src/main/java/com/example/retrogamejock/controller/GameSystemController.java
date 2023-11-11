package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameSystemDto;
import com.example.retrogamejock.service.GameSystemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

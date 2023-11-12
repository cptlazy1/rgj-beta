package com.example.retrogamejock.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.retrogamejock.service.GameService;
import com.example.retrogamejock.dto.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // GetMapping to get all games
    @GetMapping("/games")
    public ResponseEntity<List<GameDto>> getAllGames() {
        List<GameDto> gameDtos = gameService.getAllGames();
        return ResponseEntity.ok(gameDtos);
    }


}

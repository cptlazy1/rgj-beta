package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameInputDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import com.example.retrogamejock.service.GameService;
import com.example.retrogamejock.dto.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // GetMapping to get game by gameID
    @GetMapping("/games/{id}")
    public ResponseEntity<GameDto> getGameByGameID(@PathVariable("id") Long gameID) {
        GameDto gameDto = gameService.getGameByGameID(gameID);
        return ResponseEntity.ok(gameDto);
    }

    // PostMapping to add game
    @PostMapping("/games")
    public ResponseEntity<GameDto> addGame(@Valid @RequestBody GameInputDto gameInputDto) {
        GameDto gameDto1 = gameService.addGame(gameInputDto);
        return ResponseEntity.created(null).body(gameDto1);
    }

    // DeleteMapping to delete game
    @DeleteMapping("/games/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable("id") Long gameID) {
        gameService.deleteGame(gameID);
        return ResponseEntity.noContent().build();
    }

    // PutMapping to update game
    @PutMapping("/games/{id}")
    public ResponseEntity<GameDto> updateGame(@PathVariable("id") Long gameID, @Valid @RequestBody GameInputDto gameInputDto) {
        GameDto gameDto = gameService.updateGame(gameID, gameInputDto);
        return ResponseEntity.ok().body(gameDto);
    }


}

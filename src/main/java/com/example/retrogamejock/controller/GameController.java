package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameInputDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import com.example.retrogamejock.service.GameService;
import com.example.retrogamejock.dto.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        GameDto gameDto = gameService.addGame(gameInputDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/games/{id}")
                .buildAndExpand(gameDto.getGameID())
                .toUriString());

        return ResponseEntity.created(uri).body(gameDto);
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


    // PutMapping to assign gameCondition to game
    @PutMapping("/games/{gameID}/game-conditions/{gameConditionID}")
    public ResponseEntity<String> assignGameConditionToGame(@PathVariable("gameID") Long gameID, @PathVariable("gameConditionID") Long gameConditionID) {
        gameService.assignGameConditionToGame(gameID, gameConditionID);
        return ResponseEntity.ok().body("GameCondition with the " + gameConditionID + " ID has been assigned to game with the " + gameID + " ID.");
    }


}

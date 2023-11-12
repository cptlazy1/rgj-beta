package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameDto;
import com.example.retrogamejock.dto.GameInputDto;
import com.example.retrogamejock.model.Game;
import com.example.retrogamejock.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    // Constructor to inject GameRepository
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // TODO: Add methods to create, read, update, and delete games
    // Add method to get all games
    public List<GameDto> getAllGames() {
        List<Game> games = gameRepository.findAll();
        List<GameDto> gameDtos = new ArrayList<>();
        for (Game game : games) {
            GameDto gameDto = convertToGameDto(game);
            gameDtos.add(gameDto);
        }
        return gameDtos;
    }

    // Add method to get game by gameID


    // Add method to add game


    // Add method to delete game


    // Add method to update game

    // Add method to convert GameInputDto to Game
    public Game convertToGame(GameInputDto gameInputDto) {

        Game game = new Game();

        game.setGameName(gameInputDto.getGameName());
        game.setGameReview(gameInputDto.getGameReview());
        game.setGameRating(gameInputDto.getGameRating());

        return game;
    }

    // Add method to convert Game to GameDto
    public GameDto convertToGameDto(Game game) {

        GameDto gameDto = new GameDto();

        gameDto.setGameID(game.getGameID());
        gameDto.setGameName(game.getGameName());
        gameDto.setGameReview(game.getGameReview());
        gameDto.setGameRating(game.getGameRating());

        return gameDto;
    }

}

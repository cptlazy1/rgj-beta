package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameDto;
import com.example.retrogamejock.dto.GameInputDto;
import com.example.retrogamejock.exception.RecordNotFoundException;
import com.example.retrogamejock.model.Game;
import com.example.retrogamejock.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public GameDto getGameByGameID(Long gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            return convertToGameDto(game);
        } else {
            throw new RecordNotFoundException("No game record exists for given gameID");
        }

    }

    // Add method to add game
    public GameDto addGame(GameInputDto gameInputDto) {
        Game game = convertToGame(gameInputDto);
        Game savedGame = gameRepository.save(game);
        return convertToGameDto(savedGame);
    }


    // Add method to delete game
    public void deleteGame(@RequestBody Long gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isPresent()) {
            gameRepository.deleteById(gameID);
        } else {
            throw new RecordNotFoundException("No game record exists for given gameID");
        }
    }


    // Add method to update game
    public GameDto updateGame(Long gameID, GameInputDto gameInputDto) {

        Optional<Game> gameOptional = gameRepository.findById(gameID);

        if (gameOptional.isPresent()) {

            Game game = gameOptional.get();

            game.setGameName(gameInputDto.getGameName());
            game.setGameReview(gameInputDto.getGameReview());
            game.setGameRating(gameInputDto.getGameRating());

            Game savedGame = gameRepository.save(game);

            return convertToGameDto(savedGame);

        } else {
            throw new RecordNotFoundException("No game record exists for given gameID");
        }
    }


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

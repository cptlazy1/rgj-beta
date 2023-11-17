package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameDto;
import com.example.retrogamejock.dto.GameInputDto;
import com.example.retrogamejock.exception.RecordNotFoundException;
import com.example.retrogamejock.model.Game;
import com.example.retrogamejock.model.GameCondition;
import com.example.retrogamejock.repository.GameConditionRepository;
import com.example.retrogamejock.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameConditionRepository gameConditionRepository;

    // Constructor
    public GameService(GameRepository gameRepository, GameConditionRepository gameConditionRepository) {
        this.gameRepository = gameRepository;
        this.gameConditionRepository = gameConditionRepository;
    }

    // Method to get all games
    public List<GameDto> getAllGames() {
        List<Game> games = gameRepository.findAll();
        List<GameDto> gameDtos = new ArrayList<>();
        for (Game game : games) {
            GameDto gameDto = convertToGameDto(game);
            gameDtos.add(gameDto);
        }
        return gameDtos;
    }

    // Method to get game by gameID
    public GameDto getGameByGameID(Long gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            return convertToGameDto(game);
        } else {
            throw new RecordNotFoundException("No game record exists for given gameID");
        }

    }

    // Method to add game
    public GameDto addGame(GameInputDto gameInputDto) {
        Game game = convertToGame(gameInputDto);
        Game savedGame = gameRepository.save(game);
        return convertToGameDto(savedGame);
    }


    // Method to delete game
    public void deleteGame(@RequestBody Long gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isPresent()) {
            gameRepository.deleteById(gameID);
        } else {
            throw new RecordNotFoundException("No game record exists for given gameID");
        }
    }

    // Method to update game
    public GameDto updateGame(Long gameID, GameInputDto gameInputDto) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);

        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();

            // Manually update non-null fields
            if (gameInputDto.getGameName() != null) {
                game.setGameName(gameInputDto.getGameName());
            }

            if (gameInputDto.getGameReview() != null) {
                game.setGameReview(gameInputDto.getGameReview());
            }

            if (gameInputDto.getGameRating() != null) {
                game.setGameRating(gameInputDto.getGameRating());
            }

            // Save the updated game
            Game savedGame = gameRepository.save(game);

            return convertToGameDto(savedGame);
        } else {
            throw new RecordNotFoundException("No game record exists for the given gameID");
        }
    }



    // Method to convert GameInputDto to Game using ModelMapper
    public Game convertToGame(GameInputDto gameInputDto) {

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(gameInputDto, Game.class);
    }


    // Method to convert GameInputDto to Game using ModelMapper
    public GameDto convertToGameDto(Game game) {

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(game, GameDto.class);
    }


    // Method to assign gameCondition to game
    @Transactional
    public void assignGameConditionToGame(Long gameID, Long gameConditionID) {

        Optional<Game> gameOptional = gameRepository.findById(gameID);
        Optional<GameCondition> gameConditionOptional = gameConditionRepository.findById(gameConditionID);

        if (gameOptional.isPresent() && gameConditionOptional.isPresent()) {

            Game game = gameOptional.get();
            GameCondition gameCondition = gameConditionOptional.get();

            game.setGameCondition(gameCondition);

            gameRepository.save(game);

        } else {
            throw new RecordNotFoundException("No game record exists for given gameID");
        }

    }

}

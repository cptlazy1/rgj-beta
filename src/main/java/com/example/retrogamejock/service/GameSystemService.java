package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameDto;
import com.example.retrogamejock.dto.GameInputDto;
import com.example.retrogamejock.dto.GameSystemDto;
import com.example.retrogamejock.dto.GameSystemInputDto;
import com.example.retrogamejock.exception.RecordNotFoundException;
import com.example.retrogamejock.model.Game;
import com.example.retrogamejock.model.GameSystem;
import com.example.retrogamejock.repository.GameSystemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameSystemService {
    private final GameSystemRepository gameSystemRepository;

    public GameSystemService(GameSystemRepository gameSystemRepository) {
        this.gameSystemRepository = gameSystemRepository;
    }

    // Method to get all game systems
    public List<GameSystemDto> getAllGameSystems() {
        List<GameSystem> gameSystems = gameSystemRepository.findAll();
        List<GameSystemDto> gameSystemDtos = new ArrayList<>();
        for (GameSystem gameSystem : gameSystems) {
            GameSystemDto gameSystemDto = convertToGameSystemDto(gameSystem);
            gameSystemDtos.add(gameSystemDto);
        }
        return gameSystemDtos;
    }

    // Method to get game system by gameSystemID
    public GameSystemDto getGameSystemByGameSystemID(Long gameSystemID) {
        Optional<GameSystem> gameSystemOptional = gameSystemRepository.findById(gameSystemID);
        if (gameSystemOptional.isPresent()) {
            GameSystem gameSystem = gameSystemOptional.get();
            return convertToGameSystemDto(gameSystem);
        } else {
            throw new RecordNotFoundException("No game system record exists for given gameSystemID");
        }

    }

    // Method to add game system
    public GameSystemDto addGameSystem(GameSystemInputDto gameSystemInputDto) {
        GameSystem gameSystem = convertToGameSystem(gameSystemInputDto);
        GameSystem savedGameSystem = gameSystemRepository.save(gameSystem);
        return convertToGameSystemDto(savedGameSystem);
    }

    // Method to delete a game system
    public void deleteGameSystem(@RequestBody Long gameSystemID) {
        Optional<GameSystem> gameSystemOptional = gameSystemRepository.findById(gameSystemID);
        if (gameSystemOptional.isPresent()) {
            gameSystemRepository.deleteById(gameSystemID);
        } else {
            throw new RecordNotFoundException("No game system record exists for given gameSystemID");
        }
    }

    // ModelMapper version of updateGameSystem
    public GameSystemDto updateGameSystem(Long gameSystemID, GameSystemInputDto gameSystemInputDto) {
        Optional<GameSystem> gameSystemOptional = gameSystemRepository.findById(gameSystemID);

        if (gameSystemOptional.isPresent()) {
            GameSystem gameSystem = gameSystemOptional.get();

            // Automatically update non-null fields
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(gameSystemInputDto, gameSystem);

            // Save the updated game
            GameSystem savedGameSystem = gameSystemRepository.save(gameSystem);

            return convertToGameSystemDto(savedGameSystem);
        } else {
            throw new RecordNotFoundException("No game record exists for the given gameID");
        }
    }


//    // Method to convert GameSystemInputDto to GameSystem
//    private GameSystem convertToGameSystem(GameSystemInputDto gameSystemInputDto) {
//
//        GameSystem gameSystem = new GameSystem();
//
//        gameSystem.setGameSystemName(gameSystemInputDto.getGameSystemName());
//        gameSystem.setGameSystemReview(gameSystemInputDto.getGameSystemReview());
//        gameSystem.setGameSystemRating(gameSystemInputDto.getGameSystemRating());
//
//        return gameSystem;
//    }


//    // Method to convert GameSystem to GameSystemDto
//    private GameSystemDto convertToGameSystemDto(GameSystem gameSystem) {
//
//        GameSystemDto gameSystemDto = new GameSystemDto();
//
//        gameSystemDto.setGameSystemID(gameSystem.getGameSystemID());
//        gameSystemDto.setGameSystemName(gameSystem.getGameSystemName());
//        gameSystemDto.setGameSystemReview(gameSystem.getGameSystemReview());
//        gameSystemDto.setGameSystemRating(gameSystem.getGameSystemRating());
//
//        return gameSystemDto;
//    }

    // Method to convert GameSystem to GameSystemDto using ModelMapper
    public GameSystemDto convertToGameSystemDto(GameSystem gameSystem) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(gameSystem, GameSystemDto.class);
    }

    // Method to convert GameSystemInputDto to GameSystem using ModelMapper
    public GameSystem convertToGameSystem(GameSystemInputDto gameSystemInputDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(gameSystemInputDto, GameSystem.class);
    }




}

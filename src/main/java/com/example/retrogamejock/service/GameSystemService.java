package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameSystemDto;
import com.example.retrogamejock.model.GameSystem;
import com.example.retrogamejock.repository.GameSystemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    // Method to convert GameSystemDto to GameSystem
    private GameSystem convertToGameSystem(GameSystemDto gameSystemDto) {

        GameSystem gameSystem = new GameSystem();

        gameSystem.setGameSystemID(gameSystemDto.getGameSystemID());
        gameSystem.setGameSystemName(gameSystemDto.getGameSystemName());
        gameSystem.setGameSystemReview(gameSystemDto.getGameSystemReview());
        gameSystem.setGameSystemRating(gameSystemDto.getGameSystemRating());

        return gameSystem;
    }


    // Method to convert GameSystem to GameSystemDto
    private GameSystemDto convertToGameSystemDto(GameSystem gameSystem) {

        GameSystemDto gameSystemDto = new GameSystemDto();

        gameSystemDto.setGameSystemID(gameSystem.getGameSystemID());
        gameSystemDto.setGameSystemName(gameSystem.getGameSystemName());
        gameSystemDto.setGameSystemReview(gameSystem.getGameSystemReview());
        gameSystemDto.setGameSystemRating(gameSystem.getGameSystemRating());

        return gameSystemDto;
    }

}

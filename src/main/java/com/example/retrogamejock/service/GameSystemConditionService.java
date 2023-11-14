package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameSystemConditionDto;
import com.example.retrogamejock.dto.GameSystemConditionInputDto;
import com.example.retrogamejock.model.GameSystem;
import com.example.retrogamejock.model.GameSystemCondition;
import com.example.retrogamejock.repository.GameSystemConditionRepository;
import com.example.retrogamejock.repository.GameSystemRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameSystemConditionService {

    private final GameSystemRepository gameSystemRepository;
    private final GameSystemConditionRepository gameSystemConditionRepository;


    // Constructor
    public GameSystemConditionService(GameSystemRepository gameSystemRepository, GameSystemConditionRepository gameSystemConditionRepository) {
        this.gameSystemRepository = gameSystemRepository;
        this.gameSystemConditionRepository = gameSystemConditionRepository;
    }

    // Method to get all game system conditions
    public List<GameSystemConditionDto> getAllGameSystemConditions() {
        List<GameSystemCondition> gameSystemConditions = gameSystemConditionRepository.findAll();
        List<GameSystemConditionDto> gameSystemConditionDtos = new ArrayList<>();
        for (GameSystemCondition gameSystemCondition : gameSystemConditions) {
            GameSystemConditionDto gameSystemConditionDto = convertToGameSystemConditionDto(gameSystemCondition);
            gameSystemConditionDtos.add(gameSystemConditionDto);
        }
        return gameSystemConditionDtos;
    }

    // Method to add game system condition
    public GameSystemConditionDto addGameSystemCondition(GameSystemConditionInputDto gameSystemConditionInputDto) {
        GameSystemCondition gameSystemCondition = convertToGameSystemCondition(gameSystemConditionInputDto);
        GameSystemCondition savedGameSystemCondition = gameSystemConditionRepository.save(gameSystemCondition);
        return convertToGameSystemConditionDto(savedGameSystemCondition);
    }

    // Method to convert GameSystemConditionInputDto to GameSystemCondition
    public GameSystemCondition convertToGameSystemCondition(GameSystemConditionInputDto gameSystemConditionInputDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(gameSystemConditionInputDto, GameSystemCondition.class);
    }


    // Method to convert GameSystemCondition to GameSystemConditionDto
    public GameSystemConditionDto convertToGameSystemConditionDto(GameSystemCondition gameSystemCondition) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(gameSystemCondition, GameSystemConditionDto.class);
    }

    // Method to update game system condition
    public GameSystemConditionDto updateGameSystemCondition(GameSystemConditionInputDto gameSystemConditionInputDto, Long gameSystemConditionID) {
        Optional<GameSystemCondition> gameSystemConditionOptional = gameSystemConditionRepository.findById(gameSystemConditionID);

        if (gameSystemConditionOptional.isPresent()) {
            GameSystemCondition gameSystemCondition = gameSystemConditionOptional.get();

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(gameSystemConditionInputDto, gameSystemCondition);

            GameSystemCondition savedGameSystemCondition = gameSystemConditionRepository.save(gameSystemCondition);

            return convertToGameSystemConditionDto(savedGameSystemCondition);

        } else {
            throw new RuntimeException("Game system condition not found");

        }
    }

    // Method to assign game system condition to game system
    @Transactional
    public void assignGameSystemConditionToGameSystem(Long gameSystemConditionID, Long gameSystemID) {

        Optional<GameSystem> gameSystemOptional = gameSystemRepository.findById(gameSystemID);
        Optional<GameSystemCondition> gameSystemConditionOptional = gameSystemConditionRepository.findById(gameSystemConditionID);

        if (gameSystemOptional.isPresent() && gameSystemConditionOptional.isPresent()) {

            GameSystem gameSystem = gameSystemOptional.get();
            GameSystemCondition gameSystemCondition = gameSystemConditionOptional.get();

            gameSystem.setGameSystemCondition(gameSystemCondition);

            gameSystemRepository.save(gameSystem);
        } else {
            throw new RuntimeException("Game system or game system condition not found");
        }
    }


}

package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameConditionDto;
import com.example.retrogamejock.dto.GameConditionInputDto;
import com.example.retrogamejock.exception.RecordNotFoundException;
import com.example.retrogamejock.model.Game;
import com.example.retrogamejock.model.GameCondition;
import com.example.retrogamejock.repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.retrogamejock.repository.GameConditionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameConditionService {

    private final GameConditionRepository gameConditionRepository;
    private final GameRepository gameRepository;

    // Constructor to inject GameConditionRepository
    public GameConditionService(GameConditionRepository gameConditionRepository, GameRepository gameRepository) {
        this.gameConditionRepository = gameConditionRepository;
        this.gameRepository = gameRepository;
    }

    // Method to get all gameConditions
    public List<GameConditionDto> getAllGameConditions() {
        List<GameCondition> gameConditions = gameConditionRepository.findAll();
        List<GameConditionDto> gameConditionDtos = new ArrayList<>();
        for (GameCondition gameCondition : gameConditions) {
            GameConditionDto gameConditionDto = convertToGameConditionDto(gameCondition);
            gameConditionDtos.add(gameConditionDto);
        }
        return gameConditionDtos;

    }

    // Method with ModelMapper to convert GameConditionInputDto to GameCondition
    public GameCondition convertToGameCondition(GameConditionInputDto gameConditionInputDto) {
        ModelMapper modelMapper = new ModelMapper();
        GameCondition gameCondition = modelMapper.map(gameConditionInputDto, GameCondition.class);
        return gameCondition;
    }

    // Method with ModelMapper to convert GameCondition to GameConditionDto
    public GameConditionDto convertToGameConditionDto(GameCondition gameCondition) {
        ModelMapper modelMapper = new ModelMapper();
        GameConditionDto gameConditionDto = modelMapper.map(gameCondition, GameConditionDto.class);
        return gameConditionDto;
    }

    // Method to add gameCondition
    public GameConditionDto addGameCondition(GameConditionInputDto gameConditionInputDto) {
        GameCondition gameCondition = convertToGameCondition(gameConditionInputDto);
        GameCondition savedGameCondition = gameConditionRepository.save(gameCondition);
        return convertToGameConditionDto(savedGameCondition);
    }

    // Method to update gameCondition using ModelMapper
    public GameConditionDto updateGameCondition(Long gameConditionID, GameConditionInputDto gameConditionInputDto ) {
        Optional<GameCondition> gameConditionOptional = gameConditionRepository.findById(gameConditionID);

        if (gameConditionOptional.isPresent()) {
            GameCondition gameCondition = gameConditionOptional.get();

            if (gameConditionInputDto.getCompleteInBox() != null) {
                gameCondition.setCompleteInBox(gameConditionInputDto.getCompleteInBox());
            }
            if (gameConditionInputDto.getHasManual() != null) {
                gameCondition.setHasManual(gameConditionInputDto.getHasManual());
            }
            if (gameConditionInputDto.getHasCase() != null) {
                gameCondition.setHasCase(gameConditionInputDto.getHasCase());
            }

            GameCondition savedGameCondition = gameConditionRepository.save(gameCondition);

            return convertToGameConditionDto(savedGameCondition);

        } else {
            throw new RecordNotFoundException("No gameCondition record exists for given gameConditionID");
        }
    }

}

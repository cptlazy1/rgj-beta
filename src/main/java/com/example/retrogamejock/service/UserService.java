package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.GameDto;
import com.example.retrogamejock.dto.GameSystemDto;
import com.example.retrogamejock.dto.UserDto;
import com.example.retrogamejock.dto.UserInputDto;
import com.example.retrogamejock.exception.RecordNotFoundException;
import com.example.retrogamejock.model.Game;
import com.example.retrogamejock.model.GameSystem;
import com.example.retrogamejock.model.User;
import com.example.retrogamejock.repository.GameRepository;
import com.example.retrogamejock.repository.GameSystemRepository;
import com.example.retrogamejock.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final GameSystemRepository gameSystemRepository;
    private final GameService gameService;
    private final GameSystemService gameSystemService;

    // Constructor
    public UserService(
            UserRepository userRepository,
            GameRepository gameRepository,
            GameSystemRepository gameSystemRepository,
            GameService gameService,
            GameSystemService gameSystemService) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.gameSystemRepository = gameSystemRepository;
        this.gameService = gameService;
        this.gameSystemService = gameSystemService;
    }

    // Method to get all users
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new RecordNotFoundException("No users found");
        } else {
            List<UserDto> userDtos = new ArrayList<>();
            for (User user : users) {
                UserDto userDto = convertToUserDto(user);
                userDtos.add(userDto);
            }
            return userDtos;
        }
    }


    // Method to get user by userName
    public UserInputDto getUserByUserName(String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
//            return convertToUserDto(user);
            return convertToUserInputDto(user);
        } else {
            throw new RecordNotFoundException("No user record exists for given userName");
        }

    }


    // Method to get user's games by userName
    public List<GameDto> getUserGamesByUserName(String userName) {

        Optional<User> userOptional = userRepository.findByUserName(userName);

        if (userOptional.isPresent()) {
            List<GameDto> gameDtos = new ArrayList<>();
            for (Game game : userOptional.get().getGames()) {
                GameDto gameDto = gameService.convertToGameDto(game);
                gameDtos.add(gameDto);
            }

            return gameDtos;
        } else {
            throw new RecordNotFoundException("No user record exists for given userName");
        }
    }


    // Method to get user's game systems by userName
    public List<GameSystemDto> getUserGameSystemsByUserName(String userName) {

        Optional<User> userOptional = userRepository.findByUserName(userName);

        if (userOptional.isPresent()) {
            List<GameSystemDto> gameSystemDtos = new ArrayList<>();
            for (GameSystem gameSystem : userOptional.get().getGameSystems()) {
                GameSystemDto gameDto = gameSystemService.convertToGameSystemDto(gameSystem);
                gameSystemDtos.add(gameDto);
            }

            return gameSystemDtos;
        } else {
            throw new RecordNotFoundException("No user record exists for given userName");
        }
    }


    // Method to add user
    public UserDto addUser(UserInputDto userInputDto) {

        User user = convertToUser(userInputDto);
        User savedUser = userRepository.save(user);

        return convertToUserDto(savedUser);

    }


    // Method to delete a user with userName
    public void deleteUser(@RequestBody String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            userRepository.deleteByUserName(userName);
        } else {
            throw new RecordNotFoundException("No user record exists for given userName");
        }
    }

    // Method to update a user
    public UserDto updateUser(String username, UserInputDto userInputDto) {

        Optional<User> userOptional = userRepository.findByUserName(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (userInputDto.getUserName() != null) {
                user.setUserName(userInputDto.getUserName());
            }
            if (userInputDto.getPassword() != null) {
                user.setPassword(userInputDto.getPassword());
            }
            if (userInputDto.getEmail() != null) {
                user.setEmail(userInputDto.getEmail());
            }
            if (userInputDto.getProfilePrivate() != null) {
                user.setProfilePrivate(userInputDto.getProfilePrivate());
            }

            User savedUser = userRepository.save(user);

            return convertToUserDto(savedUser);
        } else {
            throw new RecordNotFoundException("No user record exists for the given userID");
        }
    }


    // Method to convert UserInputDto to User using ModelMapper
    public User convertToUser(UserInputDto userInputDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userInputDto, User.class);
    }


    // Method to convert User to UserDto using ModelMapper
    public UserDto convertToUserDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDto.class);
    }


    // Method to convert UserInputDto to UserDto using ModelMapper
    public UserInputDto convertToUserInputDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserInputDto.class);
    }


    // Method to assign a game to a user
    // This method works, but it is not ideal.
    // It is not ideal because it is overwriting the existing game.
    // TODO: Fix this method so it doesn't overwrite the existing game or user
    @Transactional
    public void assignGameToUser(String username, Long gameID) {

        Optional<User> userOptional = userRepository.findByUserName(username);
        Optional<Game> gameOptional = gameRepository.findById(gameID);

        if (userOptional.isPresent() && gameOptional.isPresent()) {

            User user = userOptional.get();
            Game game = gameOptional.get();

            user.getGames().add(game);

            game.setUser(user);
            userRepository.save(user);

        } else {
            throw new RecordNotFoundException("No user or game record exists for given IDs");
        }
    }

    // Method to assign a game system to a user
    // TODO: Fix this method so it doesn't overwrite the existing game system or user
    @Transactional
    public void assignGameSystemToUser(String username, Long gameSystemID) {

        Optional<User> userOptional = userRepository.findByUserName(username);
        Optional<GameSystem> gameSystemOptional = gameSystemRepository.findById(gameSystemID);

        if (userOptional.isPresent() && gameSystemOptional.isPresent()) {

            User user = userOptional.get();
            GameSystem gameSystem = gameSystemOptional.get();

            user.getGameSystems().add(gameSystem);
            gameSystem.setUser(user);

            userRepository.save(user);

        } else {
            throw new RecordNotFoundException("No user or game system record exists for given IDs");
        }
    }

}
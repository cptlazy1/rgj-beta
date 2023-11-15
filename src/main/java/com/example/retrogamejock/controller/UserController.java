package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameDto;
import com.example.retrogamejock.dto.GameSystemDto;
import com.example.retrogamejock.dto.UserDto;
import com.example.retrogamejock.dto.UserInputDto;
import com.example.retrogamejock.model.Game;
import com.example.retrogamejock.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GetMapping to get all users
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    // GetMapping to get user by userID
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserByUserID(@PathVariable("id") Long userID) {
        UserDto userDto = userService.getUserByUserID(userID);
        return ResponseEntity.ok(userDto);
    }



    // GetMapping to get users games by userID
    @GetMapping("/users/{id}/games")
    public ResponseEntity<List<GameDto>> getUsersGamesByUserID(@PathVariable("id") Long userID) {
        List<GameDto> gameDTOs = userService.getUserGamesByUserID(userID);
        return new ResponseEntity<>(gameDTOs, HttpStatus.OK);
    }

    // GetMapping to get users game systems by userID
    @GetMapping("/users/{id}/game-systems")
    public ResponseEntity<List<GameSystemDto>> getUsersGameSystemsByUserID(@PathVariable("id") Long userID) {
        List<GameSystemDto> gameSytemDtos = userService.getUserGameSystemsByUserID(userID);
        return new ResponseEntity<>(gameSytemDtos, HttpStatus.OK);
    }


    // PostMapping to add user
    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserInputDto userInputDto) {
        UserDto userDto = userService.addUser(userInputDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/users/{id}")
                .buildAndExpand(userDto.getUserID())
                .toUriString());

        return ResponseEntity.created(uri).body(userDto);
    }

    // DeleteMapping to delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userID) {
        userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }

    // PutMapping to update user
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userID, @Valid @RequestBody UserInputDto userInputDto) {
        UserDto userDto = userService.updateUser(userID, userInputDto);
        return ResponseEntity.ok().body(userDto);
    }

    // PutMapping to assign game to user
    @PutMapping("/users/{userID}/games/{gameID}")
    public ResponseEntity<Object> assignGameToUser(@PathVariable("userID") Long userID, @PathVariable("gameID") Long gameID) {
        userService.assignGameToUser(userID, gameID);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/users/{userID}/games/{gameID}")
                .buildAndExpand(userID, gameID)
                .toUriString());


//        return ResponseEntity.created(uri).body("Game with the " + gameID + " ID has been assigned to user with the " + userID + " ID.");
        return ResponseEntity.noContent().location(uri).build();
    }

    // PutMapping to assign game system to user
    @PutMapping("/users/{userID}/game-systems/{gameSystemID}")
    public ResponseEntity<String> assignGameSystemToUser(@PathVariable("userID") Long userID, @PathVariable("gameSystemID") Long gameSystemID) {
        userService.assignGameSystemToUser(userID, gameSystemID);
        return ResponseEntity.ok().body("Game system with the " + gameSystemID + " ID has been assigned to user with the " + userID + " ID.");
    }

}

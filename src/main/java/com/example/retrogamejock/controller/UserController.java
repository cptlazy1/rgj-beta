package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.GameDto;
import com.example.retrogamejock.dto.GameSystemDto;
import com.example.retrogamejock.dto.UserDto;
import com.example.retrogamejock.dto.UserInputDto;
import com.example.retrogamejock.service.UserService;
import jakarta.validation.*;
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


    // GetMapping to get user by username
    @GetMapping("/users/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable("username") String username) {
        UserDto userDto = userService.getUserByUserName(username);
        return ResponseEntity.ok(userDto);
    }

    // GetMapping to get users games by userID
    @GetMapping("/users/{username}/games")
    public ResponseEntity<List<GameDto>> getUsersGamesByUserID(@PathVariable("username") String username) {
        List<GameDto> gameDTOs = userService.getUserGamesByUserName(username);
        return new ResponseEntity<>(gameDTOs, HttpStatus.OK);
    }

    // GetMapping to get users game systems by userID
    @GetMapping("/users/{username}/game-systems")
    public ResponseEntity<List<GameSystemDto>> getUsersGameSystemsByUserID(@PathVariable("username") String username) {
        List<GameSystemDto> gameSytemDtos = userService.getUserGameSystemsByUserName(username);
        return new ResponseEntity<>(gameSytemDtos, HttpStatus.OK);
    }


    // PostMapping to add user
    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody UserInputDto userInputDto) {

        UserDto userDto = userService.addUser(userInputDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/users/{username}")
                .buildAndExpand(userDto.getUserName())
                .toUriString());

        return ResponseEntity.created(uri).body(userDto);
    }

    // DeleteMapping to delete user
    @DeleteMapping("/users/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    // PutMapping to update user
    @PutMapping("/users/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @Valid @RequestBody UserInputDto userInputDto) {

        UserDto userDto = userService.updateUser(username, userInputDto);
        return ResponseEntity.ok().body(userDto);
    }


    // PutMapping to assign game to user
    @PutMapping("/users/{username}/games/{gameID}")
    public ResponseEntity<Object> assignGameToUser(@PathVariable("username") String username, @PathVariable("gameID") Long gameID) {
        userService.assignGameToUser(username, gameID);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/users/{userID}/games/{gameID}")
                .buildAndExpand(username, gameID)
                .toUriString());

        return ResponseEntity.noContent().location(uri).build();
    }

    // PutMapping to assign game system to user
    @PutMapping("/users/{username}/game-systems/{gameSystemID}")
    public ResponseEntity<String> assignGameSystemToUser(@PathVariable("username") String username, @PathVariable("gameSystemID") Long gameSystemID) {
        userService.assignGameSystemToUser(username, gameSystemID);
        return ResponseEntity.ok().body("Game system with the " + gameSystemID + " ID has been assigned to user with the " + username + " ID.");
    }

}
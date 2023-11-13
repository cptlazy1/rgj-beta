package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.UserDto;
import com.example.retrogamejock.dto.UserInputDto;
import com.example.retrogamejock.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // PostMapping to add user
    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserInputDto userInputDto) {
        UserDto userDto = userService.addUser(userInputDto);
        return ResponseEntity.created(null).body(userDto);
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
    public ResponseEntity<String> assignGameToUser(@PathVariable("userID") Long userID, @PathVariable("gameID") Long gameID) {
        UserDto userDto = userService.assignGameToUser(userID, gameID);
        return ResponseEntity.ok().body("Game with the " + gameID + " ID has been assigned to user with the " + userID + " ID.");
    }

    // PutMapping to assign game system to user
    @PutMapping("/users/{userID}/game-systems/{gameSystemID}")
    public ResponseEntity<String> assignGameSystemToUser(@PathVariable("userID") Long userID, @PathVariable("gameSystemID") Long gameSystemID) {
        UserDto userDto = userService.assignGameSystemToUser(userID, gameSystemID);
        return ResponseEntity.ok().body("Game system with the " + gameSystemID + " ID has been assigned to user with the " + userID + " ID.");
    }

}

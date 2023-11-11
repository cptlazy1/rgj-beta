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
    @GetMapping("/users/{userID}")
    public ResponseEntity<UserDto> getUserByUserID(@PathVariable("userID") Long userID) {
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
    @DeleteMapping("/users/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userID") Long userID) {
        userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }

}

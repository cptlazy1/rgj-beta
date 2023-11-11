package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.UserDto;
import com.example.retrogamejock.dto.UserInputDto;
import com.example.retrogamejock.exception.RecordNotFoundException;
import com.example.retrogamejock.model.User;
import com.example.retrogamejock.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Method to get all users
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = convertToUserDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }
    // Method to get user by userID
    public UserDto getUserByUserID(Long userID) {
        Optional<User> userOptional = userRepository.findById(userID);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return convertToUserDto(user);
        } else {
            throw new RecordNotFoundException("No user record exists for given userID");
        }

    }
    // Method to add user
    public UserDto addUser(UserInputDto userInputDto) {
        User user = convertToUser(userInputDto);
        User savedUser = userRepository.save(user);
        return convertToUserDto(savedUser);
    }

    // Method to convert UserInputDto to User
    public User convertToUser(UserInputDto userInputDto) {

        User user = new User();

        user.setUserName(userInputDto.getUserName());
        user.setPassword(userInputDto.getPassword());
        user.setEmail(userInputDto.getEmail());
        user.setProfileIsPrivate(userInputDto.isProfileIsPrivate());

        return user;
    }

    // Method to convert User to UserDto
    public UserDto convertToUserDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setUserID(user.getUserID());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setProfileIsPrivate(user.isProfileIsPrivate());

        return userDto;
    }
}

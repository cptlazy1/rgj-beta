package com.example.retrogamejock.service;

import com.example.retrogamejock.dto.UserDto;
import com.example.retrogamejock.dto.UserInputDto;
import com.example.retrogamejock.model.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        UserDto userDto = userService.getUserByUserName(username);
//        String password = userDto.getPassword();
//        Set<Role> roles = userDto.getRoles();
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Role role : roles) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
//        }
//        return new User(username, password, grantedAuthorities);
//    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserInputDto userInputDto = userService.getUserByUserName(username);
        String password = userInputDto.getPassword();
        Set<Role> roles = userInputDto.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(username, password, grantedAuthorities);
    }

}

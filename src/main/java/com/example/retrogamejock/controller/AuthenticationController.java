package com.example.retrogamejock.controller;

import com.example.retrogamejock.dto.AuthenticationRequest;
import com.example.retrogamejock.dto.AuthenticationResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.retrogamejock.service.CustomUserDetailsService;
import com.example.retrogamejock.utility.JwtUtility;
import java.security.Principal;


@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtility jwtUtility;

    public AuthenticationController(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JwtUtility jwtUtility) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtility = jwtUtility;
    }

    // This method returns the principal (basic user data) of the logged-in user
    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        return ResponseEntity.ok().body(principal);
    }


    // Robert-Jan solution
    // This method returns the JWT token when the user enters the correct login details.
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        UsernamePasswordAuthenticationToken up = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        try {
            Authentication auth = authenticationManager.authenticate(up);
            UserDetails ud = (UserDetails) auth.getPrincipal();
            String token = jwtUtility.generateToken(ud);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .body("Token generated");
        }
        catch (AuthenticationException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }




    // Homework solution
    // This method returns the JWT token when the user enters the correct login details.
//    @PostMapping(value = "/authenticate")
//    public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//
//        String username = authenticationRequest.getUsername();
//        String password = authenticationRequest.getPassword();
//
//            try {
//                authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(username, password));
//            }
//            catch (BadCredentialsException ex) {
//                throw new Exception("Incorrect username or password", ex);
//            }
//
//            final UserDetails userDetails = userDetailsService
//                    .loadUserByUsername(username);
//
//            final String jwt = jwtUtility.generateToken(userDetails);
//
//            return ResponseEntity.ok(new AuthenticationResponse(jwt));
//
//    }



}

package com.example.retrogamejock.configuration;

import com.example.retrogamejock.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfiguration(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(customUserDetailsService);
        return new ProviderManager(auth);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults()).authorizeHttpRequests(
                auth -> auth
                        .requestMatchers(HttpMethod.GET,
                                "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,
                                "/games/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,
                                "/game-systems/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,
                                "/users").permitAll()
                        .requestMatchers(HttpMethod.POST,
                                "/games/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,
                                "/game-systems/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT,
                                "/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT,
                                "/games/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT,
                                "/game-systems/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT,
                                "/users/**").hasRole("USER")
                        .anyRequest().denyAll())
                        .sessionManagement(session -> session
                                .sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}

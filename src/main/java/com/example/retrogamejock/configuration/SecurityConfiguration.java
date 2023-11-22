package com.example.retrogamejock.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // TODO: login needs to be implemented instead hardcoding users and admin
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder
                        .encode("password")).roles("USER").build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder
                        .encode("admin")).roles("USER", "ADMIN").build();
        manager.createUser(user);
        manager.createUser(admin);
        return manager;
    }

//    @Bean
//    public AuthenticationManager authenticationManager() {
//
//    }
//
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

package com.example.retrogamejock.repository;

import com.example.retrogamejock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserName(String userName);

    void deleteByUserName(String userName);
}

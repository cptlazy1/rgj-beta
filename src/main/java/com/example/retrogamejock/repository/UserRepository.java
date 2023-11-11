package com.example.retrogamejock.repository;

import com.example.retrogamejock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllUsersByUserID(Long userID);
}

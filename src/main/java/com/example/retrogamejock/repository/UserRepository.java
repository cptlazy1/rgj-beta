package com.example.retrogamejock.repository;

import com.example.retrogamejock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}

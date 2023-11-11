package com.example.retrogamejock.repository;

import com.example.retrogamejock.model.GameSystem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameSystemRepository extends JpaRepository<GameSystem, Long> {

}

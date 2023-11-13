package com.example.retrogamejock.repository;

import com.example.retrogamejock.model.GameCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameConditionRepository extends JpaRepository<GameCondition, Long> {
}

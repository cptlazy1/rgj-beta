package com.example.retrogamejock.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "game_conditions")
public class GameCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameConditionID;
    private boolean isCompleteInBox;
    private boolean hasManual;
    private boolean hasCase;


    @OneToOne
    private Game game;


    // Getters and setters
    public Long getGameConditionID() {
        return gameConditionID;
    }

    public void setGameConditionID(Long gameConditionID) {
        this.gameConditionID = gameConditionID;
    }

    public boolean isCompleteInBox() {
        return isCompleteInBox;
    }

    public void setCompleteInBox(boolean completeInBox) {
        isCompleteInBox = completeInBox;
    }

    public boolean isHasManual() {
        return hasManual;
    }

    public void setHasManual(boolean hasManual) {
        this.hasManual = hasManual;
    }

    public boolean isHasCase() {
        return hasCase;
    }

    public void setHasCase(boolean hasCase) {
        this.hasCase = hasCase;
    }

    public void setGameCondition(Game game) {
    }
}

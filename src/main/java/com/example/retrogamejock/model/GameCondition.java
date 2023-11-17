package com.example.retrogamejock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game_conditions")
public class GameCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_condition_id")
    private Long gameConditionID;
    private String completeInBox;
    private String hasManual;
    private String hasCase;


    @OneToOne(mappedBy = "gameCondition")
    private Game game;

    // Getters and setters

    public Long getGameConditionID() {
        return gameConditionID;
    }

    public void setGameConditionID(Long gameConditionID) {
        this.gameConditionID = gameConditionID;
    }

    public String getCompleteInBox() {
        return completeInBox;
    }

    public void setCompleteInBox(String completeInBox) {
        this.completeInBox = completeInBox;
    }

    public String getHasManual() {
        return hasManual;
    }

    public void setHasManual(String hasManual) {
        this.hasManual = hasManual;
    }

    public String getHasCase() {
        return hasCase;
    }

    public void setHasCase(String hasCase) {
        this.hasCase = hasCase;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

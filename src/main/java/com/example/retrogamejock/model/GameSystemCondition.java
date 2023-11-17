package com.example.retrogamejock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game_system_conditions")
public class GameSystemCondition {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "game_system_condition_id")
    private Long gameSystemConditionID;
    private String box;
    private String cables;
    private String modified;

    @OneToOne(mappedBy = "gameSystemCondition")
    private GameSystem gameSystem;

    // Default constructor
    public GameSystemCondition() {
    }

    // Constructor with all fields
    public GameSystemCondition(Long gameSystemConditionID, String box, String cables, String modified) {
        this.gameSystemConditionID = gameSystemConditionID;
        this.box = box;
        this.cables = cables;
        this.modified = modified;
    }

    // Getters and setters

    public Long getGameSystemConditionID() {
        return gameSystemConditionID;
    }

    public void setGameSystemConditionID(Long gameSystemConditionID) {
        this.gameSystemConditionID = gameSystemConditionID;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getCables() {
        return cables;
    }

    public void setCables(String cables) {
        this.cables = cables;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public GameSystem getGameSystem() {
        return gameSystem;
    }

    public void setGameSystem(GameSystem gameSystem) {
        this.gameSystem = gameSystem;
    }
}

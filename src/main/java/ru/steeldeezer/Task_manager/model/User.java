package ru.steeldeezer.Task_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    private String name;

    public User(){}
    public User(String name){
        this.name = name;
        this.id = UUID.randomUUID();
    }
    public User(String name, UUID uuid){
        this.name = name;
        this.id = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID geId() {
        return id;
    }
}

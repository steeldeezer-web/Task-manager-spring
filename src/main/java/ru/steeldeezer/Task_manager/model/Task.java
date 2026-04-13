package ru.steeldeezer.Task_manager.model;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    private  UUID id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Task(){}
    public Task(User user, String title, String description){
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
        this.user = user;
    }
    public Task(UUID id, String title, String description, Status status, User user){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.user = user;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

package ru.steeldeezer.Task_manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldeezer.Task_manager.TaskService.TaskService;
import ru.steeldeezer.Task_manager.model.User;

@RestController
@RequestMapping("/users")
public class UserControl {
    private final TaskService taskService;

    public UserControl(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping("/create")
    public User createUser(@RequestParam String name){
        return taskService.createUser(name);
    }
}

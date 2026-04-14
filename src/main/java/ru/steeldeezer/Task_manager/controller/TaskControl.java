package ru.steeldeezer.Task_manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldeezer.Task_manager.TaskService.TaskService;
import ru.steeldeezer.Task_manager.model.Task;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")

public class TaskControl {
    private final TaskService taskService;

    public TaskControl(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping("/create")
    public Task createTask(
            @RequestParam UUID userId,
            @RequestParam String title,
            @RequestParam String description){
        return taskService.createTask(userId, title,description);
    }
}

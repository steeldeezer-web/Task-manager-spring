package ru.steeldeezer.Task_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.steeldeezer.Task_manager.TaskService.TaskService;

import java.util.UUID;

@Controller
public class WebController {
    private final TaskService taskService;
    public WebController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name){
        taskService.createUser(name);
        return "redirect:/";
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users", taskService.getAllUsers());
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }
    @PostMapping("/tasks/add")
    public String addTask(@RequestParam UUID userId,
                          @RequestParam String title,
                          @RequestParam String description){
        taskService.createTask(userId,title,description);
        return "redirect:/";

    }
}

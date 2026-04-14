package ru.steeldeezer.Task_manager.TaskService;

import org.springframework.stereotype.Service;
import ru.steeldeezer.Task_manager.exception.UserNotFoundException;
import ru.steeldeezer.Task_manager.model.Task;
import ru.steeldeezer.Task_manager.model.User;
import ru.steeldeezer.Task_manager.repository.TaskRepository;
import ru.steeldeezer.Task_manager.repository.UserRepository;

import java.util.List;
import java.util.UUID;
@Service
public class TaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public TaskService(UserRepository userRepository, TaskRepository taskRepository){
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public User createUser(String name){
       User user = new User(name);
       return userRepository.save(user);
    }
    //потокобезопасное создание таска
    public Task createTask(UUID userId,String title, String description){
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Заголовок задачи не может быть пустым!");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() ->new UserNotFoundException("Пользователь с ID " + userId + " не найден"));
        Task task = new Task(user, title, description);
        return taskRepository.save(task);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

}

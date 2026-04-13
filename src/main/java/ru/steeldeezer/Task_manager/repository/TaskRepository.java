package ru.steeldeezer.Task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.steeldeezer.Task_manager.model.Task;
import ru.steeldeezer.Task_manager.model.User;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID>  {
}

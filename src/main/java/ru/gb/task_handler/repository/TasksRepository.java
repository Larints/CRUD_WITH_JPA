package ru.gb.task_handler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.task_handler.model.Task;
import ru.gb.task_handler.model.TaskStatus;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {


    List<Task> getTaskByStatus(TaskStatus status);

}

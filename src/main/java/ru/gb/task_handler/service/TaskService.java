package ru.gb.task_handler.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.task_handler.model.Task;
import ru.gb.task_handler.model.TaskStatus;
import ru.gb.task_handler.repository.TasksRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class TaskService {

    private final TasksRepository repository;

    private final AtomicLong count = new AtomicLong();

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(String description) {
        Task task = new Task();
        task.setId(count.incrementAndGet());
        task.setDescription(description);
        task.setStatus(TaskStatus.NOT_STARTED);
        task.setDateOfCreation(LocalDateTime.now());
        return repository.save(task);
    }

    public List<Task> getTaskByStatus(TaskStatus status) {
        return repository.getTaskByStatus(status);
    }

    public Task updateTaskStatus(Long id, TaskStatus taskStatus) {
        Task task = repository.findById(id).orElse(null);
        assert task != null;
        task.setStatus(taskStatus);
        repository.save(task);
        return task;
    }

    public void removeTask(Long id) {
        Task task = repository.findById(id).orElse(null);
        assert task != null;
        repository.delete(task);
    }
}

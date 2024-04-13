package ru.gb.task_handler.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.task_handler.model.Task;
import ru.gb.task_handler.model.TaskStatus;
import ru.gb.task_handler.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class Controller {

    private final TaskService service;

    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @PostMapping("/add-task")
    public Task addTask(@RequestParam String description) {
        return service.addTask(description);
    }

    @GetMapping("status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return service.getTaskByStatus(status);
    }

    @PutMapping("update-task/{id}/{status}")
    public Task updateTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status) {
        return service.updateTaskStatus(id, status);
    }

    @DeleteMapping("delete-task/{id}")
    public String deleteTaskById(@PathVariable Long id) {
        service.removeTask(id);
        return "Task deleted";
    }

}

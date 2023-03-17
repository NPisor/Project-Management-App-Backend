package com.pmservice.basePackage.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pmservice.basePackage.models.Task.Task;
import com.pmservice.basePackage.services.TaskService;

@RestController
public class TasksController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public Optional<Collection<Task>> getAllTasks() throws Exception {
        return taskService.findAll();
    }

    @GetMapping("/task/id")
    public Optional<Task> getTaskById(Long id) throws Exception {
        return taskService.findById(id);
    }

    @GetMapping("/task/clientId")
    public Optional<Collection<Task>> getTasksByClientId(Long clientId) throws Exception {
        return taskService.findAllByClientId(clientId);
    }

    @GetMapping("/task/assigneeId")
    public Optional<Collection<Task>> getTasksByAssigneeId(Long assigneeId) throws Exception {
        return taskService.findAllByAssigneeId(assigneeId);
    }

    @GetMapping("/task/priority")
    public Optional<Collection<Task>> getTasksByPriority(Long priority) throws Exception {
        return taskService.findAllByPriority(priority);
    }

    @GetMapping("/task/assignerId")
    public Optional<Collection<Task>> getTaskByAssignerId(Long assignerId) throws Exception {
        return taskService.findAllByAssignerId(assignerId);
    }

    @GetMapping("/task/clientstatus")
    public Optional<Collection<Task>> getTaskByClientIdAndStatus(Long id, Long status) throws Exception {
        return taskService.findAllByClientIdAndStatus(id, status);
    }

}

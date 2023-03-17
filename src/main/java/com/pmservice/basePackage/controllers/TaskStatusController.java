package com.pmservice.basePackage.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Status.TaskStatus;
import com.pmservice.basePackage.services.TaskStatusService;

@RestController
public class TaskStatusController {

    @Autowired
    TaskStatusService taskStatusService;

    @GetMapping("/task/status")
    public Optional<Collection<TaskStatus>> getAllTaskStatuses() throws Exception {
        return taskStatusService.findAll();
    }

    @GetMapping("/task/status/id")
    public Optional<TaskStatus> getTaskStatusById(Long id) throws Exception {
        return taskStatusService.findById(id);
    }
}

package com.pmservice.basePackage.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Status.TaskStatus;
import com.pmservice.basePackage.services.TaskStatusService;

@RestController
@CrossOrigin(origins = "*")
public class TaskStatusController {

    @Autowired
    TaskStatusService taskStatusService;

    @GetMapping("/task/status")
    public Collection<TaskStatus> getAllTaskStatuses() throws Exception {
        return taskStatusService.findAll();
    }

    @GetMapping("/task/status/id")
    public TaskStatus getTaskStatusById(@RequestParam Long id) throws Exception {
        return taskStatusService.findById(id);
    }
}

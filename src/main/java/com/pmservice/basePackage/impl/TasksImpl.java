package com.pmservice.basePackage.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Task.Task;
import com.pmservice.basePackage.repos.TaskRepo;
import com.pmservice.basePackage.repos.TaskStatusRepo;
import com.pmservice.basePackage.services.TaskService;

@Component
public class TasksImpl implements TaskService{

    @Autowired
    TaskRepo taskRepo;
    @Autowired
    TaskStatusRepo taskStatusRepo;

    @Override
    public Optional<Task> findById(Long taskId) throws Exception {
        if(taskRepo.findById(taskId).isEmpty()){
            throw new Exception("No Task found with given ID.");
        }
        return taskRepo.findById(taskId);
        
    }

    @Override
    public Optional<Collection<Task>> findAllByAssigneeId(Long assigneeId) throws Exception {
        if(taskRepo.findAllByAssigneeId(assigneeId).isEmpty()){
            throw new Exception("No Tasks assigned to given User.");
        }
        return taskRepo.findAllByAssigneeId(assigneeId);
    }

    @Override
    public Optional<Collection<Task>> findAllByAssignerId(Long assignerId) throws Exception {
        if(taskRepo.findAllByAssignerId(assignerId).isEmpty()){
            throw new Exception("No Tasks assigned by given User.");
        }
        return taskRepo.findAllByAssignerId(assignerId);
    }

    @Override
    public Optional<Collection<Task>> findAllByClientIdAndStatus(Long clientId, Long status) throws Exception {
        if(taskRepo.findAllByClientIdAndStatus(clientId, status).isEmpty()){
            throw new Exception("No Tasks in Status: " + taskStatusRepo.findById(status));
        }
        return taskRepo.findAllByClientIdAndStatus(clientId, status);
    }

    @Override
    public Optional<Collection<Task>> findAllByClientId(Long clientId) throws Exception {
        if(taskRepo.findAllByClientId(clientId).isEmpty()){
            throw new Exception("No Tasks found.");
        }
        return taskRepo.findAllByClientId(clientId);
    }

    @Override
    public Optional<Collection<Task>> findAllByPriority(Long priority) throws Exception {
        if(taskRepo.findAllByPriority(priority).isEmpty()){
            throw new Exception("No Tasks found in priority: " + priority);
        }
        return taskRepo.findAllByPriority(priority);
    }

    @Override
    public Optional<Collection<Task>> findAll() throws Exception {
        if(taskRepo.findAll().isEmpty()){
            throw new Exception("No Tasks found.");
        }
        return taskRepo.findAll();
    }
    
}

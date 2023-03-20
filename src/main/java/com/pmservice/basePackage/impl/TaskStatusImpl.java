package com.pmservice.basePackage.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Status.TaskStatus;
import com.pmservice.basePackage.repos.TaskStatusRepo;
import com.pmservice.basePackage.services.TaskStatusService;

@Component
public class TaskStatusImpl implements TaskStatusService{

    @Autowired
    TaskStatusRepo taskStatusRepo;

    @Override
    public TaskStatus findById(Long id) throws Exception {
        if(taskStatusRepo.findById(id).isEmpty()){
            throw new Exception("No Task Status found with given ID");
        }
        return taskStatusRepo.findById(id).get();
        
    }

    @Override
    public Collection<TaskStatus> findAll() throws Exception {
        if(taskStatusRepo.findAll().isEmpty()){
            throw new Exception("No Task Status entries have been found.");
        }
        return taskStatusRepo.findAll().get();
    }    
}

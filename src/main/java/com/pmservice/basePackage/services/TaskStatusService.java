package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Status.TaskStatus;


public interface TaskStatusService {

    Collection<TaskStatus> findAll() throws Exception;

    TaskStatus findById(Long taskId) throws Exception;
    
}

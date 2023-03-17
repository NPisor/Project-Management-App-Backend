package com.pmservice.basePackage.services;

import java.util.Collection;
import java.util.Optional;

import com.pmservice.basePackage.models.Status.TaskStatus;


public interface TaskStatusService {

    Optional<Collection<TaskStatus>> findAll() throws Exception;

    Optional<TaskStatus> findById(Long taskId) throws Exception;
    
}

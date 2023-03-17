package com.pmservice.basePackage.services;

import java.util.Collection;
import java.util.Optional;

import com.pmservice.basePackage.models.Task.Task;


public interface TaskService {

    Optional<Collection<Task>> findAll() throws Exception;

    Optional<Task> findById(Long taskId) throws Exception;

    Optional<Collection<Task>> findAllByAssigneeId(Long assigneeId) throws Exception;

    Optional<Collection<Task>> findAllByAssignerId(Long assignerId) throws Exception;

    Optional<Collection<Task>> findAllByClientIdAndStatus(Long clientId, Long Status) throws Exception;

    Optional<Collection<Task>> findAllByClientId(Long clientId) throws Exception;

    Optional<Collection<Task>> findAllByPriority(Long priority) throws Exception;
    
}

package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Task.Task;


public interface TaskService {

    Collection<Task> findAll() throws Exception;

    String findById(Long taskId) throws Exception;

    Collection<Task> findAllByAssigneeId(Long assigneeId) throws Exception;

    Collection<Task> findAllByAssignerId(Long assignerId) throws Exception;

    Collection<Task> findAllByClientIdAndStatus(Long clientId, Long Status) throws Exception;

    Collection<Task> findAllByClientId(Long clientId) throws Exception;

    Collection<Task> findAllByPriority(Long priority) throws Exception;
    
}

package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Task.Task;


public interface TaskRepo extends Repository<Task, Long> {

    Optional<Collection<Task>> findAll();

    Optional<Task> findById(Long taskId);

    Optional<Collection<Task>> findAllByAssigneeId(Long assigneeId);

    Optional<Collection<Task>> findAllByAssignerId(Long assignerId);

    Optional<Collection<Task>> findAllByClientIdAndStatus(Long clientId, Long Status);

    Optional<Collection<Task>> findAllByClientId(Long clientId);

    Optional<Collection<Task>> findAllByPriority(Long priority);

    Long count();

    Long countByStatus(Long status);

    Task save(Task task);

    Optional<Task> delete(Task task) throws Exception;

}
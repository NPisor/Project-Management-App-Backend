package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Status.TaskStatus;


public interface TaskStatusRepo extends Repository<TaskStatus, Long> {

    Optional<Collection<TaskStatus>> findAll();

    Optional<TaskStatus> findById(Long taskId);

}
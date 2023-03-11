package com.pmservice.basePackage.repos;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Task.Task;


public interface TaskRepo extends Repository<Task, Long> {

    Task findById(Long taskId);

}
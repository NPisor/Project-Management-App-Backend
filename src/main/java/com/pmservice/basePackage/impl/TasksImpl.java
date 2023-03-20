package com.pmservice.basePackage.impl;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pmservice.basePackage.models.Task.Task;
import com.pmservice.basePackage.models.User.Users;
import com.pmservice.basePackage.repos.TaskRepo;
import com.pmservice.basePackage.repos.TaskStatusRepo;
import com.pmservice.basePackage.repos.UsersRepo;
import com.pmservice.basePackage.services.TaskService;

@Component
public class TasksImpl implements TaskService{

    @Autowired
    TaskRepo taskRepo;
    @Autowired
    TaskStatusRepo taskStatusRepo;
    @Autowired
    UsersRepo usersRepo;

    @Override
    public String findById(Long taskId) throws Exception {
        Optional<Task> task;
        task = taskRepo.findById(taskId);
        if(task.isEmpty()){
            throw new Exception("No task has been found with ID: " + taskId.toString());
        }
        else{
            OffsetDateTime created = OffsetDateTime.ofInstant(Instant.ofEpochMilli(task.get().getCreatedTs().getTime()), ZoneId.systemDefault());
            OffsetDateTime complete = OffsetDateTime.ofInstant(Instant.ofEpochMilli(task.get().getTaskCompleted().getTime()), ZoneId.systemDefault());
            OffsetDateTime submitted = OffsetDateTime.ofInstant(Instant.ofEpochMilli(task.get().getTaskSubmittedForReview().getTime()), ZoneId.systemDefault());
            Users assigner = usersRepo.findById(task.get().getAssignerId()).get();
            ObjectMapper om = new ObjectMapper();  
            JsonNode jsonNode = om.readTree(om.writeValueAsString(task.get()));
            ((ObjectNode)jsonNode).put("assignerName", assigner.getFName() + " " + assigner.getLName());
            ((ObjectNode)jsonNode).put("createdDt", created.toLocalDateTime().toString().replace('T', ' '));
            ((ObjectNode)jsonNode).put("completedDt", complete.toLocalDateTime().toString().replace('T', ' '));
            ((ObjectNode)jsonNode).put("submittedDt", submitted.toLocalDateTime().toString().replace('T', ' '));
            return om.writeValueAsString(jsonNode);
        }        
    }

    @Override
    public Collection<Task> findAllByAssigneeId(Long assigneeId) throws Exception {
        if(taskRepo.findAllByAssigneeId(assigneeId).isEmpty()){
            throw new Exception("No Tasks assigned to given User.");
        }
        return taskRepo.findAllByAssigneeId(assigneeId).get();
    }

    @Override
    public Collection<Task> findAllByAssignerId(Long assignerId) throws Exception {
        if(taskRepo.findAllByAssignerId(assignerId).isEmpty()){
            throw new Exception("No Tasks assigned by given User.");
        }
        return taskRepo.findAllByAssignerId(assignerId).get();
    }

    @Override
    public Collection<Task> findAllByClientIdAndStatus(Long clientId, Long status) throws Exception {
        if(taskRepo.findAllByClientIdAndStatus(clientId, status).isEmpty()){
            throw new Exception("No Tasks in Status: " + taskStatusRepo.findById(status));
        }
        return taskRepo.findAllByClientIdAndStatus(clientId, status).get();
    }

    @Override
    public Collection<Task> findAllByClientId(Long clientId) throws Exception {
        if(taskRepo.findAllByClientId(clientId).isEmpty()){
            throw new Exception("No Tasks found.");
        }
        return taskRepo.findAllByClientId(clientId).get();
    }

    @Override
    public Collection<Task> findAllByPriority(Long priority) throws Exception {
        if(taskRepo.findAllByPriority(priority).isEmpty()){
            throw new Exception("No Tasks found in priority: " + priority);
        }
        return taskRepo.findAllByPriority(priority).get();
    }

    @Override
    public Collection<Task> findAll() throws Exception {
        if(taskRepo.findAll().isEmpty()){
            throw new Exception("No Tasks found.");
        }
        return taskRepo.findAll().get();
    }
    
}

package com.pmservice.basePackage.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pmservice.basePackage.models.Task.Task;
import com.pmservice.basePackage.services.TaskService;

@RestController
@CrossOrigin(origins = "*")
public class TasksController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public Collection<Task> getAllTasks() throws Exception {
        return taskService.findAll();
    }
    
    @RequestMapping(value = "/tasksearch", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getTaskById(@RequestParam Long id) throws Exception {
        return taskService.findById(id);
    }

    @GetMapping("/task/clientId")
    public Collection<Task> getTasksByClientId(@RequestParam Long clientId) throws Exception {
        return taskService.findAllByClientId(clientId);
    }

    @GetMapping("/task/assigneeId")
    public Collection<Task> getTasksByAssigneeId(@RequestParam Long assigneeId) throws Exception {
        return taskService.findAllByAssigneeId(assigneeId);
    }

    @GetMapping("/task/priority")
    public Collection<Task> getTasksByPriority(@RequestParam Long priority) throws Exception {
        return taskService.findAllByPriority(priority);
    }

    @GetMapping("/task/assignerId")
    public Collection<Task> getTaskByAssignerId(@RequestParam Long assignerId) throws Exception {
        return taskService.findAllByAssignerId(assignerId);
    }

    @GetMapping("/task/clientstatus")
    public Collection<Task> getTaskByClientIdAndStatus(@RequestParam Long id, @RequestParam Long status) throws Exception {
        return taskService.findAllByClientIdAndStatus(id, status);
    }

    @RequestMapping(value = "/task/fillTaskCompletion", method = RequestMethod.GET, produces="application/json")
    public String fillTaskCompletion(@RequestParam Long clientId) throws Exception {
        return taskService.fillTaskCompletionStatus(clientId);
    }

}

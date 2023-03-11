package com.pmservice.basePackage.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Responses.MappingResponse;
import com.pmservice.basePackage.models.User.CreateUserRequest;
import com.pmservice.basePackage.models.User.UserDeleteRequest;
import com.pmservice.basePackage.models.User.UserEditRequest;
import com.pmservice.basePackage.models.User.Users;
import com.pmservice.basePackage.services.UserService;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Collection<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/id/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/role/{roleId}")
    public Collection<Users> getUsersByRole(@PathVariable Long roleId) {
        return userService.findUsersByRole(roleId);
    }

    @PostMapping("/users/new")
    public MappingResponse createNewUser(@RequestBody CreateUserRequest request) {
        userService.createNewUser(request);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("User: " + request.getId() + " successfully created.");
        return response;
    }

    @DeleteMapping("/users/delete")
    public MappingResponse deleteUser(@RequestBody UserDeleteRequest request) throws Exception {
        userService.deleteUser(request);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("User: " + request.getUserId() + " successfully deleted.");
        return response;
    }

    @PutMapping("/users/edit")
    public MappingResponse editUser(@RequestBody UserEditRequest request) {
        userService.editUser(request);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("User: " + request.getUserId() + " details successfully edited.");
        return response;
    }

}

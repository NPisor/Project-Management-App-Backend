package com.pmservice.basePackage.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmservice.basePackage.models.Responses.MappingResponse;
import com.pmservice.basePackage.models.User.CreateUserRequest;
import com.pmservice.basePackage.models.User.UserDeleteRequest;
import com.pmservice.basePackage.models.User.UserEditRequest;
import com.pmservice.basePackage.models.User.Users;
import com.pmservice.basePackage.services.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Collection<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/id")
    public String customerSearch(@RequestParam Long id) throws Exception
    {
        Optional<Users> user;
        user = userService.findById(id);
        if(user.isEmpty()){
            throw new Exception("No customer found with ID: " + id);
        }
        else{
            ObjectMapper mapper = new ObjectMapper(); 
            return mapper.writeValueAsString(user.get());
        }        
    }

    @GetMapping("/users/role")
    public Collection<Users> getUsersByRole(Long roleId) {
        return userService.findUsersByRole(roleId);
    }

    @GetMapping("/users/client")
    public Collection<Users> getUsersByClient(Long clientId) {
        return userService.findUsersByClient(clientId);
    }

    @PostMapping("/users/new")
    public MappingResponse createNewUser(@RequestBody CreateUserRequest request) throws Exception {
        userService.createNewUser(request);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("User: " + request.getFirstName() + " " + request.getLastName() + " successfully created.");
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
    public MappingResponse editUser(@RequestBody UserEditRequest request) throws Exception {
        userService.editUser(request);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("User: " + request.getId() + " details successfully edited.");
        return response;
    }

}

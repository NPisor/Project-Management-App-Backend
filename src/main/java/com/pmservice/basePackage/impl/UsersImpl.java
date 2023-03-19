package com.pmservice.basePackage.impl;

import java.sql.Date;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.User.CreateUserRequest;
import com.pmservice.basePackage.models.User.UserDeleteRequest;
import com.pmservice.basePackage.models.User.UserEditRequest;
import com.pmservice.basePackage.models.User.Users;
import com.pmservice.basePackage.repos.UsersRepo;
import com.pmservice.basePackage.services.UserService;


@Component
public class UsersImpl implements UserService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public Collection<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) throws Exception {
        if(usersRepo.findById(id).isEmpty()){
            throw new Exception("No user found with given ID");
        }
        return usersRepo.findById(id);
    }

    @Override
    public Collection<Users> findUsersByRole(Long roleId) {
        return usersRepo.findAllByRole(roleId);
    }

    @Override
    public void createNewUser(CreateUserRequest request) throws Exception {
        if(usersRepo.findById(request.getId()).isPresent()){
            throw new Exception("User already already exists in database.");
        } 
        else{      
            Users newUser = new Users();
            newUser.setId(request.getId());
            newUser.setFName(request.getFirstName());
            newUser.setLName(request.getLastName());
            newUser.setClient(request.getClient());
            newUser.setRole(request.getRole());
            newUser.setDeviceId(request.getDeviceId());
            newUser.setCreatedOn(Date.from(Instant.now()));
            newUser.setLastModified(Date.from(Instant.now()));
            newUser = usersRepo.save(newUser);
        }
    }

    @Override
    public void deleteUser(UserDeleteRequest request) throws Exception {
        if(request.getCheck()){
            if(!usersRepo.findById(request.getUserId()).isPresent()){
                throw new Exception("No user exists to be deleted with given ID.");
            }
            Users userToDelete = usersRepo.findById(request.getUserId()).get();
            userToDelete = usersRepo.delete(userToDelete);
        }
        else{
            throw new Exception("User: " + request.getUserId() + " cannot be deleted with CHECK status set to: " + request.getCheck());
        }
    }

    @Override
    public void editUser(UserEditRequest request) throws Exception {
        if(!usersRepo.findById(request.getId()).isPresent()){
            throw new Exception("No user exists to edit with given ID.");
        }
        Users userToEdit = usersRepo.findById(request.getId()).get();
        userToEdit.setFName(request.getFirstName());
        userToEdit.setLName(request.getLastName());
        userToEdit.setClient(request.getClient());
        userToEdit.setRole(request.getRole());
        userToEdit.setLastModified(Date.from(Instant.now()));
        usersRepo.save(userToEdit);
    }

    @Override
    public Collection<Users> findUsersByClient(Long clientId) {
        return usersRepo.findAllByClient(clientId);
    }
    
}

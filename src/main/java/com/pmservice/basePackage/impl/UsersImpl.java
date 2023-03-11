package com.pmservice.basePackage.impl;

import java.util.Collection;
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
    public Users findById(Long id) {
        return usersRepo.findById(id);
    }

    @Override
    public Collection<Users> findUsersByRole(Long roleId) {
        return usersRepo.findAllByRole(roleId);
    }

    @Override
    public void createNewUser(CreateUserRequest request) {
        
        Users newUser = new Users();
        newUser.setId(request.getId());
        newUser.setFName(request.getFirstName());
        newUser.setLName(request.getLastName());
        newUser.setClient(request.getClient());
        newUser.setRole(request.getRole());
        newUser = usersRepo.save(newUser);
    }

    @Override
    public void deleteUser(UserDeleteRequest request) throws Exception {
        if(request.getCheck()){
            Users userToDelete = usersRepo.findById(request.getUserId());
            userToDelete = usersRepo.delete(userToDelete);
        }
        else{
            throw new Exception("User: " + request.getUserId() + " cannot be deleted with CHECK status set to: " + request.getCheck());
        }
    }

    @Override
    public void editUser(UserEditRequest request) {
        Users userToEdit = usersRepo.findById(request.getUserId());
        userToEdit.setFName(request.getFirstName());
        userToEdit.setLName(request.getLastName());
        userToEdit.setClient(request.getClientId());
        userToEdit.setRole(request.getRoleId());
        usersRepo.save(userToEdit);
    }
    
}

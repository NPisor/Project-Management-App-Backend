package com.pmservice.basePackage.impl;

import java.sql.Date;
import java.time.Instant;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.User.CreateUserRequest;
import com.pmservice.basePackage.models.User.UserDeleteRequest;
import com.pmservice.basePackage.models.User.UserEditRequest;
import com.pmservice.basePackage.models.User.Users;
import com.pmservice.basePackage.repos.ClientsRepo;
import com.pmservice.basePackage.repos.RolesRepo;
import com.pmservice.basePackage.repos.UsersRepo;
import com.pmservice.basePackage.services.UserService;


@Component
public class UsersImpl implements UserService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private ClientsRepo clientsRepo;

    @Override
    public Collection<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public Users findById(Long id) throws Exception {
        if(usersRepo.findById(id).isEmpty()){
            throw new Exception("No user found with given ID");
        }
        return usersRepo.findById(id).get();
    }

    @Override
    public Collection<Users> findUsersByRoleAndClient(Long roleId, Long clientId) throws Exception {
        if(usersRepo.findAllByRoleAndClient(roleId, clientId).isEmpty()){
            throw new Exception("No Users found with Role: " + rolesRepo.findByIdAndClientId(roleId, clientId).get().getLabel() + " for Client: " + clientsRepo.findById(clientId).get().getClientName());            
        }
        return usersRepo.findAllByRoleAndClient(roleId, clientId).get();
    }

    @Override
    public void createNewUser(CreateUserRequest request) throws Exception {    
            Users newUser = new Users();
            newUser.setFName(request.getFirstName());
            newUser.setLName(request.getLastName());
            newUser.setClient(clientsRepo.findByClientName(request.getClient()).get().getId());
            newUser.setRole(rolesRepo.findByLabelAndClientId(request.getRole(), clientsRepo.findByClientName(request.getClient()).get().getId()).get().getId());
            newUser.setDeviceId(request.getDeviceId());
            newUser.setCreatedOn(Date.from(Instant.now()));
            newUser.setLastModified(Date.from(Instant.now()));
            newUser = usersRepo.save(newUser);
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
    public Collection<Users> findUsersByClient(Long clientId) throws Exception {
        if(usersRepo.findAllByClient(clientId).isEmpty()){
            throw new Exception("No Users found for Client: " + clientsRepo.findById(clientId).get().getClientName());
        }
        return usersRepo.findAllByClient(clientId).get();
    }

    @Override
    public Users findByClientIdAndUserId(Long clientId, Long userId) throws Exception {
        if(usersRepo.findByClientAndId(clientId, userId).isEmpty()){
            throw new Exception("No User found with ID: " + userId.toString() + " for Client: " + clientsRepo.findById(clientId).get().getClientName());
        }
        return usersRepo.findByClientAndId(clientId, userId).get();
    }
    
}

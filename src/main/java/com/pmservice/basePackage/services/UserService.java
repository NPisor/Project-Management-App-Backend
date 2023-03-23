package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.User.CreateUserRequest;
import com.pmservice.basePackage.models.User.UserDeleteRequest;
import com.pmservice.basePackage.models.User.UserEditRequest;
import com.pmservice.basePackage.models.User.Users;

public interface UserService{

    public Collection<Users> getAllUsers();

    public Users findById(Long id) throws Exception;

    public Collection<Users> findUsersByRoleAndClient(Long roleId, Long clientId) throws Exception;

    public Collection<Users> findUsersByClient(Long clientId) throws Exception;

    public Users findByClientIdAndUserId(Long clientId, Long userId) throws Exception;

    public void createNewUser(CreateUserRequest request) throws Exception;

    public void deleteUser(UserDeleteRequest request) throws Exception;

    public void editUser(UserEditRequest request) throws Exception;
}

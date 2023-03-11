package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.User.CreateUserRequest;
import com.pmservice.basePackage.models.User.UserDeleteRequest;
import com.pmservice.basePackage.models.User.UserEditRequest;
import com.pmservice.basePackage.models.User.Users;

public interface UserService{

    public Collection<Users> getAllUsers();

    public Users findById(Long id);

    public Collection<Users> findUsersByRole(Long roleId);

    public void createNewUser(CreateUserRequest request);

    public void deleteUser(UserDeleteRequest request) throws Exception;

    public void editUser(UserEditRequest request);
}

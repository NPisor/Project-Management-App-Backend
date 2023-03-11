package com.pmservice.basePackage.repos;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.User.Users;

public interface UsersRepo extends Repository<Users, Long>{

    Collection<Users> findAll();

    Users findById(Long userId);

    Collection<Users> findAllByRole(Long roleId);

    Users save(Users user);

    Users delete(Users user);

}

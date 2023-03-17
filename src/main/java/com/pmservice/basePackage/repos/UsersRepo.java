package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.User.Users;

public interface UsersRepo extends Repository<Users, Long>{

    Collection<Users> findAll();

    Optional<Users> findById(Long userId);

    Collection<Users> findAllByRole(Long roleId);

    Collection<Users> findAllByClient(Long clientId);

    Users save(Users user);

    Users delete(Users user);

}

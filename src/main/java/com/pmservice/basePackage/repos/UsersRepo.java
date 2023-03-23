package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.User.Users;

public interface UsersRepo extends Repository<Users, Long>{

    Collection<Users> findAll();

    Optional<Users> findById(Long userId);

    Optional<Users> findByClientAndId(Long clientId, Long userId) throws Exception;

    Optional<Collection<Users>> findAllByRoleAndClient(Long roleId, Long clientId) throws Exception;

    Optional<Collection<Users>> findAllByClient(Long clientId) throws Exception;

    Users save(Users user);

    Users delete(Users user);

}

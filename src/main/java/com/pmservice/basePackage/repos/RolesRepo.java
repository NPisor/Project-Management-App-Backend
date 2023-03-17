package com.pmservice.basePackage.repos;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Role.Role;

public interface RolesRepo extends Repository<Role, Long> {

    Role findAll();

    Role findById(Long roleId);

    Role findByClientId(Long clientId);

}

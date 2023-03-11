package com.pmservice.basePackage.repos;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Role.Role;

public interface RolesRepo extends Repository<Role, Long> {

    Role findById(Long roleId);

}

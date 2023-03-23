package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Role.CreateRoleRequest;
import com.pmservice.basePackage.models.Role.Role;


public interface RolesService {

    Collection<Role> findAll() throws Exception;

    Role findByIdAndClientId(Long roleId, Long clientId) throws Exception;

    Collection<Role> findAllByClientId(Long clientId) throws Exception;

    Role createNewRole(CreateRoleRequest request);

    void delete(Long clientId, String label) throws Exception;
    
}

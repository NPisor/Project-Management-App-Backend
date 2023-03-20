package com.pmservice.basePackage.services;

import java.util.Collection;
import java.util.Optional;
import com.pmservice.basePackage.models.Role.Role;


public interface RolesService {

    Collection<Role> findAll() throws Exception;

    Role findById(Long roleId) throws Exception;

    Collection<Role> findAllByClientId(Long clientId) throws Exception;
    
}

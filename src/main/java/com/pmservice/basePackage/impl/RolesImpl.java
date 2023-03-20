package com.pmservice.basePackage.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Role.Role;
import com.pmservice.basePackage.repos.RolesRepo;
import com.pmservice.basePackage.services.RolesService;

@Component
public class RolesImpl implements RolesService {

    @Autowired
    RolesRepo rolesRepo;

    @Override
    public Collection<Role> findAll() throws Exception {
        if(rolesRepo.findAll().isEmpty()){
            throw new Exception("There are no active roles to choose from.");
        }
        return rolesRepo.findAll().get();
    }

    @Override
    public Role findById(Long roleId) throws Exception {
        if(rolesRepo.findById(roleId).isEmpty()){
            throw new Exception("No role has been found with ID: " + roleId.toString());
        }
        return rolesRepo.findById(roleId).get();
    }

    @Override
    public Collection<Role> findAllByClientId(Long clientId) throws Exception {
        if(rolesRepo.findAllByClientId(clientId).isEmpty()){
            throw new Exception("No roles have been found for Client ID: " + clientId.toString());
        }
        return rolesRepo.findAllByClientId(clientId).get();
    }
    
}

package com.pmservice.basePackage.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Role.CreateRoleRequest;
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

    @Override
    public Role createNewRole(CreateRoleRequest request) {
        Role newRole = new Role();
        newRole.setId(request.getId());
        newRole.setClientId(request.getClientId());
        newRole.setGroup(request.getGroup());
        newRole.setLabel(request.getRoleDescription());
        return rolesRepo.save(newRole);
    }

    @Override
    public void delete(Long clientId, String label) throws Exception {
        rolesRepo.findByLabelAndClientId(label, clientId).ifPresentOrElse(role -> {
            rolesRepo.save(role);
        }, () -> {
            try {
                throw new Exception("No Role found for Client " + clientId + " with Description: " + label);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
}

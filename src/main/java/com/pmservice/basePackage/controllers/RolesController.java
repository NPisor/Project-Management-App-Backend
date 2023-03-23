package com.pmservice.basePackage.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Role.Role;
import com.pmservice.basePackage.services.RolesService;

@RestController
@CrossOrigin(origins = "*")
public class RolesController {

    @Autowired
    RolesService rolesService;

    @GetMapping("/roles")
    public Collection<Role> getAllRoles() throws Exception {
        return rolesService.findAll();
    }
    
    @RequestMapping(value = "/role/clientId", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Collection<Role> getRolesByClientId(@RequestParam Long id) throws Exception {
        System.out.println(rolesService.findAllByClientId(id));
        return rolesService.findAllByClientId(id);
    }

    @GetMapping("/role/idClientId")
    public Role getRoleById(@RequestParam Long id, @RequestParam Long clientId) throws Exception {
        return rolesService.findByIdAndClientId(id, clientId);
    }
}

package com.pmservice.basePackage.models.Role;

import lombok.Data;

@Data
public class CreateRoleRequest {

    Long id;
    Long clientId;
    String roleDescription;
    Long group;
    
}

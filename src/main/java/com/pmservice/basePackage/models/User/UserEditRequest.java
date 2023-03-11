package com.pmservice.basePackage.models.User;

import lombok.Data;

@Data

public class UserEditRequest {

    private Long userId;
    private String firstName;
    private String lastName;
    private Long clientId;
    private Long roleId;

}

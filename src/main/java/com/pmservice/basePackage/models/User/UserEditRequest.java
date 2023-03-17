package com.pmservice.basePackage.models.User;

import java.util.Date;

import lombok.Data;

@Data

public class UserEditRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private Long client;
    private Long role;
    private Date lastModified;

}

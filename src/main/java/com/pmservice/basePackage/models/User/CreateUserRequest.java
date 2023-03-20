package com.pmservice.basePackage.models.User;


import java.util.Calendar;

import lombok.Data;

@Data

public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String role;
    private String client;   
    private String deviceId;
    private Calendar createdOn;
    private Calendar lastModified;
}

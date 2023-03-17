package com.pmservice.basePackage.models.User;


import java.util.Calendar;

import lombok.Data;

@Data

public class CreateUserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private Long role;
    private Long client;   
    private String deviceId;
    private Calendar createdOn;
    private Calendar lastModified;

}

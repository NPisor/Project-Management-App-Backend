package com.pmservice.basePackage.models.Logins;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class ChangePasswordRequest {

    String oldPassword;
    String newPassword;
    Timestamp timeSinceLastRequest;
    Long changeAttempts;
    
}

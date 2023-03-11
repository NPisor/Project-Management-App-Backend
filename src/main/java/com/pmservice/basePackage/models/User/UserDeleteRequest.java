package com.pmservice.basePackage.models.User;

import lombok.Data;

@Data

public class UserDeleteRequest {

    private Long userId;
    private Boolean check;

}

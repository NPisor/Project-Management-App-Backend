package com.pmservice.basePackage.models.Jobs;

import lombok.Data;

@Data
public class CreateJobRequest {

    Long id;

    String jobName;

    Long client;
    
}

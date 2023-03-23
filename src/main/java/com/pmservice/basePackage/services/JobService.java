package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Jobs.CreateJobRequest;
import com.pmservice.basePackage.models.Jobs.Jobs;

public interface JobService {

    Collection<Jobs> findAll() throws Exception;

    Jobs findById(Long id) throws Exception;

    Jobs findByClientAndJobName(Long client, String jobName) throws Exception;

    Jobs findByClientAndJobId(Long clientId, Long jobId) throws Exception;

    void save(CreateJobRequest request);

    void delete(Long clientId, Long jobId) throws Exception;

    Collection<Jobs> findAllByClient(Long client) throws Exception;
    
}

package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Jobs.Jobs;

public interface JobsRepo extends Repository<Jobs, Long>{

    Optional<Collection<Jobs>> findAll() throws Exception;

    Optional<Jobs> findById(Long id) throws Exception;

    Optional<Jobs> findByClientAndJobName(Long client, String jobName) throws Exception;

    Optional<Jobs> findByClientAndId(Long clientId, Long jobId) throws Exception;

    void save(Jobs job);

    void delete(Jobs job);

    Optional<Collection<Jobs>> findAllByClient(Long client) throws Exception;
    
}

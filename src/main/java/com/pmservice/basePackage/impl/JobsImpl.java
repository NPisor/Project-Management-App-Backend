package com.pmservice.basePackage.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Jobs.CreateJobRequest;
import com.pmservice.basePackage.models.Jobs.Jobs;
import com.pmservice.basePackage.repos.ClientsRepo;
import com.pmservice.basePackage.repos.JobsRepo;
import com.pmservice.basePackage.services.JobService;

@Component
public class JobsImpl implements JobService{

    @Autowired
    JobsRepo jobsRepo;

    @Autowired
    ClientsRepo clientsRepo;

    @Override
    public Collection<Jobs> findAll() throws Exception {
        if(jobsRepo.findAll().isEmpty()){
            throw new Exception("No jobs found.");
        }
        return jobsRepo.findAll().get();
    }

    @Override
    public Jobs findById(Long id) throws Exception {
        if(jobsRepo.findById(id).isEmpty()){
            throw new Exception("No job found with ID: " + id.toString());
        }
        return jobsRepo.findById(id).get();
    }

    @Override
    public Jobs findByClientAndJobName(Long client, String jobName) throws Exception {
        if(jobsRepo.findByClientAndJobName(client, jobName).isEmpty()){
            throw new Exception("No jobs found with Name: " + jobName + " for Client: " + clientsRepo.findById(client).get().getClientName());
        }
        return jobsRepo.findByClientAndJobName(client, jobName).get();
    }

    @Override
    public void save(CreateJobRequest request) {
        Jobs newJob = new Jobs();
        newJob.setId(request.getId());
        newJob.setClient(request.getClient());
        newJob.setJobName(request.getJobName());
        jobsRepo.save(newJob);
    }

    @Override
    public void delete(Long clientId, Long jobId) throws Exception {
        Jobs jobToDelete = findByClientAndJobId(clientId,jobId);
        jobsRepo.delete(jobToDelete);
    }

    @Override
    public Collection<Jobs> findAllByClient(Long client) throws Exception {
        if(jobsRepo.findAllByClient(client).isEmpty()){
            throw new Exception("No jobs found for Client: " + clientsRepo.findById(client).get().getClientName());
        }
        return jobsRepo.findAllByClient(client).get();
    }

    @Override
    public Jobs findByClientAndJobId(Long clientId, Long jobId) throws Exception {
        if(jobsRepo.findByClientAndId(clientId, jobId).isEmpty()){
            throw new Exception("No job found with ID: " + jobId.toString() + " for Client: " + clientsRepo.findById(clientId).get().getClientName());
        }
        return jobsRepo.findByClientAndId(clientId, jobId).get();
    }
    
}

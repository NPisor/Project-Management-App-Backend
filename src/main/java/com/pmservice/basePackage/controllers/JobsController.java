package com.pmservice.basePackage.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Jobs.CreateJobRequest;
import com.pmservice.basePackage.models.Jobs.Jobs;
import com.pmservice.basePackage.services.JobService;

@RestController
@CrossOrigin(origins = "*")
public class JobsController {

    @Autowired
    JobService jobService;

    @ResponseBody
    @RequestMapping(value = "/jobs", method = RequestMethod.GET, produces="application/json")
    public Collection<Jobs> getAllJobs() throws Exception {
        return jobService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/jobs/id", method = RequestMethod.GET, produces="application/json")
    public Jobs getJobById(@RequestParam Long jobId) throws Exception {
        return jobService.findById(jobId);
    }

    @ResponseBody
    @RequestMapping(value = "/jobs/clientJobName", method = RequestMethod.GET, produces="application/json")
    public Jobs getJobByClientAndJobName(@RequestParam Long client, @RequestParam String jobName) throws Exception {
        return jobService.findByClientAndJobName(client, jobName);
    }

    @ResponseBody
    @RequestMapping(value = "/jobs/clientJobId", method = RequestMethod.GET, produces="application/json")
    public Jobs getJobByClientAndJobId(@RequestParam Long client, @RequestParam Long jobId) throws Exception {
        return jobService.findByClientAndJobId(client, jobId);
    }

    @RequestMapping(value = "/jobs/save", method = RequestMethod.POST, produces="application/json")
    public void saveJob(@RequestBody CreateJobRequest request) throws Exception {
        jobService.save(request);
    }

    @RequestMapping(value = "/jobs/delete", method = RequestMethod.DELETE, produces="application/json")
    public void deleteJob(@RequestParam Long clientId, @RequestParam Long jobId) throws Exception {
        jobService.delete(clientId, jobId);
    }
    
}

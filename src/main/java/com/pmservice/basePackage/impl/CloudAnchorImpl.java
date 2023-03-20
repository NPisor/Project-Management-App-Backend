package com.pmservice.basePackage.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Anchors.Anchors;
import com.pmservice.basePackage.repos.CloudAnchorsRepo;
import com.pmservice.basePackage.services.CloudAnchorService;

@Component
public class CloudAnchorImpl implements CloudAnchorService{

    @Autowired
    CloudAnchorsRepo cloudAnchorsRepo;

    @Override
    public Collection<Anchors> findAll() throws Exception {
        if(cloudAnchorsRepo.findAll().isEmpty()){
            throw new Exception("No cloud anchors have been found.");
        }
        return cloudAnchorsRepo.findAll().get();
    }

    @Override
    public Anchors findById(Long anchorId) throws Exception {
        if(cloudAnchorsRepo.findById(anchorId).isEmpty()){
            throw new Exception("No cloud anchor with ID: " + anchorId + " could be found.");
        }
        return cloudAnchorsRepo.findById(anchorId).get();
    }
    
}

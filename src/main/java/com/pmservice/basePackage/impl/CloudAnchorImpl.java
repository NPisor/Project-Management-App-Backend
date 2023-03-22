package com.pmservice.basePackage.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Anchors.Anchors;
import com.pmservice.basePackage.models.Anchors.CreateAnchorRequest;
import com.pmservice.basePackage.repos.ClientsRepo;
import com.pmservice.basePackage.repos.CloudAnchorsRepo;
import com.pmservice.basePackage.repos.UsersRepo;
import com.pmservice.basePackage.services.CloudAnchorService;

@Component
public class CloudAnchorImpl implements CloudAnchorService{

    @Autowired
    CloudAnchorsRepo cloudAnchorsRepo;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    ClientsRepo clientsRepo;

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

    @Override
    public Collection<Anchors> findAllInStatusByClientId(Long status, Long clientId) throws Exception {
        if(clientsRepo.findById(clientId).isEmpty()){
            throw new Exception("No client found with ID: " + clientId);
        }
        else if(cloudAnchorsRepo.findAllByStatusAndClientId(status, clientId).isEmpty()){
            throw new Exception("No tasks found for Client: " + clientsRepo.findById(clientId).get().getClientName() + " in Status: " + status.toString());
        }
        return cloudAnchorsRepo.findAllByStatusAndClientId(status, clientId).get();
    }

    @Override
    public Anchors saveAnchor(CreateAnchorRequest request) throws Exception {
        Anchors anchor = new Anchors();
        anchor.setId(request.getId());
        anchor.setAltitude(request.getAltitude());
        anchor.setLatitude(request.getLatitude());
        anchor.setLongitude(request.getLongitude());
        return cloudAnchorsRepo.save(anchor);
    }

    @Override
    public Anchors deleteAnchor(Anchors anchor) throws Exception {
        if(cloudAnchorsRepo.findById(anchor.getId()).isEmpty()){
            throw new Exception("No anchor found with ID: " + anchor.getId());
        }
        return cloudAnchorsRepo.delete(anchor).get();
    }    
}

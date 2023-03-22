package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Anchors.Anchors;
import com.pmservice.basePackage.models.Anchors.CreateAnchorRequest;


public interface CloudAnchorService {

    Collection<Anchors> findAll() throws Exception;

    Anchors findById(Long anchorId) throws Exception;

    Collection<Anchors> findAllInStatusByClientId(Long status, Long clientId) throws Exception;

    Anchors saveAnchor(CreateAnchorRequest request) throws Exception;

    Anchors deleteAnchor(Anchors anchor) throws Exception;
    
}

package com.pmservice.basePackage.services;

import java.util.Collection;
import java.util.Optional;

import com.pmservice.basePackage.models.Anchors.Anchors;


public interface CloudAnchorService {

    Optional<Collection<Anchors>> findAll() throws Exception;

    Optional<Anchors> findById(Long anchorId) throws Exception;
    
}

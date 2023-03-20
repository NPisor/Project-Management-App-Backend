package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Anchors.Anchors;


public interface CloudAnchorService {

    Collection<Anchors> findAll() throws Exception;

    Anchors findById(Long anchorId) throws Exception;
    
}

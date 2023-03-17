package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Anchors.Anchors;


public interface CloudAnchorsRepo extends Repository<Anchors, Long>{

    Optional<Collection<Anchors>> findAll() throws Exception;

    Optional<Anchors> findById(Long anchorId) throws Exception;
    
}

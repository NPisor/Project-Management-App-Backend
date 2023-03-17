package com.pmservice.basePackage.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Anchors.Anchors;
import com.pmservice.basePackage.services.CloudAnchorService;

@RestController
public class CloudAnchorController {

    @Autowired
    CloudAnchorService cloudAnchorService;

    @GetMapping("/anchors")
    public Optional<Collection<Anchors>> getAllCloudAnchors() throws Exception {
        return cloudAnchorService.findAll();
    }

    @GetMapping("/anchor/id")
    public Optional<Anchors> getAnchorById(Long anchorId) throws Exception {
        return cloudAnchorService.findById(anchorId);
    }
}

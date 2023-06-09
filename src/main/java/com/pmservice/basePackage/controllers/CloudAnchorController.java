package com.pmservice.basePackage.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Anchors.Anchors;
import com.pmservice.basePackage.services.CloudAnchorService;

@RestController
@CrossOrigin(origins = "*")
public class CloudAnchorController {

    @Autowired
    CloudAnchorService cloudAnchorService;

    @GetMapping("/anchors")
    public Collection<Anchors> getAllCloudAnchors() throws Exception {
        return cloudAnchorService.findAll();
    }

    @GetMapping("/anchor/id")
    public Anchors getAnchorById(@RequestParam Long anchorId) throws Exception {
        return cloudAnchorService.findById(anchorId);
    }
}

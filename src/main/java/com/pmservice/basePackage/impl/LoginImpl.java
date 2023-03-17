package com.pmservice.basePackage.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pmservice.basePackage.models.Logins.Logins;
import com.pmservice.basePackage.repos.LoginRepo;
import com.pmservice.basePackage.services.LoginService;

public class LoginImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;

    @Override
    public Optional<Logins> findById(Long id) throws Exception {
        if(loginRepo.findById(id).isEmpty()){
            throw new Exception("No user found with given ID.");
        }
        return loginRepo.findById(id);
    }

    @Override
    public Optional<Logins> findByUsername(String username) throws Exception {
        if(loginRepo.findByUsername(username).isEmpty()){
            throw new Exception("No user found with given Username: " + username);
        }
        return loginRepo.findByUsername(username);
    }
    
}

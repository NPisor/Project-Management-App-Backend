package com.pmservice.basePackage.services;
import java.util.Optional;
import com.pmservice.basePackage.models.Logins.Logins;


public interface LoginService {

    Logins findById(Long id) throws Exception;

    Logins findByUsername(String username) throws Exception;
    
}

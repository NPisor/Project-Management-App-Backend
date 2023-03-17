package com.pmservice.basePackage.services;
import java.util.Optional;
import com.pmservice.basePackage.models.Logins.Logins;


public interface LoginService {

    Optional<Logins> findById(Long id) throws Exception;

    Optional<Logins> findByUsername(String username) throws Exception;
    
}

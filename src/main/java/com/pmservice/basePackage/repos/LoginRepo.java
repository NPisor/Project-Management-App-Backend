package com.pmservice.basePackage.repos;

import java.util.Optional;

import org.springframework.data.repository.Repository;
import com.pmservice.basePackage.models.Logins.Logins;


public interface LoginRepo extends Repository<Logins, Long>{

    Optional<Logins> findById(Long id) throws Exception;

    Optional<Logins> findByUsername(String username) throws Exception;
    
}

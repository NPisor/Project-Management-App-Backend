package com.pmservice.basePackage.services;
import com.pmservice.basePackage.models.Logins.ChangePasswordRequest;
import com.pmservice.basePackage.models.Logins.Logins;


public interface LoginService {

    Logins findById(Long id) throws Exception;

    Logins findByUsername(String username) throws Exception;

    Boolean checkPassword(String username, String password) throws Exception;

    void editPassword(String username, ChangePasswordRequest request) throws Exception;
    
}

package com.pmservice.basePackage.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.Security.CustomDelegatingPwdEncoder;
import com.pmservice.basePackage.models.Logins.ChangePasswordRequest;
import com.pmservice.basePackage.models.Logins.Logins;
import com.pmservice.basePackage.repos.LoginRepo;
import com.pmservice.basePackage.services.LoginService;

@Component
public class LoginImpl implements LoginService, CustomDelegatingPwdEncoder {

    @Autowired
    LoginRepo loginRepo;

    @Override
    public Logins findById(Long id) throws Exception {
        if(loginRepo.findById(id).isEmpty()){
            throw new Exception("No user found with given ID.");
        }
        return loginRepo.findById(id).get();
    }

    @Override
    public Logins findByUsername(String username) throws Exception {
        if(loginRepo.findByUsername(username).isEmpty()){
            throw new Exception("No user found with given Username: " + username);
        }
        return loginRepo.findByUsername(username).get();
    }

    @Override
    public void encodePassword(String username, String password) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        loginRepo.findByUsername(username).ifPresentOrElse(user -> {
            user.setPassword(encoder.encode(password));
            loginRepo.save(user);
        }, () -> {try {
            throw new Exception("No user present with username: " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }});        
    }

    @Override
    public Boolean checkPassword(String username, String password) throws Exception {
        return loginRepo.findByUsername(username).orElseThrow().getPassword().equals(password);
    }

    @Override
    public void editPassword(String username, ChangePasswordRequest request) throws Exception {
        loginRepo.findByUsername(username).ifPresentOrElse(user -> {
            if(user.getFailedAttempts() > 3){
                String timeUntilNextAttempt = user.getLastLoginAttempt().toInstant().plus(Duration.ofMinutes(5)).toString();
                try {
                    throw new Exception("There have been 3 failed attempts to login.  You will have to wait until " + timeUntilNextAttempt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else if(user.getLastCredsChange().toInstant().isBefore(user.getLastCredsChange().toInstant().plus(Duration.ofHours(24)))){
            }
        }, () -> {
            try {
                throw new Exception("No user found with username: " + username);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}

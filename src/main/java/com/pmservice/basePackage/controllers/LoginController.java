package com.pmservice.basePackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Logins.ChangePasswordRequest;
import com.pmservice.basePackage.models.Logins.Logins;
import com.pmservice.basePackage.models.Responses.MappingResponse;
import com.pmservice.basePackage.services.LoginService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/logins")
    public Logins getLoginWithId(Long id) throws Exception {
        return loginService.findById(id);
    }

    @GetMapping("/logins/username")
    public Logins getLoginWithUsername(String username) throws Exception {
        return loginService.findByUsername(username);
    }

    @PostMapping("/editLogin")
    public MappingResponse changePassword(@RequestBody ChangePasswordRequest request) {
        MappingResponse response = new MappingResponse();
        return response;
    }

    @GetMapping("/trylogin")
    public Boolean tryUserLogin(String username, String password) throws Exception {
        return loginService.checkPassword(username,password);
    }
}

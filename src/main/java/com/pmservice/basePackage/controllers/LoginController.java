package com.pmservice.basePackage.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pmservice.basePackage.models.Logins.Logins;
import com.pmservice.basePackage.services.LoginService;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/logins")
    public Optional<Logins> getLoginWithId(Long id) throws Exception {
        return loginService.findById(id);
    }

    @GetMapping("/logins/username")
    public Optional<Logins> getLoginWithUsername(String username) throws Exception {
        return loginService.findByUsername(username);
    }
}

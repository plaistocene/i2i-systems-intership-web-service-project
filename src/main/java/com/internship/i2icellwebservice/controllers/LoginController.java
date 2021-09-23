package com.internship.i2icellwebservice.controllers;

import com.internship.i2icellwebservice.modals.LoginModal;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Log4j2
public class LoginController {

    @GetMapping("/login")
    public void LogIn(@RequestBody LoginModal loginModal) {
        if (Objects.equals(loginModal.getMsisdn(), "0000") && Objects.equals(loginModal.getPassword(), "aaaa")) {
            log.info("log in success for user {}", loginModal.getMsisdn());
            System.err.println("hello");
        } else {
            log.info("login failed");
            System.err.println("failed");
        }
    }
}

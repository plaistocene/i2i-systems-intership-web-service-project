package com.internship.i2icellwebservice.controllers;

import com.google.common.hash.Hashing;
import com.internship.i2icellwebservice.daos.UsersDao;
import com.internship.i2icellwebservice.modals.CustomerInfoModal;
import com.internship.i2icellwebservice.modals.LoginModal;
import com.internship.i2icellwebservice.modals.UsersModal;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@Log4j2
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UsersDao usersDao;

    @PostMapping("/login")
    public CustomerInfoModal LogIn(@RequestBody LoginModal loginModal) {

        String passwordSHA256 = Hashing.sha256()
                .hashString(loginModal.getPassword(), StandardCharsets.UTF_8)
                .toString();
        log.error("sha256 password {}", passwordSHA256);
        UsersModal user = usersDao.getUserInfo(new LoginModal(loginModal.getMsisdn(), passwordSHA256));
        CustomerInfoModal customerInfo = new CustomerInfoModal();

        if (user != null) {
            log.info("log in success for user {}", loginModal.getMsisdn());
            customerInfo.setName(user.getO_user_name());
            customerInfo.setSurname(user.getO_user_surname());
            customerInfo.setMsisdn(user.getO_msisdn());
            customerInfo.setEmail(user.getO_mail());
            customerInfo.setToken("Test Token");
            customerInfo.setSuccess(true);
            System.err.println("hello");
            return customerInfo;
        } else {
            log.info("login failed");
            System.err.println("failed my test");
            return null;
        }
    }
}

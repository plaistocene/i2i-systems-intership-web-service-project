package com.internship.i2icellwebservice.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginModal {
    private String msisdn;
    private String password;
}

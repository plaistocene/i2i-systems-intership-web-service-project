package com.internship.i2icellwebservice.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerInfoModal {
    private String name;
    private String surname;
    private String msisdn;
    private String email;
    private String token;
    private Boolean success;
}

package com.internship.i2icellwebservice.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(
        name = "updatePassword",
        procedureName = "CONFIRM_PASS_CHANGE",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_user_mail", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_new_password", type = String.class)
        }
)
public class PasswordRefreshUpdateModal {
    @Id
    private String i_user_mail;
    private String i_new_password;
}
// 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918 ==> admin sha256
//
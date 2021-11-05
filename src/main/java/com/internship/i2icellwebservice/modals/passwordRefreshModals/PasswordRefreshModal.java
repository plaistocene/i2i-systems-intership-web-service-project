package com.internship.i2icellwebservice.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NamedStoredProcedureQuery(
        name = "getPasswordRefreshCode",
        procedureName = "PERSIST_PASS_CHANGE_CODE",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_user_mail", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_passchangecode", type = String.class),
        }
)
public class PasswordRefreshModal {
    @Id
    private String i_user_mail;
}

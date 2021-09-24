package com.internship.i2icellwebservice.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@NamedStoredProcedureQueries ({
        @NamedStoredProcedureQuery (
                name = "getUserInfo",
                procedureName = "USER_INFO_MSISDN_PASS",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_msisdn", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_password", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_user_id", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_user_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_user_surname", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_mail", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_msisdn", type = String.class)
                }
        )})
public class UsersModal {
    @Id
    private Integer o_user_id;
    private String o_user_name;
    private String o_user_surname;
    private String o_mail;
    private String o_msisdn;
}


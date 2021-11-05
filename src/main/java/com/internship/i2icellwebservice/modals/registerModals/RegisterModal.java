package com.internship.i2icellwebservice.modals;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedStoredProcedureQuery(
        name = "register",
        procedureName = "REG_REQUEST",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_surname", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_mail", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_msisdn", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_password", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "i_generated_code", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "o_register_confirmation_id", type = String.class)
        }

)
public class RegisterModal {
    @Id
    private String i_name;
    private String i_surname;
    private String i_mail;
    private String i_msisdn;
    private String i_password;
}

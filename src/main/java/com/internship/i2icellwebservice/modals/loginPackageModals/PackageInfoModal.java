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
        name = "getPackageInfoProcedure",
        procedureName = "AUSER_PACKAGE_INFO",
        resultClasses = PackageInfoModal.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
        }
)
public class PackageInfoModal {
    @Id
    private String PACKAGE_NAME;
    private String PACKAGE_TYPE;
    private Integer PACKAGE_LIMIT;
    private String BUSINESS_ZONE;
    private Integer VISIBILITY;
    private String END_DATE;
    private String BEGIN_DATE;
    private Integer USED_AMOUNT;
}

package com.internship.i2icellwebservice.daos;

import com.internship.i2icellwebservice.modals.LoginModal;
import com.internship.i2icellwebservice.modals.UsersModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class UsersDao {
    @Autowired
    private EntityManager entityManager;

    public UsersModal getUserInfo(LoginModal loginModal){
        System.err.println(entityManager);
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("getUserInfo");

        query.setParameter("i_msisdn", loginModal.getMsisdn());
        query.setParameter("i_password", loginModal.getPassword());
        query.execute();
        UsersModal user = new UsersModal();
        user.setO_user_id((Integer) query.getOutputParameterValue("o_user_id"));
        user.setO_user_name((String) query.getOutputParameterValue("o_user_name"));
        user.setO_user_surname((String) query.getOutputParameterValue("o_user_surname"));
        user.setO_mail((String) query.getOutputParameterValue("o_mail"));
        user.setO_msisdn((String) query.getOutputParameterValue("o_msisdn"));

        return user;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.Date;
import java.util.List;
import md.factorydream.entites.ParamNames;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.ParamNamesUpdateRest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class ParamNamesDAOImpl extends AbstractSpringDao implements ParamNamesDAO {

    @Override
    public void save(ParamNames paramNames) {
        super.saveOrUpdate(paramNames);
    }

    @Override
    public List findAll() {
        return super.findAllDataEnableObject(ParamNames.class);
    }

    @Override
    public boolean update(ParamNamesUpdateRest paramNamesUpdateRest, Users users) {

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createSQLQuery(
                "             UPDATE  param_names  "
                + "              SET               "
                + "                   name = :Name, "
                + " param_name_description = :Description, "
                + "    id_user_last_update = :User, "
                + "       last_update_date = :LastUpdateDate "
                + "    WHERE  id = :Id");

        query.setLong("id", paramNamesUpdateRest.getId());

        query.setString("Name", paramNamesUpdateRest.getName());
        query.setString("Description", paramNamesUpdateRest.getParamNameDescription());
        query.setInteger("User", users.getId());
        query.setTimestamp("LastUpdateDate", new Date());

        int result = query.executeUpdate();

        return result > 0;
    }

    @Override
    public List findDistinctParamNames() {

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" "
                + " SELECT  DISTINCT  pn  "
                + "   FROM  ParamNames pn "
                + "   JOIN  FETCH  "
                + "     pn.orderParameterses "

        );

        List list = query.list();
        return list;
    }

}

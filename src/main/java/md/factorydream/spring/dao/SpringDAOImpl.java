/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.rest.MenuValueRest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class SpringDAOImpl extends AbstractSpringDao implements SpringDAO {

    @Override
    public List selectMeniu() {

        Object menuValueRest = null;

        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(" "
                + " "
                + " select 'data' AS \"menuLabel\"  "
                + " union "
                + " select 'customer' "
                + " union select "
                + " 'order identifier' "
                + " union select 'model' "
                + " union select 'diameter' "
                + " union select 'type' "
                + " union select 'threads' "
                + " union select 'color' "
                + " union Select distinct pm.name  "
                + " from order_parameters op "
                + " inner join param_names pm "
                + " on pm.id = op.id_param_name "
                + " where op.id_status_code = 2 "
                + " union select 'quantity' "
                + " union select 'delivery'  "
                + " ");

        List list = query.list();

        if (list != null && list.size() > 0) {
            menuValueRest = (Object) list.get(0);
            System.out.println(" Zaitev " + menuValueRest);

        }

        return list;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.StatusCod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class StatusCodDAOImpl extends AbstractSpringDao implements StatusCodDAO {

    @Override
    public void save(StatusCod statusCod) {
        super.saveOrUpdate(statusCod);

    }

    @Override
    public List findAll() {
        return super.findAll(StatusCod.class);
    }

    @Override
    public List findStatusCodByGroupId(short groupId) {

        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(" FROM StatusCod "
                + " WHERE statusGroup.id=:GroupID ");

        query.setLong("GroupID", groupId);

        List list = query.list();

        return list;
    }

}

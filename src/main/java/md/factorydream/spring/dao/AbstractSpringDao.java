/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Zaițev.Victor
 */
public abstract class AbstractSpringDao {

    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void saveOrUpdate(Object obj) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(obj);
    }

    protected List findAll(Class clazz) {
        Session session = this.sessionFactory.getCurrentSession();
        List list = session.createQuery(" from " + clazz.getName()).list();
        return list;
    }

    protected List findAllDataEnableObject(Class clazz) {

        String tableName = Character.toLowerCase(clazz.getName().charAt(24)) + clazz.getName().substring(25);

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" FROM " + clazz.getName()
                + " " + tableName + " WHERE " + tableName + ".statusCod.codName = 'E'  ");

        List list = query.list();

        return list;
    }

    protected List findAllCustumerEnableObject(Class clazz) {
        return null;
    }

    protected Object findClassById(Class clazz, long id) {

        Object object = null;

        Session session = this.sessionFactory.getCurrentSession();

        object = session.get(clazz, id);

        Hibernate.initialize(object);

        return object;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.RoleAccess;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class RoleAccessDAOImpl extends AbstractSpringDao implements RoleAccessDAO {

    @Override
    public void save(RoleAccess roleAccess) {
        super.saveOrUpdate(roleAccess);
    }

    @Override
    public List findAll() {
        return super.findAll(RoleAccess.class);
    }

    @Override
    public RoleAccess findRoleAccessByUserNameAndUrl(String userLogin, String url) {

        RoleAccess roleAccess = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT roleAcc FROM RoleAccess roleAcc, Roles roles, Users users, Access access, Url url "
                + " WHERE  roles.id = roleAcc.roles.id "
                + "   AND  users.id = roleAcc.users.id "
                + "   AND  access.id = roleAcc.access.id "
                + "   AND  url = roleAcc.url.id "
                + "   AND  access.statusCod.id = 2 "
                + "   AND  users.login=:UserLogin "
                + "   AND  url.url=:Url  ");

        query.setString("UserLogin", userLogin);
        query.setString("Url", url);

        List list = query.list();

        if (list != null && list.size() > 0) {
            roleAccess = (RoleAccess) list.get(0);
        }
        return roleAccess;

    }

}

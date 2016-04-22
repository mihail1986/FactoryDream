/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.RoleAccess;
import md.factorydream.spring.dao.RoleAccessDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class RoleAccessSeviceImpl implements RoleAccessSevice {

    RoleAccessDAO roleAccessDAO;

    public void setRoleAccessDAO(RoleAccessDAO roleAccessDAO) {
        this.roleAccessDAO = roleAccessDAO;
    }

    @Override
    @Transactional
    public void save(RoleAccess roleAccess) {
        roleAccessDAO.save(roleAccess);
    }

    @Override
    @Transactional
    public List findAll() {
        return roleAccessDAO.findAll();
    }

    @Override
    @Transactional
    public RoleAccess findRoleAccessByUserNameAndUrl(String userName, String url) {
        return roleAccessDAO.findRoleAccessByUserNameAndUrl(userName, url);
    }

}

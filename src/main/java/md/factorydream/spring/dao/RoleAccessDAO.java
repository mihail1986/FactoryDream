/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.RoleAccess;

/**
 *
 * @author Zaițev.Victor
 */
public interface RoleAccessDAO {

    public void save(RoleAccess roleAccess);

    public List findAll();

    public RoleAccess findRoleAccessByUserNameAndUrl(String userName, String url);
}

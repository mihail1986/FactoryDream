/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.util;

import md.factorydream.constant.AccessNameConst;
import md.factorydream.entites.RoleAccess;
import md.factorydream.spring.service.RoleAccessSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Zaițev.Victor
 */
public class Autorization {

    //RoleAccess Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "roleAccessSevice")
    private static RoleAccessSevice roleAccessSevice;

    //----------------------------------------------------------------------------------------------------------
    public static boolean isAutorization(String name, String url, String operationType) {

        RoleAccess roleAccess = roleAccessSevice.findRoleAccessByUserNameAndUrl(name, url);

        if (roleAccess == null) {
            return false;
        }

        System.out.println("Zaitev " + roleAccess.getAccess().getAccessName());

        switch (roleAccess.getAccess().getAccessName()) {

            case AccessNameConst.ACCESS_NAME_FULL: {
                return true;
            }

            case AccessNameConst.ACCESS_NAME_READ: {
                return false;
            }

            case AccessNameConst.ACCESS_NAME_UPDATE: {

                if ((operationType.equals("delete")) || (operationType.equals("save"))) {
                    return false;
                }

            }
            case AccessNameConst.ACCESS_NAME_INSERT: {
                if (operationType.equals("delete")) {
                    return false;
                }
            }
        }
        return true;
    }

}

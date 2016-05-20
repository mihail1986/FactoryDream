/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import md.factorydream.constant.AccessNameConst;
import md.factorydream.entites.RoleAccess;
import md.factorydream.entites.rest.OrdersRest;
import md.factorydream.spring.service.OrdersService;
import md.factorydream.spring.service.RoleAccessSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */

@RestController
public class RestOrdersController {

    //Orders Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "ordersService")
    private OrdersService ordersService;

    //RoleAccess Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "roleAccessSevice")
    private RoleAccessSevice roleAccessSevice;

    //------------------------ Retrieve All Orders ------------------------------------------------------ 
    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getAllOrders() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        RoleAccess roleAccess = roleAccessSevice.findRoleAccessByUserNameAndUrl(name, "/rest/orders");

        if (roleAccess == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<Map<String, Object>> respons = new ArrayList<>();
        Map<String, Object> userAccess = new HashMap<>();
        userAccess.put("userAccess", roleAccess.getAccess().getAccessName());
        respons.add(userAccess);

        if (roleAccess.getAccess().getAccessName().equals(AccessNameConst.ACCESS_NAME_READ)) {
            List<OrdersRest> ordersRestsReadOnlineList = (ArrayList<OrdersRest>) ordersService.findAllOrdersRestReadOnly();
            Map<String, Object> ordersMap = new HashMap<>();
            ordersMap.put("orders", ordersRestsReadOnlineList);
            respons.add(ordersMap);
        } else {
            List<OrdersRest> ordersRestsList = (ArrayList<OrdersRest>) ordersService.findAllOrdersRest();
            Map<String, Object> ordersMap = new HashMap<>();
            ordersMap.put("orders", ordersRestsList);
            respons.add(ordersMap);
        }

        return new ResponseEntity<>(respons, HttpStatus.OK);
    }
}

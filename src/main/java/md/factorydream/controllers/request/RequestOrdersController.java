/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import javax.validation.Valid;
import md.factorydream.constant.AccessNameConst;
import md.factorydream.entites.RoleAccess;
import md.factorydream.entites.Users;
import md.factorydream.entites.rest.OrdersRest;
import md.factorydream.spring.service.OrdersService;
import md.factorydream.spring.service.RoleAccessSevice;
import md.factorydream.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RequestOrdersController {

    //Orders Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "ordersService")
    private OrdersService ordersService;

    //RoleAccess Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "roleAccessSevice")
    private RoleAccessSevice roleAccessSevice;

    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //------------------- Save a Orders --------------------------------------------------------
    @RequestMapping(value = "/save/orders", method = RequestMethod.POST)
    public ResponseEntity<OrdersRest> createUser(@Valid @RequestBody OrdersRest ordersRest, BindingResult bindingResult) {

        System.out.println(" Orders Id " + ordersRest.getId());
        System.out.println(" colorID " + ordersRest.getColor());
        System.out.println(" customerName " + ordersRest.getCustomer());
        System.out.println(" diameterValue " + ordersRest.getDiameter());
        System.out.println(" modelName " + ordersRest.getModel());
        System.out.println(" statusName " + ordersRest.getStatus());
        System.out.println(" threadName " + ordersRest.getThread());
        System.out.println(" typeName " + ordersRest.getType());
        System.out.println(" orderData " + ordersRest.getOrderData());
        System.out.println(" orderIdentifier " + ordersRest.getOrderIdentifier());
        System.out.println(" quantity " + ordersRest.getQuantity());
        System.out.println(" delivery " + ordersRest.getDelivery());
        System.out.println(" distributionDate " + ordersRest.getDistributionDate());
        System.out.println(" lastUpdateDate " + ordersRest.getLastUpdateDate());
        System.out.println(" OrderParametersRestValue " + ordersRest.getOrderParameterses());
        System.out.println(" OrderNotes " + ordersRest.getOrderNotes());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        RoleAccess roleAccess = roleAccessSevice.findRoleAccessByUserNameAndUrl(name, "/rest/orders");

        //System.out.println(" Zaitev  " + roleAccess.getAccess().getAccessName());
        if (roleAccess == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        switch (roleAccess.getAccess().getAccessName()) {
            case AccessNameConst.ACCESS_NAME_READ: {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            case AccessNameConst.ACCESS_NAME_UPDATE: {
                if (ordersRest.getId() <= 0) {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }
            }

        }

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!ordersService.save(ordersRest, users)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ordersRest, HttpStatus.OK);

    }

}

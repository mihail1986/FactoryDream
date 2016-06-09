/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.request;

import java.util.Date;
import javax.validation.Valid;
import md.factorydream.constant.StatusCodeConst;
import md.factorydream.entites.Customers;
import md.factorydream.entites.StatusCod;

import md.factorydream.entites.Users;
import md.factorydream.entites.rest.CustomersInsertRest;
import md.factorydream.entites.rest.CustomersUpdateRest;
import md.factorydream.spring.service.CustomersService;
import md.factorydream.spring.service.StatusCodService;
import md.factorydream.spring.service.UsersService;
import md.factorydream.util.Autorization;
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
public class RequestCustomersController {

    //Users Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    //Customers Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "customersService")
    private CustomersService customersService;

    //StatusCode Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "statusCodService")
    private StatusCodService statusCodService;

    //------------------- Save Customers --------------------------------------------------------
    @RequestMapping(value = "/save/customers", method = RequestMethod.POST)
    public ResponseEntity<CustomersInsertRest> saveCustomers(@Valid @RequestBody CustomersInsertRest customersInsertRest, BindingResult bindingResult) {

        System.out.println(" Name customers " + customersInsertRest.getName());
        System.out.println(" Adress customers " + customersInsertRest.getAddress());
        System.out.println(" Phone customers " + customersInsertRest.getPhone());
        System.out.println(" Email customers " + customersInsertRest.getEmail());
        System.out.println(" Description customers " + customersInsertRest.getCustomerDescription());
        System.out.println(" Note customers " + customersInsertRest.getNote());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/customers", "save")) {

            StatusCod statusCod = statusCodService.findStatusCodByCodName(StatusCodeConst.COD_NAME_ENABLE);

            Customers customers = new Customers();
            customers.setName(customersInsertRest.getName());
            customers.setAddress(customersInsertRest.getAddress());
            customers.setPhone(customersInsertRest.getPhone());
            customers.setEmail(customersInsertRest.getEmail());
            customers.setCustomerDescription(customersInsertRest.getCustomerDescription());
            customers.setNote(customersInsertRest.getNote());
            customers.setUsers(users);
            customers.setLastUpdateDate(new Date());
            customers.setStatusCod(statusCod);

            customersService.save(customers);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(customersInsertRest, HttpStatus.OK);

    }

    //------------------- Update Customers --------------------------------------------------------
    @RequestMapping(value = "/update/customers", method = RequestMethod.POST)
    public ResponseEntity<CustomersUpdateRest> updateCustomers(@Valid @RequestBody CustomersUpdateRest customersUpdateRest, BindingResult bindingResult) {

        System.out.println(" Customers Id " + customersUpdateRest.getCustomersId());
        System.out.println(" StatusCode Id " + customersUpdateRest.getCustomersId());
        System.out.println(" Adress customers " + customersUpdateRest.getAddress());
        System.out.println(" Name customers " + customersUpdateRest.getName());
        System.out.println(" Adress customers " + customersUpdateRest.getAddress());
        System.out.println(" Phone customers " + customersUpdateRest.getPhone());
        System.out.println(" Email customers " + customersUpdateRest.getEmail());
        System.out.println(" Description customers " + customersUpdateRest.getCustomerDescription());
        System.out.println(" Note customers " + customersUpdateRest.getNote());

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Users users = usersService.findUserByLogin(name);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        if (Autorization.isAutorization(name, "/rest/customers", "update")) {

            StatusCod statusCod = statusCodService.findStatusCodById(customersUpdateRest.getStatusCodeId());

            if (statusCod == null) {
                throw new NullPointerException(" statusCod is null ");
            }

            Customers customers = customersService.findCustomersById(customersUpdateRest.getCustomersId());

            if (customers == null) {
                throw new NullPointerException(" Customers is null ");
            }

            customers.setName(customersUpdateRest.getName());
            customers.setAddress(customersUpdateRest.getAddress());
            customers.setPhone(customersUpdateRest.getPhone());
            customers.setEmail(customersUpdateRest.getEmail());
            customers.setCustomerDescription(customersUpdateRest.getCustomerDescription());
            customers.setNote(customersUpdateRest.getNote());
            customers.setUsers(users);
            customers.setLastUpdateDate(new Date());
            customers.setStatusCod(statusCod);

            customersService.save(customers);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(customersUpdateRest, HttpStatus.OK);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.rest.CustomersRest;
import md.factorydream.entites.rest.CustomersValueRest;
import md.factorydream.spring.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RestCustomersController {

    //Customers Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "customersService")
    private CustomersService customersService;

    //----------------------- Retrieve All Customers ----------------------------------------------------
    @RequestMapping(value = "/rest/customers", method = RequestMethod.GET)
    public List<CustomersRest> getAllCustomers() {
        List<CustomersRest> customersesList = (ArrayList<CustomersRest>) customersService.findAllRest();
        return customersesList;
    }

    //---------------------- Retrieve All Value of Customers -----------------------------------------------
    @RequestMapping(value = "/rest/valueCustomers", method = RequestMethod.GET)
    public ResponseEntity<List<CustomersValueRest>> getAllValueCustomers() {

        List<CustomersValueRest> customersValueRestList = (ArrayList<CustomersValueRest>) customersService.findAllEnableCustomersRest();

        return new ResponseEntity<>(customersValueRestList, HttpStatus.OK);
    }

}

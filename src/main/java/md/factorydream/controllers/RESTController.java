/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Customers;
import md.factorydream.entites.Employees;
import md.factorydream.entites.rest.OrdersRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import md.factorydream.spring.service.CustomersService;
import md.factorydream.spring.service.EmployeesService;
import md.factorydream.spring.service.OrdersService;

/**
 *
 * @author PC01017745
 */
@RestController
public class RESTController {

    //Customers Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "customersService")
    private CustomersService customersService;

    //Employees Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "employeesService")
    private EmployeesService employeesService;

    //Orders Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "ordersService")
    private OrdersService ordersService;

    //------------------------ Retrieve All Orders ------------------------------------------------------ 
    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET)
    public List<OrdersRest> getAllOrders() {
        List<OrdersRest> ordersRestsList = (ArrayList<OrdersRest>) ordersService.findAllOrdersRest();
        return ordersRestsList;
    }

    //----------------------- Retrieve All Customers ----------------------------------------------------
    @RequestMapping(value = "/rest/customers", method = RequestMethod.GET)
    public List<Customers> getAllCustomers() {
        List<Customers> customersesList = (ArrayList<Customers>) customersService.findAll();
        return customersesList;
    }

    //----------------------- Retrieve All Employees ----------------------------------------------------
    @RequestMapping(value = "/rest/employees", method = RequestMethod.GET)
    public List<Employees> getAllEmployees() {
        List<Employees> employeesesList = (ArrayList<Employees>) employeesService.findAll();
        return employeesesList;
    }

}

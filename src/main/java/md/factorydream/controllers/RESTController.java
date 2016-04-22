/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import md.factorydream.constant.AccessNameConst;
import md.factorydream.entites.Customers;
import md.factorydream.entites.Employees;
import md.factorydream.entites.RoleAccess;
import md.factorydream.entites.rest.ModelValueRest;
import md.factorydream.entites.rest.OrdersRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import md.factorydream.spring.service.CustomersService;
import md.factorydream.spring.service.EmployeesService;
import md.factorydream.spring.service.ModelsService;
import md.factorydream.spring.service.OrdersService;
import md.factorydream.spring.service.RoleAccessSevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Zaițev.Victor
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

    //RoleAccess Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "roleAccessSevice")
    private RoleAccessSevice roleAccessSevice;

    
    //Models Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "modelsService")
    private ModelsService modelsService;

    //------------------------ Retrieve All Orders ------------------------------------------------------ 
    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllOrders() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        RoleAccess roleAccess = roleAccessSevice.findRoleAccessByUserNameAndUrl(name, "/rest/orders");

        if (roleAccess == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("users", roleAccess.getAccess().getAccessName());

        if (roleAccess.getAccess().getAccessName().equals(AccessNameConst.ACCESS_NAME_READ)) {
            List<OrdersRest> ordersRestsReadOnlineList = (ArrayList<OrdersRest>) ordersService.findAllOrdersRestReadOnly();
            map.put("orders", ordersRestsReadOnlineList);
        } else {
            List<OrdersRest> ordersRestsList = (ArrayList<OrdersRest>) ordersService.findAllOrdersRest();
            map.put("orders", ordersRestsList);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
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

    //---------------------- Retrieve All Value of Models -----------------------------------------------
    @RequestMapping(value = "/rest/valueModels", method = RequestMethod.GET)
    public ResponseEntity<List<ModelValueRest>> getAllValueModels() {

        List<ModelValueRest> modeValueRestList = (ArrayList<ModelValueRest>) modelsService.findAllEnableModelsRest();

        return new ResponseEntity<>(modeValueRestList, HttpStatus.OK);
    }

}

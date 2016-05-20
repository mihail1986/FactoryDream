/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Employees;
import md.factorydream.spring.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RestEmployeesController {

    //Employees Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "employeesService")
    private EmployeesService employeesService;

    //----------------------- Retrieve All Employees ----------------------------------------------------
    @RequestMapping(value = "/rest/employees", method = RequestMethod.GET)
    public List<Employees> getAllEmployees() {
        List<Employees> employeesesList = (ArrayList<Employees>) employeesService.findAll();
        return employeesesList;
    }

}

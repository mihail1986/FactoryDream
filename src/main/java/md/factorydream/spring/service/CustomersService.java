/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.List;
import md.factorydream.entites.Customers;

/**
 *
 * @author Zaițev.Victor
 */
public interface CustomersService {

    public void save(Customers customers);

    public List findAll();

    public List findAllEnableCustomers();

    public List findAllEnableCustomersRest();

    public List findAllRest();

    public Customers findCustomersById(long id);
}

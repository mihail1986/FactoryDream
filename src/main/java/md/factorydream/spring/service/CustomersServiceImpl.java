/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.service;

import java.util.ArrayList;
import java.util.List;

import md.factorydream.entites.Customers;
import md.factorydream.entites.rest.CustomersValueRest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import md.factorydream.spring.dao.CustomersDAO;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class CustomersServiceImpl implements CustomersService {

    private CustomersDAO customersDAO;

    public void setCustomersDAO(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    @Override
    @Transactional
    public void save(Customers customers) {
        customersDAO.save(customers);
    }

    @Override
    @Transactional
    public List findAll() {
        return customersDAO.findAll();
    }

    @Override
    @Transactional
    public List findAllEnableCustomers() {
        return customersDAO.findAllEnableCustomers();
    }

    @Override
    public List findAllEnableCustomersRest() {

        List customersValueRestList = new ArrayList();

        List customersList = findAllEnableCustomers();

        for (Object customers : customersList) {
            Customers customer = (Customers) customers;

            CustomersValueRest customersValuelRest = new CustomersValueRest(customer.getId(), customer.getName());
            customersValueRestList.add(customersValuelRest);
        }

        return customersValueRestList;
    }

}

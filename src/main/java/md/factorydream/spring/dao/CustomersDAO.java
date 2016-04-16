/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Customers;

/**
 *
 * @author PC01017745
 */
public interface CustomersDAO {

    public void save(Customers customers);

    public List<Customers> findAll();
}

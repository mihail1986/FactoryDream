/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.spring.dao;

import java.util.List;
import md.factorydream.entites.Customers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC01017745
 */
@Repository
public class CustomersDAOImpl extends AbstractSpringDao implements CustomersDAO {

    @Override
    public void save(Customers customers) {
        super.saveOrUpdate(customers);
    }

    @Override
    public List findAll() {
        return super.findAll(Customers.class);
    }

}
